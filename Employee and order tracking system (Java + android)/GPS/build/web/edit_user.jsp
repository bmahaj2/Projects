
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="two.css" rel="stylesheet" type="text/css"/>

        <title>Edit User</title>
        <script type="text/javascript">
            function go3()
            {
                var contact = document.getElementById("ct");
                if (isNaN(contact.value) || contact.value.length != 10)
                {
                    document.getElementById("myct").innerHTML = "Invalid Mobile No.";
                    contact.value = "";
                }
            }
            function go2()
            {
                document.getElementById("fn").removeAttribute("disabled");
                document.getElementById("ln").removeAttribute("disabled");
                document.getElementById("dob").removeAttribute("disabled");
                document.getElementById("doj").removeAttribute("disabled");
                document.getElementById("addrs").removeAttribute("disabled");
                document.getElementById("em").removeAttribute("disabled");
                document.getElementById("ct").removeAttribute("disabled");
                document.getElementById("deptn").removeAttribute("disabled");

            }
        </script>
    </head>
    <body>
        <div id="all">
            <%@include file="header.html" %>
            <%@include file="menu_afterlogin.html" %>
            <div id="main">

                <%
                    String username = request.getParameter("q");

                    System.out.println("hello world : " + username);

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps", "root", "SYSTEM");
                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("select * from signup where username=\'" + username + "\'");

                    String firstname, lastname, email_id, mobile_no, address, department_name, dob, doj, photo_path;
                    if (rs.next()) {

                        firstname = rs.getString("firstname");
                        lastname = rs.getString("lastname");
                        email_id = rs.getString("email_id");
                        address = rs.getString("address");
                        mobile_no = rs.getString("mobile_no");
                        department_name = rs.getString("department_name");
                        dob = rs.getString("date_of_birth");
                        doj = rs.getString("date_of_joining");
                        photo_path = rs.getString("photo");
                %>
                <form action="edit_user2.jsp" method="">
                    <table border="3" style="background-color: lightgray" onload="go()">
                        <tr>
                            <td>Username</td>
                            <td><input type="text" id="un" disabled value="<%=username%>" />
                            </td>
                            <td><input type="hidden" name="un" value="<%=username%>"/>
                            </td>
                        </tr>

                        <tr>
                            <td>First Name</td>
                            <td><input type="text" required disabled placeholder="Enter First Name" value="<%=rs.getString("firstname")%>" id="fn" name="fn"/>
                            </td>
                        </tr>

                        <tr>
                            <td>Last Name</td>
                            <td><input type="text" required disabled placeholder="Enter Last Name" value="<%=rs.getString("lastname")%>" id="ln" name="ln"/>
                            </td>
                        </tr>

                        <tr>
                            <td>Date Of Birth</td>
                            <td><input type="date" disabled name="dob" id="dob" value="<%=rs.getString("date_of_birth")%>"/></td>
                        </tr>

                        <tr>
                            <td>Date Of Joining</td>
                            <td><input type="date" disabled name="doj" id="doj" value="<%=rs.getString("date_of_joining")%>"/>
                            </td>
                        </tr>

                        <tr>
                            <td>Address</td>
                            <td><textarea rows="5" cols="20" disabled id="addrs" name="addrs" ><%=rs.getString("address")%></textarea></td>
                        </tr>

                        <tr>
                            <td>Email</td>
                            <td><input type="email" name="em" disabled id="em" value="<%=rs.getString("email_id")%>"/></td>
                        </tr>

                        <tr>
                            <td>Contact</td>
                            <td><input type="text" id="ct" name="ct" disabled value="<%=rs.getString("mobile_no")%>" onblur="go3()"/></td>
                        </tr>

                        <tr>
                            <td></td>
                            <td><span id="myct"></span></td> 
                        </tr>

                        <tr>
                            <td>Select Department</td>
                            <td>
                                <select name="deptn" disabled id="deptn" value=<%=rs.getString("department_name")%>>
                                    <option value="Marketing">Marketting</option>
                                    <option value="Sales">Sales</option>
                                    <option value="Production">Production</option>
                                    <option value="Purchase">Purchase</option>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <td></td>
                            <td>
                                <input type="button" value="Edit" name="edit" onclick="go2()"/>
                                <input type="submit" value="Save" name="save"/>
                            </td>

                        </tr>
                    </table>
                </form>
                <%
                    }
                %>
                
            </div>
            <%@include file="footer.html" %>
        </div>
    </body>
</html>
