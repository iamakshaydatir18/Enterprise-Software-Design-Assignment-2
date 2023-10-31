/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw2.part7;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author akshaydatir
 */
@WebServlet(name = "ShoopingServlet", urlPatterns = {"/ShoopingServlet/shop"})
public class ShoopingServlet extends HttpServlet {
    

    protected void InProcess(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     HttpSession session = request.getSession();
        String param = request.getParameter("param");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");

        if (param == null || param=="") {
            
                 out.println("<!DOCTYPE html>");
                out.println("<html lang=" + "en" + ">");
                out.println("<head>");
                out.println("<meta charset=" + "UTF - 8 " + ">");
                out.println("<meta name=" + "viewport" + " content=" + "width = device - width, initial - scale = 1.0" + ">");
                out.println("<title>Shopping List</title>");
                out.println("<style>");
                out.println("        container {");
                out.println("        padding: 10px;");
                out.println("        display: flex;");
                out.println("        justify-content: space-around; ");
                out.println("        align-items: left; ");
                out.println("        }");
                out.println("");
                out.println("        .computer{");
                out.println("            position: absolute;");
                out.println("            top: 70px;");
                out.println("            right: 800px;");
                out.println("            display:none;");
                out.println("       ");
                out.println("        }");
                out.println("");
                out.println("        .music{");
                out.println("            position: absolute;");
                out.println("            top: 70px;");
                out.println("            right: 800px;");
                out.println("            display:none;");
                out.println("           ");
                out.println("        }");
                out.println("        .book{");
                out.println("            position: absolute;");
                out.println("            top: 70px;");
                out.println("            right: 800px;");
                out.println("            display:none;");
                out.println("     ");
                out.println("        }");
                out.println("        .display{");
                out.println("            position: absolute;");
                out.println("            top: 70px;");
                out.println("            right: 800px;");
                out.println("            display:none;");
                out.println("     ");
                out.println("        }");
                out.println("        .cart{");
                out.println("           float: right;");
                out.println("           ");
                out.println("            ");
                out.println("        }");
                out.println(".submit{ position: absolute;top:150px;right: 800px; }");
                out.println("    </style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<form action=\"/HW2/ShoopingServlet/shop\" method=\"POST\">");
                out.println("    <h2>Shopping List</h2>");
                out.println("    <div class=" + "container" + ">");
                out.println("        <div class=" + "left" + ">");
                out.println("<a href=" + "#" + " id=" + "showHideLink1" + ">Music</a>");
                out.println("<br>");
                out.println("<a href=" + "#" + " id=" + "showHideLink2" + ">Computers</a>");
                out.println("<br>");
                out.println("<a href=" + "#" + " id=" + "showHideLink3" + ">Books</a>");
                out.println("</div>");
                out.println("</div>");
                out.println("");
                out.println("<div class=" + "computer" + ">");
                out.println("<label>");
                out.println("<input type=\"checkbox\" name=\"comp\" value=\"Mac Book - $1500.00\">");
                out.println("Mac Book - $1500.00");
                out.println("</label>");
                out.println("<br>");
                out.println("<label>");
                out.println("<input type=\"checkbox\" name=\"comp\" value=\"Leneovo - $1200.00\">");
                out.println("Leneovo - $1200.00");
                out.println("</label>");
                out.println("<br>");
                out.println("<label>");
                out.println("<input type=\"checkbox\" name=\"comp\" value=\"DELL - $1300.00\">");
                out.println("DELL - $1300.00");
                out.println("</label>");
                out.println("</div>");
                out.println("");
                out.println("<div class=" + "music" + ">");
                out.println("<label>");
                out.println("<input type=\"checkbox\" name=\"music\" value=\"Rock Music - $100.00\">");
                out.println("Rock Music - $100.00");
                out.println("</label>");
                out.println("<br>");
                out.println("<label>");
                out.println("<input type=\"checkbox\" name=\"music\" value=\"JAZZ Music - $200.00\">");
                out.println("JAZZ Music - $200.00");
                out.println("</label>");
                out.println(" <br>");
                out.println("  <label>");
                out.println("<input type=\"checkbox\" name=\"music\" value=\"Hip-Hop Music - $120.00\">");
                out.println(" Hip-Hop Music - $120.00");
                out.println(" </label>");
                out.println("  </div>");
                out.println("<div class=" + "book" + ">");
                out.println(" <label>");
                out.println("<input type=\"checkbox\" name=\"book\" value=\"Harry Potter - $100.00\">");
                out.println("  Harry Potter - $100.00");
                out.println(" </label>");
                out.println(" <br>");
                out.println("  <label>");
                out.println("<input type=\"checkbox\" name=\"book\" value=\"Rich Dad Poor Dad - $60.00\">");
                out.println("  Rich Dad Poor Dad - $60.00");
                out.println("  </label>");
                out.println("  <br>");
                out.println(" <label>");
                out.println("<input type=\"checkbox\" name=\"book\" value=\"Change Habits - $90.00\">");
                out.println("Change Habits - $90.00");
                out.println("  </label>");
                out.println("  </div>");
                out.println("<input type=\"hidden\" name=\"param\" value=\"view\">");
                out.println("<div class=" + "display" + ">");
                out.println("Items added succesfully!!!!");
                out.println("</div>");
                out.println("<div class=" + "submit" + ">");
                out.println(" <button type=\"button\" id=\"cart\">Add to Cart</button>");
                out.println("<div class=" + "cart" + ">");
                out.println(" <button type=\"Submit\">View Cart</button>");
                out.println("</div>");
                out.println("</form>");
                out.println("    <script>");
                out.println("        // JavaScript to toggle visibility of the shopping list");
                out.println("        document.getElementById('cart').addEventListener('click', function() {");
                out.println("            var display = document.querySelector('.display');");
                out.println("            var shoppingList1 = document.querySelector('.music');");
                out.println("            var shoppingList2 = document.querySelector('.book');");
                out.println("            var shoppingList3 = document.querySelector('.computer');");

                out.println("            if (display.style.display === 'none') {");
                out.println("                display.style.display = 'block';");
                out.println("                shoppingList1.style.display = 'none';");
                out.println("                shoppingList2.style.display = 'none';");
                out.println("                shoppingList3.style.display = 'none';");
                out.println("               ");
                out.println("            }else {");
                out.println("                display.style.display = 'none';");
                out.println("                shoppingList1.style.display = 'none';");
                out.println("                shoppingList2.style.display = 'none';");
                out.println("                shoppingList3.style.display = 'none';");
                out.println("            }");
                out.println("        });");
                out.println("        document.getElementById('showHideLink1').addEventListener('click', function() {");
                out.println("            var display = document.querySelector('.display');");
                out.println("            var shoppingList1 = document.querySelector('.music');");
                out.println("            var shoppingList2 = document.querySelector('.book');");
                out.println("            var shoppingList3 = document.querySelector('.computer');");
                out.println("            if (shoppingList1.style.display === 'none') {");
                out.println("                shoppingList1.style.display = 'block';");
                out.println("                display.style.display = 'none';");
                out.println("                shoppingList2.style.display = 'none';");
                out.println("                shoppingList3.style.display = 'none';");
                out.println("                display.style.display = 'none';");
                out.println("               ");
                out.println("            }else {");
                out.println("                display.style.display = 'none';");
                out.println("                shoppingList1.style.display = 'none';");
                out.println("                shoppingList2.style.display = 'none';");
                out.println("                shoppingList3.style.display = 'none';");
                out.println("            }");
                out.println("        });");
                out.println("        document.getElementById('showHideLink2').addEventListener('click', function() {");
                out.println("            var shoppingList1 = document.querySelector('.computer');");
                out.println("            var display = document.querySelector('.display');");
                out.println("            var shoppingList2 = document.querySelector('.music');");
                out.println("            var shoppingList3 = document.querySelector('.book');");
                out.println("            if (shoppingList1.style.display === 'none') {");
                out.println("                shoppingList1.style.display = 'block';");
                out.println("                shoppingList2.style.display = 'none';");
                out.println("                shoppingList3.style.display = 'none';");
                out.println("                display.style.display = 'none';");
                out.println("            } else {");
                out.println("                display.style.display = 'none';");
                out.println("                shoppingList1.style.display = 'none';");
                out.println("                shoppingList2.style.display = 'none';");
                out.println("                shoppingList3.style.display = 'none';");
                out.println("                ");
                out.println("            }");
                out.println("        });");
                out.println("        document.getElementById('showHideLink3').addEventListener('click', function() {");
                out.println("            var shoppingList1 = document.querySelector('.book');");
                out.println("            var display = document.querySelector('.display');");
                out.println("            var shoppingList2 = document.querySelector('.computer');");
                out.println("            var shoppingList3 = document.querySelector('.music');");
                out.println("            if (shoppingList1.style.display === 'none') {");
                out.println("                shoppingList1.style.display = 'block';");
                out.println("                shoppingList2.style.display = 'none';");
                out.println("                shoppingList3.style.display = 'none';");
                out.println("                display.style.display = 'none';");
                out.println("            } else {");
                out.println("                display.style.display = 'none';");
                out.println("                shoppingList1.style.display = 'none';");
                out.println("                shoppingList2.style.display = 'none';");
                out.println("                shoppingList3.style.display = 'none';");
                out.println("            }");
                out.println("        });");
                out.println("    </script>");
                out.println("</body>");
                out.println("</html>");

            }else if (param.equals("view")) {

            Map<String, String[]> parameter = request.getParameterMap();
            for (Entry<String, String[]> entry : parameter.entrySet()) {
                if (entry.getKey().equals("param")) {
                    continue;
                }
                session.setAttribute(entry.getKey(), entry.getValue());
            }
            
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ExcelServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"/HW2/ShoopingServlet/shop\" method=\"POST\">");
            String[] comp = (String[]) session.getAttribute("comp");
            String[] music = (String[]) session.getAttribute("music");
            String[] book = (String[]) session.getAttribute("book");

            out.println("<h1>Cart Items!!!!</h1>");
            out.println("<br>");
            for (String a : comp) {
                out.println(a.toString());
                out.println("<br>");
            }
            for (String a : music) {
                out.println(a.toString());
                out.println("<br>");
            }
            for (String a : book) {
                out.println(a.toString());
                out.println("<br>");
            }
            out.println("<br>");
            out.println("<input type=\"hidden\" name=\"param\" value=\"\">");
            out.println("<input type=\"hidden\" name=\"input\" value=\"login\">");
            out.println("<input type=\"hidden\" name=\"username\" value=\"admin\">");
            out.println("<input type=\"hidden\" name=\"password\" value=\"admin\">");
            out.println(" <button type=\"Submit\">Shop Again</button>");
            out.println("<br>");
            out.println("<a href=\"http://localhost:8080/HW2/members.jsp\">Log out?</a>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");

        }
    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       InProcess(request,response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      InProcess(request,response);
    }

    public String func(String[] array) {

        StringBuilder s = new StringBuilder();

        for (String a : array) {
            s.append(a);
        }
        return s.toString();
    }


}
