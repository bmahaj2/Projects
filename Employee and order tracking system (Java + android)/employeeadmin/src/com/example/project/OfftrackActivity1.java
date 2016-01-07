package com.example.project;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class OfftrackActivity1 extends FragmentActivity {
	int status;
	GoogleMap theMap;
	Marker userMarker;
	double lat;
	double lng;
	PolylineOptions rectOptions;
	MYGlobalAPP gb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.offtrack_activity1);
		gb = (MYGlobalAPP)(getApplicationContext());
		rectOptions = new PolylineOptions();
		for(int i = 0;i<gb.al4.size();i++)
		{
			
	        rectOptions.add(new LatLng(Double.parseDouble(gb.al4.get(i).lat), Double.parseDouble(gb.al4.get(i).lng)));
	        Log.d("Poly",Double.parseDouble(gb.al4.get(i).lat)+" and		"+ Double.parseDouble(gb.al4.get(i).lng)+"");
		}
		
		
		status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
		Toast.makeText(this, "Play Service Status is " + status,
				Toast.LENGTH_SHORT).show();
// Get back the mutable Polyline
	}
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if (status == 0) {
			if (theMap == null) {
				theMap = ((SupportMapFragment) getSupportFragmentManager()
						.findFragmentById(R.id.mymap1)).getMap();
			}
			if (theMap != null) {
				theMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
				if (userMarker != null) {
					userMarker.remove();
				}
				//userMarker = theMap.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(gb.al4.get(0).lat), Double.parseDouble(gb.al4.get(0).lng)))
					//	.title("Rakesh Sharma")
						//.icon(BitmapDescriptorFactory.fromResource(userIcon))
						//.snippet("Queens Road,Amritsar"));
				
				theMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(Double.parseDouble(gb.al4.get(0).lat), Double.parseDouble(gb.al4.get(0).lng))));
				theMap.animateCamera(CameraUpdateFactory.zoomTo(14));
				Polyline polyline = theMap.addPolyline(rectOptions);
				polyline.setColor(Color.RED);

			} else {
				// map may be null if there is no play services, or if
				// SupportMapFragment
				// code is invalid either in xml or in Java Code or manifest
				// entries are missing
				Toast.makeText(this, "MAP IS NULL", 2000).show();
			}

		}

		else {
			Toast.makeText(this,
					"google play services is \nnot available/ out of date",
					2000).show();
		}
	// Instantiates a new Polyline object and adds points to define a rectangle
	
	}
}
