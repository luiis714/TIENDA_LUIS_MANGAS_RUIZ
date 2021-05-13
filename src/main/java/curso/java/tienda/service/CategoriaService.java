package curso.java.tienda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.Categoria;
import curso.java.tienda.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public Iterable<Categoria> listadoCategorias(){
		return repository.findAll();
	}

	public Categoria getCategoriaName(String nombre) {
		return repository.findByNombre(nombre);
	}

	public Categoria devuelveCategoriaId(int id) {
		return repository.findById(id);
	}

	public void nuevaCategoria(Categoria categoria) {
		repository.save(categoria);
		
	}

	public void borrarCategoria(Integer id) {
		repository.deleteById(id);
		
	}
	
}
