package edu.academik.producto.micro.rest;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Mario Batres
 */
@Path("/hello")
public class HelloEndpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response sayHello() {
        Map <String, String>map = new HashMap<>();
        map.put("hola", "mundo");
        return Response.ok(map).build();
    }
}
