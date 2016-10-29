package com.example.web;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Jax on 2016/10/29.
 */
public class GetINF implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service");
        String u = servletRequest.getParameter("User");
        System.out.println(u);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
    public GetINF() {
        System.out.println("GETINF");
    }
}
