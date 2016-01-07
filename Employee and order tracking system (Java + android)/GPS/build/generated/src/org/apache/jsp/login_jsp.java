package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Employee Login Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"two.css\">\n");
      out.write("        <div id=\"all\">  \n");
      out.write("          <div id=\"header\">\n");
      out.write("              <img src=\"images11/login.jpg\" width=\"980\" height=\"280\">\n");
      out.write("            \n");
      out.write("          </div>\n");
      out.write("        \n");
      out.write("          <div id=\"sidebar\">\n");
      out.write("              <input type=\"button\" value=\"Admin Login\"/>\n");
      out.write("          </div>\n");
      out.write("        \n");
      out.write("          <div id=\"main\" style=\"padding-left: 450px;padding-top: 200px\">\n");
      out.write("              <table border=\"1\" style=\"background-color: orange\">\n");
      out.write("                  <form action=\"loginCheck.jsp\" method=\"post\">\n");
      out.write("                      <tr>\n");
      out.write("                          <td>User Name</td>\n");
      out.write("                          <td><input type=\"text\" name=\"us\" required id=\"us\"/></td>\n");
      out.write("                      </tr>\n");
      out.write("                      <tr>\n");
      out.write("                          <td>Password</td>\n");
      out.write("                          <td><input type=\"password\" name=\"pwd\" required id=\"pwd\"/></td>\n");
      out.write("                      </tr>\n");
      out.write("                         <td></td>\n");
      out.write("                         <td><input type=\"submit\" value=\"Submit\"/></td>\n");
      out.write("                  </form>\n");
      out.write("              </table>\n");
      out.write("          </div>\n");
      out.write("        \n");
      out.write("          <div id=\"footer\">\n");
      out.write("              \n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        ");

           String message=request.getParameter("q");
           if(message!=null)
           {
        
      out.write("\n");
      out.write("              <b>");
      out.print(message);
      out.write("</b>\n");
      out.write("        ");

           }
        
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
