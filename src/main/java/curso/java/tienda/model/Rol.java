package curso.java.tienda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String rol;

	public Rol() {
		
	}

	public Rol(Integer id, String rol) {
		
		this.id = id;
		this.rol = rol;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", rol=" + rol + "]";
	}
	
	
}
