package com.example.animstudy.comm;

import android.view.animation.Interpolator;

/**
 * @author: ${bruce}
 * @project: AnimatorDemo-master
 * @package: com.example.animstudy.comm
 * @description:
 * @date: 2019/2/27  
 * @time: 17:22
 */
public class InterpolationDemo implements Interpolator
{
	@Override
	public float getInterpolation(float input){
		if(input>0 && input<0.5){
			return input/10;
		}else{
			return input*input;
		}
	}
}