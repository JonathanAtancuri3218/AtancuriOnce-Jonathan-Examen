package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Restuarante
 *
 */
@Entity

public class Restuarante implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/*
	  	Un restaurante puede registrarse en la aplicación. Para lo cuál,
		debe ingresar los siguientes datos: nombre, dirección, teléfono y máximo número de aforo
		(personas)
	 
	 */
	
	private String nombre;
	private String direccion;
	private String telefono;
	private int aforo;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "restauranteReserva")
    private List<Reserva> reservasRestaurante= new ArrayList<Reserva>();
	
	
	public Restuarante() {
		super();
	}


	public Restuarante(int id, String nombre, String direccion, String telefono, int aforo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.aforo = aforo;
	}


	public Restuarante(String nombre, String direccion, String telefono, int aforo) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.aforo = aforo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public int getAforo() {
		return aforo;
	}


	public void setAforo(int aforo) {
		this.aforo = aforo;
	}


	public List<Reserva> getReservasRestaurante() {
		return reservasRestaurante;
	}


	public void setReservasRestaurante(List<Reserva> reservasRestaurante) {
		this.reservasRestaurante = reservasRestaurante;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aforo;
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((reservasRestaurante == null) ? 0 : reservasRestaurante.hashCode());
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
		Restuarante other = (Restuarante) obj;
		if (aforo != other.aforo)
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
		if (reservasRestaurante == null) {
			if (other.reservasRestaurante != null)
				return false;
		} else if (!reservasRestaurante.equals(other.reservasRestaurante))
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
		return "Restuarante [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", aforo=" + aforo + ", reservasRestaurante=" + reservasRestaurante + "]";
	}
	
	
   
}
