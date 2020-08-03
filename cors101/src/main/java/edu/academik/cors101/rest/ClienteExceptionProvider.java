package edu.academik.cors101.rest;

import edu.academik.cors101.service.ClienteException;
import java.util.Map;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Mario Batres
 */
@Provider
public class ClienteExceptionProvider implements ExceptionMapper<ClienteException> {

    @Override
    public Response toResponse(ClienteException ex) {

        System.out.println("Capturando error de ClienteException");
        
        Map<String, String> map = Map.of("error", ex.getMessage());

        return Response.ok(map).build();
    }

}
