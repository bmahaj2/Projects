package com.example.project;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class LocationActivity extends FragmentActivity {
MYGlobalAPP gba;
int status;
GoogleMap map;

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.location);
		gba=(MYGlobalAPP)getApplicationContext();
		
		status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
	    
	    Toast.makeText(this, "Play services status "+status,Toast.LENGTH_LONG).show();
	
	}
	protected void onResume() 
	{
		super.onResume();
	
		if(status==0)   // 0 Indicates Google Play Services are Available
	    {
	       if(map==null) // if memory is not already to maps      
	       {
	    	   map=((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mymap)).getMap();
	       }
	       
	       if(map!=null)
	       {
	    	   map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
	    	   
	    	   map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(Double.parseDouble(gba.lat),Double.parseDouble(gba.lng))));
	    	   
	    	   map.animateCamera(CameraUpdateFactory.zoomTo(15));  //value should be 2 to 21
	    	   
	    	   MarkerOptions markerOptions = new MarkerOptions();
	    	   markerOptions.position(new LatLng(Double.parseDouble(gba.lat),Double.parseDouble(gba.lng)));
	    	   markerOptions.snippet("Welcome to Amritsar");
	    	   markerOptions.title("AMRITSAR");
	    	   
	    	   Marker marker = map.addMarker(markerOptions);
	    	   	    	   
	       }
	       else
	       {
	    	   // map may be null if there is no play services, or if SupportMapFragment
	    	   // code is invalid either in xml or in Java Code or manifest entries are missing
	    	   
	    	   Toast.makeText(this, "MAP IS NULL", 2000).show();
	       }
	    }
		else
		{
			Toast.makeText(this, "google play services is \nnot available/ out of date",2000).show();
		}
	}
	

}
