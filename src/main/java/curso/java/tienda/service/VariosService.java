package curso.java.tienda.service;

import java.util.ArrayList;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.Usuario;

@Service
public class VariosService {
	
	@Autowired
	private UsuarioService uS;
	
	public String encriptarClave(String clave) {
		//Encripto la contraseña para guardarla en la BBDD
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		return passwordEncryptor.encryptPassword(clave);//Encripto la contraseña
	}
	
	/**Método que comprueba si hay un usuario administrador en la BDD y sino lo crea*/
	public void compruebaUsuarioAdmin() {
		ArrayList<Usuario> lista = (ArrayList<Usuario>) uS.listadoAdmin();
		
		//Si es true es que hay 'admin' y false que no
		boolean flag = false;
		for(int i = 0; (i < lista.size()) && !flag; i++) {
			if(lista.get(i).getNombre().equals("admin")) {
				flag = true;
			}
		}
		
		//Si no hay lo crea
		if(!flag) {
			Usuario admin = new Usuario();
			admin.setNombre("admin");
			admin.setApellido1(" .");
			admin.setApellido2(" .");
			admin.setClave(encriptarClave("admin"));
			admin.setIdRol(1);
			admin.setEmail("admin@admin.com");
			
			uS.nuevoUsuario(admin);//Lo meto en la bd
		}
	}
}
