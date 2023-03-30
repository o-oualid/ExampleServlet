package com.oualid.jee.tp2.exampleservlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CookiesServlet", value = "/CookiesServlet")
public class CookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var out=response.getWriter();
        String sessionId = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("sessionid")) {
                    sessionId = cookie.getValue();
                }
            }
            if (sessionId == null) {
                sessionId = new java.rmi.server.UID().toString();
                response.addCookie(new Cookie("sessionid", sessionId));
                out.println("Bonjour le nouveau");
            }else{
                out.println("Encore vous");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
