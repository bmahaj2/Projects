package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_005flogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/header.html");
    _jspx_dependants.add("/menu_home.html");
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("                <link type=\"text/css\" rel=\"stylesheet\" href=\"two.css\">\n");
      out.write("\n");
      out.write("        <title>Employee Login Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div id=\"all\">\n");
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
      out.write("<ul>\n");
      out.write("   <li><a href='home.jsp'><span>Home</span></a></li>\n");
      out.write("   <li class='last'><a href='admin_login.jsp'><span>Login</span></a></li>\n");
      out.write("</ul>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write(" \n");
      out.write("            <div id=\"main\">\n");
      out.write("<!--                <span class=\"headingstyle\" style=\"margin-top: 20px;\">Login</span>-->\n");
      out.write("<h1 class=\"heading\" style=\"margin-top: -30px;\"><center>Login Form</center></h1>\n");
      out.write("                   <center>\n");
      out.write("                       <div style=\"border-radius: 10px;border:solid 3px saddlebrown;background: white; width:600px; box-shadow: 15px 15px#888888;\">\n");
      out.write("                           <center>\n");
      out.write("                                 <form action=\"admin_login2.jsp\" method=\"post\">\n");
      out.write("                <table border=\"0\" class=\"tablestyle\" cellspacing=\"5\" style=\"margin-top: 30px;\">\n");
      out.write("                \n");
      out.write("                   \n");
      out.write("                      <tr>\n");
      out.write("                          <td>Username</td>\n");
      out.write("                          <td><input type=\"text\" name=\"usr\" required id=\"usr\" class=\"tfield\"/></td>\n");
      out.write("                      </tr>\n");
      out.write("                      <tr>\n");
      out.write("                          <td>Password</td>\n");
      out.write("                          <td><input type=\"password\" name=\"pwd\" required id=\"pwd\" class=\"tfield\"/></td>\n");
      out.write("                      </tr>\n");
      out.write("                         <td></td>\n");
      out.write("                         <td><input type=\"submit\" value=\"Submit\" class=\"submitsyle\"/></td>\n");
      out.write("                          <tr>\n");
      out.write("                      ");

                            String message=request.getParameter("q");
                            if(message!=null)
                            {
                      
      out.write("\n");
      out.write("                            <td colspan=\"2\"><b>");
      out.print(message);
      out.write("</b></td>\n");
      out.write("                      ");

                            }
                      
      out.write("\n");
      out.write("                  </tr>\n");
      out.write("                   </table>\n");
      out.write("                  </form>\n");
      out.write("                           </center>\n");
      out.write("               \n");
      out.write("                       </div>\n");
      out.write("                   </center>\n");
      out.write("          </div>\n");
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
      out.write("\n");
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
