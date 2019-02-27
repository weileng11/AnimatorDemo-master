package com.example.animstudy.anim;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.*;
import android.widget.Button;
import android.widget.ImageView;
import com.example.animstudy.R;
import com.example.animstudy.comm.InterpolationDemo;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author: ${bruce}
 * @project: AnimatorDemo-master
 * @package: com.example.animstudy.anim
 * @description:Android动画之插值器简介和系统默认插值器
 * @date: 2019/2/27  https://blog.csdn.net/u010126792/article/details/85327881
 * @time: 16:02
 */
public class Anim2Act extends AppCompatActivity
{
	@BindView(R.id.btn1)
	Button mBtn1;
	@BindView(R.id.btn2)
	Button mBtn2;
	@BindView(R.id.btn3)
	Button mBtn3;
	@BindView(R.id.btn4)
	Button mBtn4;
	@BindView(R.id.btn5)
	Button mBtn5;
	@BindView(R.id.btn6)
	Button mBtn6;
	@BindView(R.id.btn7)
	Button mBtn7;
	@BindView(R.id.btn8)
	Button mBtn8;
	@BindView(R.id.btn9)
	Button mBtn9;
	@BindView(R.id.imageView)
	ImageView imageView;
	TranslateAnimation mTranslateAnimation;
	@BindView(R.id.btn10)
	Button mBtn10;
	@BindView(R.id.btn0)
	Button mBtn0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_anim2);
		ButterKnife.bind(this);
		///android:fromXDelta="-300"
		//	android:toXDelta="500"
		//	android:fromYDelta="-300"
		//	android:toYDelta="1000"
		mTranslateAnimation=new TranslateAnimation(0, 400, 0, 400);
		mTranslateAnimation.setDuration(4000);
		mTranslateAnimation.setFillAfter(true);
	}
	
	@RequiresApi(api=Build.VERSION_CODES.LOLLIPOP)
	@OnClick({
			         R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
			         R.id.btn8, R.id.btn9, R.id.btn10,R.id.btn0
	         })
	public void onClick(View view){
		switch(view.getId()){
		case R.id.btn0:
			if(imageView.getAnimation()!=null && !imageView.getAnimation().hasEnded()){
				imageView.getAnimation().cancel();
			}
			InterpolationDemo interpolationDemo = new InterpolationDemo();
			mTranslateAnimation.setInterpolator(interpolationDemo);
			imageView.startAnimation(mTranslateAnimation);
			break;
		case R.id.btn1:
			if(imageView.getAnimation()!=null && !imageView.getAnimation().hasEnded()){
				imageView.getAnimation().cancel();
			}
			mTranslateAnimation.setInterpolator(new AccelerateInterpolator());
			imageView.startAnimation(mTranslateAnimation);
			break;
		case R.id.btn2:
			if(imageView.getAnimation()!=null && !imageView.getAnimation().hasEnded()){
				imageView.getAnimation().cancel();
			}
			mTranslateAnimation.setInterpolator(new DecelerateInterpolator());
			imageView.startAnimation(mTranslateAnimation);
			break;
		case R.id.btn3:
			if(imageView.getAnimation()!=null && !imageView.getAnimation().hasEnded()){
				imageView.getAnimation().cancel();
			}
			mTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
			imageView.startAnimation(mTranslateAnimation);
			break;
		case R.id.btn4:
			if(imageView.getAnimation()!=null && !imageView.getAnimation().hasEnded()){
				imageView.getAnimation().cancel();
			}
			mTranslateAnimation.setInterpolator(new LinearInterpolator());
			imageView.startAnimation(mTranslateAnimation);
			break;
		case R.id.btn5:
			if(imageView.getAnimation()!=null && !imageView.getAnimation().hasEnded()){
				imageView.getAnimation().cancel();
			}
			mTranslateAnimation.setInterpolator(new AnticipateInterpolator());
			imageView.startAnimation(mTranslateAnimation);
			break;
		case R.id.btn6:
			if(imageView.getAnimation()!=null && !imageView.getAnimation().hasEnded()){
				imageView.getAnimation().cancel();
			}
			mTranslateAnimation.setInterpolator(new OvershootInterpolator());
			imageView.startAnimation(mTranslateAnimation);
			break;
		case R.id.btn7:
			if(imageView.getAnimation()!=null && !imageView.getAnimation().hasEnded()){
				imageView.getAnimation().cancel();
			}
			mTranslateAnimation.setInterpolator(new AnticipateOvershootInterpolator());
			imageView.startAnimation(mTranslateAnimation);
			break;
		case R.id.btn8:
			if(imageView.getAnimation()!=null && !imageView.getAnimation().hasEnded()){
				imageView.getAnimation().cancel();
			}
			mTranslateAnimation.setInterpolator(new BounceInterpolator());
			imageView.startAnimation(mTranslateAnimation);
			break;
		case R.id.btn9:
			if(imageView.getAnimation()!=null && !imageView.getAnimation().hasEnded()){
				imageView.getAnimation().cancel();
			}
			mTranslateAnimation.setInterpolator(new CycleInterpolator(5));
			imageView.startAnimation(mTranslateAnimation);
			break;
		case R.id.btn10:
			if(imageView.getAnimation()!=null && !imageView.getAnimation().hasEnded()){
				imageView.getAnimation().cancel();
			}
			PathInterpolator pathInterpolator=new PathInterpolator(0.9f, 0.1f);
			mTranslateAnimation.setInterpolator(pathInterpolator);
			imageView.startAnimation(mTranslateAnimation);
			break;
		}
	}
}
