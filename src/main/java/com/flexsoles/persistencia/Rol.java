package com.flexsoles.persistencia;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Roles")
public class Rol implements Serializable{
	//ATRIBUTOS
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "nombre_rol")
	private String nombre_rol;

	private Set<Usuario> usuarios;
	
	//CONSTRUCTORES
	public Rol() {}
	
	public Rol(long id, String nombre_rol) {
		super();
		this.id = id;
		this.nombre_rol = nombre_rol;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre_rol() {
		return nombre_rol;
	}

	public void setNombre_rol(String nombre_rol) {
		this.nombre_rol = nombre_rol;
	}
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Set<Usuario> usuario) {
		usuarios = usuario;
	}
	
	public void addUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
		usuario.getRoles().add(this);
	}	
	public void eliminarProfesor(Usuario usuario) {
		this.usuarios.remove(usuario) ;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rol other = (Rol) obj;
		return id == other.id;
	}

}
