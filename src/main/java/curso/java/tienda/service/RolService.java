package curso.java.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.Rol;
import curso.java.tienda.repository.RolRepository;

@Service
public class RolService {
	
	@Autowired
	private RolRepository repository;
	
	public Iterable<Rol> listadoRoles(){
		return repository.findAll();
	}
}
