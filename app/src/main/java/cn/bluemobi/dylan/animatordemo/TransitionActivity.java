package cn.bluemobi.dylan.animatordemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;

/**
 * @author: ${bruce}
 * @project: AnimatorDemo-master
 * @package: cn.bluemobi.dylan.animatordemo
 * @description:
 * @date: 2019/2/27  
 * @time: 15:03
 */
public class TransitionActivity extends AppCompatActivity
{
	private FrameLayout mContainer;
	boolean togger = true;
	Scene scene1 ;
	Scene scene2 ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transition);
		mContainer =(FrameLayout)findViewById(R.id.viewcontainer);
		mContainer.setOnClickListener(new View.OnClickListener() {
			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				if (togger){
					TransitionManager.go(scene1,new ChangeBounds());
				}else{
					TransitionManager.go(scene2,new ChangeBounds());
				}
				togger = !togger;
			}
		});
		init();
	}
	
	@SuppressLint("NewApi")
	private void init(){
			scene1 = Scene.getSceneForLayout(mContainer, R.layout.scene1, TransitionActivity.this);
			scene2 = Scene.getSceneForLayout(mContainer, R.layout.scene2, TransitionActivity.this);
		
	}
}
