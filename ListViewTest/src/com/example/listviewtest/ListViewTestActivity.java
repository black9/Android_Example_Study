package com.example.listviewtest;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewTestActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

//		setContentView(R.layout.listtest);

		String str[] = { "abc", "def", "ghi" };

		ArrayAdapter<String> adapter = 
				new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, str);
//				new ArrayAdapter<String>(this,      //context
//						R.layout.line,				//������ ���
//						R.id.button1,				//���޵Ǵ� �����Ͱ� ������ View 
//						str);						//���޵Ǵ� ������
		
//		ListView list = (ListView)findViewById(R.id.listView1);
		
//		list.setAdapter(adapter);
		
		setListAdapter(adapter);

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		
		Toast.makeText(this, position+"", Toast.LENGTH_LONG).show();
		
	}

	
	
	
}
