package com.example.preferencetest;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class PreferenceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        
        //preference 를 사용한 데이터 저장
//        SharedPreferences pre = getSharedPreferences("test.xml", Context.MODE_WORLD_WRITEABLE);   
//        
//        SharedPreferences.Editor editor = pre.edit();
//        
//        editor.putString("one", "HI");
//        
//        editor.commit();
        
        
        //preference 를 사용한 데이터 리딩
        SharedPreferences pre = getSharedPreferences("test.xml", Context.MODE_WORLD_WRITEABLE);
        
        String str = pre.getString("one", "default");
        
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
        
    }


}
