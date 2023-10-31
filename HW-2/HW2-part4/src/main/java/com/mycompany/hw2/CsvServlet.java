/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.relique.jdbc.csv.CsvDriver;

/**
 *
 * @author akshaydatir
 */
@WebServlet(name = "CsvServlet", urlPatterns = {"/CsvServlet.xls"})
public class CsvServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {

        HttpSession session = request.getSession();
        String input = request.getParameter("input");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
      

            if (input == null) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet CsvServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<form action=/HW2/CsvServlet.xls method=post>");
                out.println("<h1>Hello !!!!</h1>");
                out.println("<label for=" + "file" + ">Enter CSV file name :</label>");
                out.println("<input type=" + "text" + " id=" + "input" + " name=" + "input" + " required>");
              //  out.println("<input type=\"hidden\" name=\"username\" value=\"" + username + "\">");
               // out.println("<input type=\"hidden\" name=\"password\" value=\"" + password + "\">");
                out.println("<input type=" + "submit" + " value=" + "Submit" + ">");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            }else if(input.equals("parking")){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet CsvServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("Entered file name " + input);
                String csvDirectory = getServletContext().getRealPath("/WEB-INF/csv/");
                Class.forName("org.relique.jdbc.csv.CsvDriver");
                Connection conn = DriverManager.getConnection("jdbc:relique:csv:" + csvDirectory);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM " + input);
                out.println("<table border='1'>");
                out.print("<tr><th>Facility Type</th><th>License Number</th><th>Entity Name</th><th>Camis Trade Name</th><th>Address Bldg</th>"
                        + "<th>Address Street Name</th><th>Address Location</th><th>Address City</th><th>Address State</th><th>Address Zip Code</th>"
                        + "<th>Telephone Number</th><th>Number of Spaces</th></tr>");
                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getString("Facility Type") + "</td>");
                    out.println("<td>" + rs.getString("License Number") + "</td>");
                    out.println("<td>" + rs.getString("Entity Name") + "</td>");
                    out.println("<td>" + rs.getString("Camis Trade Name") + "</td>");
                    out.println("<td>" + rs.getString("Address Bldg") + "</td>");
                    out.println("<td>" + rs.getString("Address Street Name") + "</td>");
                    out.println("<td>" + rs.getString("Address Location") + "</td>");
                    out.println("<td>" + rs.getString("Address City") + "</td>");
                    out.println("<td>" + rs.getString("Address State") + "</td>");
                    out.println("<td>" + rs.getString("Address Zip Code") + "</td>");
                    out.println("<td>" + rs.getString("Telephone Number") + "</td>");
                    out.println("<td>" + rs.getString("Number of Spaces") + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            }else {
                out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CsvServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Invalid</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("Invalid CSV File Name ");
            out.println("</body>");
            out.println("</html>");
               
            }

        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CsvServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CsvServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
