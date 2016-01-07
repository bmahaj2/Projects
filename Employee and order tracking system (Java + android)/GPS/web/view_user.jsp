
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
                <link href="two.css" rel="stylesheet" type="text/css"/>

        <title>View Employee</title>
        <script type="text/javascript">
            function go()
            {
                return confirm("Are you sure you want to delete?");
            }
        </script>
    </head>
    
    <body>
        <div id="all">
            <%@include file="header.html" %>
            <%@include file="menu_afterlogin.html" %>
            <div id="main">
        <%
             Class.forName("com.mysql.jdbc.Driver");
             Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
             Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
             ResultSet rs=stmt.executeQuery("select * from signup");
        %>
        
        <div style="width: 980px; overflow: scroll;height: 980px; overflow: scroll;">         
            
                  <table border="12">
          <tr style="font-size: x-large;background-color:royalblue ; color: lightblue">
             
             <th>USER NAME</th>
             <th>NAME</th>
             <th>ADDRESS</th>
             <th>MOBILE NO.</th>
             <th>EMAIL ID</th>
             <th>DEPARTMENT NAME</th>
             <th>DATE OF BIRTH</th>
             <th>DATE OF JOINING</th>
             <th>PHOTO</th>
             <th>EDIT EMPLOYEE</th>
             <th>DELETE EMPLOYEE</th>
             <th>CHANGE PHOTO</th>
          </tr>
      <%
        String username,emp_id,firstname,lastname,email_id,mobile_no,address,department_name,dob,doj,photo_path;
        while(rs.next())
        {
             username=rs.getString("username"); 
             
             firstname=rs.getString("firstname");
             lastname=rs.getString("lastname");
             String name=firstname+" "+lastname;
             email_id=rs.getString("email_id");
             address=rs.getString("address");
             mobile_no=rs.getString("mobile_no");
             department_name=rs.getString("department_name");
             dob=rs.getString("date_of_birth");
             doj=rs.getString("date_of_joining");
             photo_path=rs.getString("photo");
    
      %>
      <tr style="background-color:whitesmoke ; color:dodgerblue ;font-size: large">
         
          <td><b><%=username%></b></td>
          <td><b><%=name%></b></td>
          <td><b><%=address%></b></td>
          <td><b><%=mobile_no%></b></td>
          <td><b><%=email_id%></b></td>
          <td><b><%=department_name%></b></td>
          <td><b><%=dob%></b></td>
          <td><b><%=doj%></b></td>
          <td><img src="<%=photo_path%>" width="100" height="100" /></td> 
          <td><a href="edit_user.jsp?q=<%=username%>">EDIT</a></td>
          <td><a href="delete_user.jsp?d=<%=username%>" onclick="return go()">DELETE</a></td>
          <td><a href="change_photo.jsp?p=<%=username%>">CHANGE PHOTO</a></td>
      </tr>
      <%
       }       
      %>   
        </table>
        </div>
         </div>
            <%@include file="footer.html" %>
        </div>
        
    </body>
</html>
