package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("      \r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("      html\r\n");
      out.write("      {\r\n");
      out.write("\theight: 100%\r\n");
      out.write("      }\r\n");
      out.write("      body\r\n");
      out.write("      {\r\n");
      out.write("\theight: 90%;\r\n");
      out.write("\twidth: 90%;\r\n");
      out.write("\tmargin: 20px;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("      }\r\n");
      out.write("      #map_canvas\r\n");
      out.write("      {\r\n");
      out.write("\theight: 70%;\r\n");
      out.write("\twidth: 70%;\r\n");
      out.write("\tborder: 3px solid #000;\r\n");
      out.write("      }\r\n");
      out.write("    </style>\r\n");
      out.write("    <script type=\"text/javascript\" \r\n");
      out.write("            src=\"http://maps.googleapis.com/maps/api/js?key=AIzaSyCJwgqN_3NBJ3thYxeNMBRSM-EW5VJPB8o&libraries=places&sensor=false&region=IN\">\r\n");
      out.write("                \r\n");
      out.write("    </script>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("      var mapOptions;\r\n");
      out.write("      var map;\r\n");
      out.write("      var zoomi=15;\r\n");
      out.write("      var marker, marker1;\r\n");
      out.write("      var service;\r\n");
      out.write("      var autocomplete;\r\n");
      out.write("      var infowindow;\r\n");
      out.write("      var t1;\r\n");
      out.write("      var poly;\r\n");
      out.write("\r\n");
      out.write("      function initialize() \r\n");
      out.write("      {\r\n");
      out.write("\t\r\n");
      out.write("            var value=\"31.634676,74.882813\";\r\n");
      out.write("            mapOptions = {\r\n");
      out.write("\t\t          center: new google.maps.LatLng(31.634676,74.882813),\r\n");
      out.write("\t\t          zoom: zoomi,\r\n");
      out.write("\t\t          mapTypeId: google.maps.MapTypeId.ROADMAP //mapid can be ROADMAP, SATELLITE, HYBRID, Terrain-->\r\n");
      out.write("\t\t\t };\r\n");
      out.write(" //                var map = new google.maps.Map(document.getElementById(\"map_canvas\"),mapOptions);\r\n");
      out.write("       \r\n");
      out.write("        \r\n");
      out.write("        //31.635913,74.873277location of vmm education..\r\n");
      out.write("        map = new google.maps.Map(document.getElementById(\"map_canvas\"),mapOptions);\r\n");
      out.write("\r\n");
      out.write("            marker = new google.maps.Marker({\r\n");
      out.write("            position: map.getCenter(),\r\n");
      out.write("            map: map, //or use marker.setMap(map);\r\n");
      out.write("            animation: google.maps.Animation.DROP,\r\n");
      out.write("            title: \"aaaaa\"  }); \r\n");
      out.write("        \r\n");
      out.write("        infowindow = new google.maps.InfoWindow(\r\n");
      out.write("        {\r\n");
      out.write("            content: value,\r\n");
      out.write("            size: new google.maps.Size(40,40)\r\n");
      out.write("        });\r\n");
      out.write("        \r\n");
      out.write("        infowindow.open(map,marker);\r\n");
      out.write("        var defaultBounds = new google.maps.LatLngBounds(\r\n");
      out.write("            new google.maps.LatLng(31.619931,74.876844),\r\n");
      out.write("            new google.maps.LatLng(31.638183,74.977341));\r\n");
      out.write("\r\n");
      out.write("        var input = document.getElementById(\"Autocomplete\");\r\n");
      out.write("        var options = {\r\n");
      out.write("            bounds: defaultBounds,\r\n");
      out.write("            types: ['establishment'],\r\n");
      out.write("            componentRestrictions: {country: 'in'}\r\n");
      out.write("\r\n");
      out.write("            };\r\n");
      out.write("\r\n");
      out.write("        autocomplete = new google.maps.places.Autocomplete(input, options);\r\n");
      out.write("      }\r\n");
      out.write("      \r\n");
      out.write("      function mark()\r\n");
      out.write("      {\r\n");
      out.write("          var place= autocomplete.getPlace();\r\n");
      out.write("          alert(place.name);\r\n");
      out.write("          //.fitBounds(place.geometry.viewport);\r\n");
      out.write("          map.setCenter(place.geometry.location);\r\n");
      out.write("          alert(place.geometry.location);\r\n");
      out.write("          marker.setPosition(place.geometry.location);\r\n");
      out.write("          infowindow.setContent(place.name+\"<br>\"+place.formatted_address);\r\n");
      out.write("          infowindow.open(map, marker);\r\n");
      out.write("      }\r\n");
      out.write("      \r\n");
      out.write("    </script>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body onload=\"initialize()\">\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"map_canvas\" style=\"width:50%; height:70%;\">\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <label name=\"label\"><b>Auto complete Search </b></label>\r\n");
      out.write("        <input type=\"text\" id=\"Autocomplete\" size=\"70\"/>\r\n");
      out.write("        <input type=\"button\" value=\" Mark Location on map\" onclick=\"mark()\"/>\r\n");
      out.write("\r\n");
      out.write("  </body>\r\n");
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
