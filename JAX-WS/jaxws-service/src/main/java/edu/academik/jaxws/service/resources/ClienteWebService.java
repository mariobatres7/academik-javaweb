package edu.academik.jaxws.service.resources;

import edu.academik.jaxws.service.domain.Cliente;
import edu.academik.jaxws.service.request.ClienteRequest;
import edu.academik.jaxws.service.response.ClienteResponse;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Mario Batres
 */
@Stateless
@WebService(
        name = "Clientes",
        targetNamespace = "http://edu.academik.javaxws/clientes",
        serviceName = "ClienteWebService"
)
public class ClienteWebService {

    @PersistenceContext
    private EntityManager entityManager;
    
    
    @WebMethod
    @WebResult(name = "clienteResponse")
    public ClienteResponse buscarClientePorId(@WebParam(name = "clienteId") Long clienteId) {
        ClienteResponse clienteResponse = new ClienteResponse();

        clienteResponse.setClienteId(clienteId);
        clienteResponse.setNombre("Donald " + clienteId);
        clienteResponse.setCreadoEl(new Date());
        return clienteResponse;
    }

    @WebMethod
    @WebResult(name = "clienteResponse")
    public ClienteResponse buscarClientePorFecha(@WebParam(name = "date") Date date, @WebParam(name = "password", header = true) String password) {

        ClienteResponse clienteResponse = new ClienteResponse();

        clienteResponse.setClienteId(1L);
        clienteResponse.setNombre("Donald " + 1L);
        clienteResponse.setCreadoEl(date);

        return clienteResponse;
    }

    @WebMethod
    @WebResult(name = "clienteResponse")
    public ClienteResponse crearCliente(@WebParam(name = "clienteRequest") ClienteRequest clienteRequest) {

        ClienteResponse clienteResponse = new ClienteResponse();

        clienteResponse.setClienteId(1L);
        clienteResponse.setNombre(clienteRequest.getNombre());
        clienteResponse.setCreadoEl(new Date());

        return clienteResponse;
    }
    
    
    
    @WebMethod
    @WebResult(name = "clienteResponseList")
    public List<ClienteResponse> buscarClientes() {

        
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        
        CriteriaQuery <ClienteResponse> clienteQuery = builder.createQuery(ClienteResponse.class);
        
        Root<Cliente> clienteRoot = clienteQuery.from(Cliente.class);

        //orden de acuerdo al constructor de la clase ClienteReponse
        clienteQuery.multiselect(
                clienteRoot.get("clienteId"), //Long
                clienteRoot.get("codigo"), // String
                clienteRoot.get("nombre"), // String
                clienteRoot.get("creadoEl").as(Date.class) //Date
        );
        
        return this.entityManager.createQuery(clienteQuery).getResultList();
    }
}
