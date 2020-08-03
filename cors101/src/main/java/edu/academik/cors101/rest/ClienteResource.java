package edu.academik.cors101.rest;

import edu.academik.cors101.modelo.Cliente;
import edu.academik.cors101.service.ClienteService;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Mario Batres
 */
@Path("/clientes")
public class ClienteResource {

    @Inject
    private ClienteService clienteService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarClientes() {

        System.out.println("2");

        Cliente cliente = Cliente.builder()
                .clienteId(2L)
                .codigo("0002")
                .nombre("Jose Perez")
                .build();

        return Response.ok(cliente).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response crearCliente(@Valid Cliente cliente) {

        System.out.println("cliente creado " + cliente);

        this.clienteService.crearCliente(cliente);
        
        return Response.ok(cliente).build();
    }
}
