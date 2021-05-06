package curso.java.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import curso.java.tienda.repository.ProductoRepository;
import curso.java.tienda.service.ProductoService;

@Controller
@RequestMapping("")
public class ProductoController {
	
	@Autowired
	private ProductoService ps;
	
	@GetMapping("")
	public String portada(Model model) {
		model.addAttribute("listaProductos", ps.listadoProductos());
		
		return "producto/lista";
	}
}
