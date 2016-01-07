
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String s = (String) session.getAttribute("user");
            System.out.println(s);
            String absolutepath = getServletContext().getRealPath("/uploads");
            String filename = vmm.FileUploader.savefile(request, absolutepath);
            System.out.println(filename);
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps", "root", "SYSTEM");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from signup where username = '" + s + "'");
            if (rs.next()) {
                rs.updateString("photo", "./uploads/" + filename);
                rs.updateRow();
                response.sendRedirect("add_userPhoto.jsp?msg=Photo Uploaded");

            }

        %>        
    </body>
</html>
