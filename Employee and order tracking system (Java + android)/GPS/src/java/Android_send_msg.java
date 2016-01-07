import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Android_send_msg extends HttpServlet 
{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String username=request.getParameter("username");
        String msg="";
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
            Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=stmt.executeQuery("select count(message_id)'id' from messages where message_to=\'"+username+"\'");
            
            rs.next();
            
            int n = rs.getInt("id");
            out.println(n);
            System.out.println(n + " -- n");
            rs=stmt.executeQuery("select * from messages where message_to=\'"+username+"\'");
            
            while(rs.next())                                            
            {
                String date = rs.getString("date_time");
                String msg2 = rs.getString("message");
                out.println(date);
                out.println(msg2);
                System.out.println(date  + " "  + msg2);
               
            }
           
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
    }
}
