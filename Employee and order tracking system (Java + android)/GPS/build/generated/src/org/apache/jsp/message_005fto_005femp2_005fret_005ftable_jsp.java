package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import java.sql.*;

public final class message_005fto_005femp2_005fret_005ftable_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<form action=\"message_to_emp3.jsp\" method=\"post\">\n");
      out.write("   <table border=\"0\" style=\"background-color:lightgray; overflow-y: scroll\" >\n");
      out.write("       <tr>\n");
      out.write("           <th>Select All<input type=\"checkbox\" id=\"cball\" name=\"cball\" onclick=\"selectbox(this)\"/></th>\n");
      out.write("           <th>Username</th>\n");
      out.write("           <th>Name</th>\n");
      out.write("           <th>Photo</th>\n");
      out.write("       </tr>\n");
      out.write("       ");

         try
         {
             String dept=request.getParameter("dept");
             Class.forName("com.mysql.jdbc.Driver");
             Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
             Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
             
             //Select employees of selected department
             ResultSet rs=stmt.executeQuery("select * from signup where department_name=\'"+dept+"\'");
             
             while(rs.next())
             {
         
      out.write("\n");
      out.write("             \n");
      out.write("             <tr>\n");
      out.write("                 <td><input type=\"checkbox\" id=\"cb\" name=\"cb\" value=\"");
      out.print(rs.getString("username"));
      out.write("\"/></td>\n");
      out.write("                 <td>");
      out.print(rs.getString("username"));
      out.write("</td>\n");
      out.write("                 <td>");
      out.print(rs.getString("firstname"));
      out.write(' ');
      out.print(rs.getString("lastname"));
      out.write("</td>\n");
      out.write("                 <td><img src=\"");
      out.print(rs.getString("photo"));
      out.write("\" height=\"50\" width=\"50\" /></td>\n");
      out.write("             </tr>\n");
      out.write("    \n");
      out.write("         ");

             }
           }
         catch(Exception ex)
         {
             ex.printStackTrace();    
         }
        
      out.write(" \n");
      out.write("        <tr>\n");
      out.write("            <!--Give message here-->\n");
      out.write("            <td colspan=\"4\">\n");
      out.write("        <textarea rows=\"5\" cols=\"40\" id=\"txt\" name=\"txt\">\n");
      out.write("           \n");
      out.write("        </textarea>\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td></td>\n");
      out.write("            <td><input type=\"submit\" value=\"Send\" /></td>\n");
      out.write("        </tr>\n");
      out.write("   </table>\n");
      out.write("</form>");
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
