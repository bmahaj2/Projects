
import java.beans.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class offtrackserver extends HttpServlet {
   BufferedReader br;
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();

                  try 
                  {
                      String lat="";
                      String lng="";
             String imei=request.getParameter("imei");
              String from=request.getParameter("from");
             String to=request.getParameter("to");
  System.out.println("ankita...."+imei+from+to);
          Class.forName("com.mysql.jdbc.Driver");
         System.out.println("driver loaded successfully");
       Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
        System.out.println("connection build");
            java.sql.Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        System.out.println("******statement created*****");
    ResultSet rs = stmt.executeQuery("select * from track_emphistory where imei = '"+imei + "' and date BETWEEN '"+from+"' AND '"+to+"'");
           while(rs.next())
       {
     lat=lat+rs.getDouble("latitude")+"~";
        lng=lng+rs.getDouble("longitude")+"~";
      }
         lat=lat.substring(0,lat.length()- 1);
         lng =lng.substring(0, lng.length()- 1);
           
       System.out.println("%%%%%%"+lat+lng);
       out.println(lat);
       out.println(lng);
       
                  }
       catch (Exception ex) {
          ex.printStackTrace();
      } 
    }
}
