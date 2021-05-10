package curso.java.tienda.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.Producto;
import curso.java.tienda.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository repository;
	
	public Producto getProductoId(int id) {
		return repository.findById(id);
	}
	
	public Iterable<Producto> listadoProductos(){
		Iterable <Producto> it = repository.findAll();
		
		return it;
	}
	
	public Iterable<Producto> listadoProductosCategoria(int idCategoria){
		return repository.findAllByIdCategoria(idCategoria);
	}
}
