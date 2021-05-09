package curso.java.tienda.repository;

import org.springframework.data.repository.CrudRepository;

import curso.java.tienda.model.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
	public Categoria findByNombre(String nombre);
}
