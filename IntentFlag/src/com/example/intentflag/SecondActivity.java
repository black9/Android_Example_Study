package com.example.intentflag;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity{
	
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
	        TextView t = new TextView(this);
	        
	        t.setText("SecondActivity");
	        
	        setContentView(t);
	 }

}
