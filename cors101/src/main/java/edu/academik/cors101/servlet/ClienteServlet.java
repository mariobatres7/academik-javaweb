package edu.academik.cors101.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.academik.cors101.modelo.Cliente;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mario Batres
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/clientes"})
public class ClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8");

        Cliente cliente = Cliente.builder()
                .clienteId(1L)
                .codigo("0001")
                .nombre("Mario Batres")
                .build();

        ObjectMapper mapper = new ObjectMapper();
        byte bytes[] = mapper.writeValueAsBytes(cliente);

        try (OutputStream outputStream = response.getOutputStream()) {
            outputStream.write(bytes);
        }
    }

}
