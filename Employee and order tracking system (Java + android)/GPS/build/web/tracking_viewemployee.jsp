<%-- 
    Document   : tracking_viewemployee
    Created on : Apr 21, 2014, 12:29:15 PM
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
        <div id="all">
            <%@include file="header.html" %>
            <%@include file="menu_afterlogin.html" %>
            <div id="main">
                <%
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps", "root", "SYSTEM");
                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("select * from signup");
                    System.out.println("helo");
                %>
                <div style="height: 980px; overflow: scroll;">         

                    <table border="12">
                        <tr style="font-size: x-large;background-color:royalblue ; color: lightblue">

                            <th>USER NAME</th>
                            <th>NAME</th>
                            <th>PHOTO</th>
                            <th>VIEW DEVICES</th>
                        </tr>
                        <%
                            String name, username, firstname, lastname, photo_path;

                            while (rs.next()) {
                                username = rs.getString("username");
                                System.out.println("helo");
                                firstname = rs.getString("firstname");
                                lastname = rs.getString("lastname");
                                name = firstname + " " + lastname;
                                photo_path = rs.getString("photo");
                        %>
                        <tr style="background-color:whitesmoke ; color:dodgerblue ;font-size: large">

                            <td><b><%=username%></b></td>
                            <td><b><%=name%></b></td>

                            <td><img src="<%=photo_path%>" width="100" height="100" /></td> 

                            <td><a href="tracking_viewdevices.jsp?p=<%=username%>">VIEW DEVICES</a></td>
                        </tr>

                        <%
                            }
                        %>
                    </table>
                </div>
            </div>

            <%@include file="footer.html" %>
        </div>
    </body>
</html>
