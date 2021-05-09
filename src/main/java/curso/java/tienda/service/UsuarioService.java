package curso.java.tienda.service;

import javax.servlet.http.HttpSession;

import org.jasypt.util.password.StrongPasswordEncryptor;
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
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		
		//Si el usuario no es null y su clave es la misma que la que de ha introducido
		//Compruebo la contraseña encriptada
		if((usuario != null) && (passwordEncryptor.checkPassword(clave, usuario.getClave())))
			return true;
		else
			return false;
	}
	
	public void insertaUsuario(String nombre, String apellido1, String apellido2, String email, String clave) {
		//Lo creo como id rol 3 ya que es el cliente
		Usuario usuario = new Usuario(3, email, clave, nombre, apellido1, apellido2);
		
		//Guardo en la BBDD
		repository.save(usuario);
	}
	
	public void insertaUsuario(Usuario usuario) {
		//Rol 3 porque son clientes
		usuario.setIdRol(3);
		
		//Encripto la contraseña para guardarla en la BBDD
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		usuario.setClave(passwordEncryptor.encryptPassword(usuario.getClave()));//Encripto la contraseña
		
		//Guardo en la BBDD
		repository.save(usuario);
	}
	
	public void cerrarSesion(HttpSession session) {
		
		if(session != null) {
			session.invalidate();
		}
	}
}
