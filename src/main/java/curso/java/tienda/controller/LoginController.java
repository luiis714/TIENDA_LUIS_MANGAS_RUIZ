package curso.java.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping("")
	public String login(){
		return "login";
	}
	
	@PostMapping("/comprueba")
	public String comprueba(Model model, @RequestParam String email, @RequestParam String clave) {
		Usuario usuario = 
		
		
		return "redirect:/menu";
	}
	
}
