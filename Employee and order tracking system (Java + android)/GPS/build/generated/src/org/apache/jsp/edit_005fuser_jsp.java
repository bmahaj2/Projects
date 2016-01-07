package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class edit_005fuser_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("                <link href=\"two.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("        <title>Edit User</title>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("        function go3()\n");
      out.write("            {\n");
      out.write("                var contact=document.getElementById(\"ct\");\n");
      out.write("                if(isNaN(contact.value) || contact.value.length!=10)\n");
      out.write("                {\n");
      out.write("                      document.getElementById(\"myct\").innerHTML=\"Invalid Mobile No.\";\n");
      out.write("                      contact.value=\"\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function go2()\n");
      out.write("            {\n");
      out.write("                document.getElementById(\"fn\").removeAttribute(\"disabled\");\n");
      out.write("                document.getElementById(\"ln\").removeAttribute(\"disabled\");\n");
      out.write("                document.getElementById(\"dob\").removeAttribute(\"disabled\");\n");
      out.write("                document.getElementById(\"doj\").removeAttribute(\"disabled\");\n");
      out.write("                document.getElementById(\"addrs\").removeAttribute(\"disabled\");\n");
      out.write("                document.getElementById(\"em\").removeAttribute(\"disabled\");\n");
      out.write("                document.getElementById(\"ct\").removeAttribute(\"disabled\");\n");
      out.write("                document.getElementById(\"deptn\").removeAttribute(\"disabled\");\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <div id=\"all\">\n");
      out.write("            ");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>header</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<!-- Save for Web Slices (header.psd) -->\r\n");
      out.write("<img src=\"images/header.png\" width=\"980\" height=\"330\" alt=\"\">\r\n");
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
      out.write("   <li class='active has-sub'><a href='index.html'><span>Employee</span></a>\n");
      out.write("      <ul>\n");
      out.write("         <li><a href='signup.jsp'><span>Add Employee</span></a></li>\n");
      out.write("         <li><a href='edit_user.jsp'><span>Edit Employee</span></a></li>\n");
      out.write("         <li><a href='delete_user.jsp'><span>Delete Employee</span></a></li>\n");
      out.write("         <li class='last'><a href='view_user.jsp'><span>View Employee</span></a></li>\n");
      out.write("      </ul>\n");
      out.write("   </li>\n");
      out.write("   <li class='has-sub'><a href='#'><span>Devices</span></a>\n");
      out.write("      <ul>\n");
      out.write("         <li><a href='#'><span>Add Device</span></a></li>\n");
      out.write("         <li><a href='#'><span>Allot Device</span></a></li>\n");
      out.write("         <li class='last'><a href='#'><span>View Allotted Devices</span></a></li>\n");
      out.write("      </ul>\n");
      out.write("   </li>\n");
      out.write("   <li><a href='#'><span>Send Message</span></a></li>\n");
      out.write("   <li class='has-sub'><a href='#'><span>Employee Tracking</span></a>\n");
      out.write("      <ul>\n");
      out.write("         <li class='last'><a href='#'><span>View and Track Employee</span></a></li>\n");
      out.write("      </ul>\n");
      out.write("   </li>\n");
      out.write("   <li class='has-sub last'><a href='#'><span>Courier Tracking</span></a>\n");
      out.write("      <ul>\n");
      out.write("         <li><a href='#'><span>Assign Courier</span></a></li>\n");
      out.write("         <li class='last'><a href='#'><span>View And Track Courier</span></a></li>\n");
      out.write("      </ul>\n");
      out.write("   </li>\n");
      out.write("</ul>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("            <div id=\"main\">\n");
      out.write("        \n");
      out.write("        ");

             String username=request.getParameter("q");
             
             System.out.println("hello world : "+username);
             
             Class.forName("com.mysql.jdbc.Driver");
             Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
             Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
             ResultSet rs=stmt.executeQuery("select * from signup where username=\'"+username+"\'");
             
             String firstname,lastname,email_id,mobile_no,address,department_name,dob,doj,photo_path;
             if(rs.next())
             {
             
             firstname=rs.getString("firstname");
             lastname=rs.getString("lastname");
             email_id=rs.getString("email_id");
             address=rs.getString("address");
             mobile_no=rs.getString("mobile_no");
             department_name=rs.getString("department_name");
             dob=rs.getString("date_of_birth");
             doj=rs.getString("date_of_joining");
             photo_path=rs.getString("photo");
        
      out.write("\n");
      out.write("            <form action=\"edit_user2.jsp\" method=\"\">\n");
      out.write("                <table border=\"3\" style=\"background-color: orange\" onload=\"go()\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>Username</td>\n");
      out.write("                    <td><input type=\"text\" id=\"un\" disabled value=\"");
      out.print(username);
      out.write("\" />\n");
      out.write("                    </td>\n");
      out.write("                    <td><input type=\"hidden\" name=\"un\" value=\"");
      out.print(username);
      out.write("\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                    <td>First Name</td>\n");
      out.write("                    <td><input type=\"text\" required disabled placeholder=\"Enter First Name\" value=\"");
      out.print(rs.getString("firstname"));
      out.write("\" id=\"fn\" name=\"fn\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                    <td>Last Name</td>\n");
      out.write("                    <td><input type=\"text\" required disabled placeholder=\"Enter Last Name\" value=\"");
      out.print(rs.getString("lastname"));
      out.write("\" id=\"ln\" name=\"ln\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("           \n");
      out.write("                <tr>\n");
      out.write("                    <td>Date Of Birth</td>\n");
      out.write("                    <td><input type=\"date\" disabled name=\"dob\" id=\"dob\" value=\"");
      out.print(rs.getString("date_of_birth"));
      out.write("\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                    <td>Date Of Joining</td>\n");
      out.write("                    <td><input type=\"date\" disabled name=\"doj\" id=\"doj\" value=\"");
      out.print(rs.getString("date_of_joining"));
      out.write("\"/>\n");
      out.write("                        </td>\n");
      out.write("                </tr>\n");
      out.write("         \n");
      out.write("                <tr>\n");
      out.write("                    <td>Address</td>\n");
      out.write("                    <td><textarea rows=\"5\" cols=\"20\" disabled id=\"addrs\" name=\"addrs\" >");
      out.print(rs.getString("address"));
      out.write("</textarea></td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                    <td>Email</td>\n");
      out.write("                    <td><input type=\"email\" name=\"em\" disabled id=\"em\" value=\"");
      out.print(rs.getString("email_id"));
      out.write("\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                    <td>Contact</td>\n");
      out.write("                    <td><input type=\"text\" id=\"ct\" name=\"ct\" disabled value=\"");
      out.print(rs.getString("mobile_no"));
      out.write("\" onblur=\"go3()\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td><span id=\"myct\"></span></td> \n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                    <td>Select Department</td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"deptn\" disabled id=\"deptn\" value=");
      out.print(rs.getString("department_name"));
      out.write(">\n");
      out.write("                            <option value=\"Marketing\">Marketting</option>\n");
      out.write("                            <option value=\"Sales\">Sales</option>\n");
      out.write("                            <option value=\"Production\">Production</option>\n");
      out.write("                            <option value=\"Purchase\">Purchase</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"button\" value=\"Edit\" name=\"edit\" onclick=\"go2()\"/>\n");
      out.write("                        <input type=\"submit\" value=\"Save\" name=\"save\"/>\n");
      out.write("                    </td>\n");
      out.write("                    \n");
      out.write("                </tr>\n");
      out.write("           </table>\n");
      out.write("        </form>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("          </div>\n");
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
