package curso.java.tienda.service;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.stereotype.Service;

@Service
public class VariosService {
	
	public String encriptarClave(String clave) {
		//Encripto la contraseña para guardarla en la BBDD
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		return passwordEncryptor.encryptPassword(clave);//Encripto la contraseña
	}
	
}
