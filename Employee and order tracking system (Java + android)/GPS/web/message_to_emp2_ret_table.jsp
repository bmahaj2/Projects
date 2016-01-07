
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<form action="message_to_emp3.jsp" method="post">
   <table border="1" style="background-color:lightgray; overflow-y: scroll; " >
       <tr>
           <th>Select All<input type="checkbox" id="cball" name="cball" onclick="selectbox(this)"/></th>
           <th>Username</th>
           <th>Name</th>
           <th>Photo</th>
       </tr>
       <%
         try
         {
             String dept=request.getParameter("dept");
             Class.forName("com.mysql.jdbc.Driver");
             Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
             Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
             
             //Select employees of selected department
             ResultSet rs=stmt.executeQuery("select * from signup where department_name=\'"+dept+"\'");
             
             while(rs.next())
             {
         %>
             
             <tr>
                 <td><input type="checkbox" id="cb" name="cb" value="<%=rs.getString("username")%>"/></td>
                 <td><%=rs.getString("username")%></td>
                 <td><%=rs.getString("firstname")%> <%=rs.getString("lastname")%></td>
                 <td><img src="<%=rs.getString("photo")%>" height="50" width="50" /></td>
             </tr>
    
         <%
             }
           }
         catch(Exception ex)
         {
             ex.printStackTrace();    
         }
        %> 
        <tr>
            <!--Give message here-->
            <td colspan="4">
        <textarea rows="5" cols="40" id="txt" name="txt">
           
        </textarea>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Send" /></td>
        </tr>
   </table>
</form>