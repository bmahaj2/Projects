package com.example.project;


import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.Menu;


public class WelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
	    	Intent in=new Intent(this,MySTService.class);
	    	startService(in);
	    	Intent in1=new Intent(this,MainActivity.class);
	        startActivity(in1);
	    	
	}

    
}
