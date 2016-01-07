
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class trackemp_liveTracking2 extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps", "root", "SYSTEM");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            java.util.Date date = new java.util.Date();
            String dt=dateFormat.format(date)+" 00:00:00";
             
            //Get database entries for today
            ResultSet rs = stmt.executeQuery("select * from track_emphistory where imei='"+request.getParameter("imei")+"' order by date desc");
            System.out.println("\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
            System.out.println("select * from track_emphistory where imei='"+request.getParameter("imei")+"' and date>='"+dt+"' order by date desc");

            String longitude,latitude;
            if(rs.next())
            {
                latitude = rs.getString("latitude");
                longitude =rs.getString("longitude");
                
                out.println(latitude+"#"+longitude);
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
