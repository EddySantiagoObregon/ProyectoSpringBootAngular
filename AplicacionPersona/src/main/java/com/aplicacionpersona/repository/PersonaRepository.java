package com.aplicacionpersona.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aplicacionpersona.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
	


}
