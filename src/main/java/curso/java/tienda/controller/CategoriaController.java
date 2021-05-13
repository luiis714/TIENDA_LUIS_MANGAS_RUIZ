package curso.java.tienda.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import curso.java.tienda.model.Categoria;
import curso.java.tienda.model.Producto;
import curso.java.tienda.service.CategoriaService;
import curso.java.tienda.service.ProductoService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService cs;
	@Autowired
	private ProductoService ps;
	
	@GetMapping("/{id}")
	public String filtra(Model model, @PathVariable("id") Integer id) {
		
		Categoria categoria = cs.devuelveCategoriaId(id);
		model.addAttribute("listaProductos", ps.listadoProductosCategoria(categoria.getId()));
		
		return "producto/lista";
	}
	
	@GetMapping("/tabla")
	public String tabla(Model model, HttpSession session) {
		//Añado lista de productos
		model.addAttribute("listaCategorias", cs.listadoCategorias());
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		else {
			return "categoria/tabla";	
		}
		
	}
	
	@GetMapping("/nueva")
	public String nuevo(Model model,HttpSession session) {
		model.addAttribute("categoria", new Categoria());
		
		return "categoria/nuevo";
	}
	
	@PostMapping("/nueva/enviar")
	public String nuevoSubmit(Model model, @ModelAttribute Categoria categoria) {
		cs.nuevaCategoria(categoria);
		
		return "redirect:/categoria/tabla";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrar(Model model,HttpSession session, @PathVariable("id") Integer id) {

		cs.borrarCategoria(id);
		
		return "redirect:/categoria/tabla";
	}
	
	@GetMapping("/libros")
	public String libros(Model model) {
		
		Categoria categoria = cs.getCategoriaName("Libros");
		model.addAttribute("listaProductos", ps.listadoProductosCategoria(categoria.getId()));
		
		return "producto/lista";
	}
	
	@GetMapping("/tecnologia")
	public String tecnologia(Model model) {
		
		Categoria categoria = cs.getCategoriaName("Tecnologia");
		model.addAttribute("listaProductos", ps.listadoProductosCategoria(categoria.getId()));
		
		return "producto/lista";
	}
	
}
