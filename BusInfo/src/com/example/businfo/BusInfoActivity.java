package com.example.businfo;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.List;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.EditText;

public class BusInfoActivity extends Activity {
	
	EditText tv;
	
	String result = "";
	
	class MyHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			// main thread에 의해 실행될 코드
			tv.setText(result.trim());
		}
	}
	
	MyHandler handler = new MyHandler();
	
	class MyThread extends Thread {
		public void run() {
			try {

				URL url = new URL(
						"http://businfo.daegu.go.kr/ba/arrbus/arrbus.do?act=arrbus&winc_id=02104");
				
				InputStream is = url.openStream();
				
				Reader r = new InputStreamReader(is,"euc-kr");
				
				Source s = new Source(r);
				
				List list = s.getAllElements();
				
				for (int i = 0 ; i< list.size(); i++) {
					Element e = (Element)list.get(i);
					if ( e.getName().equals("li") ) {
						Log.d("##########" , e.getTextExtractor()+"" );
					}
				}
				
				handler.sendEmptyMessage(0);
//				tv.setText(result.trim());
			} catch (Exception e) {
				e.printStackTrace();
				Log.d("Network Exception", "" + e);
			}
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		tv = new EditText(this);
		setContentView(tv);
		
		MyThread m = new MyThread();
		m.start();
	}
	

}











//URL url = new URL("http://businfo.daegu.go.kr/ba/arrbus/arrbus.do");
//HttpURLConnection con = (HttpURLConnection) url.openConnection();
//con.setDoOutput(true);
//String parameter = "act=arrbus&winc_id=02104";
//OutputStream wr = con.getOutputStream();
//wr.write(parameter.getBytes());
//wr.flush();
//
//BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream(),"euc-kr"));
//String line = null;
//
//while ((line = rd.readLine()) != null) {
//	result += line;
//	result += '\n';
//}
