package curso.java.tienda.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.Producto;
import curso.java.tienda.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository repository;
	
	public Iterable<Producto> listadoProductos(){
		Iterable <Producto> it = repository.findAll();
		
		return it;
	}
}
