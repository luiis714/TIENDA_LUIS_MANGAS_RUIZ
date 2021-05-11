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
import curso.java.tienda.service.MetodoPagoService;
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
	@Autowired
	private MetodoPagoService mps;
	
	@GetMapping("")
	public String inicio(Model model, HttpSession session) {
		
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
	
	@GetMapping("/detalle/{id}")
	public String detalle(Model model,HttpSession session, @PathVariable("id") Integer id) {
		
		Producto producto = ps.getProductoId(id);
		
		model.addAttribute("producto", producto);
		
		return "producto/detalle";
	}
	
	@GetMapping("/carro")
	public String carro(HttpSession session, Model model) {
		ArrayList<Producto> carro = (ArrayList<Producto>) session.getAttribute("carro");
		
		Double total = 0.0d;
		
		//Saco el total de la venta
		for(int i = 0; i < carro.size(); i++) {
			total += carro.get(i).getPrecio();
		}
		
		
		model.addAttribute("metodosPago", mps.listadoMetodos());
		model.addAttribute("precioTotal", total);
		
		
		return "producto/carro";
	}
	
	@GetMapping("/borrar_carro/{id}")
	public String borrarCarro(HttpSession session, @PathVariable("id") Integer id) {
		Producto producto = ps.getProductoId(id);
		ArrayList<Producto> carro = (ArrayList<Producto>) session.getAttribute("carro");
		
		//Lo uso para que no borre si tengo más de un único producto
		boolean flag = true;
		
		for(int i = 0; (i < carro.size()) && flag; i++){
			//Compruebo el id del producto para borrarlo
			if(producto.getId() == carro.get(i).getId()) {
				carro.remove(i);
				flag = false;//para salir del bucle
			}
		}
		
		session.setAttribute("carro", carro);
		
		return "redirect:/carro";
	}
	
	@GetMapping("/insertar_carro/{id}")
	public String insertarCarro(HttpSession session, @PathVariable("id") Integer id) {
		
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
		
		session.setAttribute("carro", carro);
		
		return "redirect:/";
	}
}
