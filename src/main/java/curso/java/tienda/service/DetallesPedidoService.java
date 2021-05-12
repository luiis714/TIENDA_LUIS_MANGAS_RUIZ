package curso.java.tienda.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.DetallesPedido;
import curso.java.tienda.model.Pedido;
import curso.java.tienda.model.Producto;
import curso.java.tienda.repository.DetallesPedidoRepository;


@Service
public class DetallesPedidoService {
	@Autowired
	private DetallesPedidoRepository repository;
	
	public void nuevosDetalles(ArrayList<Producto> carro, Pedido pedido) {
		DetallesPedido dp = null;
		ArrayList<DetallesPedido>lista = new ArrayList<DetallesPedido>();
		
		for(int i = 0; i < carro.size(); i++) {
			dp = new DetallesPedido();
			//Inserto datos
			dp.setIdPedido(pedido.getId());
			dp.setIdProducto(carro.get(i).getId());
			dp.setPrecioUnidad(Float.parseFloat(carro.get(i).getPrecio().toString()));
			dp.setUnidades(1);
			dp.setImpuesto(carro.get(i).getImpuesto());
			dp.setTotal(carro.get(i).getPrecio());
			
			lista.add(dp);
		}
		
		repository.saveAll(lista);
	}
}
