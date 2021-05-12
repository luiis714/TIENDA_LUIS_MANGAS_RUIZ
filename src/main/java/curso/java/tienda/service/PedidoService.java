package curso.java.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.repository.PedidoRepository;
import curso.java.tienda.repository.ProductoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	
}
