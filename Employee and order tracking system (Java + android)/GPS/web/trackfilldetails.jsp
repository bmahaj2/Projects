<%-- 
    Document   : trackfilldetails
    Created on : Apr 14, 2014, 5:23:21 PM
    Author     : Bhavya
--%><%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

.
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <link type="text/css" rel="stylesheet" href="two.css">

    <body>
        <div id="all">
            <%@include file="header.html" %>
            <%@include file="menu_afterlogin.html" %> 
            <div id="main">
                <%

                    String IMEI = request.getParameter("p");
                    Class.forName("com.mysql.jdbc.Driver");
                    System.out.println("Driver loaded successfully");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps", "root", "SYSTEM");
                    System.out.println("connection build");
                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    System.out.println("statemt");
                    ResultSet rs = stmt.executeQuery("select distinct imei from track_emphistory ");
                %>
                <h1 class="heading" style="margin-top: -30px;"><center>Offline Tracking</center></h1>
                <center>
                    <div style="border-radius: 10px;border:solid 3px saddlebrown;background: white; width:600px; box-shadow: 15px 15px#888888;">
                        <center>
                            <form action="employee_track3.jsp" method="POST">
                                <table border="0" class="tablestyle" cellspacing="5">




                                    <tr>
                                        <td>Date(yyyy-mm-dd)</td>
                                        <td><input type="date" name="date" class="tfield"/>
                                            <input type="hidden" name="IMEI" value="<%=IMEI%>"></td>
                                    </tr>
                                    <tr>
                                        <td>StartTime(HH:mm:ss)</td>
                                        <td><input type="text" name="starttime" class="tfield"/></td>
                                    </tr>
                                    <tr>
                                        <td>LastTime(HH:mm:ss)</td>
                                        <td><input type="text" name="lasttime" class="tfield"/></td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td><input type="submit" value="submit" class="submitsyle"</td>
                                    </tr>

                                </table>
                            </form>
                        </center>

                    </div>
                </center>
            </div>

            <%@include file="footer.html" %>
        </div>
    </body>
</html>
