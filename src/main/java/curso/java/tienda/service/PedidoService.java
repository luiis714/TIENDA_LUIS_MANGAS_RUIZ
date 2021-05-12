package curso.java.tienda.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.Pedido;
import curso.java.tienda.model.Producto;
import curso.java.tienda.model.Usuario;
import curso.java.tienda.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	@Autowired
	private DetallesPedidoService dets;

	public void nuevoPedido(Usuario usuario, String metodo_pago, String total_compra, ArrayList<Producto> carro) {
		Pedido pedido = new Pedido();
		
		//Inserto datos del pedido
		pedido.setIdUsuario(usuario.getId());//Pone id del usuario que esta logueado
		pedido.setMetodoPago(metodo_pago);
		pedido.setTotal(Double.parseDouble(total_compra));
		pedido.setEstado("pendiente");//Pongo el pedido a pendiente
		pedido.setNumFactura("2021"+pedido.getIdUsuario());//Saco el numero de factura con el año, id pedido e id usuario
		
		//Guardo en la BBDD
		repository.save(pedido);
		
		//Inserto los detalles del pedido
		dets.nuevosDetalles(carro, pedido);
		
	}
	
	
}
