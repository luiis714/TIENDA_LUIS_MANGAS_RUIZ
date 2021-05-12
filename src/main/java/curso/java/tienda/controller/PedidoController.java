package curso.java.tienda.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import curso.java.tienda.model.Pedido;
import curso.java.tienda.model.Producto;
import curso.java.tienda.model.Usuario;
import curso.java.tienda.service.DetallesPedidoService;
import curso.java.tienda.service.PedidoService;
import curso.java.tienda.service.ProductoService;
import curso.java.tienda.service.UsuarioService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private ProductoService ps;
	@Autowired
	private PedidoService peds;
	@Autowired
	private UsuarioService us;
	@Autowired
	private DetallesPedidoService dps;
	
	
	@PostMapping("/nuevo")
	public String nuevo(Model model, HttpSession session, @RequestParam String metodo_pago, @RequestParam String total_compra) {
		//Si no está logueado reenvia al login
		if(session.getAttribute("usuario") == null) {
			return "redirect:/login";
		}
		else {
			Usuario usuario = (Usuario)session.getAttribute("usuario");

			ArrayList<Producto> carro = (ArrayList<Producto>) session.getAttribute("carro");
			peds.nuevoPedido(usuario, metodo_pago, total_compra, carro);
			
			//Vacio el carro
			carro = new ArrayList<Producto>();
			session.setAttribute("carro", carro);

			//Vuelvo al inicio
			return "redirect:/";
		}
	}
	
	@GetMapping("/tabla")
	public String tabla(Model model, HttpSession session) {
		//Recojo todos los pedidos
		Iterable<Pedido> pedidos = peds.listadoProductos();
		
		model.addAttribute("listaUsuarios", us.listadoClientes());
		model.addAttribute("listaPedidos", pedidos);
		
		return "/pedido/tabla";
	}
	
	@GetMapping("/historial")
	public String historial(Model model, HttpSession session) {
		//Saco una lista de pedidos del usuario
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		Iterable<Pedido> pedidos = peds.listadoProductosUsuario(usuario.getId());
		
		model.addAttribute("listaPedidos", pedidos);
		
		return "/pedido/tabla-cliente";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalle(Model model, HttpSession session, @PathVariable("id") Integer id) {
		//Saco una lista de pedidos del usuario
		Pedido pedido = peds.devuelvePedidoId(id);
		Usuario usuario = us.devuelveUsuarioId(pedido.getIdUsuario());//devuelve el usuario del pedido
		
		
		model.addAttribute("pedido", pedido);
		model.addAttribute("usuario", usuario);
		//listado de todos los detalles del pedido
		model.addAttribute("detallesPedido", dps.devuelveDetallesIdPedido(pedido.getId()));
		model.addAttribute("listaProductos", ps.listadoProductos());
		
		return "/pedido/detalle";
	}
	
	//Procede a cancelar el pedido a través de un cliente
	@GetMapping("/cancelar/{id}")
	public String cancelar(Model model,HttpSession session, @PathVariable("id") Integer id) {
		
		Pedido pedido = peds.devuelvePedidoId(id);
		pedido.setEstado("cancelar pendiente");//cancelar pendiente es que todavía no está cancelado
		peds.actualizaPedido(pedido);
		
		return "redirect:/pedido/historial";
	}
	
	//Tramita la cancelación a través del admin
	@GetMapping("/cancelacion/{id}")
	public String tramitarCancelacion(Model model,HttpSession session, @PathVariable("id") Integer id) {
		
		Pedido pedido = peds.devuelvePedidoId(id);
		pedido.setEstado("cancelado");
		peds.actualizaPedido(pedido);
		
		return "redirect:/pedido/tabla";
	}
	
	//Procede a enviar el pedido a través del empleado
	@GetMapping("/enviar/{id}")
	public String enviar(Model model,HttpSession session, @PathVariable("id") Integer id) {
		
		Pedido pedido = peds.devuelvePedidoId(id);
		pedido.setEstado("enviado");//cancelar pendiente es que todavía no está cancelado
		pedido.setNumFactura(peds.sacaNumFactura()); //Pongo el numero de factura una vez se ha enviado
		peds.actualizaPedido(pedido);
		
		return "redirect:/pedido/tabla";
	}
}
