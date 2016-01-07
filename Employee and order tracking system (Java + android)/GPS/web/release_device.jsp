
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
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
             DateFormat dateformat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
          java.util.Date date=new java.util.Date();
             String IMEI=request.getParameter("d");
             Class.forName("com.mysql.jdbc.Driver");
             Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
             Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
             ResultSet rs=stmt.executeQuery("select * from device_allotment where IMEI=\'"+IMEI+"\'"); 
            
             if(rs.next())
             {
                            rs.updateString("releasedate",dateformat.format(date));
                            rs.updateRow();

                     response.sendRedirect("view_alloteddevices.jsp?m=Release of device with IMEI" +IMEI+" Successfull");
                
             }
        %>
    </body>
</html>
