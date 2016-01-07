<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Complex Polylines</title>
        <style>
            html, body, #map-canvas {
                height: 100%;
                margin: 0px;
                padding: 0px
            }
        </style>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB2L0USc1JUoPwL_PklKc65POdS3vBfyng&sensor=false"></script>
        <script>
                    var poly;
            var map;
            var a;
            var id;
            var j = -1;
            function initialize() {
                var mapOptions = {
                    zoom: 8,
                    center: new google.maps.LatLng(30.8000, 75.1700)
                };

                map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
                var polyOptions = {
                    strokeColor: '#000000',
                    strokeOpacity: 1.0,
                    strokeWeight: 3
                };
                poly = new google.maps.Polyline(polyOptions);
                poly.setMap(map);
                addLatLng();
                id = setInterval(addpath, "400");
            }
            function addLatLng() {

                a = new Array();
                var i = 0;
            <%
                try {
                     String date = request.getParameter("date");
                        String starttime = request.getParameter("starttime");
                        String endtime = request.getParameter("lasttime");
                        String imei = request.getParameter("IMEI");
                   
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps", "root", "SYSTEM");
                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("select * from gps.track_emphistory where IMEI='" + imei + "' and date between '" + date + " " + starttime + "' and '" + date + " " + endtime + "'");

                    double longitude, latitude;
                    while (rs.next()) {
                        latitude = Double.parseDouble(rs.getString("latitude"));
                        longitude = Double.parseDouble(rs.getString("longitude"));
            %>
                a[i] = new google.maps.LatLng(<%=latitude%>,<%=longitude%>);
                i++;
            <%
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            %>
            }
            function addpath()
            {
                j++;
                if (j === (a.length))
                {
                    clearInterval(id);
                }
                else
                {
                    go(j);
                }

            }
            var path;
            function go(j)
            {
                path = poly.getPath();
                path.push(a[j]);
            }
            
            google.maps.event.addDomListener(window, 'load', initialize);
        </script>
    </head>
    <body>
        <div id="map-canvas"></div>
    </body>
</html>