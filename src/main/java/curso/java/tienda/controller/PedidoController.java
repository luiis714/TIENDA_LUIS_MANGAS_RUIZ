package curso.java.tienda.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import curso.java.tienda.model.Pedido;
import curso.java.tienda.model.Producto;
import curso.java.tienda.model.Usuario;
import curso.java.tienda.service.PedidoService;
import curso.java.tienda.service.ProductoService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private ProductoService ps;
	@Autowired
	private PedidoService peds;
	
	
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
}
