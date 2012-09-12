package com.example.logtest;




import Log.Microlog4Android;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

		try {

			setContentView(R.layout.activity_main);

			Microlog4Android.init("Log", "Log4LogCat|Log4File");

			// test logging
			Microlog4Android.logger.debug("debug"); // <- no logging by level
			Microlog4Android.logger.info("information");
			Microlog4Android.logger.warn("warning");
			Microlog4Android.logger.error("error");
			Microlog4Android.logger.fatal("fatal");

			// try-catch에서 오류 발생시 catch문에서 로그를 남김
			int a[] = { 5, 3, 10 };

			for (int i = 0; i < 100; i++) {
				a[i] = i + 2;
				Microlog4Android.logger.info("i = " + i);
			}

		} catch (Exception e) {
			Microlog4Android.logger.error(e);
			// TODO: handle exception
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
