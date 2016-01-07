package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class message_005fto_005femp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("         <link type=\"text/css\" rel=\"stylesheet\" href=\"two.css\">\n");
      out.write("        <title>Send Message</title>\n");
      out.write("        <!--ajax to load table dynamically-->\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            var xmlhttp;\n");
      out.write("            function go()\n");
      out.write("            {\n");
      out.write("                document.getElementById(\"emptable\").style.display=block;\n");
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
      out.write("                var dname=document.getElementById(\"dept\").value;\n");
      out.write("                xmlhttp.open(\"GET\",\"message_to_emp2_ret_table.jsp?dept=\"+dname,true);\n");
      out.write("                \n");
      out.write("                xmlhttp.onreadystatechange=go2; //Response in go2\n");
      out.write("                xmlhttp.send();\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function go2()\n");
      out.write("            {\n");
      out.write("                    if(xmlhttp.readyState==4 && xmlhttp.status==200)\n");
      out.write("                    {\n");
      out.write("                        document.getElementById(\"emptable\").innerHTML=xmlhttp.responseText;\n");
      out.write("                    }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            //on selecting or deselecting select all checkbox\n");
      out.write("            function selectbox(obj)\n");
      out.write("            {\n");
      out.write("                var cball=document.getElementsByName(\"cb\");\n");
      out.write("                if(obj.checked)\n");
      out.write("                {\n");
      out.write("                    for(var i=0;i<cball.length;i++)\n");
      out.write("                    {\n");
      out.write("                        cball[i].checked=true;       \n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    for(var i=0;i<cball.length;i++)\n");
      out.write("                    {\n");
      out.write("                        cball[i].checked=false;       \n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <center>\n");
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
      out.write("      <li><a href='home.jsp'><span>Logout</span></a></li>\n");
      out.write("\n");
      out.write("</ul>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("           \n");
      out.write("            <div id=\"main\">\n");
      out.write("                <h1 class=\"heading\" style=\"margin-top: -30px;\"><center>Send Message</center></h1>\n");
      out.write("        <table class=\"tablestyle\" style=\"padding-top: 30px;\">\n");
      out.write("           <td><span>Select Department</span></td>\n");
      out.write("           <td>\n");
      out.write("               <select name=\"dept\" id=\"dept\" onchange=\"go()\" class=\"tfield\">\n");
      out.write("                <option>--Select Department--</option>\n");
      out.write("        ");

           //Add departments to compbo box from database
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
           Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
           ResultSet rs=stmt.executeQuery("select * from department");
           
           while(rs.next())
           {
        
      out.write("\n");
      out.write("                <option value=\"");
      out.print(rs.getString("dept_name"));
      out.write('"');
      out.write('>');
      out.print(rs.getString("dept_name"));
      out.write("</option>\n");
      out.write("        ");

           }
        
      out.write("\n");
      out.write("          </select>\n");
      out.write("         </td>\n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("          <div id=\"emptable\" style=\" padding-top:70px;border-radius: 10px;border:solid 3px saddlebrown;background: white; width:600px; box-shadow: 15px 15px#888888; display:block;\">\n");
      out.write("            <!--Table of details of employees of selected department(loaded dynamically using ajax)-->\n");
      out.write("        </div>\n");
      out.write("           </div>\n");
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
      out.write(" </center>\n");
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
