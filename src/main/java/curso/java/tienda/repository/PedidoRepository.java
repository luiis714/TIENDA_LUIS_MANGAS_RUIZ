package curso.java.tienda.repository;

import org.springframework.data.repository.CrudRepository;

import curso.java.tienda.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Integer> {

}
