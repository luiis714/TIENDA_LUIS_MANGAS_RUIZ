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
import org.springframework.web.bind.annotation.RequestParam;

import curso.java.tienda.model.Producto;
import curso.java.tienda.model.Usuario;
import curso.java.tienda.service.RolService;
import curso.java.tienda.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService uS;
	@Autowired
	private RolService rs;
	
	@GetMapping("/perfil")
	public String perfil() {
		
		return "/usuario/perfil";
//		return "redirect:/tienda_luis_mangas_ruiz";
	}
	
	@GetMapping("/cliente/tabla")
	public String tabla(Model model, HttpSession session) {
		//Añado lista de productos
		model.addAttribute("listaRoles", rs.listadoRoles());
		model.addAttribute("listaUsuarios", uS.listadoClientes());
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		else {
			return "usuario/tabla";	
		}
	}
	
	@GetMapping("/nuevo_usuario")
	public String nuevo(Model model,HttpSession session) {
		//Creo un nuevo cliente
		model.addAttribute("listaRoles", rs.listadoRoles());
		model.addAttribute("usuario", new Usuario());
		
		return "usuario/nuevo";
	}
	
	@PostMapping("/nuevo_usuario/enviar")
	public String nuevoSubmit(Model model, @ModelAttribute Usuario usuario) {
		//Inserto el usuario nuevo
		uS.nuevoUsuario(usuario);
		
		return "redirect:/";
	}
	
	@GetMapping("/editar_usuario/{id}")
	public String editar(Model model, @PathVariable("id") Integer id) {
		
		Usuario usuario= uS.devuelveUsuarioId(id);
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("listaRoles", rs.listadoRoles());
		
		return "usuario/editar";
	}
	
	@GetMapping("/editar_cliente/{id}")
	public String editarCliente(Model model, @PathVariable("id") Integer id) {
		
		Usuario usuario= uS.devuelveUsuarioId(id);
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("listaRoles", rs.listadoRoles());
		
		return "usuario/editar";
	}
	
	@PostMapping("/editar_usuario/enviar")
	public String editarSubmit(Model model, @ModelAttribute Usuario usuario) {
		
		uS.actualizarUsuario(usuario);
		
		return "redirect:/";
	}
	
	@GetMapping("/borrar_cliente/{id}")
	public String borrar(Model model,HttpSession session, @PathVariable("id") Integer id) {

		uS.borrarUsuario(id);
		
		return "redirect:/usuario/cliente/tabla";
	}
	
	@GetMapping("/cerrar_sesion")
	public String cerrarSesion(HttpSession session) {
		
		uS.cerrarSesion(session);
		
		return "redirect:/";
//		return "redirect:/tienda_luis_mangas_ruiz";
	}
}
