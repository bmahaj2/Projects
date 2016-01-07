
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
    </head>
    <body>
        <%
         try
         {
             String msg,msg_to;
             String cb[]=request.getParameterValues("cb");
             msg=request.getParameter("txt");
             msg_to=request.getParameter("cb");  //username
             Class.forName("com.mysql.jdbc.Driver");
             Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
             Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
             
             //Select employees of selected department
             ResultSet rs=stmt.executeQuery("select * from messages");
             
             for(int i=0;i<cb.length;i++)
             {
                rs.moveToInsertRow();
                rs.updateString("message",msg);
                rs.updateString("message_to",cb[i]);
                rs.insertRow();
             }
           }
         catch(Exception ex)
         {
             ex.printStackTrace();    
         }
         
         response.sendRedirect("message_to_emp.jsp?msg="+"message sent successfully");
        %> 
    </body>
</html>
