package com.example.tweentest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class TweenActivity extends Activity {

	Button b1,b2;
	LinearLayout layout;
	
	Animation animation;
	class MyListener implements View.OnClickListener {
		public void onClick(View v) {
			// b2 클릭할 경우 b1에 애니메이션 효과 적용
			animation = AnimationUtils.loadAnimation(TweenActivity.this, R.anim.scale);
//			b1.startAnimation(animation);
			layout.startAnimation(animation);
		}
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        layout = new LinearLayout(this);
        b1 = new Button(this);
        b2 = new Button(this);
        
        MyListener listener = new MyListener();
        
        b2.setOnClickListener(listener);
        
        layout.addView(b1);
        layout.addView(b2);
        
        setContentView(layout);
        
        Toast t = Toast.makeText(this, "Toast", Toast.LENGTH_LONG);
        
        LayoutInflater inflater = getLayoutInflater();
        
        RelativeLayout l = (RelativeLayout)inflater.inflate(R.layout.activity_tween, null);
        
        t.setView(l); 	//toast 모양결정
        
        t.setGravity(Gravity.CENTER, -100, -100);   //toast 위치결정
        
        t.show();
        
        
        
    }
}
