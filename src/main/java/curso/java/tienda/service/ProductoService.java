package curso.java.tienda.service;

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
	
	public void nuevoProducto(Producto producto) {
		repository.save(producto);
	}
	
	public void actualizarProducto(Producto producto) {
		repository.save(producto);
	}
	
	public void borrarProducto(Integer id) {
		repository.deleteById(id);
	}

	public Iterable<Producto> buscadorNombre(String cadena) {
		return repository.findByNombreContains(cadena);
	}

	public Iterable<Producto> buscadorPrecioMayor(String cadena) {
		return repository.findByPrecioGreaterThan(Double.parseDouble(cadena));
	}

	public Iterable<Producto> buscadorPrecioMenor(String cadena) {
		return repository.findByPrecioLessThan(Double.parseDouble(cadena));
	}
}
