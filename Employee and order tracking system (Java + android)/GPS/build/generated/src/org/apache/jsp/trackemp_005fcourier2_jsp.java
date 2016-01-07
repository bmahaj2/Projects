package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class trackemp_005fcourier2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title></title>\n");
      out.write("        <style>\n");
      out.write("            html, body, #map-canvas \n");
      out.write("            {\n");
      out.write("                width: 95%;\n");
      out.write("                height: 600px;\n");
      out.write("                margin: 0px;\n");
      out.write("                padding: 0px\n");
      out.write("            }\n");
      out.write("            #sidebar\n");
      out.write("            {\n");
      out.write("                float: right;\n");
      out.write("                width: 4%;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script src=\"https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyB2L0USc1JUoPwL_PklKc65POdS3vBfyng&sensor=false\"></script>\n");
      out.write("        <script>    \n");
      out.write("            var mapOptions;\n");
      out.write("            var map;\n");
      out.write("            var zoomi=15;\n");
      out.write("            var marker_s, marker_d;\n");
      out.write("            var infowindow;\n");
      out.write("            var stLatLng,destLatLng;\n");
      out.write("            var marker;\n");
      out.write("            var LL,tid;\n");
      out.write("            var poly,path;\n");
      out.write("            \n");
      out.write("            function initialize() \n");
      out.write("           {\n");
      out.write("               alert(\"Initialize called\");\n");
      out.write("           ");

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
          
      out.write("\n");
      out.write("            //Inialize map giving initial centre,zoom,mapTypeId and set map on div--map_canvas\n");
      out.write("            var value=\"31.634676,74.882813\";\n");
      out.write("            stLatLng  = new google.maps.LatLng(");
      out.print(st_lat);
      out.write(',');
      out.print(st_lng);
      out.write(");\n");
      out.write("            destLatLng= new google.maps.LatLng(");
      out.print(dest_lat);
      out.write(',');
      out.print(dest_lng);
      out.write(");\n");
      out.write("            \n");
      out.write("            mapOptions = {\n");
      out.write("\t\t          center: stLatLng,\n");
      out.write("\t\t          zoom: zoomi,\n");
      out.write("\t\t          mapTypeId: google.maps.MapTypeId.ROADMAP //mapid can be ROADMAP, SATELLITE, HYBRID, Terrain-->\n");
      out.write("\t\t\t };\n");
      out.write("\n");
      out.write("            map = new google.maps.Map(document.getElementById(\"map-canvas\"),mapOptions);\n");
      out.write("\n");
      out.write("            //InfoWindow showing latitude,longitude coordinates\n");
      out.write("            infowindow = new google.maps.InfoWindow(\n");
      out.write("            {\n");
      out.write("               content: value,\n");
      out.write("               size: new google.maps.Size(40,40)\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            //Make Marker for starting point\n");
      out.write("            marker_s = new google.maps.Marker({\n");
      out.write("            position: stLatLng,\n");
      out.write("            map: map, //or use marker.setMap(map);\n");
      out.write("            animation: google.maps.Animation.DROP,\n");
      out.write("            title: \"Starting Point\"});\n");
      out.write("        \n");
      out.write("            //Make Marker for destination point\n");
      out.write("            marker_d = new google.maps.Marker({\n");
      out.write("            position: destLatLng,\n");
      out.write("            map: map, //or use marker.setMap(map);\n");
      out.write("            animation: google.maps.Animation.DROP,\n");
      out.write("            title: \"Destination\"});\n");
      out.write("        \n");
      out.write("            marker = new google.maps.Marker({\n");
      out.write("            position: stLatLng,\n");
      out.write("            map: map, //or use marker.setMap(map);\n");
      out.write("            animation: google.maps.Animation.DROP,\n");
      out.write("            title: \"Current position\"});\n");
      out.write("        \n");
      out.write("            var polyOptions = {\n");
      out.write("                        strokeColor: '#F00000',\n");
      out.write("                        strokeOpacity: 1.0,\n");
      out.write("                        strokeWeight: 3\n");
      out.write("                    };\n");
      out.write("                    poly = new google.maps.Polyline(polyOptions);\n");
      out.write("                    poly.setMap(map);\n");
      out.write("        \n");
      out.write("           infowindow.open(map,marker_s); //open info window on marker,otherwise invisible\n");
      out.write("      }\n");
      out.write("      \n");
      out.write("      function tracknow()\n");
      out.write("      {\n");
      out.write("          alert(\"tracknow called\");\n");
      out.write("          tid=setInterval(go2,\"5000\");    \n");
      out.write("      }\n");
      out.write("\n");
      out.write("      function go2()\n");
      out.write("     {\n");
      out.write("        try\n");
      out.write("         {\n");
      out.write("              xmlhttp=new ActiveXObject(\"Msxml2.XMLHTTP\"); //Old Microsoft Browsers\n");
      out.write("         }\n");
      out.write("         catch(e)\n");
      out.write("         {\n");
      out.write("              try\n");
      out.write("              {\n");
      out.write("                    xmlhttp=new ActiveXObject(\"Microsoft.XMLHTTP\"); //For new Internet Explorer IE 6.0 \n");
      out.write("              }\n");
      out.write("              catch(e1)\n");
      out.write("              {\n");
      out.write("                    xmlhttp=new XMLHttpRequest(); //For mozilla,Opera Browsers\n");
      out.write("              }\n");
      out.write("         }\n");
      out.write("               // String var=request.getParameter(\"q\");\n");
      out.write("                //String array[]=var.split(\",\");\n");
      out.write("         xmlhttp.open(\"GET\",\"./trackemp_liveTracking2?imei=\"+");
      out.print(request.getParameter("imei"));
      out.write(",true);\n");
      out.write("        // xmlhttp.open(\"GET\",\"./trackemp_liveTracking2?imei=\"+");
      out.print(request.getParameter("array[0]"));
      out.write(",true);\n");
      out.write("         xmlhttp.onreadystatechange=go3;\n");
      out.write("         xmlhttp.send();\n");
      out.write("         }\n");
      out.write("                \n");
      out.write("         function go3()\n");
      out.write("         {\n");
      out.write("            if(xmlhttp.readyState==4 && xmlhttp.status==200)\n");
      out.write("             {\n");
      out.write("                        //get latitude,longitude using string tokenizer\n");
      out.write("                        var lat_long=xmlhttp.responseText;\n");
      out.write("                        var LtLg=lat_long.split(\"#\");\n");
      out.write("         \n");
      out.write("                        lat=parseFloat(LtLg[0]);\n");
      out.write("                        longi=parseFloat(LtLg[1]);\n");
      out.write("                        date=LtLg[2];\n");
      out.write("                        \n");
      out.write("                        document.getElementById(\"txt\").value=date;\n");
      out.write("         \n");
      out.write("                        LL=new google.maps.LatLng(lat,longi);\n");
      out.write("                        \n");
      out.write("                        var st_dist=google.maps.geometry.spherical.computeDistanceBetween(stLatLng,LL);\n");
      out.write("                        var dest_dist=google.maps.geometry.spherical.computeDistanceBetween(destLatLng,LL);\n");
      out.write("                        \n");
      out.write("                        //alert(\"Distances : \"+st_dist+\" \"+dest_dist);\n");
      out.write("                        if(parseFloat(st_dist)<30.0)\n");
      out.write("                        {\n");
      out.write("                             ");
 
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
                                Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                                ResultSet rs1=stmt.executeQuery("select * from courier_assignment where courier_id='"+request.getParameter("course_id")+"'");
                                
                                java.util.Date dt = new java.util.Date(); //Current Date Fetched
                                String dispatchTime = (new java.sql.Timestamp(dt.getTime())).toString();
                                
                                rs1.next();
                               // rs1.updateString("date_of_dispatch",dispatchTime);
                                //rs1.updateRow();
                             
      out.write("   \n");
      out.write("                        }\n");
      out.write("                        \n");
      out.write("                        if(parseFloat(dest_dist)<30.0)\n");
      out.write("                        {\n");
      out.write("                             ");

                                java.util.Date dt1 = new java.util.Date();
                                String delieveryTime =(new java.sql.Timestamp(dt.getTime())).toString();
                                
                              //  rs1.updateString("date_of_delievery",delieveryTime);
                                //rs1.updateRow();
                             
      out.write("\n");
      out.write("                             marker.setIcon(\"images11/green_marker.png\");\n");
      out.write("                             clearInterval(tid);\n");
      out.write("                        }\n");
      out.write("                        drawOnMap();\n");
      out.write("                   }\n");
      out.write("               }\n");
      out.write("                function drawOnMap()\n");
      out.write("                {\n");
      out.write("                    path = poly.getPath();\n");
      out.write("                    path.push(LL);\n");
      out.write("    \n");
      out.write("                    //marker.setMap(null);  //Remove marker from current location\n");
      out.write("                    marker.setPosition(LL);\n");
      out.write("                    //alert(\"marker pos=\"+marker.getPosition());\n");
      out.write("                    map.setCentre(marker.getPosition());\n");
      out.write("                }\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"initialize()\">\n");
      out.write("        <div id=\"all\">\n");
      out.write("          <div id=\"map-canvas\" style=\"float:left;border:solid brown 5px\"></div>\n");
      out.write("          <div id=\"sidebar\">\n");
      out.write("             <input type=\"button\" value=\"Start Tracking\" onclick=\"tracknow()\"/>\n");
      out.write("             <input type=\"text\" id=\"txt\" name=\"txt\" value=\"Current Location\"/>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
