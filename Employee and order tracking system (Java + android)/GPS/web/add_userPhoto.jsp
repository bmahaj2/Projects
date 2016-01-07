
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Step 2</title>
        <link href="two.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <div id="all">
            <%@include file="header.html" %>
            <%@include file="menu_afterlogin.html" %>
            <div id="main">
                <!--<h1 style="background-color: deepskyblue"><b>Add User Photo</b></h1>-->
                <h1 class="heading" style="margin-top: -30px;"><center>Add User Photo</center></h1>
                <center>
                    <div style="border-radius: 10px;border:solid 3px saddlebrown;background: white; width:600px; box-shadow: 15px 15px #888888;">

                        <form action="add_userPhoto2.jsp" enctype="multipart/form-data" method="post">
                            <table border="10">

                                <tr>
                                    <td>Upload Photo</td>
                                    <td><input type="file" id="im1" name="im1"/></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><input type="submit" value="submit" /></td>
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


                    </div>
                </center>
            </div>


            <%@include file="footer.html" %>
        </div>
    </body>
</html>
