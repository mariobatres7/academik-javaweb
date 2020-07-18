package edu.academik.producto.micro.rest;

import edu.academik.producto.micro.service.ProductService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

/**
 *
 * @author Mario Batres
 */
@Path("/products")
@Timed(name = "product-time",
        description = "Servicio de productos.",
        unit = MetricUnits.MINUTES,
        absolute = true)
public class ProductEndpoint {

    @Inject
    private ProductService productService;

    @GET
    @Path("/{productId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Counted(description = "How many products", absolute = true)
    public Response findProduct(@PathParam("productId") Long productoId) {
        var product = this.productService.findProduct(productoId);
        return Response.ok(product).build();
    }
}
