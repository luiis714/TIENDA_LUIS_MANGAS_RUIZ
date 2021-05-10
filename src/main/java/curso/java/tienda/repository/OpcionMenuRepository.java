package curso.java.tienda.repository;

import org.springframework.data.repository.CrudRepository;

import curso.java.tienda.model.OpcionMenu;
import curso.java.tienda.model.Producto;

public interface OpcionMenuRepository  extends CrudRepository<OpcionMenu, Integer>  {
	Iterable<OpcionMenu> findAllByIdRol(int idRol);
}
