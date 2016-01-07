package com.example.employeetrackers;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class AfterLogin extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_after_login);
	}

	public void go(View v) 
	{

		Intent in = new Intent(this, MyStickyService.class);
		startService(in);

	}

	public void go2(View v) {

		Intent in = new Intent(this, Complaints.class);
		startActivity(in);

	}

	public void go3(View v) {

		Intent in = new Intent(this, MessageDate2List.class);
		startActivity(in);

	}
	public void go4(View v)
	{

		Intent in = new Intent(this,Self_track.class);
		startActivity(in);
		
		

	}
	

	public void go5(View v) 
	{
		
		Intent in = new Intent(this,Logout.class);
		startActivity(in);

	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.after_login, menu);
		return true;
	}

}
