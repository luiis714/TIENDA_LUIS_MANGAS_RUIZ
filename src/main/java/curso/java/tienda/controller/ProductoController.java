package curso.java.tienda.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import curso.java.tienda.repository.ProductoRepository;
import curso.java.tienda.service.CategoriaService;
import curso.java.tienda.service.ProductoService;

@Controller
@RequestMapping("/tienda_luis_mangas_ruiz")
public class ProductoController {
	
	@Autowired
	private ProductoService ps;
	@Autowired
	private CategoriaService cs;
	
	@GetMapping("")
	public String inicio(Model model,HttpSession session) {
		
		model.addAttribute("listaProductos", ps.listadoProductos());
		session.setAttribute("listaCategorias", cs.listadoCategorias());
		
		return "producto/lista";
	}
	
	@GetMapping("/detalle")
	public String detalle(Model model,HttpSession session) {
		
		model.addAttribute("listaProductos", ps.listadoProductos());
		session.setAttribute("listaCategorias", cs.listadoCategorias());
		
		return "producto/detalle";
	}
}
