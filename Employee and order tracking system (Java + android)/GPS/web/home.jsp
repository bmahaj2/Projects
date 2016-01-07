<%-- 
    Document   : home
    Created on : May 10, 2014, 2:38:14 PM
    Author     : Bhavya
--%>

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
            <%@include file="menu_home.html" %> 
            <div id="main">
               
                
                   <%@include file="sliderlatest.html" %>
            </div>

            <%@include file="footer.html" %>
        </div>
    </body>
</html>
