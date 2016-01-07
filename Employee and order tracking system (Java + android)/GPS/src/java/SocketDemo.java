import java.io.*;
import java.net.*;
import java.util.*;
public class SocketDemo
{
     public static void main(String[] args)throws IOException
        {
            try
            {
        Socket sock = new Socket("127.0.0.1",8084);
        DataInputStream dis = new DataInputStream(sock.getInputStream());
        DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
                System.out.println("hello");
        dos.writeBytes("GET /GPS/trackHistoryServlet?lat=45.68&long=56.45&IMEI=985 HTTP/1.1\r\n");
        dos.writeBytes("Host: 127.0.0.1:8084\r\n");
        dos.writeBytes("\r\n");
                System.out.println(dis.readLine());
        }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
}
