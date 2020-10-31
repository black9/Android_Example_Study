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
	// //Activity ����� ȣ��
	// //��ȯ�ϰ��� �ϴ� ȭ���� ���������� ����
	// Intent intent = new Intent(this, SecondActivity.class);
	// intent.putExtra("10", "HI"); //������ ����
	// startActivity(intent);
	//
	// //Activity �Ͻ��� ȣ��
	// //��ȯ�ϰ��� �ϴ� ȭ���� ����� ����
	// //Ư�� ����� ������ �ִ� Activity�� ȣ���� �� ���
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
			
			intent.putExtra("10", "HI"); // ������ ����
//			startActivity(intent);  //�ܼ��� ȭ�� ȣ��
			startActivityForResult(intent, 0);  // 2��° ȭ������ ���� ����� �޾ƿ� ���
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
