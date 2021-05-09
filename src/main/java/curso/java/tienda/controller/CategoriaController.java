package curso.java.tienda.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import curso.java.tienda.model.Categoria;
import curso.java.tienda.service.CategoriaService;
import curso.java.tienda.service.ProductoService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService cs;
	@Autowired
	private ProductoService ps;
	
	@GetMapping("/libros")
	public String libros(Model model) {
		
		Categoria categoria = cs.getCategoriaName("Libros");
		model.addAttribute("listaProductos", ps.listadoProductosCategoria(categoria.getId()));
		
		return "categoria/lista";
	}
	
	@GetMapping("/tecnologia")
	public String tecnologia(Model model) {
		
		Categoria categoria = cs.getCategoriaName("Tecnologia");
		model.addAttribute("listaProductos", ps.listadoProductosCategoria(categoria.getId()));
		
		return "producto/lista";
	}
	
}
