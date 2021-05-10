package curso.java.tienda.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import curso.java.tienda.model.Usuario;
import curso.java.tienda.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService uS;
	
	@GetMapping("/perfil")
	public String perfil() {
		
		return "/usuario/perfil";
//		return "redirect:/tienda_luis_mangas_ruiz";
	}
	
	
	@GetMapping("/cerrar_sesion")
	public String cerrarSesion(HttpSession session) {
		
		uS.cerrarSesion(session);
		
		return "redirect:/";
//		return "redirect:/tienda_luis_mangas_ruiz";
	}
}
