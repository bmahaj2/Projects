<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
           Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
           
           ResultSet rs=stmt.executeQuery("select * from courier_assignment");
           
           String title,desc,username,source_loc,imei,source_lat,source_longi,dest_lat,dest_longi,dest_loc;
           title=request.getParameter("title");
           desc=request.getParameter("desc");
           username=request.getParameter("username");
           imei=request.getParameter("imei");
           source_loc=request.getParameter("start_pt");
          source_lat=request.getParameter("lat");
           source_longi=request.getParameter("longi");
           dest_lat=request.getParameter("dest_lat");
           dest_longi=request.getParameter("dest_longi");
           dest_loc=request.getParameter("dest_pt");
           
           
           rs.moveToInsertRow();
           rs.updateString("title",title);
           rs.updateString("description",desc);
           rs.updateString("employee",username);
           rs.updateString("IMEI",imei);
           rs.updateString("source_location",source_loc);
           rs.updateString("source_latitude",source_lat);
           rs.updateString("source_longitude",source_longi);
           rs.updateString("destination_location",dest_loc);
           rs.updateString("destination_latitude",dest_lat);
           rs.updateString("destination_longitude",dest_longi);
           rs.updateString("status","pending");
           rs.insertRow();
           response.sendRedirect("CourierAsssignment.jsp?msg=Courier Assigned");
       %> 
    </body>
</html>
