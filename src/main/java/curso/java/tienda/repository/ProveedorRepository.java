package curso.java.tienda.repository;

import org.springframework.data.repository.CrudRepository;

import curso.java.tienda.model.Proveedor;
import curso.java.tienda.model.Usuario;

public interface ProveedorRepository extends CrudRepository<Proveedor, Integer>{
	Proveedor findById(int id);
}
