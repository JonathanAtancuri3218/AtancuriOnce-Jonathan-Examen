package ec.edu.ups.controlador;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.ClienteFacade;
import ec.edu.ups.ejb.ReservaFacade;
import ec.edu.ups.ejb.RestauranteFacade;
import ec.edu.ups.entidades.Cliente;
import ec.edu.ups.entidades.Reserva;
import ec.edu.ups.entidades.Restuarante;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class ReservaBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@EJB
	private ReservaFacade ejbReserva;
	@EJB
	private ClienteFacade ejbCliente;
	@EJB 
	private RestauranteFacade ejbRestaurante;
	
	private String nombre;
	private String apellido;
    private String direccion;
    private String telefono;
    private String cedula;
    private String correo;
    private String password;
    private Cliente cliente; 
    
    
    private String nombreRestaurante;
    private String fechaRestaurante;
    private Restuarante restaurante;
    private String direccionRestuarante;
	private String telefonoRestuarante;
	private int aforo;
    
	
	
	private String fechaIngreso; 
	private int numeroPersonas; 
	private String mensaje;
   
	public ReservaBean() {
		
	}
	
	 public void buscarPersonaCedulaCliente() {
	    	cliente = ejbCliente.buscarPorCedula(cedula);
	    	System.out.println("Cliente: ");
	    	if (cliente != null) {
	    		this.setNombre(cliente.getNombre());
		    	this.setApellido(cliente.getApellido());
		    	this.setDireccion(cliente.getDireccion());
		    	this.setTelefono(cliente.getTelefono());
		    	this.setCorreo(cliente.getCorreo());
			}else {
				System.out.println("Cedula no encontrada: "+cedula);
				
			}
	    	
	 }
	 
	 
	 public void buscarRestauranteNombre() {
		 	restaurante = ejbRestaurante.buscarPorNombre(nombreRestaurante);
	    	
	    	if (restaurante != null) {
	    		this.setDireccionRestuarante(restaurante.getDireccion()); 
		    	this.setTelefonoRestuarante(restaurante.getTelefono());
		    	this.setAforo(restaurante.getAforo());
			}else {
				System.out.println("nombreRestaurante: "+nombreRestaurante);
				
			}
	    	
	 }
	 
	 public void buscarRestauranteFecha() {
		 
		 Date date = Calendar.getInstance().getTime();  
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
		 fechaRestaurante = dateFormat.format(date);  
		    
		 	restaurante = ejbRestaurante.buscarPorFecha(fechaRestaurante);
	    	
	    	if (restaurante != null) {
	    		this.setDireccionRestuarante(restaurante.getDireccion()); 
		    	this.setTelefonoRestuarante(restaurante.getTelefono());
		    	this.setAforo(restaurante.getAforo());
			}else {
				System.out.println("fechaRestaurante: "+fechaRestaurante);
				
			}
	    	
	 }
	 
	 public void crearReservaRest(){
		 
		System.out.println("Si llega");
		 
		Restuarante resturante = null;
		Cliente cliente = null;
		Reserva reserva = null;
		
		try {
			resturante = ejbRestaurante.buscarPorNombre(nombreRestaurante);
			cliente = ejbCliente.buscarPorCedula(cedula);
			
		} catch (Exception e) {
			System.out.println("NO se encontro lo necesario");
		}
		
		if (cliente != null && resturante != null) {
			
			int capacidad = resturante.getAforo() - numeroPersonas;
			System.out.println("Hola world"+capacidad);
			
			if (capacidad > 1) {
				
				//System.out.println("Hasta aqui"+fechaIngreso);
				
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat formato =  new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
				
				reserva = new Reserva(cal, numeroPersonas, cliente, resturante);
				ejbReserva.create(reserva);
				
				//cal.setTime(formato.parse(fechaIngreso));
				/*
				DateFormat fechaIngresoFormato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date fechaIngresoConDate = null;
				try {
					fechaIngresoConDate = fechaIngresoFormato.parse(fechaIngreso);
					reserva = new Reserva(fechaIngresoConDate, numeroPersonas, cliente, resturante);
					ejbReserva.create(reserva);
				} catch (ParseException e) {
					System.out.println("Problemas con fecha: "+fechaIngreso);
				}
				*/
			}else {
				mensaje = "No hay suficiente espacio en este restaurante";
			}
			
		}else {
			mensaje = "No se a encontrado ni cliente ni restaurante";
		}
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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNombreRestaurante() {
		return nombreRestaurante;
	}

	public void setNombreRestaurante(String nombreRestaurante) {
		this.nombreRestaurante = nombreRestaurante;
	}

	public String getDireccionRestuarante() {
		return direccionRestuarante;
	}

	public void setDireccionRestuarante(String direccionRestuarante) {
		this.direccionRestuarante = direccionRestuarante;
	}

	public String getTelefonoRestuarante() {
		return telefonoRestuarante;
	}

	public void setTelefonoRestuarante(String telefonoRestuarante) {
		this.telefonoRestuarante = telefonoRestuarante;
	}

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getNumeroPersonas() {
		return numeroPersonas;
	}

	public void setNumeroPersonas(int numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	 
	 
	
}
