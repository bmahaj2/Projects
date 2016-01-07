package com.example.project;


import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

public class HomeActivity extends Activity {
 MYGlobalAPP gba;
 EditText et1,et2;
 ProgressDialog pb;
 MyBroadcast br;
 MyBroadcast br1;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		gba=(MYGlobalAPP)getApplicationContext();
	  	gba.command="getdept";
	  	pb=new ProgressDialog(this);
	  	pb.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	   	br=new MyBroadcast();
	  
		br1=new MyBroadcast();
	 	showDialog(0);
	  	Intent in=new Intent(this,MySTService.class);
	   	startService(in);
	   	
	   	
	     }
	class MyBroadcast extends BroadcastReceiver
	{

		@Override
		public void onReceive(Context arg0, Intent arg1) {
			// TODO Auto-generated method stub
			dismissDialog(0);
			
			
		}
		 
	}
	protected Dialog onCreateDialog(int id )
	{
		
			return pb;
		
	}
	
	protected void onResume()
	{
		super.onResume();
		IntentFilter infilter=new IntentFilter("dept");
		registerReceiver(br,infilter);
		IntentFilter infilter1=new IntentFilter("complaint");
		registerReceiver(br1,infilter1);
	}
	protected void onPause()
	{
		unregisterReceiver(br);
		unregisterReceiver(br1);
		super.onPause();
	}
	
	public void go(View v)
	{
		
		Intent in1 = new Intent(getApplicationContext(),DeptActivity.class);
		startActivity(in1);
	}
	
	public void go1(View v)
		{
		   	gba.command="getcomplaint";
		   	showDialog(0);
		  	Intent in=new Intent(this,MySTService.class);
		   	startService(in);
		  }
	   
	  
	public void go2(View v)
		{
			Intent in1 = new Intent(getApplicationContext(),EmpActivity.class);
			startActivity(in1);
		}

	   
	public void go3(View v)
		{
		
		  Intent in1 = new Intent(getApplicationContext(),MessageActivity.class);
			startActivity(in1);
			
		}
	   
	
	public void go4(View v)
		{
		
		
		   //gba.command="getimei";
		  Intent in1 = new Intent(getApplicationContext(),OnlineActivity.class);
			startActivity(in1);
		}
	

	public void go5(View v)
	
	{
	   //gba.command="getimei";
	  Intent in1 = new Intent(getApplicationContext(),AboutActivity.class);
		startActivity(in1);
	}
	
	   

}
