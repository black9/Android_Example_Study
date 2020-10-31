package com.example.firstandroid;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class FirstActivity extends Activity {

	TextView t;
	LinearLayout layout;

	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		//명시적 Intent 사용
		Intent i = new Intent(this, SecondActivity.class);
		startActivity(i);
		return super.onTouchEvent(event);
	}


	class MyListener implements View.OnClickListener {
		// callback method
		// 프로그래머가 호출 하지 않음
		@Override
		public void onClick(View arg0) {

			switch (arg0.getId()) {
			case R.id.button1:
				layout.setBackgroundResource(R.drawable.abc);
				break;
			case R.id.button2:
				layout.setBackgroundResource(R.drawable.b);
				break;
			case R.id.button3:
				layout.setBackgroundResource(R.drawable.c);
				break;
			case R.id.button4:
				setContentView(R.layout.activity_first);
				break;
			case R.id.button5:
				//암시적 Intent 사용
				Uri number = Uri.parse("tel:01011112222");
				Intent i = new Intent(Intent.ACTION_DIAL, number);
				startActivity(i);
				break;
			}
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.first);

		layout = (LinearLayout) findViewById(R.id.layout);

		Button b1 = (Button) findViewById(R.id.button1);

		Button b2 = (Button) findViewById(R.id.button2);

		Button b3 = (Button) findViewById(R.id.button3);
		
		Button b4 = (Button) findViewById(R.id.button4);
		
		Button b5 = (Button) findViewById(R.id.button5);

		MyListener m = new MyListener();

		b1.setOnClickListener(m);

		b2.setOnClickListener(m);

		b3.setOnClickListener(m);
		
		b4.setOnClickListener(m);
		
		b5.setOnClickListener(m);
	}

}
