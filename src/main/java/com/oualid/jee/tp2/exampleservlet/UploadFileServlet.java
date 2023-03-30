package com.oualid.jee.tp2.exampleservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

@MultipartConfig(location = "/")
@WebServlet(name = "UploadFileServlet", value = "/UploadFileServlet")
public class UploadFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var out = response.getWriter();
        try {

            Iterator<Part> parts = request.getParts().iterator();
            parts.forEachRemaining((part) -> {
                out.println("<b>File:</b> <pre>" + part.getSubmittedFileName() + "</pre><br>");
                String directoryPath = "C:\\Users\\oualid\\Documents";
                String fileName = part.getSubmittedFileName();

                File dest = new File(directoryPath, fileName);
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(dest);
                    fos.write(part.getInputStream().readAllBytes());
                    fos.close();
                } catch (Exception e) {
                    out.println(e);
                }
            });

        } catch (ServletException e) {
            out.println("nothing to upload");

        }

    }
}
