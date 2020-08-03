package edu.academik.cors101.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Deshabilitado cuando se puse el JAX-RS
 * 
 * 
 * @author Mario Batres
 */
//@WebFilter(filterName = "CORSFilter", urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST})
public class CORSFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        
        HttpServletResponse response = ((HttpServletResponse) servletResponse);

        response.addHeader("Access-Control-Allow-Origin", "*");

        response.addHeader("Access-Control-Allow-Headers", "*");

        response.addHeader("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST");

        
        System.out.println(request.getMethod());
        
        
        if (request.getMethod().equals("OPTIONS")) {

            
            response.setStatus(HttpServletResponse.SC_ACCEPTED);

            return;

        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

}
