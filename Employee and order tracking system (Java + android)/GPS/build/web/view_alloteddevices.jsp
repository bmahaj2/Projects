<%-- 
    Document   : view_alloteddevices
    Created on : Apr 10, 2014, 3:48:00 PM
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
        <script type="text/javascript">
            function go()
            {
                return confirm("Are you sure you want to delete?");
            }
        </script>
    </head>
    <body>
    <center>
        <div id="all">
            <%@include file="header.html" %>
            <%@include file="menu_afterlogin.html" %>

            <div id="main">
                <%
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps", "root", "SYSTEM");
                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                    ResultSet rs1 = stmt.executeQuery("select * from device_allotment where releasedate is null");
                %>
                <%
                    String message = request.getParameter("m");
                    if (message != null) {
                %>
                <td style="background-color: gold" colspan="10"><b><%=message%></b></td>
                        <%
                            }
                        %>
                        <div style="width: 980px; overflow: scroll;">         

                    <table border="12">
                        <tr style="font-size: x-large;background-color:royalblue ; color: lightblue">

                            <th>IMEI</th>
                            <th>ALLOTED</th>
                            <th>ALLOTED TO</th>
                            <th>RELEASE DEVICE</th>

                        </tr>
                        <%
                            String IMEI, alloted, alloted_to;
                            while (rs1.next()) {

                                IMEI = rs1.getString("IMEI");
                                alloted_to = rs1.getString("username");


                        %>
                        <tr style="background-color:whitesmoke ; color:dodgerblue ;font-size: large">

                            <td><b><%=IMEI%></b></td>
                            <td>Yes</td>

                            <td><b><%=alloted_to%></b></td>


                            <td><a href="release_device.jsp?d=<%=IMEI%>" onclick="return go()">RELEASE</a></td>

                        </tr>
                        <%
                            }
                        %>   
                        <%
                            ResultSet rs = stmt.executeQuery("select imei from gps.devices where imei not in (select imei from gps.device_allotment where releasedate is null)");
                            String IMEI1, alloted1, alloted_to1;
                            while (rs.next()) {

                                IMEI1 = rs.getString("IMEI");


                        %>
                        <tr style="background-color:whitesmoke ; color:dodgerblue ;font-size: large">

                            <td><b><%=IMEI1%></b></td>
                            <td>NO</td>
                            <td></td>
                            <td></td>






                        </tr>
                        <%
                            }
                        %>   
                    </table>

                </div>
            </div>
                <%@include file="footer.html" %>
            </div>
    </center>

</body>
</html>
