package com.example.sqlitetest;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class SQLiteActivity extends Activity {

	SQLiteDatabase sd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sqlite);

		sd = openOrCreateDatabase("test", SQLiteDatabase.CREATE_IF_NECESSARY,
				null);

		String schema = "create table note "
				+ "(_id integer primary key autoincrement, "
				+ "title text not null , body text not null);";
		try {
			sd.execSQL(schema);
		} catch (Exception ignore) {

		}

		ContentValues values = new ContentValues();
		values.put("title", "First");
		values.put("body", "HI");
		sd.insert("note", null, values);
	}

}
