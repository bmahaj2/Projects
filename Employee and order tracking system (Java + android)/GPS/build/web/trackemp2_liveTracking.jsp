<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Live Tracking</title>
        <style>
            html, body, #map-canvas 
            {
                width: 95%;
                height: 100%;
                margin: 0px;
                padding: 0px
            }
            #sidebar
            {
                float: right;
                width: 4%;
            }
        </style>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB2L0USc1JUoPwL_PklKc65POdS3vBfyng&sensor=false"></script>

        <script>
            var map;
            var xmlhttp;
            function initialize()
            {
                <%
                String imei = "";
                try {
                    //String username = session.getAttribute("username").toString();
                    imei = request.getParameter("p");
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps", "root", "SYSTEM");
                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("select * from track_emphistory where IMEI='" + imei + "' order by date desc");

                    double longitude, latitude;
                    if (rs.next()) {
                        latitude = Double.parseDouble(rs.getString("latitude"));
                        longitude = Double.parseDouble(rs.getString("longitude"));
                        
                        System.out.println(latitude+"  "+longitude);

            %>
//                alert(1);
//            
//                    alert(1);
                    
                    var mapOptions = 
                        {
                        zoom: 8,
                        center: new google.maps.LatLng(<%=latitude%>, <%=longitude%>)
                    };
                    map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
           
                    var LL = new google.maps.LatLng(<%=latitude%>,<%=longitude%>);
                    var marker = new google.maps.Marker({
                        position: LL,
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
                function go()
                {
                    setInterval(go2,"5000");    
                }

                function go2()
                {
                   // alert("go2");
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
                
                    xmlhttp.open("GET","./trackemp_liveTracking?imei="+<%=imei%>,true);
         
                    xmlhttp.onreadystatechange=go3;
                    xmlhttp.send();
                }
                var lat,longi,LL;
                function go3()
                {
                  //  alert("Got Location"+xmlhttp.responseText);
                        
                    if(xmlhttp.readyState==4 && xmlhttp.status==200)
                    {
                      //  alert("Got Location"+xmlhttp.responseText);
                        //get latitude,longitude using string tokenizer
                        var lat_long=xmlhttp.responseText;
                        var LtLg=lat_long.split("#");
         
                        lat=parseFloat(LtLg[0]);
                        longi=parseFloat(LtLg[1]);
                     //   alert(lat+"   "+longi);
                        LL=new google.maps.LatLng(lat,longi);
         
                        drawOnMap();
                    }
                }
                function drawOnMap()
                {
                    path = poly.getPath();
                    path.push(LL);
    
                    //marker.setMap(null);  //Remove marker from current location
                    marker.setPosition(LL);
                    map.setCentre(marker.getPosition());
                }
            
                google.maps.event.addDomListener(window, 'load', initialize);
        </script>
    </head>
    <body>
        <div id="sidebar">
            <input type="button" value="Start Tracking" style="background-color: lightskyblue" onclick="go()"/>
        </div>
        <div id="map-canvas"></div>
        
    </body>
</html>