package com.example.project;

import com.example.project.TrackActivity.MyBroadcast;

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

public class TrackActivity extends Activity {
	ProgressDialog pb;
	MyBroadcast br,br1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.track);
		 pb=new ProgressDialog(this);
		   	br=new MyBroadcast();
			br1=new MyBroadcast();
			pb.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	}
class MyBroadcast extends BroadcastReceiver
	
	{
		public void onReceive(Context arg0, Intent arg1) {
			// TODO Auto-generated method stub
			Log.d("hello","broadcast");
			
          }
		
	}
	protected Dialog onCreateDialog(int id )
	{
		
		return pb;
		
	}
	
	protected void onResume()
	{
		super.onResume();
		IntentFilter infilter=new IntentFilter("location");
		registerReceiver(br,infilter);
		IntentFilter infilter1=new IntentFilter("offtrack");
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
		Intent in=new Intent(this,LocationActivity.class);
		startActivity(in);
	}
	public void go1(View v)
	{
		Intent in=new Intent(this,OfflineActivity.class);
		startActivity(in);
	}
	

}
