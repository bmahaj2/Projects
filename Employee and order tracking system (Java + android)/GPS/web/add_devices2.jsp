<%-- 
    Document   : add_devices2
    Created on : Apr 8, 2014, 1:37:30 PM
    Author     : Bhavya
--%>
<%@page import="sun.security.util.Password"%>
<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
      <%  
          int flag=0;
          String IMEI=request.getParameter("IMEI");
          String phone_model=request.getParameter("phone_model");
             
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded successfully");
        Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
        System.out.println("connection build");
        Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        System.out.println("statemt");
       
           ResultSet rs=stmt.executeQuery("select * from devices");
          
          while(rs.next())
          {
              if(rs.getString("IMEI").equals(IMEI))
              {
                  flag=1;
                  break;
              }
          }
          
          if(flag==1) 
          {   
               response.sendRedirect("add_device.jsp?msg=AlreadyExists");
      
          }               
       
      
        else
        {
           
        rs.moveToInsertRow();
        rs.updateString("IMEI",IMEI);
        
        rs.updateString("phone_model",phone_model);
        rs.insertRow();
        response.sendRedirect("add_device.jsp?msg=Device Added");

        }
        %>
        
    </body>
</html>
