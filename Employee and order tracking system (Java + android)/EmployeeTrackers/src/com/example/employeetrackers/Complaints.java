package com.example.employeetrackers;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import com.example.employeetrackers.MainActivity.myhandler;
import com.example.employeetrackers.MainActivity.myjob;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Complaints extends Activity 
{
	EditText et1,et2,et3,et4;
	TextView tv1;
	myhandler mh;
	GlobalApp gb;
	Spinner sp;
	String add;
	ArrayList<String> al=new ArrayList<String>();	 
	ArrayAdapter<String> ad;
	    
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_complaints);
		sp=(Spinner)(findViewById(R.id.spinner1));
		mh = new myhandler();
		al.add("Marketing");
	    al.add("Sales");
	    al.add("Production");
	    al.add("Purchase");
	    tv1 = (TextView)findViewById(R.id.tv1);
	    
	    ad=new ArrayAdapter<String>(this,
	    		  R.layout.singlerow,R.id.tv1,al);
	    
	    sp.setAdapter(ad);
	    
	    sp.setOnItemSelectedListener(new OnItemSelectedListener()
	    {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long arg3) 
			{
//				Toast.makeText(getApplicationContext(),
//						al.get(pos)+" selected", 2000).show();	
				
				add=al.get(pos);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		   
	    });
	    et1=(EditText)(findViewById(R.id.et1));
        et2=(EditText)(findViewById(R.id.et2));
        et3=(EditText)(findViewById(R.id.et3));
        et4=(EditText)(findViewById(R.id.et4));

        gb = (GlobalApp)getApplication();
        
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
		dos.writeBytes("GET /GPS/ComplaintServlet?username="+ GlobalApp.username+"&email="+et1.getText().toString()+"&phone="+et2.getText().toString()+"&department="+add+"&complaint_subject="+et3.getText().toString()+"&complaint="+et4.getText().toString()+"+ HTTP/1.1\r\n");
		dos.writeBytes("Host:GlobalApp.ip:8084\r\n");
		dos.writeBytes("\r\n");
	

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
			tv1.setText("complaint submitted");
		}
	}
		

}










