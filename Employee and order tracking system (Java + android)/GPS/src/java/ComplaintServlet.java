
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
public class ComplaintServlet extends HttpServlet
{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        String username= request.getParameter("username");
        String email=request.getParameter("email");
        long phone=Long.parseLong(request.getParameter("phone"));
        String department=request.getParameter("department");
        String complaint_subject=request.getParameter("complaint_subject");
        String complaint=request.getParameter("complaint");


        //System.out.println(latitude+"       "+ longitude+"      "+IMEI);
         try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps", "root", "SYSTEM");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from complaints");
            rs.moveToInsertRow();
            rs.updateString("username",username);
            rs.updateString("emailid", email);
            rs.updateLong("phone", phone);
            rs.updateString("department", department);
            rs.updateString("complaintsubject", complaint_subject);
            rs.updateString("complaint", complaint);
            rs.updateString("status", "pending");

            
            rs.insertRow();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
      
      
      
        
       
    
    }}
    
