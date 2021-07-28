package ec.edu.ups.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.Cliente;
import ec.edu.ups.entidades.Reserva;

/**
 * Session Bean implementation class ReservaFacade
 */
@Stateless
public class ReservaFacade extends AbstractFacade<Reserva>{

	@PersistenceContext(unitName = "exa-pra")
	private EntityManager em;
	
    public ReservaFacade() {
    	super(Reserva.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

}
