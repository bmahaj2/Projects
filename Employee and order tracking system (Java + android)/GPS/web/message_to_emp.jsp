
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link type="text/css" rel="stylesheet" href="two.css">
        <title>Send Message</title>
        <!--ajax to load table dynamically-->
        <script type="text/javascript">
            var xmlhttp;
            function go()
            {
//                document.getElementById("emptable").style.display=block;
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
                
                var dname=document.getElementById("dept").value;
                xmlhttp.open("GET","message_to_emp2_ret_table.jsp?dept="+dname,true);
                
                xmlhttp.onreadystatechange=go2; //Response in go2
                xmlhttp.send();
            }
            
            function go2()
            {
                    if(xmlhttp.readyState==4 && xmlhttp.status==200)
                    {
                        document.getElementById("emptable").innerHTML=xmlhttp.responseText;
                    
                    
                        document.getElementById("emptable").style.display="block";  
                        //alert("OK");
                    }
            }
            
            //on selecting or deselecting select all checkbox
            function selectbox(obj)
            {
                var cball=document.getElementsByName("cb");
                if(obj.checked)
                {
                    for(var i=0;i<cball.length;i++)
                    {
                        cball[i].checked=true;       
                    }
                }
                else
                {
                    for(var i=0;i<cball.length;i++)
                    {
                        cball[i].checked=false;       
                    }
                }
            }
        </script>
    </head>
    <body>
        <center>
        <div id="all">
            <%@include file="header.html" %>
            <%@include file="menu_afterlogin.html" %>
           
            <div id="main">
                <h1 class="heading" style="margin-top: -30px;"><center>Send Message</center></h1>
        <table class="tablestyle" style="padding-top: 30px;">
           <td><span>Select Department</span></td>
           <td>
               <select name="dept" id="dept" onchange="go()" class="tfield">
                <option>--Select Department--</option>
        <%
           //Add departments to compbo box from database
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
           Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
           ResultSet rs=stmt.executeQuery("select * from department");
           
           while(rs.next())
           {
        %>
                <option value="<%=rs.getString("dept_name")%>"><%=rs.getString("dept_name")%></option>
        <%
           }
        %>
          </select>
         </td>
        </table>
        
          <div id="emptable" style="display:none;padding-top:70px;border-radius: 10px;border:solid 3px saddlebrown;background: white; width:600px; box-shadow: 15px 15px#888888;">
            <!--Table of details of employees of selected department(loaded dynamically using ajax)-->
        </div>
           </div>
        
          <%@include file="footer.html" %>
          </div>
 </center>
    </body>
</html>
