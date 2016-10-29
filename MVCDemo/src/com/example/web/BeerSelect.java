package com.example.web;

import com.example.web.model.BeerExpert;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * Created by Jax on 2016/10/29.
 */
public class BeerSelect extends HttpServlet{

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {

//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("Beer Selection Advice<br>");
        String c = request.getParameter("color");
//        out.println("<br>Got beer post color " + c);
        BeerExpert be = new BeerExpert();
//        List brandsList = be.getBrands(c);
        List result = be.getBrands(c);
//        Iterator it = brandsList.iterator();
//        while (it.hasNext()) {
//            out.println("<br> try: " + it.next());
//        }
        request.setAttribute("styles", result);
        RequestDispatcher view =
                request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
    }

    public void doGet(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Beer Selection Advice<br>");
        String c = request.getParameter("color");
        out.println("<br>Got beer get color " + c);
    }
}
