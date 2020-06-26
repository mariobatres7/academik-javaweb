<%-- 
    Document   : producto-listado
    Created on : Jun 20, 2020, 4:03:51 PM
    Author     : Mario Batres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
    </head>
    <body>
        <h1>Productos</h1>

        ${mensaje}
        <br/>
        
        <table>
            <thead>
                <tr>
                    <th>Producto Id</th>
                    <th>Descripción</th>
                    <th>Precio</th>
                    <th>Opciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${productoList}" var="producto">
                    <tr>
                        <td>${producto.productoId}</td>
                        <td>${producto.descripcion}</td>
                        <td>
                            <fmt:formatNumber pattern="'Q' #, ##0.00" value="${producto.precioBase}" />
                        </td>
                        <td>
                            <form method="post" action="producto.do">
                                <input type="hidden" name="productoId" value="${producto.productoId}" />
                                <input type="text" name="cantidad" value="1" />
                                <br/>
                                <input type="submit" value="Agregar" />
                            </form>
                        </td>
                    </tr>
                </c:forEach>        
            </tbody>
        </table>

    </body>
</html>
