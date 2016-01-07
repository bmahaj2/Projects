package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class viewmap_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta name=\"viewport\" content=\"initial-scale=1.0, user-scalable=no\">\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>Simple Polylines</title>\n");
      out.write("        <style>\n");
      out.write("            html, body, #map-canvas {\n");
      out.write("                height: 100%;\n");
      out.write("                margin: 0px;\n");
      out.write("                padding: 0px\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyAB9_E8Oi3YdvKl7qhm0r8PD7-a-6TkbwY&sensor=false\"></script>\n");
      out.write("        ");

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
                        
        
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            function initialize() {\n");
      out.write("                alert(1);\n");
      out.write("                var mapOptions = {\n");
      out.write("                    zoom: 3,\n");
      out.write("                    center: new google.maps.LatLng(0, -180),\n");
      out.write("                    mapTypeId: google.maps.MapTypeId.TERRAIN\n");
      out.write("                };\n");
      out.write("\n");
      out.write("                var map = new google.maps.Map(document.getElementById('map-canvas'),\n");
      out.write("                        mapOptions);\n");
      out.write("\n");
      out.write("                        alert(1);\n");

                        while (rs.next())
                        {
            
      out.write("\n");
      out.write("                var flightPlanCoordinates = [\n");
      out.write("            \n");
      out.write("                    new google.maps.LatLng(");
      out.print(rs.getString("latitude"));
      out.write(',');
      out.write(' ');
      out.print(rs.getString("longitude"));
      out.write(")\n");
      out.write("            \n");
      out.write("                ];\n");
      out.write("                var flightPath = new google.maps.Polyline({\n");
      out.write("                    path: flightPlanCoordinates,\n");
      out.write("                    geodesic: true,\n");
      out.write("                    strokeColor: '#FF0000',\n");
      out.write("                    strokeOpacity: 1.0,\n");
      out.write("                    strokeWeight: 2\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                flightPath.setMap(map);\n");
      out.write("                ");

                        }
            
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"initialize()\">\n");
      out.write("\n");
      out.write("        <div id=\"map-canvas\"></div>\n");
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
