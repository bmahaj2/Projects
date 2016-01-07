
<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Delete Employee</title>
    </head>
    <body>
        <%
             String username=request.getParameter("d");
             Class.forName("com.mysql.jdbc.Driver");
             Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
             Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
             ResultSet rs=stmt.executeQuery("select * from signup where username=\'"+username+"\'"); 
             int ans=0;
             
             if(rs.next())
             {
                rs.deleteRow();
                     response.sendRedirect("view_user.jsp?m=Deletion of " +username+" Successfull");
                
             }
        %>
    </body>
</html>
