//
//package com.example.project;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.net.UnknownHostException;
//
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.app.Activity;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.telephony.TelephonyManager;
//import android.util.Log;
//import android.view.Menu;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.TextView;
//
//public class MainActivity extends Activity {
//   Socket sock;
//   BufferedReader br;
//   PrintWriter pw;
//   EditText et1,et2;
//   TextView tv3,tv4;
//   String s1,s2,s3,s4;
//   myhandler mh;
   
//	Intent in;
//	String t;
//
//	
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.main);
//		et1=(EditText)findViewById(R.id.editText1);
//		et2=(EditText)findViewById(R.id.editText2);
//		//tv3=(TextView)findViewById(R.id.textView4);
//		mh=new myhandler();
//		gba=(MYGlobalAPP)getApplicationContext();
//		
//	
//	}
//	public void go(View v)
//   {
//	   
//		s1=et1.getText().toString();
//	   s2=et2.getText().toString();
//		 new Thread(new job()).start(); 
//	  
//   }
//   class myhandler extends Handler
//   {
//	   @Override
//	public void handleMessage(Message msg) {
//		
//		 super.handleMessage(msg);   
//		if(msg.what==90)
//		{
//		//tv3.setText("connected");
//		 gba.username=s1;
//		  Intent in = new Intent(MainActivity.this,HomeActivity.class);
//			startActivity(in);
//		     }
//		else if(msg.what==91)
//		{
//			tv3.setText("not connected");
//		}
//	}
//   }
//   class job implements Runnable
//   {
//	   public void run() {   
//      try
//      {
//    	 Log.d("main","in run");
//    	  Socket sock=new Socket(gba.ip,8084);
//    	  Log.d("main","socket connected");
//    	  br=new BufferedReader(new InputStreamReader(sock.getInputStream()));
//	       pw=new PrintWriter(sock.getOutputStream());
//	   
//	    	
//	    	pw.println("GET /GPS/adminserver1 HTTP/1.1");
//	    	pw.println("HOST: "+gba.ip+":8084");
//	    	pw.println("");
//	        pw.flush();
//	    	while(true)
//	    	{
//	    	s3=br.readLine();    
//	    	if(s3.equals(""))
//	    	{
//	    		break;
//	    		
//	    	}
//	    	Log.d("MESSAGE", s3);
//	    	}
//	    	while(true)    
//	    	{
//	    		s3=br.readLine();
//		    	if(s3==null)
//		    	{
//		    		break;
//		    	}
//		    	Log.d("MESSAGE", s3);
//		    	
//	    	
//	    	if(s3.equals("login successful"))
//	    	{
//	    		mh.sendEmptyMessage(90);
//	    		break;
//	    	}
//	    	else
//	    	{
//	    		mh.sendEmptyMessage(91);
//	    		break;
//	    	}
//	    }
//      }
//      catch (Exception e)
//      {
//		Log.d("main", "in exception");
//		e.printStackTrace();
//		
//		
//      }	
//	}
//	   
//   }
//  
//}
package com.example.project;




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
	//GlobalApp gb;
  MYGlobalAPP gb;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		tv1=(TextView)(findViewById(R.id.tv1));
		tv2=(TextView)(findViewById(R.id.tv2));
        et1=(EditText)(findViewById(R.id.et1));
        et2=(EditText)(findViewById(R.id.et2));
        
        gb = ( MYGlobalAPP)getApplication();
        
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
		    	
			 
		Socket sock = new Socket(gb.ip,8084);
		DataInputStream dis = new DataInputStream(sock.getInputStream());
		DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
		        System.out.println("hello");
		        
		dos.writeBytes("GET /GPS/adminloginservlet?username="+ et1.getText().toString()+"&password="+et2.getText().toString()+" HTTP/1.1\r\n");
		dos.writeBytes("Host: "+gb.ip+":8084\r\n");
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
				MYGlobalAPP.username = et1.getText().toString();
					
					Intent in=new Intent(getBaseContext(),HomeActivity.class);
					
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

