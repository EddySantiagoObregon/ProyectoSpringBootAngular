package com.aplicacionpersona.controller;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aplicacionpersona.entity.Persona;
import com.aplicacionpersona.service.PersonaService;

@RestController
@RequestMapping("/api/persona")

public class PersonaController {
	@Autowired
	private PersonaService personaService;
	
	//Create
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping
	public ResponseEntity<?> create (@Validated  @RequestBody  Persona persona){
		return ResponseEntity.status(HttpStatus.CREATED).body(personaService.save(persona));
	}
	
	//Read
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value="id")   Long perId){
		Optional<Persona> oPersona = personaService.findById(perId);
		if(!oPersona.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oPersona);
	}
	//Update 
	@CrossOrigin(origins="http://localhost:4200")
	@PutMapping("/{id}") 
	public ResponseEntity<?> update(@RequestBody Persona userDetails, @PathVariable(value="id") Long perId){
		Optional<Persona> persona = personaService.findById(perId);
		if(!persona.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		// BeanUtils.copyProperties(UserDetails, user.get());
		persona.get().setNombre(userDetails.getNombre()); //Cogemos el nombre de la que le pasamos la peticion de editar y se lo mete a la persona que hemos buscado y cogido de la base datos 
		persona.get().setApellido(userDetails.getApellido());
		persona.get().setEmail(userDetails.getEmail());
		persona.get().setTelefono(userDetails.getTelefono());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(personaService.save(persona.get()));
	
}	
	//Delete 
	@CrossOrigin(origins="http://localhost:4200")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long perId){
		if(!personaService.findById(perId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		personaService.deleteById(perId);
		
		return ResponseEntity.ok().build();
	}

	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping
	public List<Persona>readAll(){
		//Este metodo lo unico que esta usando son unos objetos que llaman a unos metedos esto para recorrer nuestro iterable y pasarlo a una lista de manera secuencial
		List<Persona> persona = StreamSupport //Para contruir la lista
				.stream(personaService.findAll().spliterator(), false)//le pasamos dos parametros iterable y false significa que sera secuencial, splititerator significa que recorree la lista como si tuviera un for
				.collect(Collectors.toList()); //
				
		return persona;
	
	}
}
