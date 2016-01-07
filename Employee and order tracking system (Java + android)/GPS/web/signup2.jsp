<%-- 
    Document   : signup2
    Created on : Apr 5, 2014, 11:50:40 AM
    Author     : Bhavya
--%>


<%@page import="sun.security.util.Password"%>
<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            int flag=0;
            String password;
            String username=request.getParameter("username");
            String firstname=request.getParameter("firstname");
            String lastname=request.getParameter("lastname");
            String email_id=request.getParameter("email_id");
            String address=request.getParameter("addrs");
            String mobile_no=request.getParameter("mobile_no");
            String department_name=request.getParameter("deptn");
            String date_of_birth=request.getParameter("dob");
            String date_of_joining=request.getParameter("doj");
          
            String Photo=request.getParameter("Photo");
            String a[]={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"
                     ,"q","r","s","t","u","v","w","x","y","z"};
          
          password=""+(int)(10+(89*Math.random()));
          int j;
          
          Random rd=new Random();
          for(int i=1;i<=4;i++)
          {    
             j=(int)(0+(25*Math.random()));
             password=password+a[j];    
          }
          
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded successfully");
        Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
        System.out.println("connection build");
        Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        System.out.println("statemt");
       
           ResultSet rs=stmt.executeQuery("select * from signup");
          
          while(rs.next())
          {
              if(rs.getString("username").equals(username))
              {
                  flag=1;
                  break;
              }
          }
          
          if(flag==1) 
          {   
               response.sendRedirect("signup.jsp?msg=AlreadyExists");
      
          }               
       
      
        else
        {
           
        rs.moveToInsertRow();
        rs.updateString("username",username);
        
        rs.updateString("firstname",firstname);
        rs.updateString("lastname",lastname);
        
        
        
        rs.updateString("email_id",email_id);
        rs.updateString("address",firstname);

        rs.updateString("mobile_no",mobile_no);
        rs.updateString("department_name",department_name);
        rs.updateString("date_of_birth",date_of_birth);
        rs.updateString("date_of_joining",date_of_joining);
        rs.updateString("password",password);
        rs.insertRow();
        session.setAttribute("user", username);
       // vmm.SimpleMailDemo em = new vmm.SimpleMailDemo(email_id, "Username and Password", "Your username and Password is "+username +" "+ password);
                vmm.SimpleMailDemo em = new vmm.SimpleMailDemo(email_id, "Username and Password", "Your username is "+username+" and your password is "+ password);

        em.sendemail();
        response.sendRedirect("add_userPhoto.jsp");
        }
        
        
        %>
        <%
        
        %>
        
    </body>
</html>
