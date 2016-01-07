package com.example.project;

import com.example.project.HomeActivity.MyBroadcast;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class EmpActivity extends Activity {
 MYGlobalAPP gba;
 Spinner sp;
 ProgressDialog pb;
 MyBroadcast br;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.emp);
		gba=(MYGlobalAPP)getApplicationContext();
		sp=(Spinner)findViewById(R.id.spinner1);
		 ArrayAdapter<String>ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,gba.al);	
		  sp.setAdapter(ad);
		  pb=new ProgressDialog(this);
		   	br=new MyBroadcast();
			pb.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		  
	sp.setOnItemSelectedListener(new OnItemSelectedListener()
	{

		@Override
		public void onItemSelected(AdapterView<?> av, View v, int i,
				long id) {
			gba.dept=gba.al.get(i);
			gba.command="employee";
			 
			   Log.d("msg",gba.dept); 
			 
				showDialog(0);
				
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		
		
	});
	}
	class MyBroadcast extends BroadcastReceiver
	
	{

		@Override
		public void onReceive(Context arg0, Intent arg1) {
			// TODO Auto-generated method stub
			Log.d("hello","broadcast");
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
		IntentFilter infilter=new IntentFilter("emp");
		registerReceiver(br,infilter);
		
	}
	protected void onPause()
	{
		unregisterReceiver(br);
		super.onPause();
	}
	
	 public void go(View v)
		{
		  
		 Intent in1 = new Intent(getApplicationContext(),EmpActivity1.class);
			startActivity(in1);
			
		}
}
