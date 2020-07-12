package com.academik.javaweb.clase04.jsf001.rest;

import com.academik.javaweb.clase04.jsf001.domain.Producto;
import com.academik.javaweb.clase04.jsf001.rest.interceptor.RestLog;
import com.academik.javaweb.clase04.jsf001.servicio.ProductoServicio;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 *
 * @author Mario Batres
 */
@RestLog
@Path("/productos")
public class ProductoEndpoint {
    
    @Context
    private UriInfo context;
    
    @Inject
    private ProductoServicio productoServicio;

    /**
     * /rest/productos/listado
     */
    @GET
    @Path("/listado")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findProductoList() {
        
        var productoList = this.productoServicio.findProductoList();
        
        return Response.ok(productoList).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProducto(Producto producto) {
        System.out.println(producto.getProductoId());
        System.out.println(producto.getDescripcion());
        return Response.ok().build();
    }
    
    @GET
    @Path("/{productoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findProductoById(@PathParam("productoId") Long productoId) {
        
        System.out.println("Buscando producto con productoId:  " + productoId);

        //Dictionary en C#
        Map<String, Object> map = new HashMap<>();
        
        map.put("productoReciboId", productoId);
        map.put("fecha", LocalDateTime.now()); // Java Time API, en Jackson poner atención al utilizan este API

        return Response.ok(map).build();
    }
    
    @GET
    @Path("/codigo/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findProductoByCodigo(@PathParam("codigo") String codigo,
             @QueryParam("var1") String var1,
             @HeaderParam("userId") Long userId,
             @Context HttpHeaders headers) {
        
        headers.getRequestHeaders().forEach((key, value) -> System.out.println("Header:  " + key + "  " + value));
        
        System.out.println("Parametro del header:  userId = " + userId);
        
        System.out.println("Buscando producto con productoId:  " + codigo);
        
        System.out.println("Query Param var1 =   " + var1);

        //Dictionary en C#
        Map<String, Object> map = new HashMap<>();

        ///NOTA:  Reflection API 
        this.context.getQueryParameters().forEach((key, value) -> {
            
            List<?> list = (List) value;
            
            System.out.println(key + " = " + list.stream().findFirst().orElse(null));
            map.put(key, list.stream().findFirst().orElse(null));
        });
        
        map.put("codigoRecibido", codigo);
        map.put("fecha", LocalDateTime.now()); // Java Time API, en Jackson poner atención al utilizan este API

        if (codigo.equalsIgnoreCase("123")){
            throw new RuntimeException("Codigo no puede ser 123");
        }
        
        return Response.ok(map).build();
    }
}
