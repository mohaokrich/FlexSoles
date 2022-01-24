package com.flexsoles.controller;

import java.util.HashSet;
import java.util.List;

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
import com.flexsoles.persistencia.Rol;
import com.flexsoles.persistencia.Usuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioModelo;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
	
	//GET METHODS
	@RequestMapping(value = "/usuario/login", method = RequestMethod.GET)
	public String getLogin() {
		return "/usuario/login";
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
		List<Usuario> ListaUsuarios = (List<Usuario>) usuarioModelo.buscar(id);
		modelo.addAttribute("ListaUsuarios", ListaUsuarios);
		return "/usuario/user";
	}
	
	
	
	
	//POST METHODS
	@RequestMapping(value = "/usuario/signup", method = RequestMethod.POST)
	public String CrearUsuario(@RequestParam String nombre, String apellidos, HashSet<Rol> roles, String email, String passwd,
			String fechaNacimiento, HttpServletRequest request, Model modelo) {
		Usuario usuario = new Usuario();


		usuario.setNombre(nombre);
		usuario.setApellidos(apellidos);
		usuario.setRoles(roles);
		usuario.setEmail(email);
		usuario.setPasswd(bCryptPasswordEncoder.encode(passwd));
		usuario.setFechaNacimiento(fechaNacimiento);
		usuarioModelo.crear(usuario);
		
		//HAY QUE IMPLEMENTAR ESTO!
//		long temp = usuarioModelo.getId(usuario.getNombre());
//		usuarioModelo.saveTablaRoles(temp, "USER");
//		usuarioModelo.saveRol(temp, temp);
		
		return "redirect:/usuario/login";
	}

}