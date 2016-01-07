package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class employee_005ftrack3_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/header.html");
    _jspx_dependants.add("/menu_afterlogin.html");
    _jspx_dependants.add("/footer.html");
  }

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
      out.write("         <link type=\"text/css\" rel=\"stylesheet\" href=\"two.css\">\n");
      out.write("        <title>Complex Polylines</title>\n");
      out.write("        <style>\n");
      out.write("            html, body, #map-canvas {\n");
      out.write("                height: 100%;\n");
      out.write("                margin: 0px;\n");
      out.write("                padding: 0px\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyAB9_E8Oi3YdvKl7qhm0r8PD7-a-6TkbwY&sensor=false\"></script>\n");
      out.write("        <script>\n");
      out.write("                    var poly;\n");
      out.write("            var map;\n");
      out.write("            var a;\n");
      out.write("            var id;\n");
      out.write("            var j = -1;\n");
      out.write("            function initialize() {\n");
      out.write("                var mapOptions = {\n");
      out.write("                    zoom: 8,\n");
      out.write("                    center: new google.maps.LatLng(30.8000, 75.1700)\n");
      out.write("                };\n");
      out.write("\n");
      out.write("                map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);\n");
      out.write("                var polyOptions = {\n");
      out.write("                    strokeColor: '#000000',\n");
      out.write("                    strokeOpacity: 1.0,\n");
      out.write("                    strokeWeight: 3\n");
      out.write("                };\n");
      out.write("                poly = new google.maps.Polyline(polyOptions);\n");
      out.write("                poly.setMap(map);\n");
      out.write("                addLatLng();\n");
      out.write("                id = setInterval(addpath, \"400\");\n");
      out.write("            }\n");
      out.write("            function addLatLng() {\n");
      out.write("\n");
      out.write("                a = new Array();\n");
      out.write("                var i = 0;\n");
      out.write("            ");

                try {
                     String date = request.getParameter("date");
                        String starttime = request.getParameter("starttime");
                        String endtime = request.getParameter("lasttime");
                        String imei = request.getParameter("IMEI");
                   
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "SYSTEM");
                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("select * from gps.track_emphistory where IMEI='" + imei + "' and date between '" + date + " " + starttime + "' and '" + date + " " + endtime + "'");

                    double longitude, latitude;
                    while (rs.next()) {
                        latitude = Double.parseDouble(rs.getString("latitude"));
                        longitude = Double.parseDouble(rs.getString("longitude"));
            
      out.write("\n");
      out.write("                a[i] = new google.maps.LatLng(");
      out.print(latitude);
      out.write(',');
      out.print(longitude);
      out.write(");\n");
      out.write("                i++;\n");
      out.write("            ");

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            
      out.write("\n");
      out.write("            }\n");
      out.write("            function addpath()\n");
      out.write("            {\n");
      out.write("                j++;\n");
      out.write("                if (j === (a.length))\n");
      out.write("                {\n");
      out.write("                    clearInterval(id);\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    go(j);\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            var path;\n");
      out.write("            function go(j)\n");
      out.write("            {\n");
      out.write("                path = poly.getPath();\n");
      out.write("                path.push(a[j]);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            google.maps.event.addDomListener(window, 'load', initialize);\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"initialize()\">\n");
      out.write("         <div id=\"all\">\n");
      out.write("            ");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>header</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<!-- Save for Web Slices (header.psd) -->\r\n");
      out.write("<img src=\"images/header.png\" width=\"980\" height=\"250\" alt=\"\">\r\n");
      out.write("<!-- End Save for Web Slices -->\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\n");
      out.write("            ");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />\n");
      out.write("\t<meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1' />\n");
      out.write("\t<link rel='stylesheet' type='text/css' href='styles.css' />\n");
      out.write("\t<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script>\n");
      out.write("\t<script type='text/javascript' src='menu_jquery.js'></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div id='cssmenu'>\n");
      out.write("     \n");
      out.write("<ul>\n");
      out.write("         <li><a href='#'><span>Home</span></a></li>\n");
      out.write("\n");
      out.write("   <li class='has-sub'><a href='index.html'><span>Employee</span></a>\n");
      out.write("      <ul>\n");
      out.write("         <li><a href='signup.jsp'><span>Add Employee</span></a></li>\n");
      out.write("       \n");
      out.write("         <li class='last'><a href='view_user.jsp'><span>View Employee</span></a></li>\n");
      out.write("      </ul>\n");
      out.write("   </li>\n");
      out.write("   <li class='has-sub'><a href='#'><span>Devices</span></a>\n");
      out.write("      <ul>\n");
      out.write("         <li><a href='add_device.jsp'><span>Add Device</span></a></li>\n");
      out.write("         <li><a href='allotjsp.jsp'><span>Allot Device</span></a></li>\n");
      out.write("         <li class='last'><a href='view_alloteddevices.jsp'><span>View Allotted Devices</span></a></li>\n");
      out.write("      </ul>\n");
      out.write("   </li>\n");
      out.write("   <li><a href='message_to_emp.jsp'><span>Send Message</span></a></li>\n");
      out.write("   <li class='has-sub'><a href='#'><span>Employee Tracking</span></a>\n");
      out.write("      <ul>\n");
      out.write("         <li class='last'><a href='tracking_viewemployee.jsp'><span>View and Track Employee</span></a></li>\n");
      out.write("      </ul>\n");
      out.write("   </li>\n");
      out.write("   <li class='has-sub last'><a href='#'><span>Courier Tracking</span></a>\n");
      out.write("      <ul>\n");
      out.write("         <li><a href='CourierAssignment.jsp'><span>Assign Courier</span></a></li>\n");
      out.write("         <li class='last'><a href='view_courier_assignment.jsp'><span>View And Track Courier</span></a></li>\n");
      out.write("      </ul>\n");
      out.write("   </li>\n");
      out.write("      <li><a href='admin_login.jsp'><span>Logout</span></a></li>\n");
      out.write("\n");
      out.write("</ul>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write(" \n");
      out.write("            <div id=\"main\">\n");
      out.write("        <div id=\"map-canvas\"></div>\n");
      out.write("         </div>\n");
      out.write("        \n");
      out.write("          ");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>3698</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<!-- Save for Web Slices (3698.psd) -->\r\n");
      out.write("<img src=\"images/footer.png\" width=\"980\" height=\"52\" alt=\"\">\r\n");
      out.write("<!-- End Save for Web Slices -->\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\n");
      out.write("          </div>\n");
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
