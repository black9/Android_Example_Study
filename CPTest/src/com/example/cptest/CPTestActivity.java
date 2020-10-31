package com.example.cptest;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.v4.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class CPTestActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		String re[] = { CallLog.Calls._ID, 
				CallLog.Calls.NUMBER,// ��ȭ��ȣ
				CallLog.Calls.DURATION };// ���ð�

		Cursor calls = managedQuery(CallLog.Calls.CONTENT_URI, re, null, null,
				null);
		
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, 
				R.layout.line, 
				calls, 
				new String[]{CallLog.Calls.NUMBER, CallLog.Calls.DURATION} , 
				new int[]{R.id.textView1, R.id.textView3} );
		
		setListAdapter(adapter);

	}

}








//calls.moveToFirst();
//String temp = "";
//while (!calls.isAfterLast()) {
//	temp += "��ȭ��ȣ= " + calls.getString(0) + '\t' + "���ð�(s) ="
//			+ calls.getInt(1) + '\n';
//	calls.moveToNext();
//}
//TextView tv = new TextView(this);
//tv.setText(temp);
//setContentView(tv);