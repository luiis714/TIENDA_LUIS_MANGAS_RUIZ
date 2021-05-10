package curso.java.tienda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "opciones_menu")
public class OpcionMenu {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "id_rol")
	private Integer idRol;
	
	private String opcion;
	
	@Column(name = "url_opcion")
	private String urlOpcion;

	public OpcionMenu() {
	}

	public OpcionMenu(Integer id, Integer idRol, String opcion, String urlOpcion) {
		
		this.id = id;
		this.idRol = idRol;
		this.opcion = opcion;
		this.urlOpcion = urlOpcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public String getUrlOpcion() {
		return urlOpcion;
	}

	public void setUrlOpcion(String urlOpcion) {
		this.urlOpcion = urlOpcion;
	}

	@Override
	public String toString() {
		return "OpcionesMenu [id=" + id + ", idRol=" + idRol + ", opcion=" + opcion + ", urlOpcion=" + urlOpcion + "]";
	}
	
	
	
}
