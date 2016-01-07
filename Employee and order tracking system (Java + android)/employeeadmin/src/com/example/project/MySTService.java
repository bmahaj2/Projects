package com.example.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.util.Log;
  
public class MySTService extends Service {
	MYGlobalAPP gba;
	BufferedReader br;
	PrintWriter pw;
	String s1, deptname, username, subject, complaint, empid, empname,imei,lat,lng,t1,t2;

	public IBinder onBind(Intent intent) {

		return null;
	}

	public int onStartCommand(Intent intent, int flags, int startId) {

		gba = (MYGlobalAPP) getApplicationContext();
		if (gba.command.equals("getdept")) {
			new Thread(new viewdept()).start();
			new Thread(new getemployee()).start();
			
		} else if (gba.command.equals("getcomplaint")) {
			new Thread(new getcomplaint()).start();
		} else if (gba.command.equals("getemployee")) {
			new Thread(new getemployee()).start();
		}
		else if (gba.command.equals("getimei")) {
			new Thread(new getemployee()).start();
			new Thread(new getimei()).start();
			
		}
		else if(gba.command.equals("getlocation"))
		{
			new Thread(new getlocation()).start();
		}
		else if(gba.command.equals("getofftrack"))
		{
			new Thread(new getofftrack()).start();
		}
		
		return START_STICKY;
	}

	class viewdept implements Runnable {

		@Override
		public void run() {
			try {

				Log.d("main", "in run");
				Socket sock = new Socket(gba.ip, 8084);
				Log.d("main", "socket connected");
				br = new BufferedReader(new InputStreamReader(
						sock.getInputStream()));
				pw = new PrintWriter(sock.getOutputStream());

				pw.println("GET /GPS/deptserver1 HTTP/1.1");
				pw.println("HOST: " + gba.ip + ":8084");
				pw.println("");
				pw.flush();
				while (true) {
					s1 = br.readLine();
					if (s1.equals("")) {
						break;

					}
				}

				deptname = br.readLine();

				Log.d("MSG", deptname);

				StringTokenizer st1 = new StringTokenizer(deptname, "~");

				gba.al.clear();
				while (st1.hasMoreTokens()) {
					gba.al.add(new String(st1.nextToken()));

				}
			}

			catch (Exception e) {
				Log.d("main", "in exception");
				e.printStackTrace();
			}
			Intent i = new Intent("dept");
	           sendBroadcast(i);
		}
		
	}

	class getcomplaint implements Runnable {

		@Override
		public void run() {
			try {

				Log.d("main", "in run");
				Socket sock = new Socket(gba.ip, 8084);
				Log.d("main", "socket connected");
				br = new BufferedReader(new InputStreamReader(
						sock.getInputStream()));
				pw = new PrintWriter(sock.getOutputStream());

				pw.println("GET /GPS/admincomplaintserver HTTP/1.1");
				pw.println("HOST: "+gba.ip+":8084");
				pw.println("");
				pw.flush();
				while (true) {
					s1 = br.readLine();
					if (s1.equals("")) {
						break;

					}
				}

				username = br.readLine();
				subject = br.readLine();
				complaint = br.readLine();

				Log.d("MSG", username);

				StringTokenizer st1 = new StringTokenizer(username, "~");
				StringTokenizer st2 = new StringTokenizer(subject, "~");
				StringTokenizer st3 = new StringTokenizer(complaint, "~");

				gba.al1.clear();
				while (st1.hasMoreTokens()) {
					gba.al1.add(new complaint(st1.nextToken(), st2.nextToken(),
							st3.nextToken()));

				}
				Intent i = new Intent("complaint");
		           sendBroadcast(i);
                    Thread.sleep(500);
				Intent in1 = new Intent(getApplicationContext(),ComplaintActivity.class);
				in1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(in1);
			}

			catch (Exception e) {
				Log.d("main", "in exception");
				e.printStackTrace();
			}

		}
	}


	class getemployee implements Runnable {

