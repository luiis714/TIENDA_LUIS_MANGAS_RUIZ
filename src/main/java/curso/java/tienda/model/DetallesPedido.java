package curso.java.tienda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detalles_pedido")
public class DetallesPedido {
	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "id_pedido")
	private Integer idPedido;
	
	@Column(name = "id_producto")
	private Integer idProducto;
	
	@Column(name = "precio_unidad")
	private Float precioUnidad;
	
	private Integer unidades;
	
	private Float impuesto;
	
	private Double total;

	public DetallesPedido() {
	}

	public DetallesPedido(Integer id, Integer idPedido, Integer idProducto, Float precioUnidad, Integer unidades,
			Float impuesto, Double total) {
		super();
		this.id = id;
		this.idPedido = idPedido;
		this.idProducto = idProducto;
		this.precioUnidad = precioUnidad;
		this.unidades = unidades;
		this.impuesto = impuesto;
		this.total = total;
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
	 * @return the idPedido
	 */
	public Integer getIdPedido() {
		return idPedido;
	}

	/**
	 * @param idPedido the idPedido to set
	 */
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	/**
	 * @return the idProducto
	 */
	public Integer getIdProducto() {
		return idProducto;
	}

	/**
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	/**
	 * @return the precioUnidad
	 */
	public Float getPrecioUnidad() {
		return precioUnidad;
	}

	/**
	 * @param precioUnidad the precioUnidad to set
	 */
	public void setPrecioUnidad(Float precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	/**
	 * @return the unidades
	 */
	public Integer getUnidades() {
		return unidades;
	}

	/**
	 * @param unidades the unidades to set
	 */
	public void setUnidades(Integer unidades) {
		this.unidades = unidades;
	}

	/**
	 * @return the impuesto
	 */
	public Float getImpuesto() {
		return impuesto;
	}

	/**
	 * @param impuesto the impuesto to set
	 */
	public void setImpuesto(Float impuesto) {
		this.impuesto = impuesto;
	}

	/**
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "DetallesPedido [id=" + id + ", idPedido=" + idPedido + ", idProducto=" + idProducto + ", precioUnidad="
				+ precioUnidad + ", unidades=" + unidades + ", impuesto=" + impuesto + ", total=" + total + "]";
	}
	
}
