package com.example.employeetrackers;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import com.example.employeetrackers.MainActivity.myhandler;
import com.example.employeetrackers.MainActivity.myjob;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.widget.EditText;

public class MyStickyService extends Service implements LocationListener
{
	LocationManager locationManager;
    EditText tvLatitude, tvLongitude;
    String provider;
    Location location;
    
    double lng;
    double lat;
    String imei;
	@Override
	public IBinder onBind(Intent arg0)
	{
		// TODO Auto-generated method stub
		return null;
	}
	public int onStartCommand(Intent intent,int flags,int startId)
	{
		 locationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
	        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0,this);
	        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
	        imei=telephonyManager.getDeviceId();
	        new Thread(new myjob()).start();
		return START_STICKY;
		
	}
	class myjob implements Runnable
	{
		public void run()
		{
			 try
			 {
				Socket sock=new Socket(GlobalApp.ip,8084);	
			//Socket sock = new Socket("192.168.137.222",8084);
			DataInputStream dis = new DataInputStream(sock.getInputStream());
			DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
		    System.out.println("hello");
			while(true)
			{  
				dos.writeBytes("GET /GPS/track_EmpHistory?username="+ GlobalApp.username+"&latitude="+lat+"&longitude="+lng+"&imei="+imei+" HTTP/1.1\r\n");
				//dos.writeBytes("Host:192.168.137.152:8084\r\n");
	            dos.writeBytes("Host: +"+GlobalApp.ip+":8084\r\n");

				dos.writeBytes("\r\n");
				try
					{
						Thread.sleep(5000);
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
			}
			
			 }
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		}
	}
	@Override
	public void onLocationChanged(Location location)
	{
		// TODO Auto-generated method stub

        lng = location.getLongitude();
        lat = location.getLatitude();
		
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
