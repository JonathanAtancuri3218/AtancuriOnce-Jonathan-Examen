package ec.edu.ups.controlador;

import java.io.Serializable;


import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.ClienteFacade;
import ec.edu.ups.entidades.Cliente;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class ClienteBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@EJB
	private ClienteFacade ejbCliente;
	
	private String cedula;
	private String nombre;
	private String apellido;
	private String telefono;
	private String direccion;
	private String correo;
	
	public ClienteBean() {
		
	}
	
	public void agregarPersona() {
		
		
		
    	if(nombre!=null && nombre.equals("")!=true) {
    		Cliente cliente= new Cliente(cedula, nombre, apellido, direccion, telefono, correo);
    		ejbCliente.create(cliente);
        	nombre="";
        	apellido="";
        	direccion="";
        	telefono="";
        	cedula="";
        	correo="";
    	}
    	
    	
    		
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
	
	
	
	
}
