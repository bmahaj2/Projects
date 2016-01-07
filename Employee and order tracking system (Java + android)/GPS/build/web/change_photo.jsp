
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="two.css" rel="stylesheet" type="text/css"/>

        <title>JSP Page</title>
    </head>

    <body>
        <div id="all">
            <%@include file="header.html" %>
            <%@include file="menu_afterlogin.html" %>
            <div id="main">
                <%
                    String username = request.getParameter("p");

                    String absolutepath = getServletContext().getRealPath("/uploads");
                    String filename = vmm.FileUploader.savefile(request, absolutepath);
                    String old_path = "";
                    String new_path = "";

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps", "root", "SYSTEM");
                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("select * from signup where username=\'" + username + "\'");

                    if (rs.next()) {
                        old_path = rs.getString("photo");
                    }
                %>        

                <h1 class="heading" style="margin-top: -30px;">Change Photo for <%=username%></h1>
                <center>
                    <div style="border-radius: 10px;border:solid 3px saddlebrown;background: white; width:600px; box-shadow: 15px 15px #888888;">
                        <center>
                <form action="change_photo2.jsp?q=<%=username%>" enctype="multipart/form-data" method="post">
                    <table border="1" class="tablestyle">

                        <tr>
                            <td>Old Photo</td>

                            <td><img src="<%=old_path%>" width="100" height="100"/></td>
                        </tr> 

                        <tr>
                            <td>Upload New Photo</td>
                            <td><input type="File" id="upload" name="upload"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="upload" /></td>
                        </tr>

                        <tr>
                            <td>New Photo</td>    
                            <td><img src="<%=request.getParameter("ph")%>" width="100" height="100"/></td>
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
