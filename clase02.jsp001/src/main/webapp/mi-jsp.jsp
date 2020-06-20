<%-- 
    Document   : mi-jsp
    Created on : Jun 13, 2020, 2:38:03 PM
    Author     : Mario Batres
--%>


<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    String queryString = "select * from productos";

    //MVC
    int variable = 1;

    String nombre = request.getParameter("nombre");

    //HttpSession
    Integer valor = (Integer) session.getAttribute("valor");

    if (valor == null) {
        valor = 1;
        session.setAttribute("valor", valor);
    } else {
        valor++;
        session.setAttribute("valor", valor);
    }

    Date date = new Date();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Mi Primer JSP</h1>

        <%
            for (int i = 0; i < 10; i++) {
                //JSPWriter
                out.println("Mi variable [i] =  " + i);
            }
        %>


        <h2>Subtitulo</h2>


        <%
            if (variable == 1) {
                out.println("La variable es igual a " + variable);
            }
        %>


        <%=nombre%>

        <%
            out.println(nombre);
        %>

        <p>
            Numero de veces <%=valor%>
        </p>

        <%=date%>
    </body>
</html>
