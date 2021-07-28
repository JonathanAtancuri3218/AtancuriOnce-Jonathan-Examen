package ec.edu.ups.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.Cliente;
import ec.edu.ups.entidades.Restuarante;

/**
 * Session Bean implementation class RestauranteFacade
 */
@Stateless
public class RestauranteFacade extends AbstractFacade<Restuarante>{

	@PersistenceContext(unitName = "exa-pra")
	private EntityManager em;
	
    public RestauranteFacade() {
    	super(Restuarante.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public Restuarante buscarPorNombre(String nombre) {
		
		System.out.println("Nombre: "+nombre);
    	Restuarante restaurante=null;
    	String consulta = "Select c From Restuarante c Where c.nombre=:nombre";
    	try {
    		restaurante= (Restuarante) em.createQuery(consulta).setParameter("nombre", nombre).getSingleResult();
    	}catch(Exception e) {
    		System.out.println(">>>Warning (buscarPorCedula: )"+e.getMessage());
    	}
    	return restaurante;
    }
	
public Restuarante buscarPorFecha(String fecha) {
		
		System.out.println("Fecha: "+fecha);
    	Restuarante restaurante=null;
    	String consulta = "Select c From Restuarante c Where c.fecha=:fecha";
    	try {
    		restaurante= (Restuarante) em.createQuery(consulta).setParameter("fecha", fecha).getSingleResult();
    	}catch(Exception e) {
    		System.out.println(">>>Warning (buscarPorFecha: )"+e.getMessage());
    	}
    	return restaurante;
    }


}
