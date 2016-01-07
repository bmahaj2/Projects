
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <%
             String username=request.getParameter("un");
             Class.forName("com.mysql.jdbc.Driver");
             Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
             Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
             ResultSet rs=stmt.executeQuery("select * from signup where username=\'"+username+"\'");
             if(rs.next())
             {
                 rs.updateString("firstname",request.getParameter("fn"));
                 rs.updateString("lastname",request.getParameter("ln"));
                 rs.updateString("email_id",request.getParameter("em"));
                 rs.updateString("address",request.getParameter("addrs"));
                 rs.updateString("mobile_no",request.getParameter("ct"));
                 rs.updateString("department_name",request.getParameter("deptn"));
                 rs.updateString("date_of_birth",request.getParameter("dob"));
                 rs.updateString("date_of_joining",request.getParameter("doj"));
                 rs.updateRow();    
        %>
        <h1>Row Updated Successfully</h1>
        <%
             }
        %>
    </body>
</html>
