package ec.edu.ups.ejb;

import javax.ejb.LocalBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.Cliente;


/**
 * Session Bean implementation class ClienteFacade
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente>{

	@PersistenceContext(unitName = "exa-pra")
	private EntityManager em;

    public ClienteFacade() {
        super(Cliente.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public Cliente buscarPorCedula (String cedula) {
		
		System.out.println("Cedula en buscar cedula: "+cedula);
    	Cliente persona=null;
    	String consulta = "Select c From Cliente c Where c.cedula=:cedula";
    	try {
    		persona= (Cliente) em.createQuery(consulta).setParameter("cedula", cedula).getSingleResult();
    	}catch(Exception e) {
    		System.out.println(">>>Warning (buscarPorCedula: )"+e.getMessage());
    	}
    	return persona;
    }

}
