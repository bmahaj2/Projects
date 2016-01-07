

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
            <script type="text/javascript">
            var xmlhttp;
            function go()
            {
                try
                {
                    xmlhttp=new ActiveXObject("Msxml2.XMLHTTP"); //Old Microsoft Browsers
                }
                catch(e)
                {
                    try
                    {
                        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); //For new Internet Explorer IE 6.0 
                    }
                    catch(e1)
                    {
                        xmlhttp=new XMLHttpRequest(); //For mozilla,Opera Browsers
                    }
                }
                
                var text=document.getElementById("username").value;
                xmlhttp.open("GET","./allot?q="+text,true);
                
                xmlhttp.onreadystatechange=go2;
                xmlhttp.send();
            }
            
            function go2()
            {
                
                    if(xmlhttp.readyState==4 && xmlhttp.status==200)
                    {
                        document.getElementById("dpt").innerHTML=xmlhttp.responseText;
                    }
            }
            
            
        </script>
        
        
    </head>
    
    <body>
        <%
         Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded successfully");
        Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
        System.out.println("connection build");
        Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        System.out.println("statemt");
       
           ResultSet rs=stmt.executeQuery("select imei from gps.devices where imei not in (select imei from gps.device_allotment where releasedate is null)");
           %>
           <form action="allotjsp2.jsp" method="POST">
               <table border="1">
           <td>department_name</td>
                    <td>
                        <select name="deptn" id="deptn">
                            <option value="Marketing">Marketing</option>
                            <option value="Sales">Sales</option>
                            <option value="Production">Production</option>
                            <option value="Purchase">Purchase</option>
                        </select>
                    </td>
                </tr>
                           <%
                           ResultSet rs1=stmt.executeQuery("select * from signup");
                           %>
                             
                           <tr>
                               <td>EMPLOYEE</td>
                               <td>
                      
                                   <select name="username" id="username" onchange="go()">
                           <%
                           while(rs1.next())
                           {
                               String username=rs1.getString("username");
                               String firstname=rs1.getString("firstname");
                               %>
                               <option value="<%=username%>"><%=firstname%></option>
                                   <%
                               
                           }
                           %>
                   </select>
                               </td>
                           </tr>
                            <tr>
                        <td></td>
                        <td><input type="submit" value="add"</td>
                    </tr>
           </table>
                   <div id="dpt">
                       
                   </div> 
           </form>
                   
                          
                   
          
        
        
       
                
    </body>
</html>
