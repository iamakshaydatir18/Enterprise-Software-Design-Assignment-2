<%-- 
    Document   : login
    Created on : Oct 8, 2023, 1:07:44 PM
    Author     : akshaydatir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (request.getParameter("login") != null) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("admin") && password.equals("admin")) {

            session.setAttribute("username", username);
            session.setAttribute("password", password);
            response.sendRedirect("/HW2/ShoopingServlet/shop");
            return;
        }else{
            response.sendRedirect("error.jsp");
            return;
        }
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log In Form</title>
    </head>
    <body>
        <FORM ACTION="login.jsp" METHOD="get">
            <TABLE>
                <TR><TD>Authentication Required for User!!!
                <TR><TD>User name: <INPUT TYPE="TEXT" NAME="username">
                <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="password">
                <TR><TH><INPUT TYPE="SUBMIT" NAME="login" VALUE="Log In">
            </TABLE>
        </FORM>
    </body>
</html>
