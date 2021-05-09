package curso.java.tienda.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import curso.java.tienda.service.CategoriaService;

@Controller
@RequestMapping("")
public class IndexController {

	@Autowired
	private CategoriaService cs;
	
	@GetMapping("")
	public String inicio(HttpSession session) {
		//Meto el listado de categorias en el sesión
		
		
		//Redirige a la página principal de la aplicación
		return "redirect:/tienda_luis_mangas_ruiz";
	}
}
