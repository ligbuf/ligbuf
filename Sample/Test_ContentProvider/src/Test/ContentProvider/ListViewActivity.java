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
 * 2012. 9. 1.���� 12:37:04
 * TODO ȭ���� �����ϴ� ��Ƽ��Ƽ(�ּҷ�)
 * @author JeongSeungsu
 * @description ���״�� ȭ���� �ٷιٷ� ���ŵǴ� ���� �� �� ����.. 
 */
public class ListViewActivity extends ListActivity
{
	// where id, name , �ڹ� ��ȣ ������.
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
		
		// query ����.
		c = getContentResolver().query(Phone.CONTENT_URI, projection, where, null, null);
		

		
		// activity ���� �ֱ�� ��ġ ��Ų��.
		// �ش� activity�� �����ϴ��� �Ŵ����� �˾Ƽ� Ŀ���� �ݾ��ش�.
		// �ش� Ŀ���� ����ġ ����Ǿ� unloading�� �����͵鵵 �˾Ƽ� ó�����ش�.
		startManagingCursor(c);

		/**
		 * ����� ���� ������ ���� ���� Cursor ��ü�� �̿��� �����
		 */
		adapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_multiple_choice, c,
												new String[] { Data.DISPLAY_NAME, Phone.NUMBER },
												new int[] { android.R.id.text1, android.R.id.text2 });
		
		
		lv = getListView();
						
		/**
		 * �信 ����� ���
		 */
		lv.setAdapter(adapter);
		lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
						
		StartButton.setOnClickListener(new OnClickListener()
		{
			
			public void onClick(View v)
			{
				/**
				 * �ּҷϿ� 4�ʿ� �ѹ��� �����ϴ� ���� ����
				 */
				Intent it = new Intent("com.test.INSERTSERVICE");
				startService(it);
			}
			
		});
		StopButton.setOnClickListener(new OnClickListener(){
			
			public void onClick(View v)
			{
				/**
				 * ���� ���� ����
				 */
				Intent it = new Intent("com.test.INSERTSERVICE");
				stopService(it);
				
			}
		});
		DeleteButton.setOnClickListener(new OnClickListener(){
			
			public void onClick(View v) {

				/**
				 * ������ ���� ��� �ּҷ� ����
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
