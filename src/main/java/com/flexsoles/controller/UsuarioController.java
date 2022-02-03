package com.flexsoles.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flexsoles.modelo.UsuarioDAO;
import com.flexsoles.persistencia.Usuario;
import com.flexsoles.servicios.UsuarioServicio;

@Controller
public class UsuarioController {
	@Autowired
	UsuarioServicio usuarioServicio;
	@Autowired 
	UsuarioDAO usuarioModelo;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	
	//GET METHODS
//	@RequestMapping(value = "/usuario/login", method = RequestMethod.GET)
//	public String getLogin() {
//		return "/usuario/login";
//	}


	// GET METHODS
	@RequestMapping(value = "/usuario/login", method = RequestMethod.GET)
	public String getLogin() {
		return "redirect:/index";
	}


	@RequestMapping(value = "/usuario/signup", method = RequestMethod.GET)
	public String getRegistro() {
		return "/usuario/signup";
	}

	@RequestMapping(value = "/usuario/logout", method = RequestMethod.GET)
	public String getLogOut(HttpSession session) {
		session.removeAttribute("usuario");
		session.invalidate();
		return "redirect:/index";
	}
	@RequestMapping(value = "/usuario/user{id}", method = RequestMethod.GET)
	public String getPerfil(Model modelo, @PathVariable("id") long id) {
		Usuario usuario = usuarioModelo.buscar(id);
		modelo.addAttribute("usuario", usuario);
		return "/usuario/user";
	}
//	@RequestMapping(value = "/usuario/user/{id}", method = RequestMethod.GET)
//	public Usuario getPerfil(Model modelo, @PathVariable("id") long id) {
//		return usuarioModelo.buscar(id);
//	}

	// POST METHODS
	@RequestMapping(value = "/usuario/signup", method = RequestMethod.POST)
	public String CrearUsuario(@RequestParam String nombre, String apellidos, String email, String passwd,
			String fechaNacimiento, HttpServletRequest request, Model modelo) {
		Usuario usuario = new Usuario();

		usuario.setNombre(nombre);
		usuario.setApellidos(apellidos);

		usuario.setEmail(email);
		usuario.setPasswd(bCryptPasswordEncoder.encode(passwd));
		usuario.setFechaNacimiento(fechaNacimiento);

		usuarioServicio.crearUsuario(usuario);

		// HAY QUE IMPLEMENTAR ESTO!
//		long temp = usuarioModelo.getId(usuario.getNombre());
//		usuarioModelo.saveTablaRoles(temp, "USER");
//		usuarioModelo.saveRol(temp, temp);

		return "redirect:/usuario/login";
	}
/*
	@RequestMapping(value = "/usuario/login", method = RequestMethod.POST)
	public String iniciarSesion(Model modelo, @RequestParam String nombre, @RequestParam String passwd,
			HttpSession session) {
		Usuario usuario = usuarioModelo.iniciarSesion(nombre, passwd);
		session.setAttribute("usuario", usuario);
		return "redirect:/index";
	}*/
}
