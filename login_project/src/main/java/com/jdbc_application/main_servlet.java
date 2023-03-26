package com.jdbc_application;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class main_servlet extends HttpServlet {
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        try {
            String username = request.getParameter("Username");
            String password = request.getParameter("Password");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            database db = new database();
            String cssTag = "<link rel='stylesheet' type='text/css' href='./styling/style.css'>";
            out.println("<head><title>Servlet Home Page</title>" + cssTag);
            out.println("<meta http-equiv='X-UA-Compatible' content='IE=edge'>"
                    + "<meta name='viewport' content='width=device-width, initial-scale=1.0'></head>");
            out.println("<body>");
            String conditional = (String) request.getParameter("button");
            if (conditional.contentEquals("Register")) {

                db.put_data(username, password, firstName, lastName);
                db.get_data(request, response);

            } else if (conditional.contentEquals("Login ")) {
                try {
                    response.setHeader("method", "session");
                    db.login(username, password, request, response);
                    out.println("<h2>" + firstName + lastName + "<br> has Successfully log in.</h2>");
                } catch (Exception e) {
                    out.println("<h2>Sorry you are not register. Please register to log in.</h2>");

                }

            }

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
        } finally {
            out.println("</body>");
            out.close();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
