package com.example.project;

import java.util.List;

import com.example.project.OnlineActivity.MyBroadcast;

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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class OnlineActivity2 extends Activity {
MYGlobalAPP gba;
ListView lv;
ProgressDialog pb;
MyBroadcast br;

protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.online_activity2);
		gba=(MYGlobalAPP)getApplicationContext();
	  lv=(ListView)findViewById(R.id.onlistView1);
	 
	
	  ArrayAdapter<String>ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,gba.al3);	
	  lv.setAdapter(ad);
	  pb=new ProgressDialog(this);
	   	br=new MyBroadcast();
		pb.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	  lv.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> av, View v, int i,
		     long arg3) {
			
				
				gba.imei=gba.al3.get(i);
			gba.command="getlocation";
			showDialog(0);
			Intent i1=new Intent(getApplicationContext(),MySTService.class);
			startService(i1);
			Intent in1 = new Intent(getApplicationContext(),TrackActivity.class);
			startActivity(in1);
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

}
