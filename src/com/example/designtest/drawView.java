package com.example.designtest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
public class drawView extends View {

	String text="";
	Paint paint;
	int x,y;
	LineGraph myLine;
	TargetCircle myTarget;
	Bitmap myBufferedBitmap;
	Canvas myBufferedCanvas;
	@SuppressLint("NewApi")
	public drawView(Context context,String msg) {
		super(context);
		text=msg;
		paint=new Paint();
		x=this.getWidth();
		y=this.getHeight();
		myLine= new LineGraph();
		myTarget= new TargetCircle(); 
		this.setBackgroundColor(Color.WHITE);
		setLayerType(View.LAYER_TYPE_SOFTWARE, null);
		
	}
	
	public void onDraw(Canvas c)
	{
		if(x==0) {
			x=getWidth();
			y=getHeight();
		}
		  if(myBufferedBitmap == null)
	        {
	            myBufferedBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
	            myBufferedCanvas = new Canvas(myBufferedBitmap);
	        }
		myTarget.set((float)x); // Once we have the actual size of the View set the Target circle's radii
		//Log.i("VIEW WIDTH",""+getHeight());
		paint.setColor(Color.WHITE);
		paint.setTextSize(30);
		myBufferedCanvas.drawRect(0,0,1000,1000,paint);
		//Log.i("VIEW WIDTH",""+getHeight());
		myTarget.draw(myBufferedCanvas);
		myLine.draw(myBufferedCanvas);
		c.drawBitmap(myBufferedBitmap, 0, 0, null); 
		try {
			Thread.sleep(15);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		invalidate();
	}
	public void upDate(float a, float b)
	{
		
		myTarget.upDate(a, b);
	}
}