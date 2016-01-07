package com.example.employeetrackers;

import java.util.ArrayList;

import android.app.Application;

public class GlobalApp extends Application
{
	 static boolean flag=false;
     static String ip="192.168.1.3";
	 static boolean msgflag=false;
     static String username;
     
     static ArrayList<MessageDate> msgal=new ArrayList <MessageDate>();
     
     
}
