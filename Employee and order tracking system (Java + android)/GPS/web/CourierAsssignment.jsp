
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="two.css">

        <title>Courier Assignment</title>

        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyBbp_1vI2a4mnbrS6D6F5QqWlXMt3YZSiA&sensor=false&libraries=places&sensor=false&region=IN"></script>

        <script src="CourierAssignmentMapAC.js">
        </script>

        <script type="text/javascript">

            var xmlhttp;
            function go()
            {
                try
                {
                    xmlhttp = new ActiveXObject("Msxml2.XMLHTTP"); //Old Microsoft Browsers
                }
                catch (e)
                {
                    try
                    {
                        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); //For new Internet Explorer IE 6.0 
                    }
                    catch (e1)
                    {
                        xmlhttp = new XMLHttpRequest(); //For mozilla,Opera Browsers
                    }
                }

                var username = document.getElementById("username").value;
                xmlhttp.open("GET", "CourierAssignment2_getImei.jsp?username=" + username, true);

                xmlhttp.onreadystatechange = go2;
                xmlhttp.send();
            }

            function go2()
            {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                {
                    document.getElementById("devid").innerHTML = xmlhttp.responseText;
                }
            }

        </script>
    </head>
    <body onload="initialize()" style="background-color: whitesmoke">

        <div id="all">
            <%@include file="header.html" %>
            <%@include file="menu_afterlogin.html" %> 
            <div id="main" style="height: 800px;">
                <!--                <div style="height:100%;width:50%;float:left;">-->
                                         <div id="map_canvas" style="height:350px; width:300px;border: solid gold 5px; float:right; position: relative;top: 100px; left: -5px;"><table border="10"><tr><td>Here Map is loaded</td></tr></table>sk<br>ddd<br>dff<br></div>

                    <div style="border-radius: 10px;border:solid 3px saddlebrown;background: white; width:600px; box-shadow: 15px 15px #888888;">
                     
                            <form action="CourierAssignment3.jsp" method="get">
                                <!--                        <table border="3" style="background-color:lightgray" class="tablestyle" cellspacing="5">-->
                                <table border="0" class="tablestyle" cellspacing="5">
                                    <tr>
                                        <td>Title</td>
                                        <td><input type="text" id="title" name="title" required placeholder="Add Title" class="tfield"/></td>
                                    </tr>

                                    <tr>
                                        <td>Description</td>
                                        <td><textarea rows="8" cols="65" id="desc" name="desc" required placeholder="Enter Details" class="tarea2"  ></textarea></td>
                                    </tr>

                                    <tr>
                                        <td>Employee</td>
                                        <td><select id="username" name="username" required onchange="go()" class="tfield">
                                                <option>--Select Employee--</option>
                                                <%
                                                    try {
                                                        Class.forName("com.mysql.jdbc.Driver");
                                                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps", "root", "SYSTEM");
                                                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                                        ResultSet rs = stmt.executeQuery("select * from signup");

                                                        while (rs.next()) {
                                                %>
                                                <option value="<%=rs.getString("username")%>"><%=rs.getString("firstname")%> <%=rs.getString("lastname")%></option>
                                                <%
                                                        }
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }
                                                %>
                                            </select></td>
                                    </tr>

                                    <tr>
                                        <td>Device Id</td>
                                        <td><div id="devid" required name="devid"></div></td>
                                    </tr>

                                    <tr>
                                        <td>Starting point</td>
                                        <td>
                                            <input id="start_pt" name="start_pt" rowspan="4" required placeholder="Enter Location" size="50" class="tfield"/>
                                            <input type="button" name="sbt" id="sbt" value="Mark Location On Map" onclick="mark_s()" class="submitsyle"/>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>Source Latitude</td>
                                        <td><input type="text" id="st_lat" name="lat" class="tfield"/></td>
                                    </tr>

                                    <tr>
                                        <td>Source Longitude</td>
                                        <td><input type="text" id="st_lon" name="longi" class="tfield"/></td>
                                    </tr>

                                    <tr>
                                        <td>Destination</td>
                                        <td>
                                            <input id="dest_pt" name="dest_pt" required placeholder="Enter Location" size="50" class="tfield"/>
                                            <input type="button" name="dbt" id="dbt" value="Mark Location On Map" onclick="mark_d()" class="submitsyle"/>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>Destination Latitude</td>
                                        <td><input type="text" id="dest_lat" name="dest_lat" class="tfield"/></td>
                                    </tr>

                                    <tr>
                                        <td>Destination Longitude</td>
                                        <td><input type="text" id="dest_lon" name="dest_longi" class="tfield"/></td>
                                    </tr>

                                    <tr>
                                        <td>Status</td>
                                        <td><input type="text" class="tfield"/></td>
                                    </tr>

                                    <tr>
                                        <td></td>
                                        <td><input type="submit" value="ASSIGN ORDER" class="submitsyle"/></td>
                                    </tr>
                                </table>
                            </form>
                                            
                            <%
                                String msg = request.getParameter("msg");
                                if (msg != null) {
                            %>
                            <label style="color:red"><%=msg%>
                            </label>
                            <%
                                }
                            %>
                            </div>       

                  

<!--                    </div>-->
               
            </div>

            <%@include file="footer.html" %>
        </div>
    </body>
</html>
