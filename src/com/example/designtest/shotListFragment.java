package com.example.designtest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.graphics.Matrix;
@SuppressLint("ValidFragment")
public class shotListFragment extends Fragment {
	String[] values = new String[] { "SHOT 0", 
            "SHOT 1",
            "SHOT 2",
            "SHOT 3", 
            "SHOT 4", 
            "SHOT 5", 
            "SHOT 6", 
            "SHOT 7" ,
            "SHOT 1",
            "SHOT 2",
            "SHOT 3", 
            "SHOT 4", 
            "SHOT 5", 
            "SHOT 6", 
            "SHOT 7" 
           };
	ListView myListView;
	public shotListFragment() {
		super();
		
	}

	
    @SuppressLint("ValidFragment")
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    	 myListView= new ListView(getActivity());
    	 ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, values);
    	 myListView.setAdapter(adapter); 
    	 return myListView;
    }

	
}
