package com.example.project;


import com.example.project.R;
import com.example.project.ComplaintActivity.myadapter;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class EmpActivity1 extends Activity {
MYGlobalAPP gba;
ListView lv1;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.emp_activity1);
		gba=(MYGlobalAPP)getApplicationContext();
		lv1=(ListView)findViewById(R.id.listView3);
		myadapter ad=new myadapter();
		lv1.setAdapter(ad);
		ad.notifyDataSetChanged();
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
