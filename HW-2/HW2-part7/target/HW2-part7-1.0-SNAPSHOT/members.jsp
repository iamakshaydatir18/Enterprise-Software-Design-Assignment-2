<%-- 
    Document   : members
    Created on : Oct 8, 2023, 1:08:00 PM
    Author     : akshaydatir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(request.getParameter("logout") != null){
        request.getSession().invalidate();
        response.sendRedirect("login.jsp");
    }
    
    String username = (String) session.getAttribute("username");
    
    if(username != null){
         response.sendRedirect("login.jsp");
            return;
    }
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Members</title>
    </head>
    <body>

        <h1> <%= username %> want to log out????</h1>
        <br>
        <a href="members.jsp?logout=t">Log Out</a>
    </body>
</html>
