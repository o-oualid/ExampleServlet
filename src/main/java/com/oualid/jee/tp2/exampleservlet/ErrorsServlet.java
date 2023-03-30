package com.oualid.jee.tp2.exampleservlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ErrorsServlet", value = "/ErrorsServlet")
public class ErrorsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType("text/html");
        var writer = response.getWriter();
        writer.println(
                "<form method='post'> <input type='text' name='login'> <input type='password' name='password'> <input type='submit'> </form> ");
    }

    private boolean checkUserAndPassword(String login, String password) {
        return login.equals("oualid") && password.equals("pass");
    }

    private void grantAccessTo(String login) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login == null || login.trim().equals("")) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "empty login");
            return;
        }
        if (checkUserAndPassword(login, password)) {
            grantAccessTo(login);
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access denied to:" + login);
        }
    }
}
