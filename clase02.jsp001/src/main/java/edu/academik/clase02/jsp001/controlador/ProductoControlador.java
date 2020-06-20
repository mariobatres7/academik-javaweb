package edu.academik.clase02.jsp001.controlador;

import edu.academik.clase02.jsp001.modelo.Producto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mario Batres
 */
@WebServlet(name = "ProductoControlador", urlPatterns = {"/productos.do"})
public class ProductoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            ConnectionManager connectionManager = new ConnectionManager();

            List<Producto> productoList = connectionManager.buscarProductos();

            request.setAttribute("productoList", productoList);

            String jstl = request.getParameter("jstl");

            if (jstl == null || jstl.equalsIgnoreCase("no")) {
                request.getRequestDispatcher("productos.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("productos-jstl.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
