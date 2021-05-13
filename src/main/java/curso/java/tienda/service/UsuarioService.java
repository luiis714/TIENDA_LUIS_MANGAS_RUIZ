package curso.java.tienda.service;

import java.util.Optional;

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
	@Autowired
	private VariosService service;
	
	public Usuario devuelveUsuarioEmail(String email){
		return repository.findByEmail(email);
	}
	
	public Usuario devuelveUsuarioId(int id){
		return repository.findById(id);
	}
	
	public Iterable<Usuario> listadoClientes(){
		//Devuelvo todos los usuarios que tengan el rol 3 de cliente
		return repository.findAllByIdRol(3);
	}
	
	public Object listadoEmpleados() {
		//Devuelvo todos los usuarios que tengan el rol 2 de empleado
		return repository.findAllByIdRol(2);
	}
	
	public boolean compruebaUsuario(String email, String clave) {
		Usuario usuario = devuelveUsuarioEmail(email);
		//Para desencriptar la clave
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		
		//Si el usuario no es null y su clave es la misma que la que de ha introducido
		//Compruebo la contraseña encriptada
		if((usuario != null) && (passwordEncryptor.checkPassword(clave, usuario.getClave())))
			return true;
		else
			return false;
	}
	
	public void insertaUsuario(Usuario usuario) {
		//Rol 3 porque son clientes
		usuario.setIdRol(3);
		
		usuario.setClave(service.encriptarClave((usuario.getClave())));//Encripto la contraseña
		
		//Guardo en la BBDD
		repository.save(usuario);
	}
	
	public void nuevoUsuario(Usuario usuario) {
		usuario.setClave(service.encriptarClave((usuario.getClave())));//Encripto la contraseña
		
		repository.save(usuario);
	}
	
	public void actualizarUsuario(Usuario usuario) {
		repository.save(usuario);
	}
	
	public void borrarUsuario(Integer id) {
		repository.deleteById(id);
	}
	
	public void cerrarSesion(HttpSession session) {
		if(session != null) {
			session.invalidate();
		}
	}
}
