package com.example.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityTest extends Activity {

	// @Override
	// public boolean onTouchEvent(MotionEvent event) {
	//
	// //Activity 명시적 호출
	// //전환하고자 하는 화면을 직접적으로 선택
	// Intent intent = new Intent(this, SecondActivity.class);
	// intent.putExtra("10", "HI"); //데이터 전달
	// startActivity(intent);
	//
	// //Activity 암시적 호출
	// //전환하고자 하는 화면의 기능을 선택
	// //특정 기능을 가지고 있는 Activity를 호출할 때 사용
	// // Uri number = Uri.parse("tel:01011112222");
	// // Intent i = new Intent(Intent.ACTION_DIAL, number);
	// // startActivity(i);
	//
	// return super.onTouchEvent(event);
	// }

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		String id = data.getStringExtra("id");
		String pass = data.getStringExtra("pass");
		
		Toast.makeText(this, id + " // " + pass, Toast.LENGTH_LONG).show();
	}

	class MyListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
//			Intent intent = new Intent(ActivityTest.this, SecondActivity.class);
			Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
			
			intent.putExtra("10", "HI"); // 데이터 전달
//			startActivity(intent);  //단순한 화면 호출
			startActivityForResult(intent, 0);  // 2번째 화면으로 부터 결과값 받아올 경우
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_activity_test);

		Button b = (Button) findViewById(R.id.button1);
		
		MyListener m = new MyListener();
		
		b.setOnClickListener(m);

		
	}

}
