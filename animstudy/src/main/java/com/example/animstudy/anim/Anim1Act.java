package com.example.animstudy.anim;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import com.example.animstudy.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author: ${bruce}
 * @project: AnimatorDemo-master
 * @package: com.example.animstudy.anim
 * @description: 补间动画  https://blog.csdn.net/u010126792/article/details/85302050
 * @date: 2019/2/27  
 * @time: 16:02
 *
 * translate (平移动画) — TranslateAnimation
scale (缩放动画) — ScaleAnimation
rotate （旋转动画） — RotateAnimation类
alpha （ 透明度动画） — AlphaAnimation 类
 */
public class Anim1Act extends AppCompatActivity
{
	@BindView(R.id.btn_bj)
	Button mBtnBj;
	@BindView(R.id.btn_alpha)
	Button mBtnAlpha;
	@BindView(R.id.btn_scale)
	Button mBtnScale;
	@BindView(R.id.btn_roate)
	Button mBtnRoate;
	@BindView(R.id.btn_set)
	Button mBtnSet;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_anim1);
		ButterKnife.bind(this);
	}
	
	@OnClick({R.id.btn_bj, R.id.btn_alpha, R.id.btn_scale, R.id.btn_roate,R.id.btn_set})
	public void onClick(View view){
		switch(view.getId()){
		case R.id.btn_bj:
			//TranslateAnimation translateAnimation=new TranslateAnimation(0, 400, 0, 200);
			//translateAnimation.setDuration(3000);
			//translateAnimation.setFillAfter(true);
			//mBtnBj.startAnimation(translateAnimation);
			Animation animation=AnimationUtils.loadAnimation(this, R.anim.translate);
			mBtnBj.startAnimation(animation);
			break;
		case R.id.btn_alpha:
			//AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
			//alphaAnimation.setDuration(3000);
			//alphaAnimation.setFillBefore(true);
			//mBtnAlpha.startAnimation(alphaAnimation);
			Animation animation1=AnimationUtils.loadAnimation(this, R.anim.alpha);
			mBtnAlpha.startAnimation(animation1);
			break;
		case R.id.btn_scale:
			//ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 2.0f, 0.0f, 2.0f);
			//scaleAnimation.setDuration(3000);
			//scaleAnimation.setFillAfter(true);
			//mBtnScale.startAnimation(scaleAnimation);
			Animation animation2=AnimationUtils.loadAnimation(this, R.anim.scale);
			mBtnScale.startAnimation(animation2);
			break;
		case R.id.btn_roate:
			//RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 270f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
			//rotateAnimation.setDuration(3000);
			//rotateAnimation.setFillAfter(true);
			//mBtnRoate.startAnimation(rotateAnimation);
			Animation animation3=AnimationUtils.loadAnimation(this, R.anim.rotate);
			mBtnRoate.startAnimation(animation3);
			break;
		case R.id.btn_set:
			//RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 270f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
			//rotateAnimation.setDuration(3000);
			//rotateAnimation.setFillAfter(true);
			//mBtnRoate.startAnimation(rotateAnimation);
			Animation animation4=AnimationUtils.loadAnimation(this, R.anim.animset);
			mBtnSet.startAnimation(animation4);
			break;
		}
	}
}
