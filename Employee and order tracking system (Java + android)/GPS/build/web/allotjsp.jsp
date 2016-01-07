

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="two.css" rel="stylesheet" type="text/css"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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

                var text = document.getElementById("username").value;
                xmlhttp.open("GET", "./allot?q=" + text, true);

                xmlhttp.onreadystatechange = go2;
                xmlhttp.send();
            }

            function go2()
            {
//                alert(xmlhttp.responseText);
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                {

                    document.getElementById("dpt").innerHTML = xmlhttp.responseText;
                }
            }


        </script>


    </head>

    <body>

        <div id="all">
            <%@include file="header.html" %>
            <%@include file="menu_afterlogin.html" %>
            <div id="main">
                <h1 class="heading" style="margin-top: -30px;"><center>Allot Device</center></h1>
                <center>
                    <div style="border-radius: 10px;border:solid 3px saddlebrown;background: white; width:600px; box-shadow: 15px 15px#888888;">
                        <center>
                            <!--                <span  style="margin-top: 50px; position: absolute; class:headingstyle">Allot Device</span>-->
                            <!--<h1 class="headingstyle"> Allot Device</h1>-->

                            <%
                                Class.forName("com.mysql.jdbc.Driver");
                                System.out.println("Driver loaded successfully");
                                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps", "root", "SYSTEM");
                                System.out.println("connection build");
                                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                System.out.println("statemt");

                                ResultSet rs = stmt.executeQuery("select imei from gps.devices where imei not in (select imei from gps.device_allotment where releasedate is null)");
                            %>
                            <form action="allotjsp2.jsp" method="POST">
                                <table border="0" class="tablestyle" style="margin-top: 30px;">
                                    <tr>
                                        <td>IMEI</td>
                                        <td>
                                            <select name="IMEI" class="tfield">
                                                <%
                                                    while (rs.next()) {
                                                        String IMEI = rs.getString("IMEI");
                                                %>
                                                <option value="<%=IMEI%>" ><%=IMEI%></option>
                                                <%

                                                    }

                                                %>
                                            </select>
                                        </td>
                                    </tr>
                                    <%                               ResultSet rs1 = stmt.executeQuery("select * from signup");
                                    %>

                                    <tr>
                                        <td>EMPLOYEE</td>
                                        <td>

                                            <select name="username" id="username" onchange="go()" class="tfield">
                                                <%
                                                    while (rs1.next()) {
                                                        String username = rs1.getString("username");
                                                        String firstname = rs1.getString("firstname");
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
                                        <td>
                                            <input type="submit" value="add" class="submitsyle"</td>
                                    </tr>
                                </table>
                                <div id="dpt">
                                </div> 
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
                        </center>

                    </div>
                </center>
            </div>
            <%@include file="footer.html" %>
        </div>


    </body>
</html>