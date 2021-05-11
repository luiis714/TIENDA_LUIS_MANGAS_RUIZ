package curso.java.tienda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "metodos_pago")
public class MetodoPago {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "metodo_pago")
	private String metodoPago;

	public MetodoPago() {
	}

	public MetodoPago(Integer id, String metodoPago) {
		this.id = id;
		this.metodoPago = metodoPago;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	@Override
	public String toString() {
		return "MetodoPago [id=" + id + ", metodoPago=" + metodoPago + "]";
	}
	
	
}
