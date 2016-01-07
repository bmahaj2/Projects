<%-- 
    Document   : trackfilldetails2
    Created on : Apr 14, 2014, 5:41:43 PM
    Author     : Bhavya
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            String imei=request.getParameter("IMEI");
            String date = request.getParameter("date");
            String starttime = request.getParameter("starttime");
            String endtime = request.getParameter("lasttime");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println(imei);
            System.out.println("Driver loaded successfully");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps", "root", "SYSTEM");
            System.out.println("connection build");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            System.out.println("statemt");
            // ResultSet rs=stmt.executeQuery("select * from track_emphistory where date between '"+date +" "+starttime+"' and '"+date +"'"+endtime+"'");
            ResultSet rs = stmt.executeQuery("select * from gps.track_emphistory where IMEI='" + imei + "' and date between '" + date + " " + starttime + "' and '" + date + " " + endtime + "'");
        %>

        <form action="employee_track3.jsp">
            <input type="hidden" name="date" value="<%=date%>">
            <input type="hidden" name="starttime" value="<%=starttime%>">
            <input type="hidden" name="lasttime" value="<%=endtime%>">
            <input type="hidden" name="IMEI" value="<%=imei%>">

            <input type="submit" value="Show">
        </form>

        <div style="overflow: scroll">
            <table border="12">
                <tr style="font-size: x-large;background-color:royalblue ; color: lightblue">


                    <th>USERNAME</th>
                    <th>IMEI</th>
                    <th>LATITUDE</th>
                    <th>LONGITUDE</th>
                        <%
                            String IMEI, username, latitude, longitude;
                            while (rs.next()) {
                                username = rs.getString("username");

                                IMEI = rs.getString("IMEI");
                                latitude = rs.getString("latitude");
                                longitude = rs.getString("longitude");


                        %>
                <tr style="background-color:whitesmoke ; color:dodgerblue ;font-size: large">

                    <td><b><%=username%></b></td>
                    <td><b><%=IMEI%></b></td>
                    <td><b><%=latitude%></b></td>
                    <td><b><%=longitude%></b></td>
                </tr>
                <%
                    }
                %>
            </table> 
        </div>
    </body>
</html>
