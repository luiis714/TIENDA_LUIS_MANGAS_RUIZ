package curso.java.tienda.repository;

import org.springframework.data.repository.CrudRepository;

import curso.java.tienda.model.Pedido;
import curso.java.tienda.model.Producto;

public interface PedidoRepository extends CrudRepository<Pedido, Integer> {
	Pedido findById(int id);
	Iterable<Pedido> findAllByIdUsuario(int idUsuario);
}
