<%-- 
    Document   : allotjsp2
    Created on : Apr 9, 2014, 5:39:59 PM
    Author     : Bhavya
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
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
            String IMEI = request.getParameter("IMEI");
            String username = request.getParameter("username");
            DateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            java.util.Date date = new java.util.Date();
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps", "root", "SYSTEM");
            System.out.println("connection build");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            System.out.println("statemt");

            ResultSet rs = stmt.executeQuery("select * from device_allotment");
            rs.moveToInsertRow();
            rs.updateString("IMEI", IMEI);
            rs.updateString("username", username);
            rs.updateString("date_of_allotment", dateformat.format(date));
            rs.insertRow();
            response.sendRedirect("allotjsp.jsp?msg=Device Alloted");

        %>

    </body>
</html>
