package com.example.animstudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.example.animstudy.anim.*;

public class MainActivity extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	@RequiresApi(api=Build.VERSION_CODES.HONEYCOMB)
	public void onClick(View v){
		switch(v.getId()){
		case R.id.anim1:
			showActivity(MainActivity.this, Anim1Act.class);
			break;
		case R.id.anim2:
			showActivity(MainActivity.this, Anim2Act.class);
			break;
		case R.id.anim3:
			showActivity(MainActivity.this, Anim3Act.class);
			break;
		case R.id.anim4:
			showActivity(MainActivity.this, Anim4Act.class);
			break;
		case R.id.anim5:
			showActivity(MainActivity.this, Anim5Act.class);
			break;
		case R.id.anim6:
			showActivity(MainActivity.this, Anim6Act.class);
			break;
		}
	}
	
	/**
	 Activity跳转
	 */
	public void showActivity(Activity aty, Class<?> cls){
		Intent intent=new Intent();
		intent.setClass(aty, cls);
		aty.startActivity(intent);
	}
}
