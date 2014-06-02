package com.example.designtest;
import android.app.ListFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
public class TabsPagerAdapter extends FragmentPagerAdapter {
	
	testFragment fg1;
	testFragment fg2;
	shotListFragment fg3;
	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
		fg1= new testFragment("Frag 1");
		fg2= new testFragment("Frag 1");
		fg3= new shotListFragment();
		
	}
	
	@Override
	public Fragment getItem(int index) {
		 
        switch (index) {
        case 0:
            // Top Rated fragment activity
           // return new testFragment("Frag 1");
        	  return fg1;
        case 1:
            // Games fragment activity
        	//return new testFragment("Frag 2");
        	  return fg2;
        case 2:
            // Movies fragment activity
        	//return new testFragment("Frag 3");
        	  return fg3;
        }
 
        return null;
    }

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}
	public void upDate(float a, float b)
	{
		fg1.upDate(a, b);
		fg2.upDate(a, b);
		//fg3.upDate(a, b);
	}
}
