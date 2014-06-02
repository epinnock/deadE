package com.example.designtest;

import android.graphics.Canvas;
import java.util.ArrayList;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class LineGraph extends Drawable
{
    private final Paint myPaint;
    float lasty=820;
    float y=820;
    float lastx=820;
    float x=820;
    public LineGraph()
    {
        myPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
       
    }

    public void draw(Canvas canvas)
    {
    	myPaint.setColor(Color.BLACK);
        myPaint.setStrokeWidth(3);
    	myPaint.setStyle(Paint.Style.STROKE);
    	myPaint.setStrokeJoin(Paint.Join.ROUND);
    	for(int i=1;i<39;i++)
    		{
    				myPaint.setColor(Color.BLACK);
    				y=(float)(820+(Math.random()*40-20));
    				canvas.drawLine(0+((i-1)*20),lasty, 0+(i*20),y, myPaint);
    				lasty=y;
    				myPaint.setColor(Color.RED);
    				x=(float)(820+(Math.random()*40-20));
    				canvas.drawLine(0+((i-1)*20),lastx, 0+(i*20),x, myPaint);
    				lastx=x;
    		}
    		
		
    }

    public int getOpacity()
    {
        return PixelFormat.OPAQUE;
    }

    public void setAlpha(int arg0)
    {
    }

    public void setColorFilter(ColorFilter arg0)
    {
    }
}
