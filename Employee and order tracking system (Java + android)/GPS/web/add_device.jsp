<%-- 
    Document   : add_device
    Created on : Apr 8, 2014, 12:48:24 PM
    Author     : Bhavya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="two.css" rel="stylesheet" type="text/css"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            

        <div id="all">
            <%@include file="header.html" %>
            <%@include file="menu_afterlogin.html" %>
            <div id="main">
                <h1 class="heading" style="margin-top: -30px;"><center>Add Device</center></h1>
                 <center>
                       <div style="border-radius: 10px;border:solid 3px saddlebrown;background: white; width:600px; box-shadow: 15px 15px#888888;">
                           <center>
                <form action="add_devices2.jsp" method="POST">
                    <table border="0" class="tablestyle" cellspacing="5" style="margin-top: 30px;">
                        <tr>
                            <td>IMEI number</td>
                            <td><input type="text" name="IMEI" class="tfield"/></td>
                        </tr>

                        <tr>
                            <td>Phone model</td>
                            <td><input type="text" name="phone_model" class="tfield"/></td>
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
