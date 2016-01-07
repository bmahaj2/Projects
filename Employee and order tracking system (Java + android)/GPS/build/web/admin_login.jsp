
<%@page contentType="text/html"%>
<!DOCTYPE html>
<html>
    <head>
                <link type="text/css" rel="stylesheet" href="two.css">

        <title>Employee Login Page</title>
    </head>
    <body>
        
        <div id="all">
            <%@include file="header.html" %>
            <%@include file="menu_home.html" %> 
            <div id="main">
<!--                <span class="headingstyle" style="margin-top: 20px;">Login</span>-->
<h1 class="heading" style="margin-top: -30px;"><center>Login Form</center></h1>
                   <center>
                       <div style="border-radius: 10px;border:solid 3px saddlebrown;background: white; width:600px; box-shadow: 15px 15px#888888;">
                           <center>
                                 <form action="admin_login2.jsp" method="post">
                <table border="0" class="tablestyle" cellspacing="5" style="margin-top: 30px;">
                
                   
                      <tr>
                          <td>Username</td>
                          <td><input type="text" name="usr" required id="usr" class="tfield"/></td>
                      </tr>
                      <tr>
                          <td>Password</td>
                          <td><input type="password" name="pwd" required id="pwd" class="tfield"/></td>
                      </tr>
                         <td></td>
                         <td><input type="submit" value="Submit" class="submitsyle"/></td>
                          <tr>
                      <%
                            String message=request.getParameter("q");
                            if(message!=null)
                            {
                      %>
                            <td colspan="2"><b><%=message%></b></td>
                      <%
                            }
                      %>
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
