package com.example.designtest;

import android.os.Bundle;
import android.os.Handler;
import android.annotation.SuppressLint;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.widget.Toast;
import android.app.ActionBar;
import android.util.Log;
@SuppressLint("NewApi")
public class MainActivity extends FragmentActivity implements ActionBar.TabListener{

	private int counter;
	private ViewPager viewPager;
	private TabsPagerAdapter mAdapter;
	private ActionBar actionBar;
	private String[] tabs={"Settings", "Charts","Shots"};
	private BluetoothInterloper btInterlope = new BluetoothInterloper();
	Handler handler;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		    btInterlope = new BluetoothInterloper() {
		    	public void sendToast()
		    	{
		            counter+=1;
		    		//Log.i("Alert",""+counter);
		    		//makeToast();
		    		grab();
		    		
		    	}
		    	
		    };
		    btInterlope.setup();
		    btInterlope.loop();
		    viewPager = (ViewPager) findViewById(R.id.pager);
	        actionBar = getActionBar();
	        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
	 
	        viewPager.setAdapter(mAdapter);
	        actionBar.setDisplayShowHomeEnabled(true);
	        actionBar.setHomeButtonEnabled(true);
	        actionBar.setDisplayShowTitleEnabled(true);
	        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);   
	        
	 
	        // Adding Tabs
	        for (String tab_name : tabs) {
	            actionBar.addTab(actionBar.newTab().setText(tab_name)
	                    .setTabListener(this));
	        }
	        handler = new Handler();//Handler for managing toasts;
	        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
	        	 
	            @Override
	            public void onPageSelected(int position) {
	                // on changing the page
	                // make respected tab selected
	                actionBar.setSelectedNavigationItem(position);
	               // makeToast();
	                
	            }
	         
	            @Override
	            public void onPageScrolled(int arg0, float arg1, int arg2) {
	            }
	         
	            @Override
	            public void onPageScrollStateChanged(int arg0) {
	            }
	        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		 viewPager.setCurrentItem(arg0.getPosition());
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
	public void makeToast() {
		Log.i("alert","Shots fired");
		handler.post(new Runnable(){
            public void run() {
                Toast.makeText(getApplicationContext(), "Shot Fired", Toast.LENGTH_SHORT).show();
               grab();
         }
      });
		
	}
	public void grab() {
		float a=(float)(Math.random()*300-150);
		float b=(float)(Math.random()*300-150);
		mAdapter.upDate(a,b);
	}
	public void onDestroy()
	{
		System.exit(0);
	}
}
