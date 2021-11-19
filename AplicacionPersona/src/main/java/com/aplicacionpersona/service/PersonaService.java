package com.aplicacionpersona.service;

import java.util.Optional;


import org.springframework.stereotype.Repository;

import com.aplicacionpersona.entity.Persona; 

@Repository


public interface PersonaService{ 
	public Iterable<Persona> findAll();//Colección en forma de iterable
	
	public Optional<Persona> findById(Long id); //Que nos encuentre la persona por medio del id
	
	public Persona save(Persona persona);//actualizar entidad o guardarla, le pasamos una persona y va a guardar una persona
	
	public void deleteById(Long id); //Elimina un usuario por id, el metodo es void significa que no devuelve nada

}
