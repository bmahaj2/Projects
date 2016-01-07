
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


public class adminmessageserver extends HttpServlet {
   BufferedReader br;
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();

                  try 
                  {
              String msg=request.getParameter("msg");
              String empid=request.getParameter("empid");
              String empname=request.getParameter("empname");
              System.out.println("msg"+msg+empid+empname);
              ArrayList<message>al=new ArrayList<message>();
          Class.forName("com.mysql.jdbc.Driver");
         System.out.println("driver loaded successfully");
       Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps","root","SYSTEM");
        System.out.println("connection build");
            java.sql.Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        System.out.println("******statement created*****");
        ResultSet rs=stmt.executeQuery("select * from messages");
                      StringTokenizer st1=new StringTokenizer(empid,"~");
                       StringTokenizer st2=new StringTokenizer(empname,"~");
               while(st1.hasMoreTokens())
               {
            al.add(new message(st1.nextToken(),st2.nextToken()));
			    		
               }
       
           for(int i=0;i<al.size();i++)
           {
               rs.moveToInsertRow();
          rs.updateString("message", msg);
        
          rs.updateString("message_to",al.get(i).empid.toString());
         rs.insertRow();
      }
         
         
       System.out.println("%%%%%%"+empid+empname);
     
                  }
       catch (Exception ex) {
          ex.printStackTrace();
      } 
    }
}
