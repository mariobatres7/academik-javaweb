<%-- 
    Document   : productos
    Created on : Jun 13, 2020, 3:30:15 PM
    Author     : Mario Batres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos (JSTL)</title>
    </head>
    <body>
        <h1>Listado de Productos (JSTL)</h1>


        <c:set var="miVariable" value="${2+2}" scope="request" /> 

        Mi Variable = ${miVariable}

        <table>

            <thead>
                <tr>
                    <td>Id</td>
                    <td>Nombre</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="producto" items="${productoList}">
                    <tr>
                        <td><c:out value="${producto.id}" /></td>
                        <td><c:out value="${producto.nombre}" /></td>
                    </tr>
                </c:forEach>
            </tbody>

        </table>


    </body>
</html>
