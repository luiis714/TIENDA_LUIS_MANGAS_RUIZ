package curso.java.tienda.repository;

import java.util.Iterator;

import org.springframework.data.repository.CrudRepository;

import curso.java.tienda.model.DetallesPedido;

public interface DetallesPedidoRepository extends CrudRepository<DetallesPedido, Integer> {
	Iterable<DetallesPedido> findAllByIdPedido(int idPedido);
	DetallesPedido findById(int id);
}
