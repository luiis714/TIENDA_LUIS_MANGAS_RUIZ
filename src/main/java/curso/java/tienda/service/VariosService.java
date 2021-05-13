package curso.java.tienda.service;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.stereotype.Service;

@Service
public class VariosService {
	
	public String encriptarClave(String clave) {
		//Encripto la contraseña para guardarla en la BBDD
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		return passwordEncryptor.encryptPassword(clave);//Encripto la contraseña
	}
	
//	public String desencriptarClave(String clave) {
//		//DesEncripto la contraseña para guardarla en la BBDD
////		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
////		//textEncryptor.setPassword(clave);
////		
////		return textEncryptor.decrypt(clave); 
//	}
}
