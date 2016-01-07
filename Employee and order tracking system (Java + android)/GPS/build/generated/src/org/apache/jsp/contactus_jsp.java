package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contactus_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<!--    <head>\n");
      out.write("          <link href=\"two.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <link href=\"cssmenu/menu_source/styles.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <script src=\"cssmenu/menu_source/menu_jquery.js\"></script>\n");
      out.write("    </head>-->\n");
      out.write(" <head>\n");
      out.write("                <link type=\"text/css\" rel=\"stylesheet\" href=\"two.css\">\n");
      out.write("\n");
      out.write("        <title>Employee Login Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <center>\n");
      out.write("\n");
      out.write("        <div id=\"all\">\n");
      out.write("            ");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>header</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<!-- Save for Web Slices (header.psd) -->\r\n");
      out.write("<img src=\"images/header.png\" width=\"980\" height=\"200\" alt=\"\">\r\n");
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
      out.write("         <li><a href='home.jsp'><span>Home</span></a></li>\n");
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
      out.write("         <li><a href='CourierAsssignment.jsp'><span>Assign Courier</span></a></li>\n");
      out.write("         <li class='last'><a href='view_courier_assignment.jsp'><span>View And Track Courier</span></a></li>\n");
      out.write("      </ul>\n");
      out.write("   </li>\n");
      out.write("      \n");
      out.write("    <li class='has-sub last'><a href='#'><span>More</span></a>\n");
      out.write("      <ul>\n");
      out.write("         <li><a href='home.jsp'><span>Contact Us</span></a></li>\n");
      out.write("         <li class='last'><a href='home.jsp'><span>Logout</span></a></li>\n");
      out.write("      </ul>\n");
      out.write("   </li>\n");
      out.write("\n");
      out.write("</ul>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("\n");
      out.write("         ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div id=\"main\" style=\"margin-left: 0px\" >\n");
      out.write("                <label class=\"stylelabel\">Contact us</label>\n");
      out.write("                \n");
      out.write("                <table style=\"font-size: 20px; font-style: italic; color: #000000; text-align: justify;\">\n");
      out.write("                    <tr><td rowspan=\"5\"><img src=\"images11/pic_1.jpg\" width=\"150\" height=\"200\" style=\"border: solid 5px orange; border-radius: 10px;\"/></td></tr>\n");
      out.write("                    <tr><td>Name : Bhavya Mahajan</td></tr>\n");
      out.write("                    <tr><td>Class : B.Tech(CSE),Sem-8th</td></tr>\n");
      out.write("                    <tr><td>Rollno : 2010CSA1709</td></tr>\n");
      out.write("                    <tr><td>College : Guru Nanak Dev University,Regional Campus, Gurdaspur</td></tr>\n");
      out.write("                    \n");
      out.write("                    </table>\n");
      out.write("                \n");
      out.write("<!--                <br>\n");
      out.write("                <table style=\"font-size: 20px; font-style: italic; color: #000000; text-align: justify;\">\n");
      out.write("                    <tr><td rowspan=\"5\"><img src=\"images11/pic_1.jpg\" width=\"150\" height=\"200\" style=\"border: solid 5px orange; border-radius: 10px;\"/></td></tr>\n");
      out.write("                    <tr><td>Name : Karan Kaher</td></tr>\n");
      out.write("                    <tr><td>Class : MCA(FYIC),Sem-6th</td></tr>\n");
      out.write("                    <tr><td>Rollno : 2011CSC1088</td></tr>\n");
      out.write("                    <tr><td>College : Guru Nanak Dev University, Amritsar</td></tr>\n");
      out.write("                </table>-->\n");
      out.write("            </div>\n");
      out.write("            ");
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
      out.write("        </div>    \n");
      out.write("\n");
      out.write("    </center> \n");
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
