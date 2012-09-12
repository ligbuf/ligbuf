package Test.ContentProvider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * Test_ContentProvider 
 * 2012. 9. 1.오전 12:40:40
 * TODO  매인 액티비티
 * @author JeongSeungsu
 * @description 그냥 껍데기 매인 액티비티
 */
public class Test_ContentProvider extends Activity
{
	Button listButton;
	TextView tv;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		listButton = (Button)findViewById(R.id.listButton);
		listButton.setOnClickListener(clickListener);
	
		tv = (TextView)findViewById(R.id.phoneNumberTextView);
		
	}
	
	private OnClickListener clickListener = new OnClickListener()
	{
		
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			switch(v.getId())
			{
			case R.id.listButton:
				{
					Intent intent = new Intent(Test_ContentProvider.this, ListViewActivity.class);
					startActivity(intent);
					
				}break;

			}
			
		}
	};
}