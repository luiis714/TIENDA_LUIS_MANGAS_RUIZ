package curso.java.tienda.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import curso.java.tienda.model.Producto;
import curso.java.tienda.model.Usuario;
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
		session.setAttribute("listaCategorias", cs.listadoCategorias());//creo la lista de categorias en el inicio
		session.setAttribute("carro", new ArrayList<Producto>());//creo el carro en el inicio
		
		return "producto/lista";
	}
	
	@GetMapping("/detalle")
	public String detalle(Model model,HttpSession session) {
		
		model.addAttribute("listaProductos", ps.listadoProductos());
		
		return "producto/detalle";
	}
	
	@GetMapping("/carro")
	public String carro(Model model,HttpSession session) {
		
		model.addAttribute("lista", session.getAttribute("carro"));
		
		return "producto/carro";
	}
	
	
	@GetMapping("insertar_carro")
	public void insertarCarro(Model model,HttpSession session, @ModelAttribute Producto producto) {
//		((ArrayList<Producto>) session.getAttribute("carro")).add(producto);
		ArrayList<Producto> carro = (ArrayList<Producto>) session.getAttribute("carro");
 		carro.add(producto);
		session.setAttribute("carro", carro);
	}
}
