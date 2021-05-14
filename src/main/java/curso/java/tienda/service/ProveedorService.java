package curso.java.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.Categoria;
import curso.java.tienda.model.Proveedor;
import curso.java.tienda.model.Usuario;
import curso.java.tienda.repository.ProveedorRepository;
import curso.java.tienda.repository.UsuarioRepository;

@Service
public class ProveedorService {

	@Autowired
	private ProveedorRepository repository;
	
	public void nuevoProveedor(Proveedor proveedor) {
		repository.save(proveedor);
	}
	
	public void actualizarProveedor(Proveedor proveedor) {
		repository.save(proveedor);
	}
	
	public void borrarProveedor(Integer id) {
		repository.deleteById(id);
	}

	public Iterable<Proveedor>  listadoProveedores() {
		return repository.findAll();
	}

	public Proveedor devuelveProveedorId(int id) {
		return repository.findById(id);
	}
}
