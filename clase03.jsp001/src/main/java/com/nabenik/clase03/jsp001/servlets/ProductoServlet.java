package com.nabenik.clase03.jsp001.servlets;

import com.nabenik.clase03.jsp001.db.DatabaseManager;
import com.nabenik.clase03.jsp001.dominio.Producto;
import com.nabenik.clase03.jsp001.wrapper.Carretilla;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controlador de productos.
 *
 *
 * @author Mario Batres
 */
@WebServlet(name = "ProductoServlet", urlPatterns = {"/producto.do"})
public class ProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManager entityManager = DatabaseManager.getEntityManager();

        List<Producto> productoList = DatabaseManager.findAll(entityManager, Producto.class);

        entityManager.close();

        request.setAttribute("productoList", productoList);

        request.getRequestDispatcher("productos/producto-listado.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long productoId = Long.parseLong(request.getParameter("productoId"));

        Integer cantidad = Integer.parseInt(request.getParameter("cantidad"));

        EntityManager entityManager = DatabaseManager.getEntityManager();

        Producto producto = DatabaseManager.find(entityManager, Producto.class, productoId);

        List<Carretilla> carretillaList = (List<Carretilla>) request.getSession().getAttribute("carretillaList");

        if (carretillaList != null) {

            Carretilla carretilla = carretillaList.stream()
                    .filter(c -> c.getProducto().equals(producto))
                    .findFirst()
                    .orElse(null);

            if (carretilla == null) {
                carretilla = new Carretilla();
                carretilla.setProducto(producto);
                carretilla.setCantidad(cantidad);

                carretillaList.add(carretilla);

            } else {
                carretilla.setCantidad(carretilla.getCantidad() + cantidad);
            }
        } else {
            carretillaList = new ArrayList<>();
            Carretilla carretilla = new Carretilla();
            carretilla.setProducto(producto);
            carretilla.setCantidad(cantidad);
            carretillaList.add(carretilla);

            request.getSession().setAttribute("carretillaList", carretillaList);
        }

        request.setAttribute("mensaje", "Producto " + producto + " fue agregado.");

        List<Producto> productoList = DatabaseManager.findAll(entityManager, Producto.class);

        request.setAttribute("productoList", productoList);

        entityManager.close();

        request.getRequestDispatcher("productos/producto-listado.jsp").forward(request, response);

    }

}
