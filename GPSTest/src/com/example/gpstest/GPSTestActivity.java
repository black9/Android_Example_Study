package com.example.gpstest;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class GPSTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		System.currentTimeMillis();
		
		TextView tv = new TextView(this);
		
		LocationManager locationManager = 
				(LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
		Location location = locationManager
				.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		
		String latLongString = "";
		if (location != null) {
			double lat = location.getLatitude();
			double lng = location.getLongitude();
			latLongString = "����:" + lat + "\n�浵:" + lng;
		} else {
			latLongString = "��ġ��ã���������ϴ�.";
		}
		tv.setText("������ġ:\n" + latLongString);
		
		setContentView(tv);

	}
}
