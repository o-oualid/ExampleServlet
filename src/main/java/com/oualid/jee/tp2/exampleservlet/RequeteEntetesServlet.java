package com.oualid.jee.tp2.exampleservlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RequeteEntetesServlet", value = "/RequeteEntetesServlet")
public class RequeteEntetesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<table><tr><th>Request</th><th>Result</th></tr>");
        out.println("<tr><th>String getMethod()</th><td>"+request.getMethod()+"</td></tr>");
        out.println("<tr><th>String getServerName()</th><td>"+request.getServerName()+"</td></tr>");
        out.println("<tr><th>String getParameter()</th><td>"+request.getParameter("test")+"</td></tr>");
        out.println("<tr><th>String getParameterNames()</th><td>"+request.getParameterNames()+"</td></tr>");
        out.println("<tr><th>String getRemoteHost()</th><td>"+request.getRemoteHost()+"</td></tr>");
        out.println("<tr><th>String getRemotePort()</th><td>"+request.getRemotePort()+"</td></tr>");
        out.println("<tr><th>String getQueryString()</th><td>"+request.getQueryString()+"</td></tr>");
        out.println("</table>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
