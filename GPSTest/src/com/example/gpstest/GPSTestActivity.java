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
			latLongString = "위도:" + lat + "\n경도:" + lng;
		} else {
			latLongString = "위치를찾을수없습니다.";
		}
		tv.setText("현재위치:\n" + latLongString);
		
		setContentView(tv);

	}
}
