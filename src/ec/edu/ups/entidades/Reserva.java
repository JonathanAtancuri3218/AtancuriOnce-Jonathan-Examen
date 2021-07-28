package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Reserva
 *
 */
@Entity

public class Reserva implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/*
	  	e. Luego, debe ingresar el número de personas, la fecha y la hora de la reserva.
	 
	 */
	private Calendar fecha;
	private int numeroPersonas;
	
	
	@ManyToOne
	@JoinColumn
	private Cliente clienteReserva;
	
	@ManyToOne
	@JoinColumn
	private Restuarante restauranteReserva;
	
	public Reserva() {
		super();
	}

	public Reserva(int id, Calendar fecha, int numeroPersonas, Cliente clienteReserva, Restuarante restauranteReserva) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.numeroPersonas = numeroPersonas;
		this.clienteReserva = clienteReserva;
		this.restauranteReserva = restauranteReserva;
	}
	
	public Reserva(int id, Calendar fecha, int numeroPersonas, Restuarante restauranteReserva) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.numeroPersonas = numeroPersonas;
		this.restauranteReserva = restauranteReserva;
	}
	
	public Reserva(int id, Calendar fecha, int numeroPersonas, Cliente clienteReserva) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.numeroPersonas = numeroPersonas;
		this.clienteReserva = clienteReserva;
	}

	public Reserva(Calendar fecha, int numeroPersonas, Cliente clienteReserva, Restuarante restauranteReserva) {
		super();
		this.fecha = fecha;
		this.numeroPersonas = numeroPersonas;
		this.clienteReserva = clienteReserva;
		this.restauranteReserva = restauranteReserva;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public int getNumeroPersonas() {
		return numeroPersonas;
	}

	public void setNumeroPersonas(int numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}

	public Cliente getClienteReserva() {
		return clienteReserva;
	}

	public void setClienteReserva(Cliente clienteReserva) {
		this.clienteReserva = clienteReserva;
	}

	public Restuarante getRestauranteReserva() {
		return restauranteReserva;
	}

	public void setRestauranteReserva(Restuarante restauranteReserva) {
		this.restauranteReserva = restauranteReserva;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clienteReserva == null) ? 0 : clienteReserva.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + id;
		result = prime * result + numeroPersonas;
		result = prime * result + ((restauranteReserva == null) ? 0 : restauranteReserva.hashCode());
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
		Reserva other = (Reserva) obj;
		if (clienteReserva == null) {
			if (other.clienteReserva != null)
				return false;
		} else if (!clienteReserva.equals(other.clienteReserva))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		if (numeroPersonas != other.numeroPersonas)
			return false;
		if (restauranteReserva == null) {
			if (other.restauranteReserva != null)
				return false;
		} else if (!restauranteReserva.equals(other.restauranteReserva))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", fecha=" + fecha + ", numeroPersonas=" + numeroPersonas + ", clienteReserva="
				+ clienteReserva + ", restauranteReserva=" + restauranteReserva + "]";
	}
	
	
   
}
