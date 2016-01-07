package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class trackemp2_005fliveTracking_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Live Tracking</title>\n");
      out.write("        <style>\n");
      out.write("            html, body, #map-canvas \n");
      out.write("            {\n");
      out.write("                width: 95%;\n");
      out.write("                height: 100%;\n");
      out.write("                margin: 0px;\n");
      out.write("                padding: 0px\n");
      out.write("            }\n");
      out.write("            #sidebar\n");
      out.write("            {\n");
      out.write("                float: right;\n");
      out.write("                width: 4%;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyAB9_E8Oi3YdvKl7qhm0r8PD7-a-6TkbwY&sensor=false\"></script>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            var map;\n");
      out.write("            var xmlhttp;\n");
      out.write("            function initialize()\n");
      out.write("            {\n");
      out.write("                ");

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

            
      out.write("\n");
      out.write("//                alert(1);\n");
      out.write("//            \n");
      out.write("//                    alert(1);\n");
      out.write("                    \n");
      out.write("                    var mapOptions = \n");
      out.write("                        {\n");
      out.write("                        zoom: 8,\n");
      out.write("                        center: new google.maps.LatLng(");
      out.print(latitude);
      out.write(',');
      out.write(' ');
      out.print(longitude);
      out.write(")\n");
      out.write("                    };\n");
      out.write("                    map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);\n");
      out.write("           \n");
      out.write("                    var LL = new google.maps.LatLng(");
      out.print(latitude);
      out.write(',');
      out.print(longitude);
      out.write(");\n");
      out.write("                    var marker = new google.maps.Marker({\n");
      out.write("                        position: LL,\n");
      out.write("                        map: map,\n");
      out.write("                        title: 'Hello World!'\n");
      out.write("                    });\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("            ");

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            
      out.write("\n");
      out.write("                }\n");
      out.write("                function go()\n");
      out.write("                {\n");
      out.write("                    setInterval(go2,\"5000\");    \n");
      out.write("                }\n");
      out.write("\n");
      out.write("                function go2()\n");
      out.write("                {\n");
      out.write("                   // alert(\"go2\");\n");
      out.write("                    try\n");
      out.write("                    {\n");
      out.write("                        xmlhttp=new ActiveXObject(\"Msxml2.XMLHTTP\"); //Old Microsoft Browsers\n");
      out.write("                    }\n");
      out.write("                    catch(e)\n");
      out.write("                    {\n");
      out.write("                        try\n");
      out.write("                        {\n");
      out.write("                            xmlhttp=new ActiveXObject(\"Microsoft.XMLHTTP\"); //For new Internet Explorer IE 6.0 \n");
      out.write("                        }\n");
      out.write("                        catch(e1)\n");
      out.write("                        {\n");
      out.write("                            xmlhttp=new XMLHttpRequest(); //For mozilla,Opera Browsers\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                \n");
      out.write("                    xmlhttp.open(\"GET\",\"./trackemp_liveTracking?imei=\"+");
      out.print(imei);
      out.write(",true);\n");
      out.write("         \n");
      out.write("                    xmlhttp.onreadystatechange=go3;\n");
      out.write("                    xmlhttp.send();\n");
      out.write("                }\n");
      out.write("                var lat,longi,LL;\n");
      out.write("                function go3()\n");
      out.write("                {\n");
      out.write("                    alert(\"Got Location\"+xmlhttp.responseText);\n");
      out.write("                        \n");
      out.write("                    if(xmlhttp.readyState==4 && xmlhttp.status==200)\n");
      out.write("                    {\n");
      out.write("                      //  alert(\"Got Location\"+xmlhttp.responseText);\n");
      out.write("                        //get latitude,longitude using string tokenizer\n");
      out.write("                        var lat_long=xmlhttp.responseText;\n");
      out.write("                        var LtLg=lat_long.split(\"#\");\n");
      out.write("         \n");
      out.write("                        lat=parseFloat(LtLg[0]);\n");
      out.write("                        longi=parseFloat(LtLg[1]);\n");
      out.write("                        alert(lat+\"   \"+longi);\n");
      out.write("                        LL=new google.maps.LatLng(lat,longi);\n");
      out.write("         \n");
      out.write("                        drawOnMap();\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                function drawOnMap()\n");
      out.write("                {\n");
      out.write("                    path = poly.getPath();\n");
      out.write("                    path.push(LL);\n");
      out.write("    \n");
      out.write("                    //marker.setMap(null);  //Remove marker from current location\n");
      out.write("                    marker.setPosition(LL);\n");
      out.write("                    map.setCentre(marker.getPosition());\n");
      out.write("                }\n");
      out.write("            \n");
      out.write("                google.maps.event.addDomListener(window, 'load', initialize);\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"sidebar\">\n");
      out.write("            <input type=\"button\" value=\"Start Tracking\" style=\"background-color: lightskyblue\" onclick=\"go()\"/>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"map-canvas\"></div>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>");
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
