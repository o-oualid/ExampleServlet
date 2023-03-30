package com.oualid.jee.tp2.exampleservlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "sqlServlet", value = "/sqlServlet")
public class sqlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var writer = response.getWriter();
        response.setContentType("text/html");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String mysqlServer = getServletContext().getInitParameter("mysql_server");
            String mysqlUser = getServletContext().getInitParameter("mysql_user");
            String mysqlPassword = getServletContext().getInitParameter("mysql_password");
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://" + mysqlServer + "/ExpServletsPersonDB", mysqlUser, mysqlPassword);
            Statement myStatement = myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("select nom,prenom,age from Personne");
            writer.println("<table>");
            writer.println("<tr><th>Nom</th><th>Prénom</th><th>Age</th></td>");
            while (myResult.next()) {
                writer.println("<tr>");
                writer.print("<td>" + myResult.getString(1) + "</td>");
                writer.print("<td>" + myResult.getString(2) + "</td>");
                writer.print("<td>" + myResult.getString(3) + "</td>");
                writer.println("</tr>");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
