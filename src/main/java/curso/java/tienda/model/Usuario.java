package curso.java.tienda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer idRol;
	
	@Email(message="Debe ser una dirección de correo electrónico con formato correcto")
	@Column(unique = true)
	private String email;

	@NotBlank(message="La clave es obligatoria")
	private String clave;
	
	@NotBlank(message="El nombre es obligatorio")
	private String nombre;
	
	@NotBlank(message="El primer apellido es obligatorio")
	private String apellido1;
	
	@NotBlank(message="El segundo apellido es obligatorio")
	private String apellido2;
	
	private String direccion;
	
	private String localidad;
	
	private String provincia;
	
//	@Size(min=9, max=9, message="El teléfono debe tener 9 dígitos")
	private String telefono;
	
	private String dni;

	public Usuario() {
	}

	/** Contructor minimo usado para el registro */
	public Usuario(Integer idRol, String email, String clave, String nombre, String apellido1, String apellido2) {
		this.idRol = idRol;
		this.email = email;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}

	public Usuario(Integer idRol, String email, String clave, String nombre, String apellido1, String apellido2,
			String direccion, String localidad, String provincia, String telefono, String dni) {
		this.idRol = idRol;
		this.email = email;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.telefono = telefono;
		this.dni = dni;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdRol() {
		return this.idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", idRol=" + idRol + ", email=" + email + ", clave=" + clave + ", nombre=" + nombre
				+ ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", direccion=" + direccion + ", localidad="
				+ localidad + ", provincia=" + provincia + ", telefono=" + telefono + ", dni=" + dni + "]";
	}
}
