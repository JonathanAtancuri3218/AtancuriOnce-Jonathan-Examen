package ec.edu.ups.controlador;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.ReservaFacade;
import ec.edu.ups.ejb.RestauranteFacade;
import ec.edu.ups.entidades.Cliente;
import ec.edu.ups.entidades.Restuarante;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named("restauranteBean")
@RequestScoped
public class RestauranteBean implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@EJB
	private RestauranteFacade ejbRestaurante;
	
	
	private String nombre;
	private String telefono;
	private String direccion;
	private int aforo;
	
	public RestauranteBean() {
		
	}
	
	
	public void agregarResturante() {
		
    	if(nombre!=null && nombre.equals("")!=true) {
    		Restuarante r = new Restuarante(nombre, direccion, telefono, aforo);
    		ejbRestaurante.create(r);
        	nombre="";      	
        	direccion="";
        	telefono="";
        	aforo=0;
    	}
    	
    	
    		
    }


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}
	
	
	
}
