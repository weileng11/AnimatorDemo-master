package com.example.animstudy.anim;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import com.example.animstudy.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author: ${bruce}
 * @project: AnimatorDemo-master
 * @package: com.example.animstudy.anim
 * @description: ValueAnimator和估值器简介 https://blog.csdn.net/u010126792/article/details/85340010
 * @date: 2019/2/27  
 * @time: 16:02
 */
public class Anim3Act extends AppCompatActivity
{
	@BindView(R.id.btn0)
	Button mBtn0;
	@BindView(R.id.imageView)
	ImageView mImageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_anim3);
		ButterKnife.bind(this);
	}
	
	@OnClick(R.id.btn0)
	public void onClick(){
		//ValueAnimator valueAnimator=new ValueAnimator();
		//Animator animator = AnimatorInflater.loadAnimator(this, R.animator.animator);
		////如果是ObjectAnimator设置动画对象，如果是ValueAnimator则不需要设置target
		//valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
		//	@Override
		//	public void onAnimationUpdate(ValueAnimator animation) {
		//		float name = (float) animation.getAnimatedValue();
		//	}
		//});
		//animator.setTarget(mBtn0);
		//animator.start();
		ValueAnimator valueAnimator=ValueAnimator.ofFloat(1, 0.5f);
		valueAnimator.setDuration(1000);
		valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
		{
			@Override
			public void onAnimationUpdate(ValueAnimator animation){
				float data=(float)animation.getAnimatedValue();
				Matrix matrix=new Matrix();
				matrix.setScale(data, data);
				//ImageView要支持matrix,需要设置ImageView的ScaleType为matrix
				mImageView.setImageMatrix(matrix);
			}
		});
		valueAnimator.start();
		
		
		//1.ValueAnimator用法
		//ValueAnimator animator = ValueAnimator.ofInt(0,500,100);
		//animator.setDuration(1000);
		//animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
		//	@Override
		//	public void onAnimationUpdate(ValueAnimator animation) {
		//		int value = (int) animation.getAnimatedValue();
		//		mImageView.setX(value);
		//	}
		//});
		//animator.start();
		
		//ValueAnimator valueAnimator = ValueAnimator.ofArgb(Color.RED, Color.GREEN);
		//valueAnimator.setDuration(3000);
		//valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
		//	@Override
		//	public void onAnimationUpdate(ValueAnimator animation) {
		//		int data = (int) animation.getAnimatedValue();
		//		mImageView.setBackgroundColor(data);
		//	}
		//});
		//animator.start();
	}
}
