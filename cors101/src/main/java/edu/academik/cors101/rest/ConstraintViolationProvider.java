package edu.academik.cors101.rest;


import java.util.HashMap;
import java.util.Map;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Mario Batres
 */
@Provider
public class ConstraintViolationProvider implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        
        Map<String, String> errorMap = new HashMap<>();
        exception.getConstraintViolations().stream().forEach(val -> {
            errorMap.put(val.getPropertyPath().toString(), val.getMessage());
        });

        return Response.ok(errorMap).build();

    }

}
