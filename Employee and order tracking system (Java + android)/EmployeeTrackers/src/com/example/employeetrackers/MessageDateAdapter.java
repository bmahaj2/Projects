package com.example.employeetrackers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MessageDateAdapter extends BaseAdapter
{
	//ArrayList referred from GlobalApp and elements are added by server 
    //using the service MessageFetchingService.java
	
	@Override
	public int getCount()   //No. of Rows or Elements in the List
	{
		return GlobalApp.msgal.size();
	}

	@Override
	public Object getItem(int i) //Item at ith position in the list
	{
		return GlobalApp.msgal.get(i);
	}

	@Override
	public long getItemId(int position) //Assign unique id to each element of the list
	{
		return position*10;
	}

	@Override
	public View getView(int i, View convertView, ViewGroup parent) //TextView
	{
		if(convertView==null)  //If no memory given to xml file
		{
			//Allocates memory to xml file
			LayoutInflater inflater=LayoutInflater.from(parent.getContext());//It's java class file not activity ,so it doesn't has context
            convertView=inflater.inflate(R.layout.msg_list_adapter,parent,false);		
		}
		
		MessageDate md=GlobalApp.msgal.get(i); //Get ith Message
		
		TextView date_time,message;
		date_time=(TextView)(convertView.findViewById(R.id.txtdate));
		message=(TextView)(convertView.findViewById(R.id.txtmsg));
		
		date_time.setText(GlobalApp.msgal.get(i).date);
		message.setText(GlobalApp.msgal.get(i).message);
	    return convertView;
	}

}
