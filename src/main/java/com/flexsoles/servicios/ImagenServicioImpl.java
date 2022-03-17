package com.flexsoles.servicios;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.flexsoles.entidad.Imagen;
import com.flexsoles.entidad.Producto;
import com.flexsoles.modelo.ImagenDAO;
import com.flexsoles.modelo.ProductoDAO;

@Transactional
@Service
public class ImagenServicioImpl implements ImagenServicio {
	@Autowired
	private ImagenDAO imagenModelo;

	@Autowired
	private ProductoDAO productoModelo;

	public int guardarImagen(Imagen img) {
		try {
			imagenModelo.save(img);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public Imagen obtenerImagen(Long id) {
		Imagen findById = imagenModelo.findById(id).orElse(null);
		
		if (findById != null) {
			Imagen getImageDetails = findById;
			return findById;
		} else {
			return null;
		}
	}

	public Boolean actualizarImagen(long idProducto, MultipartFile file) {

		Producto p = productoModelo.buscar(idProducto);
		if (p == null)
			return false;
		try {
			byte[] image = file.getBytes();
			if (!p.getProducto_imagen().isEmpty()) {

				Set<Imagen> limg = p.getProducto_imagen();
				for (Imagen a : limg) {
					a.setImagen(image);
					imagenModelo.save(a);
					return true;
				}
				return null;

			} else {
				Imagen img = new Imagen("foto", image,p);
				p.getProducto_imagen().add(img);


				//p.addImagen(img);
				imagenModelo.save(img);
				//productoModelo.actualizar(p);
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
