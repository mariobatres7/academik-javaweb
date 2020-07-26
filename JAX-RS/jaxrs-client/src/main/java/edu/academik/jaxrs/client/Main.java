package edu.academik.jaxrs.client;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

/**
 *
 * @author Mario Batres
 */
public class Main {

    //
    public <T> T buscarProductos_Forma5(Class clazz, String url) throws IOException {

        Client client = ResteasyClientBuilder.newBuilder().build();

        WebTarget target = client.target(url);

        var response = target.request(MediaType.APPLICATION_JSON)
                .get(new GenericType<byte[]>() {
                });

        var mapper = new ObjectMapper();

        JsonNode responseJsonNode = mapper.readTree(response);

        boolean successful = responseJsonNode.get("success").asBoolean();

        if (successful) {

            JsonNode contentJsonNode = responseJsonNode.get("content");

            if (contentJsonNode != null && !contentJsonNode.isNull()) {

                if (contentJsonNode.isArray()) {
                    
                    JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, clazz);

                    T content = mapper.readValue(contentJsonNode.toString(), type);

                    return content;
                } else {

                    T content = (T) mapper.readValue(contentJsonNode.toString(), clazz);

                    return content;
                }

            }

        } else {
            throw new RuntimeException (responseJsonNode.get("messsage").asText());
        }

        return null;
    }

    public List<Producto> buscarProductos_Forma4() throws IOException {

        Client client = ResteasyClientBuilder.newBuilder().build();

        WebTarget target = client.target("http://localhost:8080/clase04.jsf001-1.0.0/rest/productos/listado");

        try (Response response = target.request(MediaType.APPLICATION_JSON).get()) {

            var responseApi = response.readEntity(new GenericType<ResponseApi<List<Producto>>>() {
            });

            if (!responseApi.isSuccess()) {
                throw new RuntimeException(responseApi.getMessage());
            }

            return responseApi.getContent();
        }
    }

    public byte[] buscarProductos_Forma3() throws IOException {

        Client client = ResteasyClientBuilder.newBuilder().build();

        WebTarget target = client.target("http://localhost:8080/clase04.jsf001-1.0.0/rest/productos/listado");

        try (Response response = target.request(MediaType.APPLICATION_JSON).get()) {

            return response.readEntity(new GenericType<byte[]>() {
            });
        }

    }

    public byte[] buscarProductos_Forma2() throws IOException {

        URL url = new URL("http://localhost:8080/clase04.jsf001-1.0.0/rest/productos/listado");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.setConnectTimeout(20000);
        connection.setReadTimeout(20000);

        try (InputStream inputStream = connection.getInputStream()) {

            return inputStream.readAllBytes();
        }
    }

    public byte[] buscarProductos_Forma1() throws IOException {

        URL url = new URL("http://localhost:8080/clase04.jsf001-1.0.0/rest/productos/listado");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.setConnectTimeout(20000);
        connection.setReadTimeout(20000);

        try (InputStream inputStream = connection.getInputStream()) {

            int available = inputStream.available();

            byte[] buffer = new byte[available];

            int read;

            ByteArrayOutputStream baas = new ByteArrayOutputStream();
            while ((read = inputStream.read(buffer)) > 0) {
                baas.write(buffer, 0, read);
                available = inputStream.available();

                System.out.println(available);
                buffer = new byte[available];
            }

            return baas.toByteArray();
        }

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        /*

        byte [] bytes1 = main.buscarProductos_Forma3();
        
        //System.out.println(new String(bytes1));
        
        
        //byte[] bytes2 = main.buscarProductos_Forma2();
        /*
        byte[] bytes3 = main.buscarProductos_Forma3();

        
        
        
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonNode = mapper.readTree(bytes1);

        JsonNode contentJsonNode = jsonNode.get("content");

        if (contentJsonNode.isArray()) {
            
            JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, Producto.class);

            List<Producto> productoList = mapper.readValue(contentJsonNode.toString(), type);

            productoList.stream().forEach(producto -> {

                System.out.print(producto.getProductoId());
                System.out.print("\t" + producto.getCodigo());
                System.out.print("\t" + producto.getPrecioBase());
                System.out.println("\t" + producto.getDescripcion());

            });

        }*/
        List<Producto> productoList = main.<List<Producto>>buscarProductos_Forma5(Producto.class, "http://localhost:8080/clase04.jsf001-1.0.0/rest/productos/listado");

        productoList.stream().forEach(producto -> {

            System.out.print(producto.getProductoId());
            System.out.print("\t" + producto.getCodigo());
            System.out.print("\t" + producto.getPrecioBase());
            System.out.println("\t" + producto.getDescripcion());

        });

        Producto producto = main.<Producto>buscarProductos_Forma5(Producto.class, "http://localhost:8080/clase04.jsf001-1.0.0/rest/productos/4444");

        System.out.println("--------------------------------");

        System.out.print(producto.getProductoId());
        System.out.print("\t" + producto.getCodigo());
        System.out.print("\t" + producto.getPrecioBase());
        System.out.println("\t" + producto.getDescripcion());

    }
}
