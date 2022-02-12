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

import com.flexsoles.entidad.Producto;
import com.flexsoles.modelo.ProductoDAO;
import com.flexsoles.servicios.ProductoServicio;


@Controller
public class ProductoController {
	@Autowired
	private ProductoDAO productoModelo;
	@Autowired
	private ProductoServicio modeloProductoSer;
	
	// GET METHODS
	@RequestMapping(value = "/producto/producto{id}", method = RequestMethod.GET)
	public String getIdProducto(Model modelo, @PathVariable("id") long id) {
		Producto producto = (Producto) productoModelo.buscar(id);
		modelo.addAttribute("producto", producto);
		return "/producto/producto";
	}

	@RequestMapping(value = "/producto/borrar/{id}", method = RequestMethod.GET)
	public String getBorrarIdProducto(@PathVariable("id") long id) {
		modeloProductoSer.borrar(id);
		return "redirect:/index";
	}

	@RequestMapping(value = "/producto/crear", method = RequestMethod.GET)
	public String getCrear() {
		return "/producto/crear";
	}

	@RequestMapping(value = "/producto/buscar", method = RequestMethod.GET)
	public String getBuscarProducto(Model modelo, @RequestParam String busqueda) {
		List<Producto> ListaProductos = modeloProductoSer.obtenerListaProductos(busqueda);
		modelo.addAttribute("ListaProductos", ListaProductos);
		return "/producto/productos_buscados";
	}
	
	
	// POST METHODS
		@RequestMapping(value = "/producto/crear", method = RequestMethod.POST)
		public String CrearProducto(@RequestParam String titulo, String descripcion, double precio, int descuento,
				Model modelo) {
			Producto producto = new Producto("", "", 0, 0);
			producto.setTitulo(titulo);
			producto.setDescripcion(descripcion);
			producto.setPrecio(precio);
			producto.setDescuento(descuento);
			modeloProductoSer.crearProducto(producto);
			return "redirect:/index";
		}

}
