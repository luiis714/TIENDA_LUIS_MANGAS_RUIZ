package curso.java.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import curso.java.tienda.model.Usuario;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@GetMapping("/altaUsuario")
	public String altaUsuario(Model model){
		model.addAttribute("usuario", new Usuario());
		
		return "altaUsuario";
	}
	
	@PostMapping("/altaCorrecta")
	public String altaCorrecta(Model model, @ModelAttribute Usuario u){
		System.out.println(u.toString());
		
		return "correcto";
	}
}
