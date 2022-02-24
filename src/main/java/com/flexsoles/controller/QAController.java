package com.flexsoles.controller;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flexsoles.entidad.Pregunta;
import com.flexsoles.servicios.PreguntaServicio;

@Controller
public class QAController {
	@Autowired
	private PreguntaServicio preguntaServicio;
	
	@ResponseBody
	@GetMapping("/preguntas")
	public Pregunta getPregunta(@PathVariable long id) {
		Pregunta pregunta = (Pregunta) preguntaServicio.buscar(id);
		return pregunta;
	}	
	
	@ResponseBody
	@PostMapping("/crear/pregunta/{idProducto}")
	public ResponseEntity<Object> crearPreguntas(@PathVariable int idProducto, @RequestBody Map<String, String> json,
			HttpSession session) {
		
		Pregunta pregunta = new Pregunta();

		int idUsuario;

		try {
			idUsuario = (int) session.getAttribute("id_Usuario");
		} catch (Exception e) {
			idUsuario = 1;
		}
		pregunta.setPregunta(json.get("pregunta"));

		int id = preguntaServicio.crearPregunta(pregunta, idUsuario, idProducto);
		
		PreguntasDto dto = new PreguntasDto(id, json.get("pregunta"), idUsuario, null, null);
		
		return new ResponseEntity<Object>(dto, HttpStatus.OK);
	}

}
