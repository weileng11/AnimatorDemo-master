package cn.bluemobi.dylan.animatordemo;

import android.animation.*;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.*;
import android.widget.ImageView;

/**
 * @author: ${bruce}
 * @project: AnimatorDemo-master
 * @package: cn.bluemobi.dylan.animatordemo
 * @description:
 * @date: 2019/2/26  
 * @time: 10:40
 */
public class ValueAnimatorActivity extends AppCompatActivity
{
	private ImageView iv;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_valueanimator);
		iv=(ImageView)findViewById(R.id.iv);
	}
	
	@RequiresApi(api=Build.VERSION_CODES.HONEYCOMB)
	public void onClick(View v){
		iv.setBackgroundColor(Color.TRANSPARENT);
		switch(v.getId()){//透明度动画
		case R.id.animation_alpha:
			final TranslateAnimation
					animation = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 400,
					Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 400);
			animation.setFillAfter(true);
			animation.setDuration(1000);
			iv.startAnimation(animation);
			break;
		case R.id.animation_scale://缩放动画
			final ValueAnimator valueAnimator = ValueAnimator.ofFloat(1f , 0.5f,1f);
			valueAnimator.setDuration(2000);
			valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
				@Override
				public void onAnimationUpdate(ValueAnimator animation) {
            //这里在值变化的时候做相应的动作，我们是缩放图片，注意先设置缩放的起始点，坐标都是以view的左上角为原点
					float value = (float) animation.getAnimatedValue();
					iv.setPivotX(iv.getWidth()/2);
					iv.setPivotY(iv.getHeight()/2);
					iv.setScaleX(value);
					iv.setScaleY(value);
				}
			});
			//动画完成后有个缩小的动作
			valueAnimator.addListener(new AnimatorListenerAdapter() {
				@Override
				public void onAnimationEnd(Animator animation) {
					//这里写是有问题的，递归调用会重新启动监听，然后又会启动，因为动画只启动一次的缘故，但是会持续执行onUpdateListener，且value值一直是0.95
					//             scaleAnimate(view, end, 0.95f, duration / 3);
					ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f , 1f , 0.5f , 1f , iv.getWidth() , iv.getHeight());
					scaleAnimation.setDuration(1000);
					//scaleAnimation.setFillAfter(true);//这是保证动画后的效果，不然会恢复到原来大小。
					iv.startAnimation(scaleAnimation);
				}
			});
			valueAnimator.start();
			break;
		case R.id.animation_rotate://旋转动画
			final RotateAnimation
					animation1 = new RotateAnimation(0f,360f);
			animation1.setFillAfter(true);
			animation1.setDuration(1000);
			iv.startAnimation(animation1);
			break;
		case R.id.animation_translate://位移动画
			//1.ValueAnimator用法
			ValueAnimator animator = ValueAnimator.ofInt(0,500,100);
			animator.setDuration(1000);
			animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
				@Override
				public void onAnimationUpdate(ValueAnimator animation) {
					int value = (int) animation.getAnimatedValue();
					iv.setX(value);
				}
			});
			animator.start();
			break;
		case R.id.animation_group1://先播放缩放动画，完成后播放旋转动画
			ValueAnimator animator4 = ValueAnimator.ofInt(0,400);
			animator4.setDuration(1000);
			
			animator4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
				@Override
				public void onAnimationUpdate(ValueAnimator animation) {
					int curValue = (int)animation.getAnimatedValue();
					iv.layout(curValue,curValue,curValue+iv.getWidth(),curValue+iv.getHeight());
				}
			});
			animator4.start();
			break;
		case R.id.animation_group2://先播放旋转动画，完成后播放位移动画
			ValueAnimator animator5 = ValueAnimator.ofInt(400,100);
			animator5.setDuration(1000);
			
			animator5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
				@Override
				public void onAnimationUpdate(ValueAnimator animation) {
					int curValue = (int)animation.getAnimatedValue();
					iv.layout(curValue,curValue,curValue+iv.getWidth(),curValue+iv.getHeight());
				}
			});
			animator5.start();
			break;
		case R.id.animation_group3://重复的透明度动画
			break;
		case R.id.animation_group4://重复的位移动画
			break;
		case R.id.animation_frame:
			if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
				ValueAnimator valueAnimator1 = ValueAnimator.ofArgb(0xffffffff,0xffff0000,0xff0000ff);
				valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
					@Override
					public void onAnimationUpdate(ValueAnimator animation) {
						iv.setBackgroundColor((Integer) animation.getAnimatedValue());
					}
				});
				valueAnimator1.setDuration(3000);
				valueAnimator1.setRepeatCount(10);
				valueAnimator1.start();
			}
			break;
		}
	}
}
