<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
        <meta charset="utf-8">
        <title>Simple markers</title>
        <style>
            html, body, #map-canvas {
                height: 100%;
                margin: 0px;
                padding: 0px
            }
        </style>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAB9_E8Oi3YdvKl7qhm0r8PD7-a-6TkbwY&sensor=false"></script>
        <script>
            function initialize() {
            <%
                    try {
                        String imei = request.getParameter("p");

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps", "root", "SYSTEM");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from gps.track_emphistory where IMEI='" + imei + "' order by date desc");

                        double longitude, latitude;
                        if (rs.next()) {
                            latitude = Double.parseDouble(rs.getString("latitude"));
                            longitude = Double.parseDouble(rs.getString("longitude"));
            %>

                var myLatlng = new google.maps.LatLng(<%=latitude%>,<%=longitude%>);
                var mapOptions = {
                    zoom: 12,
                    center: myLatlng
                };
                var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
                
                var marker = new google.maps.Marker({
                    position: myLatlng,
                    map: map,
                    title: 'Hello World!'
                });
            <%
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            %>

    }
            google.maps.event.addDomListener(window, 'load', initialize);

        </script>
    </head>
    <body>
        <div id="map-canvas"></div>
    </body>
</html>