package curso.java.tienda.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import curso.java.tienda.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	Usuario findById(int id);
	Iterable<Usuario> findAllByIdRol(int idRol);
	Usuario findByEmail(String email);
}
