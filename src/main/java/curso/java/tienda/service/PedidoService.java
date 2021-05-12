package curso.java.tienda.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.Configuracion;
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
	@Autowired
	private ConfiguracionService cs;

	public void nuevoPedido(Usuario usuario, String metodo_pago, String total_compra, ArrayList<Producto> carro) {
		Pedido pedido = new Pedido();
		
		//Inserto datos del pedido
		pedido.setIdUsuario(usuario.getId());//Pone id del usuario que esta logueado
		pedido.setMetodoPago(metodo_pago);
		pedido.setTotal(Double.parseDouble(total_compra));
		pedido.setEstado("pendiente");//Pongo el pedido a pendiente
		
		//pedido.setNumFactura(sacaNumFactura());
		
		//Guardo en la BBDD
		repository.save(pedido);
		
		//Inserto los detalles del pedido
		dets.nuevosDetalles(carro, pedido);
		
	}
	
	public Iterable<Pedido> listadoProductos(){
		return repository.findAll();
	}
	
	public Iterable<Pedido> listadoProductosUsuario(int idUsuario){
		return repository.findAllByIdUsuario(idUsuario);
	}
	
	public Pedido devuelvePedidoId(int id) {
		return repository.findById(id);
	}

	public void actualizaPedido(Pedido pedido) {
		repository.save(pedido);
	}
	
	/**
	 * Saca el número de factura a través del año, el mes y un número sacado de la tabla de configuración
	 * */
	public String sacaNumFactura() {
		//Saco el año y el mes para añadirlo al numero de factura
		Date date = new Date();
        ZoneId timeZone = ZoneId.systemDefault();
        LocalDate getLocalDate = date.toInstant().atZone(timeZone).toLocalDate();
		int year = getLocalDate.getYear();
		int month = getLocalDate.getMonthValue();
		
		//Saco el numero de la BD y le incremento 1
		Configuracion numFactura = cs.devuelveConfiguracionClave("numFactura");
		int v = Integer.parseInt(numFactura.getValor()); //saca un numero aleatorio entre 0 y 600
		v++;
		
		//Actualizo el valor en la BDD
		numFactura.setValor(Integer.toString(v));
		cs.actualizaCofiguracion(numFactura);
		
		return "" + year + month + v;
	}
}
