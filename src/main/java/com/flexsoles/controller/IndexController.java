package com.flexsoles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flexsoles.entidad.Producto;
import com.flexsoles.modelo.ProductoDAO;

@Controller
public class IndexController {
	@Autowired
	private ProductoDAO productoModelo;
	
	@RequestMapping(value = { "/","index"}, method = RequestMethod.GET)
	public String getIndex2(Model modelo) {
		List<Producto> ListaProductos = productoModelo.get8Productos();
		modelo.addAttribute("ListaProductos", ListaProductos);
		return "index";
	}

//	@RequestMapping(value = "/index", method = RequestMethod.GET)
//	public String getIndex(Model modelo) {
//		List<Producto> ListaProductos = productoModelo.get8Productos();
//		modelo.addAttribute("ListaProductos", ListaProductos);
//		return "index";
//	}

}
