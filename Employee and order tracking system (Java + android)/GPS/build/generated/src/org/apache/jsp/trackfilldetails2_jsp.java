package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;

public final class trackfilldetails2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");

            String imei=request.getParameter("IMEI");
            String date = request.getParameter("date");
            String starttime = request.getParameter("starttime");
            String endtime = request.getParameter("lasttime");
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
      out.write("\n");
      out.write("        <form action=\"viewmap.jsp\">\n");
      out.write("            <input type=\"hidden\" name=\"date\" value=\"");
      out.print(date);
      out.write("\">\n");
      out.write("            <input type=\"hidden\" name=\"starttime\" value=\"");
      out.print(starttime);
      out.write("\">\n");
      out.write("            <input type=\"hidden\" name=\"lasttime\" value=\"");
      out.print(endtime);
      out.write("\">\n");
      out.write("            <input type=\"hidden\" name=\"IMEI\" value=\"");
      out.print(imei);
      out.write("\">\n");
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"Show\">\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <div style=\"overflow: scroll\">\n");
      out.write("            <table border=\"12\">\n");
      out.write("                <tr style=\"font-size: x-large;background-color:royalblue ; color: lightblue\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <th>USERNAME</th>\n");
      out.write("                    <th>IMEI</th>\n");
      out.write("                    <th>LATITUDE</th>\n");
      out.write("                    <th>LONGITUDE</th>\n");
      out.write("                        ");

                            String IMEI, username, latitude, longitude;
                            while (rs.next()) {
                                username = rs.getString("username");

                                IMEI = rs.getString("IMEI");
                                latitude = rs.getString("latitude");
                                longitude = rs.getString("longitude");


                        
      out.write("\n");
      out.write("                <tr style=\"background-color:whitesmoke ; color:dodgerblue ;font-size: large\">\n");
      out.write("\n");
      out.write("                    <td><b>");
      out.print(username);
      out.write("</b></td>\n");
      out.write("                    <td><b>");
      out.print(IMEI);
      out.write("</b></td>\n");
      out.write("                    <td><b>");
      out.print(latitude);
      out.write("</b></td>\n");
      out.write("                    <td><b>");
      out.print(longitude);
      out.write("</b></td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </table> \n");
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
