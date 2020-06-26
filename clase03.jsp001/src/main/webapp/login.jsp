<%-- 
    Document   : index
    Created on : Jun 20, 2020, 2:28:58 PM
    Author     : Mario Batres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>


        <h5><%=request.getAttribute("mensaje")%></h5>

        <form action="login.do" method="post">

            <label>Usuario:</label>
            <input type="text" name="usuario" />
            <br/>
            <label>Contraseña: </label>
            <input type="password" name="password" />
            <br/>

            <input type="submit" value="Login!!" />
        </form>
    </body>
</html>
