package com.flexsoles.controller;


import java.util.Map;

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
import com.flexsoles.entidad.Producto;
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
	@PostMapping("/pregunta/crearPregunta")
	public ResponseEntity postCrearPregunta(@RequestBody Map<String, String> json, Producto producto) {
		Pregunta pregunta = preguntaServicio.crear(new Pregunta(json.get("txtPregunta"), producto));
		ResponseEntity<Object> preg = new ResponseEntity<Object>(pregunta, HttpStatus.OK);
		return preg;
	}

}
