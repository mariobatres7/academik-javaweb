<%-- 
    Document   : index
    Created on : Jun 20, 2020, 2:28:58 PM
    Author     : Mario Batres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Mis Productos</h1>

        <a href="producto.do">Ver Productos</a>

        <h2>Carretilla</h2>


        <table>
            <thead>
                <tr>
                    <th>Producto</th>
                    <th>Cantidad</th>
                </tr>
            </thead>

            <tbody>

                <c:forEach items="${carretillaList}" var="carretilla">
                    <tr>
                        <td>${carretilla.producto.descripcion}</td>
                        <td>${carretilla.cantidad}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
