package curso.java.tienda.repository;

import org.springframework.data.repository.CrudRepository;

import curso.java.tienda.model.Configuracion;
import curso.java.tienda.model.Producto;

public interface ConfiguracionRepository extends CrudRepository<Configuracion, Integer>{
	Configuracion findByClave(String clave);
}
