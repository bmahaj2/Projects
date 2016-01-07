
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Check Admin Login and Password</title>
    </head>
    <body>
        <%
              String adminName=request.getParameter("usr");
              String pwd=request.getParameter("pwd");
              
              Class.forName("com.mysql.jdbc.Driver");
              Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
              Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
              ResultSet rs=stmt.executeQuery("select * from admin");
              
              rs.next();
              if(rs.getString("username").equals(adminName) && rs.getString("password").equals(pwd))
              {
                  session.setAttribute("username",adminName);
                  response.sendRedirect("admin_login3.jsp");
              }
              else
              {
                  response.sendRedirect("admin_login.jsp?q=Invalid Username or Password");    
              }
        %>
    </body>
</html>
