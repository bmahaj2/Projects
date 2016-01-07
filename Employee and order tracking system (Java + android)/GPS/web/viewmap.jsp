<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
        <meta charset="utf-8">
        <title>Simple Polylines</title>
        <style>
            html, body, #map-canvas {
                height: 100%;
                margin: 0px;
                padding: 0px
            }
        </style>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAB9_E8Oi3YdvKl7qhm0r8PD7-a-6TkbwY&sensor=false"></script>
        <%
            String date = request.getParameter("date");
                        String starttime = request.getParameter("starttime");
                        String endtime = request.getParameter("lasttime");
                        String imei = request.getParameter("IMEI");
                        Class.forName("com.mysql.jdbc.Driver");
                        System.out.println(imei);
                        System.out.println("Driver loaded successfully");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps", "root", "SYSTEM");
                        System.out.println("connection build");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        System.out.println("statemt");
                        // ResultSet rs=stmt.executeQuery("select * from track_emphistory where date between '"+date +" "+starttime+"' and '"+date +"'"+endtime+"'");
                        ResultSet rs = stmt.executeQuery("select * from gps.track_emphistory where IMEI='" + imei + "' and date between '" + date + " " + starttime + "' and '" + date + " " + endtime + "'");
                        
        %>
        <script type="text/javascript">
            
            
            function initialize() {
                alert(1);
                var mapOptions = {
                    zoom: 3,
                    center: new google.maps.LatLng(0, -180),
                    mapTypeId: google.maps.MapTypeId.TERRAIN
                };

                var map = new google.maps.Map(document.getElementById('map-canvas'),
                        mapOptions);

                        alert(1);
<%
                        while (rs.next())
                        {
            %>
                var flightPlanCoordinates = [
            
                    new google.maps.LatLng(<%=rs.getString("latitude")%>, <%=rs.getString("longitude")%>)
            
                ];
                var flightPath = new google.maps.Polyline({
                    path: flightPlanCoordinates,
                    geodesic: true,
                    strokeColor: '#FF0000',
                    strokeOpacity: 1.0,
                    strokeWeight: 2
                });

                flightPath.setMap(map);
                <%
                        }
            %>
            }

            
        </script>
    </head>
    <body onload="initialize()">

        <div id="map-canvas"></div>
    </body>
</html>