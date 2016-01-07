
      var mapOptions;
      var map;
      var zoomi=15;
      var marker_s, marker_d;
      var autocomplete_s,autocomplete_d;
      var infowindow;

      function initialize() 
      {
            //Inialize map giving initial centre,zoom,mapTypeId and set map on div--map_canvas
            var value="31.634676,74.882813";
            mapOptions = {
		          center: new google.maps.LatLng(31.634676,74.882813),
		          zoom: zoomi,
		          mapTypeId: google.maps.MapTypeId.ROADMAP //mapid can be ROADMAP, SATELLITE, HYBRID, Terrain-->
			 };

            map = new google.maps.Map(document.getElementById("map_canvas"),mapOptions);

            //Make Marker for starting point
            marker_s = new google.maps.Marker({
            position: map.getCenter(),
            map: map, //or use marker.setMap(map);
            animation: google.maps.Animation.DROP,
            title: "Starting Point"});
        
            //Make Marker for destination point
            marker_d = new google.maps.Marker({
            position: map.getCenter(),
            map: map, //or use marker.setMap(map);
            animation: google.maps.Animation.DROP,
            title: "Destination"});
        
            //InfoWindow showing latitude,longitude coordinates
            infowindow = new google.maps.InfoWindow(
            {
               content: value,
               size: new google.maps.Size(40,40)
            });
        
           infowindow.open(map,marker_s); //open info window on marker,otherwise invisible
           
           //Autocomplete
           var defaultBounds = new google.maps.LatLngBounds(
            new google.maps.LatLng(31.619931,74.876844),
            new google.maps.LatLng(31.638183,74.977341));
           
           var start = document.getElementById("start_pt"); //Autocomplete textbox
           var dest = document.getElementById("dest_pt"); //Autocomplete textbox
           var options = {
            bounds: defaultBounds,
            types: ['establishment'],
            componentRestrictions: {country: 'in'}
            };

          autocomplete_s = new google.maps.places.Autocomplete(start, options);
          autocomplete_d = new google.maps.places.Autocomplete(dest, options);
      }
      
      //Get place from autocomplete and drop a marker there
      function mark_s()
      {
          var place= autocomplete_s.getPlace();
          //.fitBounds(place.geometry.viewport);
          map.setCenter(place.geometry.location);
          //alert(place.geometry.location.lat());
          marker_s.setPosition(place.geometry.location);
          infowindow.setContent(place.name+"<br>"+place.formatted_address);
          infowindow.open(map, marker_s);
          
          //Set Latitude Longitude Value
          document.getElementById("st_lat").value=place.geometry.location.lat();
          document.getElementById("st_lon").value=place.geometry.location.lng();
      }
      
      function mark_d()
      {
          //alert("mark dest called ");
          var place= autocomplete_d.getPlace();
          //alert(place.name);
          //.fitBounds(place.geometry.viewport);
          map.setCenter(place.geometry.location);
          //alert(place.geometry.location);
          marker_d.setPosition(place.geometry.location);
          infowindow.setContent(place.name+"<br>"+place.formatted_address);
          infowindow.open(map, marker_d);
          
          //Set Latitude Longitude Value
          document.getElementById("dest_lat").value=place.geometry.location.lat();
          document.getElementById("dest_lon").value=place.geometry.location.lng();
      }

      