package com.jdbc_application;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class database {
    String password = "Suju123@4*";

    public void put_data(String Username, String Password, String firstName, String lastName) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", this.password);
        Statement stmt1 = con.createStatement();
        stmt1.executeUpdate("CREATE DATABASE IF NOT EXISTS servlet_application ;");
        stmt1.executeUpdate("USE servlet_application;");
        stmt1.executeQuery("SELECT DATABASE();");
        /*
         * Set Username as promary key so that no two users with same username register.
         */
        String query1 = ("CREATE TABLE IF NOT EXISTS store_user(" + "Username VARCHAR(30) NOT NULL PRIMARY KEY,"
                + "Password VARCHAR(30) NOT NULL," + "firstName NOT NULL,"
                + "lastName NOT NULL));");
        stmt1.executeUpdate(query1);
        PreparedStatement stmt2;
        /* NULLIF is to return NULL if both parameters are same */
        stmt2 = con.prepareStatement("INSERT INTO store_user VALUES" + "(NULLIF(?,''),NULLIF(?,''),NULLIF(?,''),?);");
        stmt2.setString(1, Username);
        stmt2.setString(2, Password);
        stmt2.setString(3, firstName);
        stmt2.setString(4, lastName);
        
        stmt2.executeUpdate();
        con.close();
    }

    public void get_data(HttpServletRequest request, HttpServletResponse response)
            throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_application", "root",
                this.password);
        Statement stmt = con.createStatement();
        ResultSet rs1 = stmt.executeQuery("SELECT * FROM store_user ORDER BY Username;");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        out.println("<p>");
        while (rs1.next()) {
            out.println(rs1.getString(1) + ' ' + rs1.getString(2) + ' ' + rs1.getString(3) + ' ' + rs1.getString(4)
                    + "<br>");
        }
        out.println("</p>");
    }

    public void login(String username, String password, HttpServletRequest request, HttpServletResponse response)
            throws ClassNotFoundException, SQLException, IOException, ServletException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_application", "root",
                this.password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM store_user WHERE Username=" + "'" + username + "';");
        if (!rs.next()) {
            throw new SQLException("No Username found");
        } else {
            rs = stmt.executeQuery("SELECT * FROM store_user WHERE Username=" + "'" + username + "' AND password=" + "'"
                    + password + "';");
            if (!(rs.next())) {
                throw new SQLException("Invalid Password");
            } else {
                // if username and password is found in the database,
                String method = response.getHeader("method");
                System.out.println("Login: " + method);
                if (method == "session") {
                    HttpSession session = request.getSession();
                    // storing the username in the session is enough as it is primary key
                    session.setAttribute("Username", username);
                } 
                // redirect to User home page.
                response.sendRedirect("home_user.jsp");
            }
        }
    }

}
