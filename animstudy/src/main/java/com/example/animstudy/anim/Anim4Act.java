package com.example.animstudy.anim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Property;
import android.widget.Button;
import android.widget.TextView;
import com.example.animstudy.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author: ${bruce}
 * @project: AnimatorDemo-master
 * @package: com.example.animstudy.anim
 * @description: https://blog.csdn.net/u010126792/article/details/85623527
 * @date: 2019/2/27  
 * @time: 16:02
 */
public class Anim4Act extends AppCompatActivity
{
	@BindView(R.id.btn_obj)
	Button mBtnObj;
	@BindView(R.id.txv1)
	TextView mTxv1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_anim4);
		ButterKnife.bind(this);
	}
	
	@RequiresApi(api=Build.VERSION_CODES.LOLLIPOP)
	@OnClick(R.id.btn_obj)
	public void onClick(){
		//ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mBtnObj, "rotation", 0, 270);
		//objectAnimator.setDuration(3000);
		//objectAnimator.setRepeatCount(-1);
		//objectAnimator.setInterpolator(new LinearInterpolator());
		//objectAnimator.start();
		//path
		//Path path = new Path();
		//path.moveTo(0,0);
		//path.lineTo(50,50);
		//path.lineTo(100,20);
		//path.lineTo(900,400);
		////path.lineTo(500,1000);
		//ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mBtnObj, "translationX","translationY",path );
		//objectAnimator.setDuration(3000);
		//objectAnimator.setRepeatCount(-1);
		//objectAnimator.setInterpolator(new LinearInterpolator());
		//objectAnimator.start();
		//Path path = new Path();
		//path.moveTo(0,0);
		//path.lineTo(50,1);
		//path.lineTo(100,2);
		//path.lineTo(900,0.5f);
		//path.lineTo(500,1);
		//ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mBtnObj, "translationX","scaleX",path );
		//objectAnimator.setDuration(3000);
		//objectAnimator.setRepeatCount(-1);
		//objectAnimator.setInterpolator(new LinearInterpolator());
		//objectAnimator.start();
		//ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mBtnObj, ROTATION, 0,270);
		//objectAnimator.setDuration(3000);
		//objectAnimator.setRepeatCount(-1);
		//objectAnimator.setInterpolator(new LinearInterpolator());
		//objectAnimator.start();
		//IntEvaluator intEvaluator = new IntEvaluator();
		//MyProperty property = new MyProperty("text");
		//ObjectAnimator objectAnimator = ObjectAnimator.ofObject(mBtnObj,property,intEvaluator,"1", "10");
		//objectAnimator.setDuration(3000);
		//objectAnimator.setRepeatCount(-1);
		//objectAnimator.setInterpolator(new LinearInterpolator());
		//objectAnimator.start();
		//ObjectAnimator objectAnimator = ObjectAnimator.ofArgb(mBtnObj,"backgroundColor", Color.RED, Color.GREEN);
		//objectAnimator.setDuration(3000);
		//objectAnimator.setRepeatCount(-1);
		//objectAnimator.setInterpolator(new LinearInterpolator());
		//objectAnimator.start();
		//int[][] data={{1, 9}, {4, 12}};
		//ViewDemo24 viewDemo24=new ViewDemo24(this);
		//viewDemo24.setMulText(1,5);
		//@SuppressLint("ObjectAnimatorBinding")
		//ObjectAnimator objectAnimator=ObjectAnimator.ofMultiInt(viewDemo24, "mulText", data);
		//objectAnimator.setDuration(3000);
		//objectAnimator.setRepeatCount(-1);
		//objectAnimator.setInterpolator(new LinearInterpolator());
		//objectAnimator.start();
		//mTxv1.setText(viewDemo24.getMulText());
		
		ObjectAnimator objectAnimator1 = ObjectAnimator.ofArgb(mBtnObj, "backgroundColor", Color.WHITE, Color.GREEN);
		ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(mBtnObj, "scaleX", 0.1f, 1.2f);
		ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(mBtnObj, "scaleY", 0.5f, 1.0f);
		ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(mBtnObj, "translationY", 0, 250);
		ObjectAnimator objectAnimator6 = ObjectAnimator.ofFloat(mBtnObj, "translationY", 0, 100);
		
		ObjectAnimator objectAnimator7 = ObjectAnimator.ofArgb(mBtnObj, "backgroundColor", Color.WHITE, Color.GREEN);
		ObjectAnimator objectAnimator8 = ObjectAnimator.ofFloat(mBtnObj, "scaleX", 0.1f, 1.2f);
		ObjectAnimator objectAnimator9 = ObjectAnimator.ofFloat(mBtnObj, "scaleY", 0.5f, 1.0f);
		ObjectAnimator objectAnimator10 = ObjectAnimator.ofFloat(mBtnObj, "translationY", 0, 250);
		
		ObjectAnimator objectAnimator11 = ObjectAnimator.ofArgb(mBtnObj, "backgroundColor", Color.WHITE, Color.GREEN);
		ObjectAnimator objectAnimator12 = ObjectAnimator.ofFloat(mBtnObj, "scaleX", 0.1f, 1.2f);
		ObjectAnimator objectAnimator13 = ObjectAnimator.ofFloat(mBtnObj, "scaleY", 0.5f, 1.0f);
		ObjectAnimator objectAnimator14 = ObjectAnimator.ofFloat(mBtnObj, "translationY", 0, 250);
		
		AnimatorSet animatorSet = new AnimatorSet();
		animatorSet.playTogether(objectAnimator1,objectAnimator2,objectAnimator3,objectAnimator4,objectAnimator6);
		animatorSet.setDuration(3000);
		animatorSet.start();
		
		//AnimatorSet animatorSet1 = new AnimatorSet();
		//animatorSet1.play(objectAnimator1).before(objectAnimator2);
		//animatorSet1.setDuration(3000);
		//animatorSet1.start();
	}
	//public static final Property<View, Float> ROTATION = new FloatProperty<View>("rotation") {
	//	@Override
	//	public void setValue(View object, float value) {
	//		object.setRotation(value);
	//	}
	//
	//	@Override
	//	public Float get(View object) {
	//		return object.getRotation();
	//	}
	//};
	
	public static class MyProperty extends Property<TextView, String>
	{
		public MyProperty(String name){
			super(String.class, name);
		}
		
		@Override
		public String get(TextView object){
			return object.getText().toString();
		}
		
		@Override
		public void set(TextView object, String value){
			object.setText(value);
		}
	}
	
	public static class IntEvaluator implements TypeEvaluator<String>
	{
		@Override
		public String evaluate(float fraction, String startValue, String endValue){
			int startInt=Integer.parseInt(startValue);
			int endInt=Integer.parseInt(endValue);
			int cur=(int)(startInt+fraction*(endInt-startInt));
			return cur+"";
		}
	}
	
	public class ViewDemo24 extends AppCompatTextView
	{
		public ViewDemo24(Context context){
			this(context, null, 0);
			init();
		}
		
		public ViewDemo24(Context context, @Nullable AttributeSet attrs){
			this(context, attrs, 0);
			init();
		}
		
		public ViewDemo24(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
			super(context, attrs, defStyleAttr);
			init();
		}
		
		private void init(){
		}
		
		public void setMulText(int data1, int data2){
			String data="";
			data=data+data1+data2;
			setText(data);
		}
		
		public String getMulText(){
			return getText().toString();
		}
	}
}
