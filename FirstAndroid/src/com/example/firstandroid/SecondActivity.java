package com.example.firstandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class SecondActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		Button b = new Button(this);
		
		b.setText("SecondAcitivty");
		
		setContentView(b);
		
	}

}
