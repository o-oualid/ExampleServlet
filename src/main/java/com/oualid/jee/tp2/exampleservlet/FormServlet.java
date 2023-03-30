package com.oualid.jee.tp2.exampleservlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@MultipartConfig(location = "/")
@WebServlet(name = "FormServlet", value = "/FormServlet")
public class FormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var out = response.getWriter();

        response.setContentType("text/html");
        var name = request.getParameter("name");
        var password = request.getParameter("password");
        if (name.equals("oualid") && password.equals("pass")) {
            out.println("Hello " + name);
        }else{
            out.println("Erreur de connection");
        }
        var var =5;
    }
}
