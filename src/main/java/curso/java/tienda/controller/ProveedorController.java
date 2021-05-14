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

import curso.java.tienda.model.Proveedor;
import curso.java.tienda.service.ProveedorService;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {
	
	@Autowired
	private ProveedorService ps;
	
	@GetMapping("/tabla")
	public String tabla(Model model, HttpSession session) {
		//Añado lista de proveedores
		model.addAttribute("listaProveedores", ps.listadoProveedores());
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		else {
			return "proveedor/tabla";	
		}
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model,HttpSession session) {
		model.addAttribute("proveedor", new Proveedor());
		
		return "proveedor/nuevo";
	}
	
	@PostMapping("/nuevo/enviar")
	public String nuevoSubmit(Model model, @ModelAttribute Proveedor proveedor) {
		ps.nuevoProveedor(proveedor);
		
		return "redirect:/proveedor/tabla";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(Model model,HttpSession session, @PathVariable("id") Integer id) {
		Proveedor proveedor = ps.devuelveProveedorId(id);
		
		model.addAttribute("proveedor", proveedor);
		
		return "proveedor/editar";
	}
	
	@PostMapping("/editar/enviar")
	public String editarSubmit(Model model, @ModelAttribute Proveedor proveedor) {
		ps.nuevoProveedor(proveedor);
		
		return "redirect:/proveedor/tabla";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrar(Model model,HttpSession session, @PathVariable("id") Integer id) {

		ps.borrarProveedor(id);
		
		return "redirect:/proveedor/tabla";
	}
	
}
