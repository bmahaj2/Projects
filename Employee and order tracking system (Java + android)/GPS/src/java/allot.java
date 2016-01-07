


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class allot extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String user=request.getParameter("q");
        
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
          Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
          ResultSet rs=stmt.executeQuery("select * from signup where username=\'"+user+"\'");
        
          if(rs.next())
          {
                  out.println("<table border=\"1\" class=\"tablestyle\" cellspacing=\"5\">");
                  out.println("<tr>");
                  out.println("<td>Name : "+rs.getString("firstname")+" "+rs.getString("lastname")+"</td>");
                  out.println("<td rowspan=\"2\"><img src=\""+rs.getString("photo")+"\" width=\"100\" height=\"100\" /></td>");
                  out.println("</tr>");
                  out.println("<tr>");
                  out.println("<td>Mobile No. : "+rs.getString("mobile_no")+"</td>");
                  out.println("</tr>");
                  
            //      ResultSet rs1=stmt.executeQuery("select IMEI from view_alloted_devices where alloted_to=\'"+user+"\'");
                  
//                  while(rs1.next())
//                  {
//                     out.println("<tr>");
//                     out.println("<td colspan=\"2\">IMEI : "+rs1.getString("IMEI")+"</td>");
//                     out.println("</tr>");
//                  }
                  out.println("</table>");
          }
          
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            out.close();
        }
    }   
}