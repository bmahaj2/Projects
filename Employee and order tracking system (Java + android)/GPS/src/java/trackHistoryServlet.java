
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class trackHistoryServlet extends HttpServlet
{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        String latitude= request.getParameter("lat");
        String longitude=request.getParameter("long");
        String IMEI=request.getParameter("IMEI");
        System.out.println(latitude+"       "+ longitude+"      "+IMEI);
         try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps", "root", "SYSTEM");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from location");
            rs.moveToInsertRow();
            rs.updateString("IMEI", IMEI);
            rs.updateString("latitude", latitude);
            rs.updateString("longitude", longitude);
            rs.insertRow();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
      
      
      
        
       
    
    }}
    
