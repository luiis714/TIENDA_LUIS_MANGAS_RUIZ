package curso.java.tienda.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String registro(Model model){
		model.addAttribute("usuario", new Usuario());
		
		return "registro";
	}
	
	@PostMapping("/nuevo")
	public String nuevo(HttpSession session, Model model, @Valid @ModelAttribute Usuario usuario, BindingResult bindingResult) {
		
//			uS.insertaUsuario(nombre, apellido1, apellido2, email, clave);
			
//			Usuario usuario = uS.devuelveUsuarioEmail(email);
//			session.setAttribute("usuario", usuario);
			
		if(bindingResult.hasErrors()) {
			return "/registro";
		}
		else {
			uS.insertaUsuario(usuario);
			return "redirect:/";
		}
		
			
	}
}
