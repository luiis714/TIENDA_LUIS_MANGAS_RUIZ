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

import curso.java.tienda.model.Configuracion;
import curso.java.tienda.model.Usuario;
import curso.java.tienda.service.ConfiguracionService;
import curso.java.tienda.service.UsuarioService;

@Controller
@RequestMapping("/configuracion")
public class ConfiguracionController {
	
	@Autowired
	private ConfiguracionService cs;
	
	@GetMapping("/tabla")
	public String tablaCliente(Model model, HttpSession session) {
		//Añado lista de config
		model.addAttribute("listaConfiguraciones", cs.listadoConfiguraciones());
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		else {
			return "configuracion/tabla";	
		}
	}
	
	@GetMapping("/editar/{id}")
	public String editarl(Model model, @PathVariable("id") Integer id) {
		
		Configuracion configuracion = cs.devuelveConfiguracionId(id);
		
		model.addAttribute("configuracion", configuracion);

		return "/configuracion/editar";
	}
	
	@PostMapping("/editar/enviar")
	public String editarPerfilSubmit(Model model, HttpSession session, @ModelAttribute Configuracion configuracion) {
		
		cs.actualizarConfiguracion(configuracion);
		
		return "redirect:/configuracion/tabla";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model,HttpSession session) {
		//Creo un nuevo cliente
		model.addAttribute("configuracion", new Configuracion());
		
		return "/configuracion/nuevo";
	}
	
	@PostMapping("/nuevo/enviar")
	public String nuevoSubmit(Model model, @ModelAttribute Configuracion configuracion) {
		//Inserto el usuario nuevo
		cs.nuevaConfiguracion(configuracion);
		
		
		
		return "redirect:/configuracion/tabla";
	}
}
