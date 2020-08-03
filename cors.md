# CORS

*  Cross Origin Resource Sharing.
*  Una solicitud de un recurso fuera del origen es conocido como una solicitud _cross-origin_ 
*  Nos permite relajar la seguridad a un API Rest.
*  Aplica la política de un origen único y un sitio web solo puede realizar llamadas a su propio origen.
*  Esto permite que se soliciten recursos restringidos en una página web desde otro dominio fuera del dominio desde el que se sirvió el primer recurso.
*  El cliente y el servidor intercambian un conjunto de encabezados para especificar comportamientos con respecto a las solicitudes entre dominios.
*  Es la forma estándar de compartir recursos desde un origen a otro.



## Llamada AJAX con JQuery

```javascript 
    $(document).ready(function () {

                $("#obtenerClienteButton").click(function (ev) {
                    ev.preventDefault();


                    $.ajax("http://localhost:8080/cors101/v2/clientes", {
                        type: "GET",
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        success : function(cliente) {
                            $("#clienteIdSpan").html(cliente.clienteId);
                            $("#codigoSpan").html(cliente.codigo);
                            $("#nombreSpan").html(cliente.nombre);
                            
                            alert("Información obtenida.");
                        },
                        error : function(e){
                            console.log("error:  " +  e);
                            alert("Error:  " +  e);
                        }
                    });
                });
            });

```


## Utilizando un Servlet y um Filter
```java
   response.setContentType("application/json;charset=UTF-8");

        Cliente cliente = Cliente.createBuilder()
                .clienteId(1L)
                .codigo("0001")
                .nombre("Mario Batres")
                .build();

        ObjectMapper mapper = new ObjectMapper();
        byte bytes[] = mapper.writeValueAsBytes(cliente);

        try (OutputStream outputStream = response.getOutputStream()) {
            outputStream.write(bytes);
        }
```

```java
@WebFilter(filterName = "CORSFilter", urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST})
public class CORSFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        
        HttpServletResponse response = ((HttpServletResponse) servletResponse);

        response.addHeader("Access-Control-Allow-Origin", "*");

        response.addHeader("Access-Control-Allow-Headers", "*");

        response.addHeader("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST");

        if (request.getMethod().equals("OPTIONS")) {

            
            response.setStatus(HttpServletResponse.SC_ACCEPTED);

            return;

        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

}

```

## Configuración en JAX-RS

```java 
@Provider
public class CORSProvider implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        
        containerResponseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
        containerResponseContext.getHeaders().add("Access-Control-Allow-Headers", "*");
        containerResponseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
        containerResponseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        
    }

}
```


```java 
@Path("/clientes")
public class ClienteResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarClientes() {
        
        Cliente cliente = Cliente.createBuilder()
                .clienteId(1L)
                .codigo("0001")
                .nombre("Mario Batres")
                .build();

        return Response.ok(cliente).build();
    }

}

```


https://www.codecademy.com/articles/what-is-cors