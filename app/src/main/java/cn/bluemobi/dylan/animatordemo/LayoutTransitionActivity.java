package cn.bluemobi.dylan.animatordemo;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * @author: ${bruce}
 * @project: AnimatorDemo-master
 * @package: cn.bluemobi.dylan.animatordemo
 * @description: LayoutTransition 布局动画
 * @date: 2019/2/27
 * @time: 9:32
 *
   详细地址请看:https://blog.csdn.net/u010126792/article/details/85702033
 * 四种不同的动画分别是（api11中添加）：

APPEARING：view被添加（可见）到ViewGroup会触发的动画。
DISAPPEARING ：view被移除（不可见）ViewGroup会触发的动画。
CHANGE_APPEARING ：view被添加（可见）到ViewGroup，会影响其他View，此时其它View会触发的动画。
CHANGE_DISAPPEARING：view被移除（不可见）ViewGroup，会影响其他View，此时其它View会触发的动画。
API16 添加了CHANGING 类型，所以是五种类型动画。
---------------------
 *  共享动画:https://blog.csdn.net/u010126792/article/details/85706553
 */
public class LayoutTransitionActivity extends AppCompatActivity
{
	private LinearLayout mContainer;
	private Button mBtnAdd;
	private Button mBtnDel;
	private LayoutTransition layoutTransition;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_layouttransition);
		mContainer=(LinearLayout)findViewById(R.id.ll_container);
		layoutTransition=new LayoutTransition();
		addPropertyValues();
		//addCustomTransition();
		mContainer.setLayoutTransition(layoutTransition);
		
		mBtnAdd=(Button)findViewById(R.id.btnadd);
		mBtnAdd.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				Button button=new Button(LayoutTransitionActivity.this);
				button.setPadding(20, 20, 20, 20);
				button.setText("tempBtn");
				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
						ViewGroup.LayoutParams.WRAP_CONTENT);
				mContainer.addView(button, 2,params);
			}
		});
		mBtnDel=(Button)findViewById(R.id.btndel);
		mBtnDel.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				int count=mContainer.getChildCount();
				if(count >= 3){
					mContainer.removeViewAt(2);
				}
			}
		});
	}
	
	
	private void addPropertyValues(){
		//为了防止动画没有效果，把left，right，top，bottom的设置都加上
		@SuppressLint("ObjectAnimatorBinding")
		PropertyValuesHolder changeLeft =
				PropertyValuesHolder.ofInt("left", 0, 0);
		@SuppressLint("ObjectAnimatorBinding")
		PropertyValuesHolder changeTop =
				PropertyValuesHolder.ofInt("top", 0, 0);
		PropertyValuesHolder changeRight =
				PropertyValuesHolder.ofInt("right", 0, 0);
		PropertyValuesHolder changeBottom =
				PropertyValuesHolder.ofInt("bottom", 0, 0);
		
		@SuppressLint("ObjectAnimatorBinding")
		PropertyValuesHolder propertyValuesHolder=PropertyValuesHolder.ofFloat("rotation",0,50,0);
		ObjectAnimator changApp=ObjectAnimator.ofPropertyValuesHolder(this,changeLeft,changeTop,propertyValuesHolder);
		layoutTransition.setAnimator(LayoutTransition.CHANGE_APPEARING,changApp);
		
		/**
		 * 删除view时其他受影响view动画效果
		 */
		@SuppressLint("ObjectAnimatorBinding")
		PropertyValuesHolder aniChangeDis = PropertyValuesHolder.ofFloat("rotation", 0, 50, 0);
		ObjectAnimator changeDis = ObjectAnimator.ofPropertyValuesHolder(this,changeLeft,changeTop,aniChangeDis);
		
		layoutTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, changeDis);
		
	}
	
	private void addCustomTransition(){
		
		
		
		
		/**
		 * 移除View时view的DISAPPEARING动画
		 */
		ObjectAnimator addAnimator = ObjectAnimator.ofFloat(null, "translationX", 0, 50,0).
				setDuration(1500);
		layoutTransition.setAnimator(LayoutTransition.DISAPPEARING, addAnimator);
		
		/**
		 * 添加view是view的APPEARING动画
		 */
		ObjectAnimator removeAnimator = ObjectAnimator.ofFloat(null, "scaleX", 0.5f, 1).
				setDuration(1500);
		layoutTransition.setAnimator(LayoutTransition.APPEARING, removeAnimator);
	}
}
