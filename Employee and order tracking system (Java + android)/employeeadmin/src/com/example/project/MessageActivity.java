package com.example.project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.example.project.HomeActivity.MyBroadcast;
import com.example.project.MessageActivity.myadapter;
import com.example.project.MessageActivity.sendmsg;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MessageActivity extends Activity {
	MYGlobalAPP gba;
	Spinner sp;
	ListView lv1;
	EditText et1;
	String msg;
	BufferedReader br;
	PrintWriter pw;
	myadapter ad;
	myhandler mh;
	ProgressDialog pb;
	TextView tv;
	MyBroadcast brr;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.message);
		gba = (MYGlobalAPP) getApplicationContext();
		sp = (Spinner) findViewById(R.id.msgspinner);
		brr = new MyBroadcast();
		ArrayAdapter<String> ad1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, gba.al);
		sp.setAdapter(ad1);
		lv1 = (ListView) findViewById(R.id.msglv1);
		et1 = (EditText) findViewById(R.id.msget1);
		mh = new myhandler();
		tv = (TextView) findViewById(R.id.messagetv);
		ad = new myadapter();
		lv1.setAdapter(ad);
		pb = new ProgressDialog(this);
		pb.setProgressStyle(ProgressDialog.STYLE_SPINNER);

		ad.notifyDataSetChanged();
		sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> av, View v, int i, long id) {
				gba.dept = gba.al.get(i);
				gba.command = "employee";
				// ad.notifyDataSetChanged();
				Log.d("msg", gba.dept);
				pb.show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});
	}

	protected Dialog onCreateDialog(int id) {

		return pb;

	}

	class myhandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (msg.what == 91) {
				tv.setText("Message Sent Successfully");
			}
			else
			{
				tv.setText("Message Sending Failed");
			}
		}
	}
class MyBroadcast extends BroadcastReceiver
	
	{

		@Override
		public void onReceive(Context arg0, Intent arg1) {
			// TODO Auto-generated method stub
			Log.d("hello","broadcast");
			pb.dismiss();
			ad.notifyDataSetChanged();
		}
		
	}

protected void onResume()
{
	super.onResume();
	IntentFilter infilter=new IntentFilter("emp");
	registerReceiver(brr,infilter);
	
}
protected void onPause()
{
	unregisterReceiver(brr);
	super.onPause();
}


	class sendmsg implements Runnable {
		@Override
		public void run() {
			try {

				Log.d("main", "message send");
				Socket sock = new Socket(gba.ip, 8084);
				Log.d("main", "socket connected");
				br = new BufferedReader(new InputStreamReader(
						sock.getInputStream()));
				pw = new PrintWriter(sock.getOutputStream());
				String q = "msg=" + msg + "&empid=" + gba.empid + "&empname="
						+ gba.empname;
				q = q.replaceAll(" ", "_");
				pw.println("GET /GPS/adminmessageserver?" + q + " HTTP/1.1");
				pw.println("HOST: " + gba.ip + ":8084");
				pw.println("");
				pw.flush();
				while (true) {
					String s3 = br.readLine();
					if (s3.equals("")) {
						break;

					}

					Log.d("MESSAGE", s3);
					mh.sendEmptyMessage(91);

				}

			}

			catch (Exception e) {
				Log.d("main", "in exception");
				e.printStackTrace();
				mh.sendEmptyMessage(99);

			}

		}
	}

	class myadapter extends BaseAdapter {

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

			return 10 * i;
		}

		@Override
		public View getView(int i, View singlerow2, ViewGroup parent) {
			if (singlerow2 == null) {
				LayoutInflater inflator = LayoutInflater.from(parent
						.getContext());
				singlerow2 = inflator.inflate(R.layout.singlerow1, parent,
						false);
			}
			TextView tv1, tv2;
			tv1 = (TextView) (singlerow2.findViewById(R.id.tvsinglerow1));
			tv2 = (TextView) (singlerow2.findViewById(R.id.tvsinglerow2));

			employee md = gba.al2.get(i);
			tv1.setText(md.empid);
			tv2.setText(md.empname);

			// TODO Auto-generated method stub
			return singlerow2;
		}

	}

	public void go(View v) {

		msg = et1.getText().toString();
		new Thread(new sendmsg()).start();
		showDialog(0);
	}
}
