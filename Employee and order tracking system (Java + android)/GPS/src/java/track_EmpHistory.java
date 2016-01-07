
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
public class track_EmpHistory extends HttpServlet
{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        String latitude= request.getParameter("latitude");
        String longitude=request.getParameter("longitude");
        String IMEI=request.getParameter("imei");
        String username=request.getParameter("username");
        System.out.println(latitude+"       "+ longitude+"      "+IMEI);
         try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps", "root", "SYSTEM");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from track_Emphistory");
            rs.moveToInsertRow();
            rs.updateString("IMEI", IMEI);
            rs.updateString("latitude", latitude);
            rs.updateString("longitude", longitude);
            rs.updateString("username", username);
            rs.insertRow();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
      
      
      
        
       
    
    }}
    
