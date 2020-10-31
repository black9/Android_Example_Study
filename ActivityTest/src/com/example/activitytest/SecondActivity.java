package com.example.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends Activity{

	static final int RESULT_OK = 1;
	static final int RESULT_NO = 0;
	
	EditText e1;
	EditText e2;
	
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.second);
        
        Intent i = getIntent();
        
        String str = i.getStringExtra("10");
        
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
        
        e1 = (EditText)findViewById(R.id.editText1);
        
        e2 = (EditText)findViewById(R.id.editText2);
        
        Button b = (Button)findViewById(R.id.button2);
        
        b.setOnClickListener( new View.OnClickListener(){
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				i.putExtra("id", e1.getText() +"");
				i.putExtra("pass", e2.getText() +"");
				
				setResult(RESULT_OK, i);
				finish();   	//화면(Activity) 종료
			}
		} ) ;
        
        
        
        
        
    }
	

}
