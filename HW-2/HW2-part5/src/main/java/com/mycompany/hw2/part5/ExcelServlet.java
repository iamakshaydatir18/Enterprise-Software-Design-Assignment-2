package com.mycompany.hw2.part5;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

@WebServlet("/ExcelServlet.xls")
public class ExcelServlet extends HttpServlet {
    
    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {
         
         response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String input = request.getParameter("input");
        
            if (input == null) {
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ExcelServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<form action=/HW2/ExcelServlet.xls method=post>");
                out.println("<h1>Hello  !!!!</h1>");
                out.println("<label for=" + "file" + ">Enter Excel file name:</label>");
                out.println("<input type=" + "text" + " id=" + "input" + " name=" + "input" + " required>");
                out.println("<input type=" + "submit" + " value=" + "Submit" + ">");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            }else if(input.equals("store")){

                    try {

                        String xlsDirectory = getServletContext().getRealPath("/WEB-INF/xls/store.xls");

                        FileInputStream fis = new FileInputStream(xlsDirectory);
                        HSSFWorkbook workbook = new HSSFWorkbook(fis);

                        Sheet sheet = workbook.getSheetAt(0);

                        StringBuilder htmlContent = new StringBuilder();
                        htmlContent.append("<html><head><title>Excel to HTML</title></head><body><h1>Entered file name is "+ input +" </h1><table border='1'>");

                        for (Row row : sheet) {
                            htmlContent.append("<tr>");
                            for (Cell cell : row) {
                                htmlContent.append("<td>").append(cell.toString()).append("</td>");
                            }
                            htmlContent.append("</tr>");
                        }

                        htmlContent.append("</table></body></html>");

                        workbook.close();
                        fis.close();

                        response.getWriter().write(htmlContent.toString());
                    } catch (Exception e) {

                    }

                } else {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet ExcelServlet</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<form action=/HW2/ExcelServlet.xls method=post>");
                    out.println("Invalid XLS File Name ");
                    out.println("<input type=\"hidden\" name=\"username\" value=\"admin\">");
                    out.println("<input type=\"hidden\" name=\"password\" value=\"admin\">");
                    out.println(" <button type=\"Submit\">Try Again?</button>");
                    out.println("</form>");
                    out.println("</body>");
                    out.println("</html>");
                }
           

         
     }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         try {
             processRequest(request,response);
         } catch (Exception ex) {
             Logger.getLogger(ExcelServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         try {
             processRequest(request,response);
         } catch (Exception ex) {
             Logger.getLogger(ExcelServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

}
