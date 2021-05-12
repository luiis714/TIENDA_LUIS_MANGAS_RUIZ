package curso.java.tienda.repository;

import org.springframework.data.repository.CrudRepository;

import curso.java.tienda.model.DetallesPedido;

public interface DetallesPedidoRepository extends CrudRepository<DetallesPedido, Integer> {

}
