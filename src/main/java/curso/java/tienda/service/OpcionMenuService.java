package curso.java.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.OpcionMenu;
import curso.java.tienda.repository.OpcionMenuRepository;

@Service
public class OpcionMenuService {
	
	@Autowired
	private OpcionMenuRepository repository;
	
	
	public Iterable<OpcionMenu> listadoOpciones(){
		return repository.findAll();
	}
	
	public Iterable<OpcionMenu> listadoOpcionesIdRol(int idRol){
		return repository.findAllByIdRol(idRol);
	}
	
}
