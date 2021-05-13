package curso.java.tienda.repository;

import org.springframework.data.repository.CrudRepository;

import curso.java.tienda.model.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {
	Iterable<Producto> findAllByIdCategoria(int idCategoria);
	Producto findById(int id);
	Iterable<Producto> findByNombreContains(String cadena);
	Iterable<Producto> findByPrecioGreaterThan(double cadena);
	Iterable<Producto> findByPrecioLessThan(double parseDouble);
}
