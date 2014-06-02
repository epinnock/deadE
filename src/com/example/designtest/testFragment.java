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
import android.widget.LinearLayout;
import android.graphics.Matrix;
@SuppressLint("ValidFragment")
public class testFragment extends Fragment {
	drawView view_a;
	String text;
	@SuppressLint("ValidFragment")
	public testFragment(String msg) {
		super();
		text=msg;
	}

	
    @SuppressLint("ValidFragment")
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    	 
        view_a= new drawView(getActivity(),text);

        return view_a;
    }
    public void upDate(float a, float b)
    {
    	try{
    	view_a.upDate(a, b);}
    	catch(NullPointerException e)
        {}
    }
    
	
}
