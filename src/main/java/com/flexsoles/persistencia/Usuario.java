package com.flexsoles.persistencia;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_security", schema = "usuario_security")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellidos")
	private String apellidos;
	@Column(name = "rol")
	private String rol;
	@Column(name = "email")
	private String email;
	@Column(name = "passwd")
	private String passwd;
	@Column(name = "fechaNacimiento")
	private String fechaNacimiento;

	
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "usuario_rol", 
	joinColumns = @JoinColumn(name = "id_usuario"), 
	inverseJoinColumns = @JoinColumn(name = "id"))

	private Set<Rol> roles = new HashSet<>();

	// CONSTRUCTORES
	public Usuario() {
	}

	public Usuario(long id, String nombre, String apellidos, String email, String passwd, String fechaNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.passwd = passwd;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Usuario(long id, String nombre, String apellidos, HashSet<Rol> roles, String email, String passwd,
			String fechaNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.roles = roles;
		this.email = email;
		this.passwd = passwd;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Usuario(long id, String nombre, String apellidos, String rol, String email, String passwd,
			String fechaNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.rol = rol;
		this.email = email;
		this.passwd = passwd;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Usuario(long id, String nombre, String apellidos, String email, String fechaNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Usuario(String nombre, String passwd) {
		this.nombre = nombre;
		this.passwd = passwd;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Usuario(long id) {
		this.id = id;
	}

	// GETTERS & SETTERS
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
	
	public boolean anadirRol(Rol rol) {
	    rol.addUsuario(this);
		return getRoles().add(rol);
	}

	public void eliminarRol(Rol rol) {
		this.roles.remove(rol);
		rol.getUsuarios().remove(this);
	}
}
