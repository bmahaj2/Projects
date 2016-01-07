package com.example.employeetrackers;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

//Service to fetch messages from server
public class MessageFetchingService extends Service
{
	Socket sock;
	DataInputStream dis;
	DataOutputStream dos;
	String s,msg,date_time;
	StringTokenizer msgdate,datemsg;
	@Override
	public IBinder onBind(Intent arg0)
	{
		return null;
	}
	
	public int onStartCommand(Intent intent, int flags, int startId) 
	{
		Log.d("MySa" , "within service");
		if(GlobalApp.msgflag==false)  //only single service
		{
			Log.d("MySa" , "message fetching started");
			new Thread(new fetchmsg()).start();
			
			GlobalApp.flag=true;
		}
		return START_STICKY;
	}
	public void onTaskRemoved(Intent rootIntent)
	{
		//Intent in=new Intent(getBaseContext(),MessageFetchingService.class);
		//PendingIntent pin=PendingIntent.getService(getBaseContext(),0,in,0);
	}

	public class fetchmsg implements Runnable
	{
		@Override
		public void run()
		{
		    while(true)
		    {
		    	try
		    	{
		    		sock=new Socket(GlobalApp.ip,8084);
			        dis=new DataInputStream(sock.getInputStream());
			        dos=new DataOutputStream(sock.getOutputStream());
			    
			        dos.writeBytes("GET /GPS/Android_send_msg?username="+GlobalApp.username+" HTTP/1.1\r\n");
		            dos.writeBytes("Host: +"+GlobalApp.ip+":8084\r\n");
		            dos.writeBytes("\r\n");
		            
		            GlobalApp.msgal.clear();
		            while(true)
			        {
			        	s=dis.readLine();
			        	if(s==null || s.equals(""))
			        		break;
			        	Log.d("MySa" , s);
			        }
			        s=dis.readLine();  //Message Fetched but it is in the form of a "date1`message1~date2`message2~date3`message3"
			                           //Using String Tokenizer fetch date and message one by one and show in the form of a list
			        
			       // if(!(s==null || s.equals("")))
			        
			        int n = Integer.parseInt(s);
			        for (int i = 0; i < n; i++)
			        {
					  String date = dis.readLine();
					  String msg = dis.readLine();
					  GlobalApp.msgal.add(new MessageDate(msg,date));
		        	  Log.d("MYMSG",date+" "+msg);
					}
			        Intent in = new Intent("messages");
			        sendBroadcast(in);
			        Thread.sleep(5000);
		    	}
		    	catch(Exception ex)
		    	{
		    		ex.printStackTrace();
		        }
		    }
		}
	}

}
