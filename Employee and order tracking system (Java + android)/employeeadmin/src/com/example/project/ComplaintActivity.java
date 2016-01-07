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

public class ComplaintActivity extends Activity {
MYGlobalAPP gba;
ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.complaint);
		gba=(MYGlobalAPP)getApplicationContext();
		lv=(ListView)findViewById(R.id.listView2);
		myadapter ad=new myadapter();
		lv.setAdapter(ad);
	}

	 class myadapter extends BaseAdapter
     {
         @Override
		public int getCount() {
			// TODO Auto-generated method stub
			return gba.al1.size();
		}

		@Override
		public Object getItem(int i) {
			// TODO Auto-generated method stub
			return gba.al1.get(i);
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
				singlerow2 = inflator.inflate(R.layout.singlerow,parent,false);
			}
			TextView tv1,tv2,tv3;
			tv1=(TextView)(singlerow2.findViewById(R.id.tv1singlerow));
			tv2=(TextView)(singlerow2.findViewById(R.id.tv2singlerow));
			tv3=(TextView)(singlerow2.findViewById(R.id.tv4singlerow));
			complaint md=gba.al1.get(i);
			tv1.setText(md.subject);
			tv2.setText(md.username);
			tv3.setText(md.complaint);
			// TODO Auto-generated method stub
			return singlerow2;
		}
    	 
     }

}
