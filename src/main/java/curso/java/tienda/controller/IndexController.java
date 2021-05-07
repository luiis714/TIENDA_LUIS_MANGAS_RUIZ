package curso.java.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class IndexController {

	@GetMapping("")
	public String inicio() {
		//Redirige a la página principal de la aplicación
		return "redirect:/tienda_luis_mangas_ruiz";
	}
}
