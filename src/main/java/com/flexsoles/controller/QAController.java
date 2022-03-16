package com.flexsoles.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flexsoles.dtos.PreguntaDTO;
import com.flexsoles.entidad.Pregunta;
import com.flexsoles.servicios.PreguntaServicio;

@Controller
public class QAController {
	@Autowired
	private PreguntaServicio preguntaServicio;
	
	@ResponseBody
	@GetMapping("/preguntas")
	public List<PreguntaDTO> getPregunta(@PathVariable long idProducto) {
		return preguntaServicio.getAllPreguntas(idProducto);
	}	
	
	@ResponseBody
	@RequestMapping(value="/crear/pregunta/{idProducto}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<PreguntaDTO> crearPreguntas(@PathVariable long idProducto, Map<String, String> json,
			HttpSession session) {
		
		Pregunta pregunta = new Pregunta();

		long idUsuario;

		try {
			idUsuario = (int) session.getAttribute("id");
		} catch (Exception e) {
			idUsuario = 1;
		}
		pregunta.setPregunta(json.get("pregunta"));
		

		long id = preguntaServicio.crearPregunta(pregunta, idUsuario, idProducto);
		
		PreguntaDTO dto = new PreguntaDTO(id, idUsuario,json.get("pregunta"), null, null);
		ResponseEntity<PreguntaDTO> resp = new ResponseEntity<PreguntaDTO>(dto, HttpStatus.OK);
		
		return resp;
	}

}
