package com.example.employeetrackers;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
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

public class Self_track extends FragmentActivity implements LocationListener
{
	int status;
	GoogleMap map;
	LocationManager locationManager;
	double lng;
    double lat;
    Marker marker;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_self_track);
	
	    status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
	    
	    
	    Toast.makeText(this, "Play services status "+status,Toast.LENGTH_LONG).show();
	    locationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
        Location loc =  locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        lat = loc.getLatitude();
        lng = loc.getLongitude();
        
	}
	
	@Override
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
	    	   
	    	   map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(lat, lng)));
	    	   
	    	   map.animateCamera(CameraUpdateFactory.zoomTo(5));  //value should be 2 to 21
	    	   
	    	   MarkerOptions markerOptions = new MarkerOptions();
	    	   markerOptions.position(new LatLng(lat, lng));
	    	   //markerOptions.snippet("Welcome to Amritsar");
	    	   //markerOptions.title("AMRITSAR");
	    	   marker = map.addMarker(markerOptions);
	    	   	    	   
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

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		lng = location.getLongitude();
        lat = location.getLatitude();
        marker.setPosition(new LatLng(lat, lng));
        
	}
	

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}

}
