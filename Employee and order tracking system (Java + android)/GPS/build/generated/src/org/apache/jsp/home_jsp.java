package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(4);
    _jspx_dependants.add("/header.html");
    _jspx_dependants.add("/menu_home.html");
    _jspx_dependants.add("/sliderlatest.html");
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"two.css\">\n");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
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
      out.write("<ul>\n");
      out.write("   <li><a href='home.jsp'><span>Home</span></a></li>\n");
      out.write("   <li class='last'><a href='admin_login.jsp'><span>Login</span></a></li>\n");
      out.write("</ul>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write(" \n");
      out.write("            <div id=\"main\">\n");
      out.write("               \n");
      out.write("                \n");
      out.write("                   ");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"\r\n");
      out.write("\t\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>WOWSlider generated by WOWSlider.com</title>\r\n");
      out.write("\t<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("\t<meta name=\"keywords\" content=\"WOW Slider, html slider, jquery photo gallery\" />\r\n");
      out.write("\t<meta name=\"description\" content=\"WOWSlider created with WOW Slider, a free wizard program that helps you easily generate beautiful web slideshow\" />\r\n");
      out.write("\t<!-- Start WOWSlider.com HEAD section -->\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"engine1/style.css\" />\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"engine1/jquery.js\"></script>\r\n");
      out.write("\t<!-- End WOWSlider.com HEAD section -->\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"background-color:#FFFFFF\">\r\n");
      out.write("\t<!-- Start WOWSlider.com BODY section -->\r\n");
      out.write("\t<div id=\"wowslider-container1\">\r\n");
      out.write("\t<div class=\"ws_images\"><ul>\n");
      out.write("<li><img src=\"data1/images/catchmeifyoucan1.jpg\" alt=\"Tracking employee's movement\" title=\"Tracking employee's movement\" id=\"wows1_0\"/></li>\n");
      out.write("<li><img src=\"data1/images/googlemapsthumb.jpg\" alt=\"Tracking- Powered by google maps\" title=\"Tracking- Powered by google maps\" id=\"wows1_1\"/></li>\n");
      out.write("<li><img src=\"data1/images/trackingats.jpg\" alt=\"Track using a click of mouse \" title=\"Track using a click of mouse \" id=\"wows1_2\"/></li>\n");
      out.write("<li><img src=\"data1/images/courier_service.jpg\" alt=\"Track couriers\" title=\"Track couriers\" id=\"wows1_3\"/></li>\n");
      out.write("<li><img src=\"data1/images/104photoreprivacyissuestimetrackingsystemsgpstrackingofmobileemployees.jpg\" alt=\"Spy on your employee's movements\" title=\"Spy on your employee's movements\" id=\"wows1_4\"/></li>\n");
      out.write("<li><img src=\"data1/images/worldmapicon.png\" alt=\"Accurate locations using markers\" title=\"Accurate locations using markers\" id=\"wows1_5\"/></li>\n");
      out.write("</ul></div>\n");
      out.write("<div class=\"ws_bullets\"><div>\n");
      out.write("<a href=\"#\" title=\"Tracking employee's movement\"><img src=\"data1/tooltips/catchmeifyoucan1.jpg\" alt=\"Tracking employee's movement\"/>1</a>\n");
      out.write("<a href=\"#\" title=\"Tracking- Powered by google maps\"><img src=\"data1/tooltips/googlemapsthumb.jpg\" alt=\"Tracking- Powered by google maps\"/>2</a>\n");
      out.write("<a href=\"#\" title=\"Track using a click of mouse \"><img src=\"data1/tooltips/trackingats.jpg\" alt=\"Track using a click of mouse \"/>3</a>\n");
      out.write("<a href=\"#\" title=\"Track couriers\"><img src=\"data1/tooltips/courier_service.jpg\" alt=\"Track couriers\"/>4</a>\n");
      out.write("<a href=\"#\" title=\"Spy on your employee's movements\"><img src=\"data1/tooltips/104photoreprivacyissuestimetrackingsystemsgpstrackingofmobileemployees.jpg\" alt=\"Spy on your employee's movements\"/>5</a>\n");
      out.write("<a href=\"#\" title=\"Accurate locations using markers\"><img src=\"data1/tooltips/worldmapicon.png\" alt=\"Accurate locations using markers\"/>6</a>\n");
      out.write("</div></div>\n");
      out.write("<span class=\"wsl\"><a href=\"http://wowslider.com\">javascript slider</a> by WOWSlider.com v5.4</span>\r\n");
      out.write("\t<div class=\"ws_shadow\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"engine1/wowslider.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"engine1/script.js\"></script>\r\n");
      out.write("\t<!-- End WOWSlider.com BODY section -->\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
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
