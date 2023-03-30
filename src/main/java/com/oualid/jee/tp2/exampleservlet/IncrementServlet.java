package com.oualid.jee.tp2.exampleservlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "IncrementServlet", value = "/IncrementServlet")
public class IncrementServlet extends HttpServlet {

    int count;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String initial = this.getServletContext().getInitParameter("valeur_initial");
        try {
            count = Integer.parseInt(initial);
        } catch (NumberFormatException e) {
            count = 0;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        count++;
        response.setContentType("text/html");
        var writer = response.getWriter();
        writer.println("this page was visited " + count + " times.");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
