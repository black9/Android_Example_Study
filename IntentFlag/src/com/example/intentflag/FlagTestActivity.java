package com.example.intentflag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

public class FlagTestActivity extends Activity {

	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		super.onNewIntent(intent);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		for (int j = 0; j < 3; j++) {
			Intent i = new Intent(this, SecondActivity.class);

			i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			
//			i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
//			
//			i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

			startActivity(i);
		}

		return super.onTouchEvent(event);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getIntent();
		
		setContentView(R.layout.activity_flag_test);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.flag_test, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
