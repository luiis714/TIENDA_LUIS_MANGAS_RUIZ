package curso.java.tienda.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import curso.java.tienda.model.Producto;
import curso.java.tienda.model.Usuario;
import curso.java.tienda.repository.ProductoRepository;
import curso.java.tienda.service.CategoriaService;
import curso.java.tienda.service.OpcionMenuService;
import curso.java.tienda.service.ProductoService;

@Controller
@RequestMapping("")
public class ProductoController {
	
	@Autowired
	private ProductoService ps;
	@Autowired
	private CategoriaService cs;
	@Autowired
	private OpcionMenuService oms;
	
	@GetMapping("")
	public String inicio(Model model,HttpSession session) {
		
		model.addAttribute("listaProductos", ps.listadoProductos());
		session.setAttribute("listaCategorias", cs.listadoCategorias());//creo la lista de categorias en el inicio
		
		//Si es null es anónimo
		if(session.getAttribute("usuario") == null) {
			session.setAttribute("opcionesMenu", oms.listadoOpcionesIdRol(4));	
		}
		else {
			//Si no es null es que esta logueado
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			session.setAttribute("opcionesMenu", oms.listadoOpcionesIdRol(usuario.getIdRol()));
		}
		
		return "producto/lista";
	}
	
	@GetMapping("/detalle")
	public String detalle(Model model,HttpSession session) {
		
		model.addAttribute("listaProductos", ps.listadoProductos());
		
		return "producto/detalle";
	}
	
	@GetMapping("/carro")
	public String carro(Model model,HttpSession session) {
		
		return "producto/carro";
	}
	
	
	@GetMapping("/insertar_carro/{id}")
	public String insertarCarro(Model model, HttpSession session, @PathVariable("id") Integer id) {
		
		ArrayList<Producto> carro = null;
		
		if(session.getAttribute("carro") == null) {
			carro = new ArrayList<Producto>();
			Producto producto = ps.getProductoId(id);
			carro.add(producto);	
		}
		else {
			carro = (ArrayList<Producto>) session.getAttribute("carro");
			Producto producto = ps.getProductoId(id);
			carro.add(producto);
		}
		
		System.out.println(carro.size());
		
		session.setAttribute("carro", carro);
		
		return "redirect:/";
	}
}
