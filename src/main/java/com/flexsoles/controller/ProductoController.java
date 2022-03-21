package com.flexsoles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flexsoles.entidad.Producto;
import com.flexsoles.servicios.ProductoServicio;


@Controller
public class ProductoController {
	@Autowired
	private ProductoServicio modeloProductoSer;
	
	// GET METHODS
	@RequestMapping(value = "/producto/producto{id}", method = RequestMethod.GET)
	public String getIdProducto(Model modelo, @PathVariable("id") long id) {
		Producto producto = (Producto) modeloProductoSer.buscarProducto(id);
		modelo.addAttribute("producto", producto);
		return "producto/producto";
	}

	@RequestMapping(value = "/producto/borrar/{id}", method = RequestMethod.GET)
	public String getBorrarIdProducto(@PathVariable("id") long id) {
		modeloProductoSer.borrarProducto(id);
		return "redirect:/index";
	}

	@RequestMapping(value = "/producto/buscar", method = RequestMethod.GET)
	public String getBuscarProducto(Model modelo, @RequestParam String busqueda) {
		List<Producto> ListaProductos = modeloProductoSer.obtenerListaProductos(busqueda);
		modelo.addAttribute("ListaProductos", ListaProductos);
		return "producto/productos_buscados";
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
