
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


public class admincomplaintserver extends HttpServlet {
   BufferedReader br;
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();

                  try 
                  {
              String username="";
              String subject="";
              String complaint="";
          Class.forName("com.mysql.jdbc.Driver");
         System.out.println("driver loaded successfully");
       Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
        System.out.println("connection build");
            java.sql.Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        System.out.println("******statement created*****");
        ResultSet rs=stmt.executeQuery("select * from complaints");
           while(rs.next())
       {
         username=username+rs.getString("username")+"~";
         subject=subject+rs.getString("complaintsubject")+"~";
            complaint=complaint+rs.getString("complaint")+"~";
      }
                      System.out.println("username = "+username);
         username=username.substring(0, username.length()- 1);
         subject =subject.substring(0, subject.length()- 1);
           complaint =complaint.substring(0, complaint.length()- 1);
           
       System.out.println("%%%%%%"+username+subject+complaint);
       out.println(username);
       out.println(subject);
       out.println(complaint);
       
                  }
       catch (Exception ex) {
          ex.printStackTrace();
      } 
    }
}
