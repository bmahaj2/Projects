

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="two.css" rel="stylesheet" type="text/css"/>
        <title>Home Page</title>
    </head>
    <body>
        <div id="all">
            <%@include file="header.html" %>
            <%@include file="menu_afterlogin.html" %>
            <div id="main">
                <h3 class="heading" style="margin-top: -30px;"><center>Welcome Administrator</center></h3>
                                   <%@include file="sliderlatest.html" %>
                <%
                    if (session.getAttribute("username") == null) {
                        response.sendRedirect("admin_login.jsp");
                        
                    }
                %>

            </div>
            <%@include file="footer.html" %>
        </div>
    </body>
</html>
