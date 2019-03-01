package cn.bluemobi.dylan.animatordemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author: ${bruce}
 * @project: AnimatorDemo-master
 * @package: cn.bluemobi.dylan.animatordemo
 * @description:
 * @date: 2019/2/28  
 * @time: 16:05
 */
public class ViewDemo22 extends View
{
	private int color=Color.GREEN;
	private int radius=100;
	private Paint mPaint;
	
	public int getColor(){
		return color;
	}
	
	public void setColor(int color){
		this.color=color;
		mPaint.setColor(color);
		invalidate();
	}
	
	public int getRadius(){
		return radius;
	}
	
	public void setRadius(int radius){
		this.radius=radius;
		invalidate();
	}
	
	public ViewDemo22(Context context){
		this(context, null, 0);
	}
	
	public ViewDemo22(Context context, @Nullable AttributeSet attrs){
		this(context, attrs, 0);
	}
	
	public ViewDemo22(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
		super(context, attrs, defStyleAttr);
		init();
	}
	
	private void init(){
		mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaint.setColor(color);
		mPaint.setStrokeWidth(5);
		mPaint.setStyle(Paint.Style.STROKE);
	}
	
	@Override
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		canvas.drawCircle(getMeasuredHeight()/2, getMeasuredHeight()/2, radius, mPaint);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int width=MeasureSpec.getSize(widthMeasureSpec);
		int height=MeasureSpec.getSize(heightMeasureSpec);
		if(width<200){
			width=200;
		}
		if(height<200){
			height=200;
		}
		if(width<height){
			setMeasuredDimension(height, height);
		}else{
			setMeasuredDimension(width, width);
		}
	}
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh){
		super.onSizeChanged(w, h, oldw, oldh);
	}
}
