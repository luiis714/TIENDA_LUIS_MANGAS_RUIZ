package curso.java.tienda.repository;

import org.springframework.data.repository.CrudRepository;

import curso.java.tienda.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	public Usuario findById(long id);
	public Iterable<Usuario> findAllById(long id);
	public Usuario findByEmail(String email);
}