		@Override
		public void run() {
			try {
				while (true) {
					if (gba.command.equals("employee")) {
						Log.d("msg", gba.dept);
						Log.d("main", "ankita");
						Socket sock = new Socket(gba.ip, 8084);
						Log.d("main", "socket connected");
						br = new BufferedReader(new InputStreamReader(
								sock.getInputStream()));
						pw = new PrintWriter(sock.getOutputStream());

						pw.println("GET /GPS/employeeserver?dept="+ gba.dept + " HTTP/1.1");
						pw.println("HOST: "+gba.ip+":8084");
						pw.println("");
						pw.flush();
						gba.command = "";

						while (true) {
							s1 = br.readLine();
							if (s1==null || s1.equals("")) {
								break;

							}
							Log.d("hello", "byee");
						}

						gba.empid = br.readLine();
						gba.empname = br.readLine();

						Log.d("empid", gba.empid);
						Log.d("empid", gba.empname);

						StringTokenizer st1 = new StringTokenizer(gba.empid, "~");
						StringTokenizer st2 = new StringTokenizer(gba.empname, "~");

						gba.al2.clear();
						while (st1.hasMoreTokens()) {
							gba.al2.add(new employee(st1.nextToken(), st2.nextToken()));

						}
						Intent i = new Intent("emp");
				           sendBroadcast(i);
					}

				}
			}

			catch (Exception e) {
				Log.d("main", "in exception");
				e.printStackTrace();
			}

		}
	}
	class getimei implements Runnable {

		@Override
		public void run() {
			try {
				
					Log.d("hello", "oye");
						Socket sock = new Socket(gba.ip, 8084);
						Log.d("main", "socket connected");
						br = new BufferedReader(new InputStreamReader(
								sock.getInputStream()));
						pw = new PrintWriter(sock.getOutputStream());

						pw.println("GET /GPS/imeiserver?eid="
								+ gba.eid + " HTTP/1.1");
						pw.println("HOST: "+gba.ip+":8084");
						pw.println("");
						pw.flush();
						
						
						while (true) {
							s1 = br.readLine();
							if (s1.equals("")) {
								break;

							}
							
						}
                         
					    imei=br.readLine();
					    Log.d("hello", imei);
					    StringTokenizer st1 = new StringTokenizer(imei, "~");
						

						gba.al3.clear();
						while (st1.hasMoreTokens()) {
							gba.al3.add(new String(st1.nextToken()));

						}
						Intent in1 = new Intent(getApplicationContext(),OnlineActivity2.class);
						in1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						startActivity(in1);

						
					

				
			}

			catch (Exception e) {
				Log.d("main", "in exception");
				e.printStackTrace();
			}

		}
	}
	class getlocation implements Runnable {

		@Override
		public void run() {
			try {
				
						Socket sock = new Socket(gba.ip, 8084);
						Log.d("main", "socket connected");
						br = new BufferedReader(new InputStreamReader(
								sock.getInputStream()));
						pw = new PrintWriter(sock.getOutputStream());

						pw.println("GET /GPS/locationserver?imei="
								+ gba.imei + " HTTP/1.1");
						pw.println("HOST: "+gba.ip+":8084");
						pw.println("");
						pw.flush();
						Log.d("hello", "dffa ho");

						while (true) {
							s1 = br.readLine();
							if (s1.equals("")) {
								break;

							}
							
						}
                         
					   gba.lat=br.readLine();
					   gba.lng=br.readLine();
					    
					    Log.d("hello",gba.lat);
					   
					    Intent i = new Intent("location");
				           sendBroadcast(i);
				           Thread.sleep(500);
					  
						
						

						
					

				
			}

			catch (Exception e) {
				Log.d("main", "in exception");
				e.printStackTrace();
			}

		}
	}

	class getofftrack implements Runnable {

		@Override
		public void run() {
			try {
				
						
						Socket sock = new Socket(gba.ip, 8084);
						Log.d("main", "socket connected");
						br = new BufferedReader(new InputStreamReader(
								sock.getInputStream()));
						pw = new PrintWriter(sock.getOutputStream());

						pw.println("GET /GPS/offtrackserver?imei="+gba.imei+"&from="+gba.from+"&to="+gba.to+" HTTP/1.1");
						pw.println("HOST: "+gba.ip+":8084");
						pw.println("");
						pw.flush();
						
						Log.d("Offline","after flush");
						while (true) {
							s1 = br.readLine();
							if (s1.equals("")) {
								break;
							}
							Log.d("hello", "gotogo");
						}

					    lat= br.readLine();
						lng= br.readLine();

						Log.d("lat", lat);

						StringTokenizer st1 = new StringTokenizer(lat, "~");
						StringTokenizer st2 = new StringTokenizer(lng, "~");

						gba.al4.clear();
						while (st1.hasMoreTokens()) {
							gba.al4.add(new offtrack(st1.nextToken(),st2.nextToken()));

					

				}
						Intent i = new Intent("offtrack");
				           sendBroadcast(i);
								
						Thread.sleep(500);
				
			   
			}

				catch (Exception e) {
				Log.d("main", "in exception");
				e.printStackTrace();
			}

		}
	}
	


}
