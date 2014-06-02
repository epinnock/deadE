package com.example.designtest;

import android.graphics.drawable.Drawable;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PixelFormat;
public class TargetCircle extends Drawable {
	
	float bigRadius;
	float smallRadius;
	float centerX;
	float centerY;
	float xDiff;
	float yDiff;
	float totalDiff;
	Paint myPaint;
	public TargetCircle() {
		myPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
	}	
	
	public TargetCircle(float radius) {
		myPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
		bigRadius=radius*.95f;
		smallRadius=(float)(radius/5.0);
		centerX=radius/2;
		centerY=radius/2;
		xDiff=0.0f;
	    yDiff=0.0f;
	}	
	
	public void set(float radius)
	{
		bigRadius=radius/2.1f;
		smallRadius=(float)(radius/12.0f);
		centerX=radius/2;
		centerY=radius/2;
	}
	public void upDate(float a, float b) {
		xDiff=a;
		yDiff=b;
	}
	@Override
	public void draw(Canvas c) {
		
		//xDiff=((float)(Math.random()*(-smallRadius))+(smallRadius/2));
		//yDiff=((float)(Math.random()*(-smallRadius))+(smallRadius/2));
		totalDiff=(float)Math.sqrt((xDiff*xDiff)+(yDiff*yDiff)); 
		myPaint.setARGB(255, 255, 255, 255);
		myPaint.setStyle(Style.FILL);
		c.drawCircle(centerX,centerY,bigRadius,myPaint);
		if(totalDiff<smallRadius/4.0f)
			myPaint.setARGB(56, 255, 0, 0);
			
		else
			myPaint.setARGB(30, 0, 255, 0);
		 
		 c.drawCircle(centerX,centerY,bigRadius,myPaint);
		 myPaint.setARGB(155, 0, 0, 255);
		 c.drawCircle(centerX+xDiff,centerY+yDiff,smallRadius,myPaint);	 
		xDiff=0.0f;
	    yDiff=0.0f;
	}

	@Override
	public int getOpacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAlpha(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColorFilter(ColorFilter arg0) {
		// TODO Auto-generated method stub
		
	}

}
