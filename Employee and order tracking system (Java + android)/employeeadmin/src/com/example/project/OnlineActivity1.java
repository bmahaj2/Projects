package com.example.project;


import com.example.project.R;
import com.example.project.ComplaintActivity.myadapter;
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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class OnlineActivity1 extends Activity {
MYGlobalAPP gba;
ListView lv1;
ProgressDialog pb;
MyBroadcast br;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.online_activity1);
		gba=(MYGlobalAPP)getApplicationContext();
		lv1=(ListView)findViewById(R.id.onlistView);
		myadapter ad=new myadapter();
		lv1.setAdapter(ad);
		 pb=new ProgressDialog(this);
		   	br=new MyBroadcast();
			pb.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		
		//ad.notifyDataSetChanged();
		lv1.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> av, View v, int i,
					long arg3) {
			gba.eid=gba.al2.get(i).empid;
			gba.ename=gba.al2.get(i).empname;
			gba.command="getimei";
			showDialog(0);
			Intent i1=new Intent(getApplicationContext(),MySTService.class);
			startService(i1);
				
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
	
	

	 class myadapter extends BaseAdapter
     {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return gba.al2.size();
		}

		@Override
		public Object getItem(int i) {
			// TODO Auto-generated method stub
			return gba.al2.get(i);
		}

		@Override
		public long getItemId(int i) {
			// TODO Auto-generated method stub
			
			return 10*i;
		}

		@Override
		public View getView(int i, View singlerow2, ViewGroup parent) {
			if(singlerow2==null)
			{
				LayoutInflater inflator=LayoutInflater.from(parent.getContext());
				singlerow2 = inflator.inflate(R.layout.singlerow1,parent,false);
			}
			TextView tv1,tv2;
			tv1=(TextView)(singlerow2.findViewById(R.id.tvsinglerow1));
			tv2=(TextView)(singlerow2.findViewById(R.id.tvsinglerow2));
			
			employee md=gba.al2.get(i);
			tv1.setText(md.empid);
			tv2.setText(md.empname);
			
			// TODO Auto-generated method stub
			return singlerow2;
		}
    	 
     }

}
