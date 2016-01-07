package com.example.employeetrackers;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

//List showing messages--Custom List
/*1)For Messages ArrayList is made using MessageDate class (date,message) is made
  2)Make xml file and give it memory using LayoutInflater in Adapter
  3)Custom Adapter MessageDateAdapter.java
  4)ListView Activity--MessageDate2List.java
*/

public class MessageDate2List extends Activity 
{
	ListView listmsg;
	MessageDateAdapter ad;
	mybroadcast br;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.message_date2_list);
		br = new mybroadcast();
		listmsg=(ListView)(findViewById(R.id.listmsg));
		
		Intent in = new Intent(this , MessageFetchingService.class);
		startService(in);
	
		Log.d("MySa","Activity Started");
		
		ad=new MessageDateAdapter();
		listmsg.setAdapter(ad);
		
		listmsg.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) 
			{
				listmsg.setBackgroundColor(5);
			}
			
		});
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		IntentFilter in = new IntentFilter("messages");
		registerReceiver(br, in);
		
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		unregisterReceiver(br);
	}
	
	class mybroadcast extends BroadcastReceiver
	{

		@Override
		public void onReceive(Context arg0, Intent arg1) {
			// TODO Auto-generated method stub
			ad.notifyDataSetChanged();
		}
		
	}
}
