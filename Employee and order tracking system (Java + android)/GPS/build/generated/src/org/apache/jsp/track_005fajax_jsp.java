package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class track_005fajax_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("            var xmlhttp;\n");
      out.write("            function go()\n");
      out.write("            {\n");
      out.write("                try\n");
      out.write("                {\n");
      out.write("                    xmlhttp=new ActiveXObject(\"Msxml2.XMLHTTP\"); //Old Microsoft Browsers\n");
      out.write("                }\n");
      out.write("                catch(e)\n");
      out.write("                {\n");
      out.write("                    try\n");
      out.write("                    {\n");
      out.write("                        xmlhttp=new ActiveXObject(\"Microsoft.XMLHTTP\"); //For new Internet Explorer IE 6.0 \n");
      out.write("                    }\n");
      out.write("                    catch(e1)\n");
      out.write("                    {\n");
      out.write("                        xmlhttp=new XMLHttpRequest(); //For mozilla,Opera Browsers\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                var text=document.getElementById(\"username\").value;\n");
      out.write("                xmlhttp.open(\"GET\",\"./allot?q=\"+text,true);\n");
      out.write("                \n");
      out.write("                xmlhttp.onreadystatechange=go2;\n");
      out.write("                xmlhttp.send();\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function go2()\n");
      out.write("            {\n");
      out.write("                \n");
      out.write("                    if(xmlhttp.readyState==4 && xmlhttp.status==200)\n");
      out.write("                    {\n");
      out.write("                        document.getElementById(\"dpt\").innerHTML=xmlhttp.responseText;\n");
      out.write("                    }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        ");

         Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded successfully");
        Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
        System.out.println("connection build");
        Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        System.out.println("statemt");
       
           ResultSet rs=stmt.executeQuery("select imei from gps.devices where imei not in (select imei from gps.device_allotment where releasedate is null)");
           
      out.write("\n");
      out.write("           <form action=\"allotjsp2.jsp\" method=\"POST\">\n");
      out.write("               <table border=\"1\">\n");
      out.write("           <tr>\n");
      out.write("           <td>IMEI</td>\n");
      out.write("                   <td>\n");
      out.write("                   <select name=\"IMEI\">\n");
      out.write("                           ");

                           while(rs.next())
                           {
                               String IMEI=rs.getString("IMEI");
                               
      out.write("\n");
      out.write("                               <option value=\"");
      out.print(IMEI);
      out.write('"');
      out.write('>');
      out.print(IMEI);
      out.write("</option>\n");
      out.write("                                   ");

                               
                           }
                           
                           
      out.write("\n");
      out.write("                       </select>\n");
      out.write("                   </td>\n");
      out.write("                        </tr>\n");
      out.write("                           ");

                           ResultSet rs1=stmt.executeQuery("select * from signup");
                           
      out.write("\n");
      out.write("                             \n");
      out.write("                           <tr>\n");
      out.write("                               <td>EMPLOYEE</td>\n");
      out.write("                               <td>\n");
      out.write("                      \n");
      out.write("                                   <select name=\"username\" id=\"username\" onchange=\"go()\">\n");
      out.write("                           ");

                           while(rs1.next())
                           {
                               String username=rs1.getString("username");
                               String firstname=rs1.getString("firstname");
                               
      out.write("\n");
      out.write("                               <option value=\"");
      out.print(username);
      out.write('"');
      out.write('>');
      out.print(firstname);
      out.write("</option>\n");
      out.write("                                   ");

                               
                           }
                           
      out.write("\n");
      out.write("                   </select>\n");
      out.write("                               </td>\n");
      out.write("                           </tr>\n");
      out.write("                            <tr>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td><input type=\"submit\" value=\"add\"</td>\n");
      out.write("                    </tr>\n");
      out.write("           </table>\n");
      out.write("                   <div id=\"dpt\">\n");
      out.write("                       \n");
      out.write("                   </div> \n");
      out.write("           </form>\n");
      out.write("                   \n");
      out.write("                          \n");
      out.write("                   \n");
      out.write("          \n");
      out.write("        \n");
      out.write("        \n");
      out.write("       \n");
      out.write("                \n");
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
