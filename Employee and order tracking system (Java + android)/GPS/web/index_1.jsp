<%-- 
    Document   : index
    Created on : Aug 22, 2012, 3:53:48 PM
    Author     : Parwinder
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
      
    <style type="text/css">
      html
      {
	height: 100%
      }
      body
      {
	height: 90%;
	width: 90%;
	margin: 20px;
	padding: 0;
      }
      #map_canvas
      {
	height: 70%;
	width: 70%;
	border: 3px solid #000;
      }
    </style>
    <script type="text/javascript" 
            src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCJwgqN_3NBJ3thYxeNMBRSM-EW5VJPB8o&libraries=places&sensor=false&region=IN">
                
    </script>
    <script type="text/javascript">
      var mapOptions;
      var map;
      var zoomi=15;
      var marker, marker1;
      var service;
      var autocomplete;
      var infowindow;
      var t1;
      var poly;

      function initialize() 
      {
	
            var value="31.634676,74.882813";
            mapOptions = {
		          center: new google.maps.LatLng(31.634676,74.882813),
		          zoom: zoomi,
		          mapTypeId: google.maps.MapTypeId.ROADMAP //mapid can be ROADMAP, SATELLITE, HYBRID, Terrain-->
			 };
 //                var map = new google.maps.Map(document.getElementById("map_canvas"),mapOptions);
       
        
        //31.635913,74.873277location of vmm education..
        map = new google.maps.Map(document.getElementById("map_canvas"),mapOptions);

            marker = new google.maps.Marker({
            position: map.getCenter(),
            map: map, //or use marker.setMap(map);
            animation: google.maps.Animation.DROP,
            title: "aaaaa"  }); 
        
        infowindow = new google.maps.InfoWindow(
        {
            content: value,
            size: new google.maps.Size(40,40)
        });
        
        infowindow.open(map,marker);
        var defaultBounds = new google.maps.LatLngBounds(
            new google.maps.LatLng(31.619931,74.876844),
            new google.maps.LatLng(31.638183,74.977341));

        var input = document.getElementById("Autocomplete");
        var options = {
            bounds: defaultBounds,
            types: ['establishment'],
            componentRestrictions: {country: 'in'}

            };

        autocomplete = new google.maps.places.Autocomplete(input, options);
      }
      
      function mark()
      {
          var place= autocomplete.getPlace();
          alert(place.name);
          //.fitBounds(place.geometry.viewport);
          map.setCenter(place.geometry.location);
          alert(place.geometry.location);
          marker.setPosition(place.geometry.location);
          infowindow.setContent(place.name+"<br>"+place.formatted_address);
          infowindow.open(map, marker);
      }
      
    </script>
  </head>
  <body onload="initialize()">
	
	

	<div id="map_canvas" style="width:50%; height:70%;">
        </div>
        
        
        <label name="label"><b>Auto complete Search </b></label>
        <input type="text" id="Autocomplete" size="70"/>
        <input type="button" value=" Mark Location on map" onclick="mark()"/>

  </body>
</html>