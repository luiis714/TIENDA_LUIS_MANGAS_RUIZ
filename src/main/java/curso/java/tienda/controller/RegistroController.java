package curso.java.tienda.controller;

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
@RequestMapping("/registro")
public class RegistroController {

	@Autowired
	private UsuarioService uS;
	
	@GetMapping("")
	public String login(){
		return "registro";
	}
	
	@PostMapping("/nuevo")
	public String nuevo(Model model, @RequestParam String nombre, @RequestParam String apellido1, @RequestParam String apellido2, @RequestParam String email, @RequestParam String clave) {
		
			uS.insertaUsuario(nombre, apellido1, apellido2, email, clave);
			
			return "redirect:/menu";

	}
}
