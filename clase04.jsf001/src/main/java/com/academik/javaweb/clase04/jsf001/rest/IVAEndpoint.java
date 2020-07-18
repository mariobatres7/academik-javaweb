package com.academik.javaweb.clase04.jsf001.rest;

import com.academik.javaweb.clase04.jsf001.qualifier.AnnotationIVACalculo;
import com.academik.javaweb.clase04.jsf001.qualifier.IVA;
import com.academik.javaweb.clase04.jsf001.qualifier.IVACalculo;
import com.academik.javaweb.clase04.jsf001.request.IVARequest;
import com.academik.javaweb.clase04.jsf001.rest.interceptor.RestLog;
import java.math.BigDecimal;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Mario Batres
 */
@RestLog
@Path("/iva")
public class IVAEndpoint {

    @Any
    @Inject
    private Instance<IVACalculo> ivaCalculoInstance;

    // IVA/SV
    // IVA/GT
    @POST
    @Path("/{inicial}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response desglozarIVA(IVARequest request, @PathParam("inicial") String inicial) {

        IVA.Pais paisEnum = IVA.Pais.valueOf(inicial);
        
        IVACalculo ivaCalculo =  ivaCalculoInstance.select(AnnotationIVACalculo.getInstance(paisEnum)).get();

        BigDecimal monto = ivaCalculo.desglozarIVA(request.getCantidad());

        return Response.ok(monto).build();
    }
}
