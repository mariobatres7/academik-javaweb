package com.academik.javaweb.clase04.jsf001.rest.interceptor;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.ws.rs.core.Response;
import lombok.extern.java.Log;

/**
 *
 * @author Mario Batres
 */
@Interceptor
@RestLog
@Priority(Interceptor.Priority.APPLICATION)
@Log
public class RestLogInterceptor {

    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {
        
        System.out.println("Invoncando:  " + context.getMethod());

        boolean success = false;
        
        String message = "OK";
        
        Map <String, Object> responseMap = new HashMap<>();
        
        try {
            
            Response obj = (Response) context.proceed();
            
            success = true;
            
            responseMap.put("content", obj.getEntity());
        
        } catch(RuntimeException ex){
            message = ex.getMessage();
            log.log(Level.SEVERE, "Error", ex);
        }
        
        responseMap.put("success", success);
        responseMap.put("message", message);
        
        return Response.ok(responseMap).build();
    }
}
