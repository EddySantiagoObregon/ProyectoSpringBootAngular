package com.aplicacionpersona.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aplicacionpersona.entity.Persona;
import com.aplicacionpersona.repository.PersonaRepository;
@Service
public  class PersonaImp implements PersonaService{

	@Autowired
	private PersonaRepository personaRepository; //Intanciamos la clase para poder usar todos los metodos que estan la clase repositorio


	@Override
	@Transactional(readOnly = true) //Una transaccion de solo lectura la cual no va a cambiar el estado de nuestra base de datos
	public Iterable<Persona> findAll() {
		
		return personaRepository.findAll(); //Usamos el metodo de la clase instanciada para poder listar todos los usuarios 
	}
	
	@Override
	@Transactional(readOnly = true) //Una transaccion de solo lectura la cual no va a cambiar el estado de nuestra base de datos
	public Optional<Persona> findById(Long id) {
		return personaRepository.findById(id); //Usamos el metodo de la clase instanciada para poder buscar la persona por  el metodo de id
	}

	@Override
	@Transactional(readOnly = false) //Una transaccion de  la cual va a cambiar el estado de nuestra base de datos va a crear o actualizar nuestra base de datos
	public Persona save(Persona persona) {
		return personaRepository.save(persona);
	}

	@Override
	@Transactional(readOnly = false) //Una transaccion de  la cual va a cambiar el estado de nuestra base de datos va a eliminar un dato de nuestra base de datos
	public void deleteById(Long id) {
		personaRepository.deleteById(id);
	}
	
}
	