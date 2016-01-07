
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class courier_assignServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String user = request.getParameter("q");

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps", "root", "SYSTEM");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from device_allotment where username=\'" + user + "\'");
            out.println("<select>");

            while (rs.next()) {
                String IMEI = rs.getString("imei");
                System.out.println("imei=" +IMEI);
                out.println("<option value=\"" + IMEI + "\">" + IMEI + "</option>");
                
            }
            out.println("</select>");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
