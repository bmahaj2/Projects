package com.example.project;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DeptActivity extends Activity {
MYGlobalAPP gba;
ListView lv;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dept);
		gba=(MYGlobalAPP)getApplicationContext();
	  lv=(ListView)findViewById(R.id.listView1);
	 
	
	  ArrayAdapter<String>ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,gba.al);	
	  lv.setAdapter(ad);
	}
	

}
