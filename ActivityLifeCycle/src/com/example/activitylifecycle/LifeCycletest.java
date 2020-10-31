package com.example.activitylifecycle;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;


public class LifeCycletest extends Activity {
    @Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.d("############", "onSaveInstanceState");
	}
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycletest);
        Log.d("############", "onCreate");
        
    }
	protected void onStart() {
		super.onStart();
		Log.d("############", "onStart");
	}
	protected void onResume() {
		super.onResume();
		Log.d("############", "onResume");
	}
	protected void onPause() {
		super.onPause();
		Log.d("############", "onPause");
	}
	protected void onStop() {
		super.onStop();
		Log.d("############", "onStop");
	}
	protected void onDestroy() {
		super.onDestroy();
		Log.d("############", "onDestroy");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d("############", "onRestart");
	}

	

	

	

	

}
