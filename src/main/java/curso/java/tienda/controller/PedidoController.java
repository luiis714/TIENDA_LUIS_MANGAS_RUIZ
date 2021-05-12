package curso.java.tienda.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String nuevo(Model model,HttpSession session, @ModelAttribute Pedido pedido) {
		
		
		System.out.println(pedido.toString());
		
		//Vuelvo al inicio
		return "redirect:/";
	}
}
