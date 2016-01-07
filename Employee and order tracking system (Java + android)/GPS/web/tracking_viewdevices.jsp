<%-- 
    Document   : tracking_viewdevices
    Created on : Apr 21, 2014, 12:42:22 PM
    Author     : Bhavya
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="two.css">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <div id="all">
            <%@include file="header.html" %>
            <%@include file="menu_afterlogin.html" %>

            <div id="main">
                <%
                    String username = request.getParameter("p");
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps", "root", "SYSTEM");
                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("select * from device_allotment where username='" + username + "'");
                %>
                <table border="12">
                    <tr style="font-size: x-large;background-color:royalblue ; color: lightblue">

                        <th>USER NAME</th>
                        <th>IMEI</th>
                        <th>OFFLINE TRACKING</th>
                        <th>ONLINE TRACKING</th>
                    </tr>
                    <%
                        String IMEI;
                        while (rs.next()) {
                            username = rs.getString("username");
                            System.out.println("helo");
                            IMEI = rs.getString("IMEI");

                    %>
                    <tr style="background-color:whitesmoke ; color:dodgerblue ;font-size: large">

                        <td><b><%=username%></b></td>
                        <td><b><%=IMEI%></b></td>



                        <td><a href="trackfilldetails.jsp?p=<%=IMEI%>">OFFLINE TRACKING</a></td>
                        <td><a href="trackemp2_liveTracking.jsp?p=<%=IMEI%>">ONLINE TRACKING</a></td>
                    </tr>

                    <%
                        }
                    %>
                </table>
            </div>

            <%@include file="footer.html" %>
        </div>
    </center>
</body>
</html>
