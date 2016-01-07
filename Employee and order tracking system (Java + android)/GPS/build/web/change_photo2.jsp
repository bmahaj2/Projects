
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
             String username=request.getParameter("q");
             
             String absolutepath=getServletContext().getRealPath("/uploads");
             String filename=vmm.FileUploader.savefile(request,absolutepath);
             String new_path="";
           
             Class.forName("com.mysql.jdbc.Driver");
             Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
             Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
             ResultSet rs=stmt.executeQuery("select * from signup where username=\'"+username+"\'");
             
             if(rs.next())
             {       
                 rs.updateString("photo","./uploads/"+filename);
                 rs.updateRow();
                 new_path=rs.getString("photo");
                 
                 response.sendRedirect("change_photo.jsp?ph="+new_path);                   
             }
         %>
              
    </body>
</html>
