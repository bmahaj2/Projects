
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class imeiserver extends HttpServlet {
   BufferedReader br;
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();

                  try 
                  {
                      String imei="";
              String eid=request.getParameter("eid");
            System.out.println("***###@@@"+eid);
          Class.forName("com.mysql.jdbc.Driver");
         System.out.println("driver loaded successfully");
       Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
        System.out.println("connection build");
            java.sql.Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        System.out.println("******statement created*****");
        ResultSet rs=stmt.executeQuery("select * from device_allotment where username='"+eid+"'");
        while(rs.next())
        {
          imei=imei+rs.getString("imei")+"~";
        }
          imei = imei.substring(0, imei.length()- 1);
       
         out.println(imei);
      
                  }
       catch (Exception ex) {
          ex.printStackTrace();
      } 
    }
}
