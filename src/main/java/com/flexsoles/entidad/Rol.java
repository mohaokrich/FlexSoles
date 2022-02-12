package com.flexsoles.entidad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol implements Serializable {
	// ATRIBUTOS
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "nombre_rol")
	private String nombre_rol;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "usuario_rol", 
	joinColumns = @JoinColumn(name = "id"), 
	inverseJoinColumns = @JoinColumn(name = "id_usuario"))

	private Set<Usuario> usuarios = new HashSet<>();

	// CONSTRUCTORES
	public Rol() {
	}

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


	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void addUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
		usuario.getRoles().add(this);
	}

	public void eliminarUsuario(Usuario usuario) {
		this.usuarios.remove(usuario);
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
