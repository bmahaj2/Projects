

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="two.css">

        <title>View Employee</title>
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
                    ResultSet rs = stmt.executeQuery("select * from courier_assignment");
                    Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    Statement stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                %>

                <%                          String message = request.getParameter("m");
                    if (message != null) {
                %>
                <td style="background-color: gold" colspan="10"><b><%=message%></b></td>
                        <%
                            }
                        %>
                <div style="width: 980px; overflow: scroll;">  
                <table border="12">
                    <tr style="font-size: x-large;background-color:royalblue ; color: lightblue">

                        <th>COURIER ID</th>
                        <th>TITLE</th>
                        <th>DESCRIPTION</th>
                        <th>DELIVERY EMPLOYEE</th>
                        <th>PHOTO</th>
                        <th>TRACKING</th>

                    </tr>
                    <%
                        String courier_id, title, description, employee, fname = "", lname = "", photo = "", IMEI = "";
                        while (rs.next()) {
                            courier_id = rs.getString("courier_id");

                            title = rs.getString("title");
                            description = rs.getString("description");
                            employee = rs.getString("employee");
                            ResultSet rs1 = stmt1.executeQuery("select * from signup where username=" + "'" + employee + "'");
                            ResultSet rs2 = stmt2.executeQuery("select * from device_allotment where username=" + "'" + employee + "'");

                            if (rs1.next()) {
                                photo = rs1.getString("photo");
                                fname = rs1.getString("firstname");
                                lname = rs1.getString("lastname");
                            }
                            if (rs2.next()) {
                                IMEI = rs2.getString("IMEI");
                            }

                    %>
                    <tr style="background-color:whitesmoke ; color:dodgerblue ;font-size: large">

                        <td><b><%=courier_id%></b></td>
                        <td><b><%=title%></b></td>
                        <td><b><%=description%></b></td>

                        <td><b><%=fname + " " + lname%></b></td>
                        <td><img src="<%=photo%>" width="100" height="100" /></td> 
                        <td><a href="trackemp_courier2.jsp?courier_id=<%=courier_id%>,&imei=<%=IMEI%>">TRACK</a></td>

                    </tr>
                    <%
                        }
                    %>   
                </table>
                </div>
            </div>  
        </div>

        <%@include file="footer.html" %>
    </div>
</center>
</body>
</html>
