package com.example.designtest;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;
import java.io.IOException;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.app.Service;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.IBinder;
import android.util.Log;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
public class BluetoothInterloper extends Service {

	BluetoothAdapter myBluetoothAdapter;
    BluetoothSocket myBTSocket;
    BluetoothDevice myBTDevice;
    InputStream btInputStream;
    OutputStream btOutputStream;
    Scanner btScanner;
    PrintStream btPrint;
    int btData;
    public BluetoothInterloper() {
    	
    }
    public void setup()
    {
    	
	    	  findBT();
	    	  try{
	    	  openBT();
	    	  }
	    	  catch(Exception e)
	    	  {Log.i("BADBADBAD","eRROR");
	    	  System.exit(0);
	    	  }
	    	 // blueOutputStream.
	    	  
	    
    }
    public void loop() {
	    // do something long
    	Log.i("RECIEVED",":Sdf");
	    Runnable runnable = new Runnable() {
	      @Override
	      public void run() {
	    	
	    	  while(true)
	    		  {
	    		 
	    	  	  try {
	    	  		
	    	  		   			
	    	  			 if(btScanner!=null&&btScanner.hasNextLine())
	    	  			 {	 sendToast();
	    	  			Log.i("Recieved",""+btScanner.nextLine());
	    	  			 }
	    	  			// Thread.sleep(10);	
				} catch (Exception e) {
					// TODO Auto-generated catch block
					 Log.e("ERROR","Things went bad");
				}
	    		  }
	      }
	    };
	    new Thread(runnable).start();
	  }
public void findBT() {
		
		//GAIN ACCESS TO BLUETOOTH RADIO
		myBluetoothAdapter =BluetoothAdapter.getDefaultAdapter();
		
		if(!myBluetoothAdapter.isEnabled()) {
			Intent enablebtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			 enablebtIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			 this.startActivity(enablebtIntent);
		}
		
		//Grab all currently paired bluetooth devices and look for our adapter named linvor and set as our device
	       Set<BluetoothDevice> pairedDevices = myBluetoothAdapter.getBondedDevices();
	         if(pairedDevices.size() > 0) {
	             for(BluetoothDevice device : pairedDevices) {
	              //Name of BT device
	                 if(device.getName().equals("HC-06")) {
	                     myBTDevice = device;
	                     break;
	                 }
	             }
	         }
		
	}
void openBT() throws IOException
{
    UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb"); //Standard SerialPortService ID
    myBTSocket = myBTDevice.createRfcommSocketToServiceRecord(uuid);        
    myBTSocket.connect();
    btOutputStream = myBTSocket.getOutputStream();
    btScanner = new Scanner(myBTSocket.getInputStream());
    Log.i("Connected","Connect");
}

@Override
public IBinder onBind(Intent arg0) {
	// TODO Auto-generated method stub
	return null;
}

public void sendToast()
{
	// will be overridden 
}
}
