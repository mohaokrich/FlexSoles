package com.flexsoles.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.flexsoles.entidad.Imagen;
import com.flexsoles.entidad.Producto;
import com.flexsoles.servicios.ImagenServicio;
import com.flexsoles.servicios.ProductoServicio;

@Controller
public class ImagenControlador {
	
	@Autowired
	private ImagenServicio imgServicio;

	@Autowired
	ProductoServicio productoService;
	
	@RequestMapping(value = "/imagenes/cargar/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public Model actualizarFotoPerfil(Model modelo, HttpServletRequest request, @PathVariable("id") long idProducto) {

		Producto p = productoService.buscar(idProducto);   
		Imagen img = null;
		if (!p.getProducto_imagen().isEmpty()) {
			for (Imagen i : p.getProducto_imagen()) {
				img = i;
				break;
			}
		}

		modelo.addAttribute("image",img);
		
		return modelo;
	}

	@PostMapping("/imagenes/cargar/{id}")
	public String fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request,
			@PathVariable("id") long idProducto) {
		try {
			byte[] image = file.getBytes();
			Imagen img = new Imagen("image", image);
			Boolean saveImage = imgServicio.actualizarImagen(idProducto, file);
			if (saveImage) {
				return "redirect:/producto/producto" + idProducto;
			} else {
				return "redirect:/imagenes/cargar/" + idProducto;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/producto/producto" + idProducto;
		}
	}

	@RequestMapping(value = "/imagen/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody ResponseEntity getImageAsResponseEntity(@PathVariable String id) {

		try {
			Imagen imagesObj = imgServicio.obtenerImagen(Long.parseLong(id));
			byte[] media = imagesObj.getImagen();
			HttpHeaders headers = new HttpHeaders();
			headers.setCacheControl(CacheControl.noCache().getHeaderValue());

			ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
			
			return responseEntity;

		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
}
