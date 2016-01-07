<%-- 
    Document   : signup
    Created on : Apr 5, 2014, 11:20:41 AM
    Author     : Bhavya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="two.css">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>signup</title>
    </head>
    <body>

        <div id="all">
            <%@include file="header.html" %>
            <%@include file="menu_afterlogin.html" %>
            <div id="main">
                <!--                <span class="headingstyle" style="margin-top: 20px;">Add Employee</span>-->
                <h3 class="heading" style="margin-top: -30px;"><center>Add Employee</center></h3>
                <center>
                    <div style="border-radius: 10px;border:solid 3px saddlebrown;background: white; width:600px; box-shadow: 15px 15px #888888;">
                        <center>
                            <form action="signup2.jsp" method="POST">
                                <table border="0" class="tablestyle" cellspacing="5">
                                    <tr>
                                        <td>Username</td>
                                        <td><input type="text" name="username" class="tfield"/></td>
                                    </tr>

                                    <tr>
                                        <td>Firstname</td>
                                        <td><input type="text" name="firstname" class="tfield"/></td>
                                    </tr>
                                    <tr>
                                        <td>Lastname</td>
                                        <td><input type="text" name="lastname" class="tfield"/></td>
                                    </tr>
                                    <tr>
                                        <td>Email Id</td>
                                        <td><input type="email" name="email_id" class="tfield"/></td>
                                    </tr>
                                    <tr>
                                        <td>Address</td>
                                        <td><textarea rows="5" cols="20" id="addrs" name="addrs" class="tarea1"></textarea></td>
                                    </tr>


                                    <tr>
                                        <td>Contact Number</td>
                                        <td><input type="text" name="mobile_no" class="tfield"/></td>
                                    </tr>
                                    <tr>
                                        <td>Department Name</td>
                                        <td>
                                            <select name="deptn" id="deptn" class="tfield">
                                                <option value="Marketing">Marketing</option>
                                                <option value="Sales">Sales</option>
                                                <option value="Production">Production</option>
                                                <option value="Purchase">Purchase</option> 
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Date Of Birth</td>
                                        <td><input type="date" name="dob" class="tfield"/></td>
                                    </tr>
                                    <tr>
                                        <td>Date Of Joining</td>
                                        <td><input type="date" name="doj" class="tfield"/></td>
                                    </tr>

                                    <tr>
                                        <td></td>
                                        <td><input type="submit" value="add" class="submitsyle"</td>
                                    </tr>

                                </table>
                            </form>
                            <%
                                String msg = request.getParameter("msg");
                                if (msg != null) {
                            %>
                            <label style="color:red"><%=msg%>
                            </label>
                            <%
                                }
                            %>

                    </center>
               
                       </div>
                   </center>
          </div>
        

                    <%@include file="footer.html" %>
            </div>


    </body>
</html>
