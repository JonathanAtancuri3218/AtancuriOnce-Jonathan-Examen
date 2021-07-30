package ec.edu.ups.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import ec.edu.ups.ejb.ClienteFacade;
import ec.edu.ups.ejb.ReservaFacade;
import ec.edu.ups.ejb.RestauranteFacade;
import ec.edu.ups.entidades.Cliente;
import ec.edu.ups.entidades.Reserva;
import ec.edu.ups.entidades.Restuarante;

@Path("/reservas/")
public class reservas {

	@EJB
	private ClienteFacade ejbCliente; 
	@EJB
	private ReservaFacade ejbReserva;
	@EJB
	private RestauranteFacade ejbResturante;
	
	
    public reservas() {
        // TODO Auto-generated constructor stub
    }

    @GET
    @Path("/listarClienteReservas/{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
   // @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response listar(@PathParam("cedula") String cedula) {
    	
    	System.out.println("Metodo Listar reservas clientes:"+cedula);
	
    	Cliente cliente = ejbCliente.buscarPorCedula(cedula);
    	
    	List<Reserva> pedido = new ArrayList<Reserva>();
    	
    	
    	
    	for (Reserva pedidoCabecera : cliente.getReservasCliente()) {
    		
    		Cliente p = new Cliente(cliente.getId(), cliente.getCedula(), cliente.getNombre(), cliente.getApellido(), cliente.getTelefono(), cliente.getDireccion(), cliente.getCorreo());
			Reserva r = new Reserva(pedidoCabecera.getId(), pedidoCabecera.getFecha(), pedidoCabecera.getNumeroPersonas(), p);
			
			
			pedido.add(r);
		}
    	
    	
    	Jsonb jsonb = JsonbBuilder.create();
    	return Response.ok(jsonb.toJson(pedido))
    		.header("Access-Control-Allow-Origin", "*")
    		.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
    		.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    }
    
    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
   // @Consumes(MediaType.APPLICATION_JSON)
    public Response Listcli( ) {
    	return null;
    }
    
    @GET
    @Path("/listarRestauranteReservas/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response listarRest(@PathParam("nombre") String nombre) {
	
    	Restuarante restuarante = ejbResturante.buscarPorNombre(nombre);
    	
    	List<Reserva> pedido = new ArrayList<Reserva>();
    	
    	
    	
    	for (Reserva pedidoCabecera : restuarante.getReservasRestaurante()) {
    		
    		Restuarante res = new Restuarante(pedidoCabecera.getRestauranteReserva().getId(), pedidoCabecera.getRestauranteReserva().getNombre(), 
    				pedidoCabecera.getRestauranteReserva().getDireccion(), pedidoCabecera.getRestauranteReserva().getTelefono(), 
    				pedidoCabecera.getRestauranteReserva().getAforo());
    		Reserva r = new Reserva(pedidoCabecera.getId(), pedidoCabecera.getFecha(), pedidoCabecera.getNumeroPersonas(), res);
			
			pedido.add(r);
		}
    	
    	
    	Jsonb jsonb = JsonbBuilder.create();
    	return Response.status(201).entity(jsonb.toJson(pedido))
    		.header("Access-Control-Allow-Origin", "*")
    		.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
    		.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    }
    
    
    
	@GET
	@Path("/buscarCliente/{cedula}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response buscarUsuario(@PathParam("cedula") String cedula) {
		Cliente usu = new Cliente();
		Jsonb jsonb = JsonbBuilder.create();
		//usu = ejbUsuarioFacade.find(cedula);
		usu = ejbCliente.buscarPorCedula(cedula);
		
		System.out.println("usuario recuperado: "+usu);
		
		return Response.status(201).entity(jsonb.toJson(usu))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		
	}
	
	@GET
	@Path("/buscarRestaurante/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response buscarRestaurante(@PathParam("nombre") String nombre) {
		Restuarante rest = new Restuarante();
		Jsonb jsonb = JsonbBuilder.create();
		//usu = ejbUsuarioFacade.find(cedula);
		rest = ejbResturante.buscarPorNombre(nombre);
		
		System.out.println("usuario recuperado: "+rest);
		
		return Response.status(201).entity(jsonb.toJson(rest))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		
	}
	
    
    
    @POST
    @Path("/listarRestFecha")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response listarRestFecha(@FormParam("fecha") String fecha) {
	
    	Restuarante restuarante = ejbResturante.buscarPorFecha(fecha);
    	
    	List<Reserva> pedido = new ArrayList<Reserva>();
    	
    	
    	
    	for (Reserva pedidoCabecera : restuarante.getReservasRestaurante()) {
    		
    		Restuarante res = new Restuarante(pedidoCabecera.getRestauranteReserva().getId(), pedidoCabecera.getRestauranteReserva().getNombre(), 
    				pedidoCabecera.getRestauranteReserva().getDireccion(), pedidoCabecera.getRestauranteReserva().getTelefono(), 
    				pedidoCabecera.getRestauranteReserva().getAforo());
    		Reserva r = new Reserva(pedidoCabecera.getId(), pedidoCabecera.getFecha(), pedidoCabecera.getNumeroPersonas(), res);
			
			pedido.add(r);
		}
    	
    	
    	Jsonb jsonb = JsonbBuilder.create();
    	return Response.status(201).entity(jsonb.toJson(pedido))
    		.header("Access-Control-Allow-Origin", "*")
    		.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
    		.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    }
    
    @POST
    @Path("/crearCliente")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response crearCliente(
    		@FormParam("nombre") String nombre,
    		@FormParam("apellido") String apellido,
    		@FormParam("cedula") String cedula, 
    		@FormParam("correo") String correo, 
    		@FormParam("direccion") String direccion,
    		@FormParam("telefono") String telefono) {
    	
    	System.out.println("Metodo crear");

    	System.out.println("Nombre " + nombre);
    	System.out.println("Apellido " + apellido);
    	System.out.println("Telefono " + telefono);
    	System.out.println("Cedula " + cedula);
    	System.out.println("Correo " + correo);
    	System.out.println("Direccion " + direccion);
    	
    	
    	Cliente cliente = new Cliente();
    	cliente.setNombre(nombre);
    	cliente.setApellido(apellido);
    	cliente.setCedula(cedula);
    	cliente.setCorreo(correo);
    	cliente.setDireccion(direccion);
    	cliente.setTelefono(telefono);
    	ejbCliente.create(cliente);
    	
    	
    	Jsonb jsonb = JsonbBuilder.create();
    	return Response.status(201).entity(jsonb.toJson(cliente))
    		.header("Access-Control-Allow-Origin", "*")
    		.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
    		.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    }
    
    @POST
    @Path("/crearRestaurante")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response crearCliente(
    		@FormParam("nombre") String nombre,
    		@FormParam("direccion") String direccion,
    		@FormParam("telefono") String telefono, 
    		@FormParam("aforo") int aforo) {
    	
    	System.out.println("Metodo crear");

    	System.out.println("Nombre " + nombre);
    	System.out.println("Direccion " + direccion);
    	System.out.println("Telefono " + telefono);
    	System.out.println("Aforo " + aforo);

    	
    	
    	Restuarante restaurante = new Restuarante();
    	restaurante.setNombre(nombre);
    	restaurante.setDireccion(direccion);
    	restaurante.setTelefono(telefono);
    	restaurante.setAforo(aforo);
    	ejbResturante.create(restaurante);
    	
    	
    	Jsonb jsonb = JsonbBuilder.create();
    	return Response.status(201).entity(jsonb.toJson(restaurante))
    		.header("Access-Control-Allow-Origin", "*")
    		.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
    		.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    }
    
    


}