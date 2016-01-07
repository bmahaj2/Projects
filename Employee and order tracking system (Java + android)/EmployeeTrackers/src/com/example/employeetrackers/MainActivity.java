package com.example.employeetrackers;




import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity
{
	TextView tv1,tv2;
	EditText et1,et2;
	String s;
	myhandler mh;
	GlobalApp gb;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv1=(TextView)(findViewById(R.id.tv1));
		tv2=(TextView)(findViewById(R.id.tv2));
        et1=(EditText)(findViewById(R.id.et1));
        et2=(EditText)(findViewById(R.id.et2));
        
        gb = (GlobalApp)getApplication();
        
        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
       String imei=telephonyManager.getDeviceId();
       //tv2.setText(imei);
        mh=new myhandler();
	}
	public void go(View v)
	{
		new Thread(new myjob()).start();
		
	}
	class myjob implements Runnable
	{
		public void run()
		{
			
		 try
		    {
		    	
			 
		Socket sock = new Socket(GlobalApp.ip,8084);
		DataInputStream dis = new DataInputStream(sock.getInputStream());
		DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
		        System.out.println("hello");
		        
		dos.writeBytes("GET /GPS/LoginServlet?username="+ et1.getText().toString()+"&password="+et2.getText().toString()+" HTTP/1.1\r\n");
		dos.writeBytes("Host:GlobalApp.ip:8084\r\n");
		dos.writeBytes("\r\n");
		while(true)
		{
			 s=dis.readLine();
			if(s==null||s.equals(""))
			{
				break;
				
			}
			Log.d("mymess" , s);
		}
		s=dis.readLine();
		Log.d("mymess1" , s);
		//s=dis.readLine();
	//	Log.d("mymess1" , s);

		mh.sendEmptyMessage(99);
		        
		}
		    catch(Exception ex)
		    {
		        ex.printStackTrace();
		    }
		
		}	
    }
	class myhandler extends Handler
	{
		public void handleMessage(Message ms)
		{
		
			if(s.equals("login successfull"))
			{
					GlobalApp.username = et1.getText().toString();
					
					Intent in=new Intent(getBaseContext(),AfterLogin.class);
					startActivity(in);
			}
			else
			{
				tv1.setText("Invalid username or password");
				et1.setText("");
				et2.setText("");
				
			}
			
	//		tv1.setText(s);
			
			
		}
	}
		

	


	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
