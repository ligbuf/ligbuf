package Test.ContentProvider;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

/**
 * ListViewActivity 
 * 2012. 9. 1.오전 12:37:04
 * TODO 화면을 관리하는 액티비티(주소록)
 * @author JeongSeungsu
 * @description 말그대로 화면이 바로바로 갱신되는 것을 볼 수 있음.. 
 */
public class ListViewActivity extends ListActivity
{
	// where id, name , 핸번 번호 까지만.
	private String[] projection = new String[] { Data._ID, Data.DISPLAY_NAME, Phone.NUMBER };
	private String where = Data.MIMETYPE + "='" + Phone.CONTENT_ITEM_TYPE + "'";
	Cursor c;
	
	Button StartButton;
	Button StopButton;
	Button DeleteButton;
	TextView contentText;
	ListAdapter adapter;
	ListView lv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_view_activity);
		
		StartButton = (Button)findViewById(R.id.StartButton);
		StopButton  = (Button)findViewById(R.id.StopButton);
		DeleteButton= (Button)findViewById(R.id.DeleteButton);
		contentText = (TextView)findViewById(R.id.conTextView);
		
		// query 날려.
		c = getContentResolver().query(Phone.CONTENT_URI, projection, where, null, null);
		

		
		// activity 생명 주기와 일치 시킨다.
		// 해당 activity가 종료하더라도 매니져가 알아서 커서를 닫아준다.
		// 해당 커서가 예상치 종료되어 unloading된 데이터들도 알아서 처리해준다.
		startManagingCursor(c);

		/**
		 * 어댑터 생성 쿼리를 날려 나온 Cursor 객체를 이용한 어댑터
		 */
		adapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_multiple_choice, c,
												new String[] { Data.DISPLAY_NAME, Phone.NUMBER },
												new int[] { android.R.id.text1, android.R.id.text2 });
		
		
		lv = getListView();
						
		/**
		 * 뷰에 어댑터 등록
		 */
		lv.setAdapter(adapter);
		lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
						
		StartButton.setOnClickListener(new OnClickListener()
		{
			
			public void onClick(View v)
			{
				/**
				 * 주소록에 4초에 한번씩 갱시하는 서비스 시작
				 */
				Intent it = new Intent("com.test.INSERTSERVICE");
				startService(it);
			}
			
		});
		StopButton.setOnClickListener(new OnClickListener(){
			
			public void onClick(View v)
			{
				/**
				 * 위의 서비스 멈춤
				 */
				Intent it = new Intent("com.test.INSERTSERVICE");
				stopService(it);
				
			}
		});
		DeleteButton.setOnClickListener(new OnClickListener(){
			
			public void onClick(View v) {

				/**
				 * 쿼리를 날려 모든 주소록 삭제
				 */
				getContentResolver().delete(
						ContactsContract.RawContacts.CONTENT_URI,
						null,
						null);
				
				Log.d("","DeleteContract");
			
			}
		});
		
	}
	
}
