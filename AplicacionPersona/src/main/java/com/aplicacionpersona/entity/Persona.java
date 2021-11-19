package com.aplicacionpersona.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity //le decimos a java que es una entidad
@Table(name="persona") // para que nos cree la tabla user en la base de datos
public class Persona implements Serializable {

	private static final long serialVersionUID = 3499113360580787796L;
	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY) //le decimos que va a ser de tipo autoincrementable
	private Long id;
	@NotEmpty(message="El campo no debe ser vacio")
	@Size(max=50, message = "El campo debe tener un maximo de 50 caracteres")
	@Column(length = 50)private String nombre;
	@NotEmpty(message="El campo no debe ser vacio")
	@Size(max=50, message = "El campo debe tener un maximo de 50 caracteres")
	@Column(length = 50)
	private String apellido;
	@NotEmpty(message="El campo no debe ser vacio")
	@Size(max=50, message = "El campo debe tener un maximo de 50 caracteres")
	@Email
	@Column(name="mail", nullable=false, length=50, unique=true)
	private String email;
	@NonNull
	@Pattern(regexp = "{5}[0-9]{10}", message = "Campo numerico minimo 5 caracteres y maximo 10 caracteres") //
	private String telefono;
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
}
