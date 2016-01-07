<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <style>
            html, body, #map-canvas 
            {
                width: 95%;
                height: 600px;
                margin: 0px;
                padding: 0px
            }
            #sidebar
            {
                float: right;
                width: 4%;
            }
        </style>
        <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyB2L0USc1JUoPwL_PklKc65POdS3vBfyng&sensor=false"></script>
        <script>    
            var mapOptions;
            var map;
            var zoomi=15;
            var marker_s, marker_d;
            var infowindow;
            var stLatLng,destLatLng;
            var marker;
            var LL,tid;
            var poly,path;
            
            function initialize() 
           {
               alert("Initialize called");
           <%
           double st_lat=0.0,st_lng=0.0,dest_lat=0.0,dest_lng=0.0;
           try
             {
             
             Class.forName("com.mysql.jdbc.Driver");
             Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
             Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
             ResultSet rs=stmt.executeQuery("select * from courier_assignment where courier_id='"+request.getParameter("courier_id")+"'");
            
             rs.next();
             st_lat=Double.parseDouble(rs.getString("source_latitude"));
             st_lng=Double.parseDouble(rs.getString("source_longitude"));
             dest_lat=Double.parseDouble(rs.getString("destination_latitude"));
             dest_lng=Double.parseDouble(rs.getString("destination_longitude"));
             }
           catch(Exception ex)
           {
               ex.printStackTrace();
           }                                                                                     
          %>
            //Inialize map giving initial centre,zoom,mapTypeId and set map on div--map_canvas
            var value="31.634676,74.882813";
            stLatLng  = new google.maps.LatLng(<%=st_lat%>,<%=st_lng%>);
            destLatLng= new google.maps.LatLng(<%=dest_lat%>,<%=dest_lng%>);
            
            mapOptions = {
		          center: stLatLng,
		          zoom: zoomi,
		          mapTypeId: google.maps.MapTypeId.ROADMAP //mapid can be ROADMAP, SATELLITE, HYBRID, Terrain-->
			 };

            map = new google.maps.Map(document.getElementById("map-canvas"),mapOptions);

            //InfoWindow showing latitude,longitude coordinates
            infowindow = new google.maps.InfoWindow(
            {
               content: value,
               size: new google.maps.Size(40,40)
            });
            
            //Make Marker for starting point
            marker_s = new google.maps.Marker({
            position: stLatLng,
            map: map, //or use marker.setMap(map);
            animation: google.maps.Animation.DROP,
            title: "Starting Point"});
        
            //Make Marker for destination point
            marker_d = new google.maps.Marker({
            position: destLatLng,
            map: map, //or use marker.setMap(map);
            animation: google.maps.Animation.DROP,
            title: "Destination"});
        
            marker = new google.maps.Marker({
            position: stLatLng,
            map: map, //or use marker.setMap(map);
            animation: google.maps.Animation.DROP,
            title: "Current position"});
        
            var polyOptions = {
                        strokeColor: '#F00000',
                        strokeOpacity: 1.0,
                        strokeWeight: 3
                    };
                    poly = new google.maps.Polyline(polyOptions);
                    poly.setMap(map);
        
           infowindow.open(map,marker_s); //open info window on marker,otherwise invisible
      }
      
      function tracknow()
      {
          alert("tracknow called");
          tid=setInterval(go2,"5000");    
      }

      function go2()
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
               // String var=request.getParameter("q");
                //String array[]=var.split(",");
         xmlhttp.open("GET","./trackemp_liveTracking2?imei="+<%=request.getParameter("imei")%>,true);
        // xmlhttp.open("GET","./trackemp_liveTracking2?imei="+<%=request.getParameter("array[0]")%>,true);
         xmlhttp.onreadystatechange=go3;
         xmlhttp.send();
         }
                
         function go3()
         {
            if(xmlhttp.readyState==4 && xmlhttp.status==200)
             {
                        //get latitude,longitude using string tokenizer
                        var lat_long=xmlhttp.responseText;
                        var LtLg=lat_long.split("#");
         
                        lat=parseFloat(LtLg[0]);
                        longi=parseFloat(LtLg[1]);
                        date=LtLg[2];
                        
                        document.getElementById("txt").value=date;
         
                        LL=new google.maps.LatLng(lat,longi);
                        
                        var st_dist=google.maps.geometry.spherical.computeDistanceBetween(stLatLng,LL);
                        var dest_dist=google.maps.geometry.spherical.computeDistanceBetween(destLatLng,LL);
                        
                        //alert("Distances : "+st_dist+" "+dest_dist);
                        if(parseFloat(st_dist)<30.0)
                        {
                             <% 
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
                                Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                                ResultSet rs1=stmt.executeQuery("select * from courier_assignment where courier_id='"+request.getParameter("course_id")+"'");
                                
                                java.util.Date dt = new java.util.Date(); //Current Date Fetched
                                String dispatchTime = (new java.sql.Timestamp(dt.getTime())).toString();
                                
                                rs1.next();
                               // rs1.updateString("date_of_dispatch",dispatchTime);
                                //rs1.updateRow();
                             %>   
                        }
                        
                        if(parseFloat(dest_dist)<30.0)
                        {
                             <%
                                java.util.Date dt1 = new java.util.Date();
                                String delieveryTime =(new java.sql.Timestamp(dt.getTime())).toString();
                                
                              //  rs1.updateString("date_of_delievery",delieveryTime);
                                //rs1.updateRow();
                             %>
                             marker.setIcon("images11/green_marker.png");
                             clearInterval(tid);
                        }
                        drawOnMap();
                   }
               }
                function drawOnMap()
                {
                    path = poly.getPath();
                    path.push(LL);
    
                    //marker.setMap(null);  //Remove marker from current location
                    marker.setPosition(LL);
                    //alert("marker pos="+marker.getPosition());
                    map.setCentre(marker.getPosition());
                }
            
        </script>
    </head>
    <body onload="initialize()">
        <div id="all">
          <div id="map-canvas" style="float:left;border:solid brown 5px"></div>
          <div id="sidebar">
             <input type="button" value="Start Tracking" onclick="tracknow()"/>
             <input type="text" id="txt" name="txt" value="Current Location"/>
          </div>
        </div>
    </body>
</html>
