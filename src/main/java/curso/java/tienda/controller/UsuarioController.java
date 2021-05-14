package curso.java.tienda.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
import curso.java.tienda.service.VariosService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService uS;
	@Autowired
	private RolService rs;
	@Autowired
	private VariosService vs;
	
	@GetMapping("/perfil")
	public String perfil() {
		
		return "/usuario/perfil";
//		return "redirect:/tienda_luis_mangas_ruiz";
	}
	
	@GetMapping("/perfil/editar/{id}")
	public String editarPerfil(Model model, @PathVariable("id") Integer id) {
		
		Usuario usuario= uS.devuelveUsuarioId(id);
		
//		String clave = vs.desencriptarClave(usuario.getClave());
		model.addAttribute("usuario", usuario);
//		model.addAttribute("clave", clave);

		return "/usuario/editar-perfil";
	}
	
	@PostMapping("/perfil/editar/enviar")
	public String editarPerfilSubmit(Model model, HttpSession session, @ModelAttribute Usuario usuario) {
		
		uS.actualizarUsuario(usuario);
		//Lo meto en sesion cuando termino de editarlo para que quede constracia en la session
		session.setAttribute("usuario", usuario);
		
		return "redirect:/usuario/perfil";
	}
	
	@GetMapping("/cliente/tabla")
	public String tablaCliente(Model model, HttpSession session) {
		//Añado lista de productos
		model.addAttribute("listaRoles", rs.listadoRoles());
		model.addAttribute("listaUsuarios", uS.listadoClientes());
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		else {
			return "/usuario/tabla";	
		}
	}
	
	@GetMapping("/empleado/tabla")
	public String tablaEmpleado(Model model, HttpSession session) {
		//Añado lista de productos
		model.addAttribute("listaRoles", rs.listadoRoles());
		model.addAttribute("listaUsuarios", uS.listadoEmpleados());
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		else {
			return "/usuario/tabla";	
		}
	}
	
	@GetMapping("/admin/tabla")
	public String tablaAdmin(Model model, HttpSession session) {
		//Añado lista de productos
		model.addAttribute("listaRoles", rs.listadoRoles());
		model.addAttribute("listaUsuarios", uS.listadoAdmin());
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		else {
			return "/usuario/tabla";	
		}
	}
	
	@GetMapping("/nuevo_cliente")
	public String nuevoCliente(Model model,HttpSession session) {
		//Creo un nuevo cliente
		model.addAttribute("listaRoles", rs.listadoRoles());
		
		Usuario usuario = new Usuario();
		usuario.setIdRol(3);//Id de cliente
		model.addAttribute("usuario", usuario);
		
		return "/usuario/nuevo";
	}
	
	@GetMapping("/nuevo_usuario")
	public String nuevo(Model model,HttpSession session) {
		//Creo un nuevo cliente
		model.addAttribute("listaRoles", rs.listadoRoles());
		model.addAttribute("usuario", new Usuario());
		
		return "/usuario/nuevo";
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
	public String editarSubmit(Model model, @Valid @ModelAttribute Usuario usuario, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "/usuario/editar_usuario/{id}"+usuario.getId();
		}
		else {
			uS.actualizarUsuario(usuario);
			
			return "redirect:/";
		}
	}
	
	@GetMapping("/borrar_cliente/{id}")
	public String borrarCliente(Model model,HttpSession session, @PathVariable("id") Integer id) {

		uS.borrarUsuario(id);
		
		return "redirect:/usuario/cliente/tabla";
	}
	
	@GetMapping("/borrar_empleado/{id}")
	public String borrarEmpleado(Model model,HttpSession session, @PathVariable("id") Integer id) {

		uS.borrarUsuario(id);
		
		return "redirect:/usuario/empleado/tabla";
	}
	
	@GetMapping("/borrar_admin/{id}")
	public String borrarAdmin(Model model,HttpSession session, @PathVariable("id") Integer id) {

		uS.borrarUsuario(id);
		
		return "redirect:/usuario/admin/tabla";
	}
	
	@GetMapping("/cerrar_sesion")
	public String cerrarSesion(HttpSession session) {
		
		uS.cerrarSesion(session);
		
		return "redirect:/";
//		return "redirect:/tienda_luis_mangas_ruiz";
	}
}
