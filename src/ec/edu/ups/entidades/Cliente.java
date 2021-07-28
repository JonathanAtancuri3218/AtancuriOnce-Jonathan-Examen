package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cliente
 *
 */
@Entity

public class Cliente implements Serializable {

	/* 	Un cliente puede registrarse en la aplicación. Para lo cuál, debe ingresar
		sus datos personales: nombres completos, cedula de identidad, correo electrónico, dirección,
		teléfono
		
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String cedula;
	private String nombre;
	private String apellido;
	private String telefono;
	private String direccion;
	private String correo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteReserva")
    private List<Reserva> reservasCliente= new ArrayList<Reserva>();
	
	
	private static final long serialVersionUID = 1L;

	public Cliente() {
		super();
	}

	public Cliente(int id, String cedula, String nombre, String apellido, String telefono, String direccion,
			String correo) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.direccion = direccion;
		this.correo = correo;
	}

	public Cliente(String cedula, String nombre, String apellido, String telefono, String direccion, String correo) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.direccion = direccion;
		this.correo = correo;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public List<Reserva> getReservasCliente() {
		return reservasCliente;
	}

	public void setReservasCliente(List<Reserva> reservasCliente) {
		this.reservasCliente = reservasCliente;
	}
	
	public void addReservasCliente(Reserva reservasCliente) {
		this.reservasCliente.add(reservasCliente);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((reservasCliente == null) ? 0 : reservasCliente.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (reservasCliente == null) {
			if (other.reservasCliente != null)
				return false;
		} else if (!reservasCliente.equals(other.reservasCliente))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", telefono=" + telefono + ", direccion=" + direccion + ", correo=" + correo + ", reservasCliente="
				+ reservasCliente + "]";
	}
	
	
	
   
}
