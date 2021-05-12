package curso.java.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.Configuracion;
import curso.java.tienda.repository.ConfiguracionRepository;
import curso.java.tienda.repository.ProductoRepository;

@Service
public class ConfiguracionService {
	
	@Autowired
	private ConfiguracionRepository repository;
	
	public Iterable<Configuracion> listadoConfiguraciones(){
		return repository.findAll();
	}
	
	public Configuracion devuelveConfiguracionClave(String clave) {
		return repository.findByClave(clave);
	}

	public void actualizaCofiguracion(Configuracion configuracion) {
		repository.save(configuracion);
	}
}
