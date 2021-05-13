package curso.java.tienda.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "id_categoria")
	private Integer idCategoria;
	private String nombre;
	private String descripcion;
	private Double precio;
	private Integer stock;
	@Column(name = "fecha_alta")
	private Date fechaAlta;
	@Column(name = "fecha_baja")
	private Date fechaBaja;
	private Float impuesto;
	
	private String imagen;
	


	public Producto() {

	}

	public Producto(Integer id, Integer idCategoria, String nombre, String descripcion, Double precio, Integer stock,
			Date fechaAlta, Date fechaBaja, Float impuesto) {

		this.id = id;
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.impuesto = impuesto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Float getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(Float impuesto) {
		this.impuesto = impuesto;
	}
	
	/**
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", idCategoria=" + idCategoria + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", precio=" + precio + ", stock=" + stock + ", fechaAlta=" + fechaAlta + ", fechaBaja="
				+ fechaBaja + ", impuesto=" + impuesto + "]";
	}

}
