package com.nabenik.clase03.jsp001.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

/**
 *
 * @author Mario Batres
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login.do"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String usuario = request.getParameter("usuario");

        String password = request.getParameter("password");

        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {

            try {
                UsernamePasswordToken token = new UsernamePasswordToken(usuario, password);
                currentUser.login(token);

                //request.getRequestDispatcher("index.jsp").forward(request, response);
                response.sendRedirect("index.jsp");
            } catch (IncorrectCredentialsException | UnknownAccountException ex) {

                request.setAttribute("mensaje", ex.getMessage());

                request.getRequestDispatcher("login.jsp").forward(request, response);

            }
        } else {
            response.sendRedirect("index.jsp");
        }

    }
}
