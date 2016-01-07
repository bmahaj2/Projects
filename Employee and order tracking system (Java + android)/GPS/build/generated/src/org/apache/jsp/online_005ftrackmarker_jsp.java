package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class online_005ftrackmarker_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Simple markers</title>\n");
      out.write("        <style>\n");
      out.write("            html, body, #map-canvas {\n");
      out.write("                height: 100%;\n");
      out.write("                margin: 0px;\n");
      out.write("                padding: 0px\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyAB9_E8Oi3YdvKl7qhm0r8PD7-a-6TkbwY&sensor=false\"></script>\n");
      out.write("        <script>\n");
      out.write("            function initialize() {\n");
      out.write("            ");

                    try {
                        String imei = request.getParameter("p");

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "SYSTEM");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from gps.track_emphistory where IMEI='" + imei + "' order by date desc");

                        double longitude, latitude;
                        if (rs.next()) {
                            latitude = Double.parseDouble(rs.getString("latitude"));
                            longitude = Double.parseDouble(rs.getString("longitude"));
            
      out.write("\n");
      out.write("\n");
      out.write("                var myLatlng = new google.maps.LatLng(");
      out.print(latitude);
      out.write(',');
      out.print(longitude);
      out.write(");\n");
      out.write("                var mapOptions = {\n");
      out.write("                    zoom: 12,\n");
      out.write("                    center: myLatlng\n");
      out.write("                };\n");
      out.write("                var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);\n");
      out.write("                \n");
      out.write("                var marker = new google.maps.Marker({\n");
      out.write("                    position: myLatlng,\n");
      out.write("                    map: map,\n");
      out.write("                    title: 'Hello World!'\n");
      out.write("                });\n");
      out.write("            ");

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            
      out.write("\n");
      out.write("\n");
      out.write("    }\n");
      out.write("            google.maps.event.addDomListener(window, 'load', initialize);\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
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
