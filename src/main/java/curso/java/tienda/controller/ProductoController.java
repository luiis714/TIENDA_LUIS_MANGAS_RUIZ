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
	public String inicio(Model model, HttpSession session, @RequestParam(name="buscar", required=false, defaultValue="") String cadena, @RequestParam(name="valor", required=false, defaultValue="nombre") String valor) {
		
		Iterable<Producto> listaProductos = null;
		
		if(cadena.equals("")) {
			listaProductos = ps.listadoProductos();
		}
		else if(valor.equals("nombre")){
			listaProductos = ps.buscadorNombre(cadena);
		}
		else if(valor.equals("precio-mayor-que")) {
			listaProductos = ps.buscadorPrecioMayor(cadena);
		}
		else if(valor.equals("precio-menor-que")) {
			listaProductos = ps.buscadorPrecioMenor(cadena);
		}
		
		model.addAttribute("listaProductos", listaProductos);
		session.setAttribute("listaCategorias", cs.listadoCategorias());//creo la lista de categorias en el inicio
		Usuario usuario = null;
		
		//Si es null es anónimo
		if(session.getAttribute("usuario") == null) {
			session.setAttribute("opcionesMenu", oms.listadoOpcionesIdRol(4));	
		}
		else {
			//Si no es null es que esta logueado
			usuario = (Usuario) session.getAttribute("usuario");
			session.setAttribute("opcionesMenu", oms.listadoOpcionesIdRol(usuario.getIdRol()));
		}
		
		//Si el usuario es null es anonimo y 3 es cliente
		if((usuario == null) || (usuario.getIdRol() == 3)) {
			return "producto/lista";
		}
		else if((usuario.getIdRol() == 1) || (usuario.getIdRol() == 2)) {
			//Si es empleado a admin entra directamente en tabla productos y no en lista
			return "redirect:/tabla";
		} else {
			//Si no es cliente
			return "producto/lista";
		}
			
	}
	
	@GetMapping("/tabla")
	public String tabla(Model model, HttpSession session) {
		//Añado lista de productos
		model.addAttribute("listaProductos", ps.listadoProductos());
		model.addAttribute("listaCategorias", cs.listadoCategorias());
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		else {
			return "producto/tabla";	
		}
		
	}
	
	@GetMapping("/detalle/{id}")
	public String detalle(Model model,HttpSession session, @PathVariable("id") Integer id) {
		
		Producto producto = ps.getProductoId(id);
		
		model.addAttribute("producto", producto);
		model.addAttribute("listaCategorias", cs.listadoCategorias());
		
		return "producto/detalle";
	}
	
	@GetMapping("/nuevo_producto")
	public String nuevo(Model model,HttpSession session) {
		model.addAttribute("producto", new Producto());
		model.addAttribute("listaCategorias", cs.listadoCategorias());
		
		return "producto/nuevo";
	}
	
	@PostMapping("/nuevo/enviar")
	public String nuevoSubmit(Model model, @ModelAttribute Producto producto) {
		ps.nuevoProducto(producto);
		model.addAttribute("listaCategorias", cs.listadoCategorias());
		
		return "redirect:/";
	}
	
	@GetMapping("/editar_producto/{id}")
	public String editar(Model model, @PathVariable("id") Integer id) {
		
		Producto producto = ps.getProductoId(id);
		
		model.addAttribute("producto", producto);
		model.addAttribute("listaCategorias", cs.listadoCategorias());//Listado para escoger la categoriaS
		
		return "producto/editar";
	}
	
	@PostMapping("/editar/enviar")
	public String editarSubmit(Model model, @ModelAttribute Producto producto) {
		ps.actualizarProducto(producto);
		
		model.addAttribute("listaCategorias", cs.listadoCategorias());
		
		return "redirect:/";
	}
	
	@GetMapping("/borrar_producto/{id}")
	public String borrar(Model model,HttpSession session, @PathVariable("id") Integer id) {

		ps.borrarProducto(id);
		
		return "redirect:/";
	}
	
	
	@GetMapping("/carro")
	public String carro(HttpSession session, Model model) {
		
		ArrayList<Producto> carro = null;
		//Si el carro no está creado, lo creo para evitar errores
		if((ArrayList<Producto>) session.getAttribute("carro") == null) {
			carro = new ArrayList<Producto>();
			session.setAttribute("carro", carro);
		}
		
		carro = (ArrayList<Producto>) session.getAttribute("carro");
		
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
