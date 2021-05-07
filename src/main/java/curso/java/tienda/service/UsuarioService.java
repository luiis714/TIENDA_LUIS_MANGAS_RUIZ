package curso.java.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.Usuario;
import curso.java.tienda.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public Usuario devuelveUsuarioEmail(String email){
		return repository.findByEmail(email);
	}

	public boolean compruebaUsuario(String email, String clave) {
		Usuario usuario = devuelveUsuarioEmail(email);
		
		//Si el usuario no es null y su clave es la misma que la que de ha introducido
		if((usuario != null) && (usuario.getClave().equals(clave)))
			return true;
		else
			return false;
	}
}
