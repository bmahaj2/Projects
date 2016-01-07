package com.example.project;

import com.example.project.OfflineActivity.MyBroadcast;

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
import android.widget.EditText;

public class OfflineActivity extends Activity {
EditText et1,et2;
MYGlobalAPP gba;
ProgressDialog pb;
MyBroadcast br;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.offline);
		gba=(MYGlobalAPP)getApplicationContext();
		et1=(EditText)findViewById(R.id.offeditText1);
		et2=(EditText)findViewById(R.id.offeditText2);
		 pb=new ProgressDialog(this);
		 pb.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			br=new MyBroadcast();

	}
class MyBroadcast extends BroadcastReceiver
	
	{
		public void onReceive(Context arg0, Intent arg1) {
			// TODO Auto-generated method stub
			Log.d("hello","broadcast");
			pb.dismiss();
			Intent in=new Intent(getApplicationContext(),OfftrackActivity1.class);
			startActivity(in);
          }
		
	}
	protected Dialog onCreateDialog(int id )
	{
		
		return pb;
		
	}
	
	protected void onResume()
	{
		super.onResume();
		IntentFilter infilter=new IntentFilter("offtrack");
		registerReceiver(br,infilter);
		
		
		
	}
	protected void onPause()
	{
		unregisterReceiver(br);
		
		super.onPause();
	}

	public void go(View v)
	
	{

		
		gba.from=et1.getText().toString();
		gba.to=et2.getText().toString();
		gba.command="getofftrack";
			
		Log.d("offline", "go");
		pb.show();
		Intent i1=new Intent(getApplicationContext(),MySTService.class);
		startService(i1);
		
		
	}
}
