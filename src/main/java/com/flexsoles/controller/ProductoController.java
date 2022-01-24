package com.flexsoles.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flexsoles.modelo.ProductoDAO;
import com.flexsoles.persistencia.Producto;


@Controller
public class ProductoController {
	@Autowired
	private ProductoDAO productoModelo;
	
	
	// GET METHODS
	@RequestMapping(value = "/producto/producto{id}", method = RequestMethod.GET)
	public String getIdProducto(Model modelo, @PathVariable("id") long id) {
		List<Producto> ListaProductos = (List<Producto>) productoModelo.buscar(id);
		modelo.addAttribute("ListaProductos", ListaProductos);
		return "/producto/producto";
	}

	@RequestMapping(value = "/producto/borrar/{id}", method = RequestMethod.GET)
	public String getBorrarIdProducto(@PathVariable("id") long id) {
		productoModelo.borrar(id);
		return "redirect:/index";
	}

	@RequestMapping(value = "/producto/crear", method = RequestMethod.GET)
	public String getCrear() {
		return "/producto/crear";
	}

	@RequestMapping(value = "/producto/buscar", method = RequestMethod.GET)
	public String getBuscarProducto(Model modelo, @RequestParam String busqueda) {
		List<Producto> ListaProductos = productoModelo.buscarNombre(busqueda);
		modelo.addAttribute("ListaProductos", (ListaProductos));
		return "/producto/producto";
	}
	
	
	// POST METHODS
		@RequestMapping(value = "/producto/crear", method = RequestMethod.POST)
		public String CrearProducto(@RequestParam String titulo, String descripcion, double precio, int descuento,
				Model modelo) {
			Producto producto = new Producto();
			producto = new Producto(null, null, 0, 0, 0);
			producto.setTitulo(titulo);
			producto.setDescripcion(descripcion);
			producto.setPrecio(precio);
			producto.setDescuento(descuento);
			productoModelo.crear(producto);
			return "redirect:/index";
		}

}
