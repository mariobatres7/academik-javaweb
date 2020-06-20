<%-- 
    Document   : productos
    Created on : Jun 13, 2020, 3:30:15 PM
    Author     : Mario Batres
--%>

<%@page import="java.util.List"%>
<%@page import="edu.academik.clase02.jsp001.modelo.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
    </head>
    <body>
        <h1>Listado de Productos</h1>

        <table>

            <thead>
                <tr>
                    <td>Id</td>
                    <td>Nombre</td>
                </tr>
            </thead>

            <tbody>
                <%
                    List<Producto> productoList = (List<Producto>) request.getAttribute("productoList");

                    for (Producto producto : productoList) {
                        out.println("<tr>");
                        out.println("<td>" + producto.getId() + "</td><td>" + producto.getNombre() + "</td>");
                        out.println("</tr>");
                    }

                %>
            </tbody>

        </table>

    </body>
</html>
