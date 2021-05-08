package curso.java.tienda.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import curso.java.tienda.model.Usuario;
import curso.java.tienda.service.UsuarioService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UsuarioService uS;
	
	@GetMapping("")
	public String login(){
		return "login";
	}
	
	@PostMapping("/comprueba")
	public String comprueba(HttpSession session, Model model, @RequestParam String email, @RequestParam String clave) {
		
		//Comprueba el email y la clave y si son correctos inicia sesión
		if(uS.compruebaUsuario(email, clave)) {
			Usuario usuario = uS.devuelveUsuarioEmail(email);
			session.setAttribute("usuario", usuario);
			
			return "redirect:/tienda_luis_mangas_ruiz";
		}
		else {
			return "login";
		}
	}
	
}
