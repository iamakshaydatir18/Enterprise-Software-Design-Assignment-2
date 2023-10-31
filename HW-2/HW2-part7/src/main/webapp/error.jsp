<%-- 
    Document   : error
    Created on : Oct 7, 2023, 11:23:37 PM
    Author     : akshaydatir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
  
    String log = (String) request.getParameter("logIn");
    
    if(log != null && log.equals("t")){
        response.sendRedirect("login.jsp");
            return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Log In Failed!</h1>
        <br>
        <a href="members.jsp?logIn=t">Try Log In Again</a>
    </body>
</html>
