package com.example.gametest;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

class Unit {
	// ��� Ÿ�� ������ ���� ���
	static final int MAL = 0;
	static final int LARGE = 1;
	static final int MIDDLE = 2;
	static final int SMALL = 3;

	int type = Unit.SMALL;

	int x = 0;
	int y = 0;
	int ax = 5;
	int ay = 5;
	int health = 500;
	int score = 50;
	Bitmap image;

	double x_area = 1;
	double y_area = 1;
}

class ���󸮾� extends Unit {
}

class ū��� extends Unit {
}

class �߰���� extends Unit {
}

class ������� extends Unit {
}

public class GameTestActivity extends Activity {

	int x = 50;
	int y = 50;

	int ax = 5;
	int ay = 5;

	int score = 0;

	ArrayList totalUnit = new ArrayList();

	int unit_count = 100;

	int width = 720;
	int height = 1280;

	MyView m;

	MyHandler h = new MyHandler();

	class MyHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			// MyView ����
			m.invalidate();
			sendEmptyMessageDelayed(0, 5);
		}
	}

	class MyView extends View {
		Bitmap image;

		@Override
		public boolean onTouchEvent(MotionEvent event) {
			int x2 = (int) event.getX();
			int y2 = (int) event.getY();

			for (int i = 0; i < unit_count; i++) {
				Unit u = (Unit) totalUnit.get(i);

				int a = x2 - u.x;
				int c = y2 - u.y;

				int b = (int) Math.sqrt(Math.pow(a, 2) + Math.pow(c, 2));

				if (b < 50) {

					u.health = u.health - 500;

					if (u.health == 0) {
						score = score + u.score;
						totalUnit.remove(i);
						unit_count--;
					}

				}

			}
			return super.onTouchEvent(event);
		}

		@Override
		protected void onDraw(Canvas canvas) {
			Paint paint = new Paint();
			paint.setTextSize(70);
			paint.setColor(Color.BLUE);
			canvas.drawText(score + "", (int) (width * 0.9),
					(int) (height * 0.1), paint);

			for (int i = 0; i < unit_count; i++) {
				Unit u = (Unit) totalUnit.get(i);

				if (u.type == Unit.MAL) {
					switch (u.health) {
					case 1500:
						u.image = BitmapFactory.decodeResource(getResources(),
								R.drawable.mal_1);
						break;
					case 1000:
						u.image = BitmapFactory.decodeResource(getResources(),
								R.drawable.mal_2);
						break;
					case 500:
						u.image = BitmapFactory.decodeResource(getResources(),
								R.drawable.mal_3);
						break;
					}
				}
				canvas.drawBitmap(u.image, u.x, u.y, null);

				u.x = u.x + u.ax;
				u.y = u.y + u.ay;

				if (u.x > width * u.x_area || u.x < 0) {
					u.ax = -u.ax;
				} else if (u.y > height * u.y_area || u.y < 0) {
					u.ay = -ay;
				}
			}

		}

		public MyView(Context context) {
			super(context);
			image = BitmapFactory.decodeResource(getResources(),
					R.drawable.myunit);

			h.sendEmptyMessage(0);

			// �ܸ������ػ󵵰����ϱ�
			WindowManager wm = (WindowManager) context
					.getSystemService(Context.WINDOW_SERVICE);
			Display display = wm.getDefaultDisplay();

			width = display.getWidth();
			height = display.getHeight();

			setBackgroundResource(R.drawable.back);

			for (int i = 0; i < unit_count; i++) {

				Unit u = new Unit();
				int c = (int) (Math.random() * 4 + 1);

				switch (c) {

				case 1:
					u = new ���󸮾�();
					u.score = 200;
					u.health = 2000;
					u.x_area = 0.5;
					u.type = Unit.MAL;
					u.image = BitmapFactory.decodeResource(getResources(),
							R.drawable.mal);
					break;
				case 2:
					u = new ū���();
					u.score = 150;
					u.health = 1500;
					u.y_area = 0.5;
					u.image = BitmapFactory.decodeResource(getResources(),
							R.drawable.large);
					break;
				case 3:
					u = new �������();
					u.score = 50;
					u.health = 500;
					u.image = BitmapFactory.decodeResource(getResources(),
							R.drawable.middle);
					break;
				case 4:
					u = new �߰����();
					u.score = 100;
					u.health = 1000;
					u.image = BitmapFactory.decodeResource(getResources(),
							R.drawable.small);
					break;
				}

				u.x = (int) (Math.random() * width);
				u.y = (int) (Math.random() * height);

				u.ax = (int) (Math.random() * 5 + 1);
				u.ay = (int) (Math.random() * 5 + 1);

				totalUnit.add(u);
			}
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		m = new MyView(this);

		setContentView(m);
	}

}
