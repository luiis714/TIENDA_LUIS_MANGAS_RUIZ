package curso.java.tienda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "configuracion")
public class Configuracion {

	@Id
	@GeneratedValue
	private Integer id;

	private String clave;
	private String valor;
	private String tipo;

	public Configuracion() {

	}

	public Configuracion(Integer id, String clave, String valor, String tipo) {
		super();
		this.id = id;
		this.clave = clave;
		this.valor = valor;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Configuracion [id=" + id + ", clave=" + clave + ", valor=" + valor + ", tipo=" + tipo + "]";
	}

}
