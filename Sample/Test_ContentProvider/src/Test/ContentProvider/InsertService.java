package Test.ContentProvider;

import android.app.Service;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.RawContacts;
import android.util.Log;

/**
 * InsertService 
 * 2012. 9. 1.오전 12:35:02
 * TODO 주수록에 계속 데이터를 추가하는 일
 * @author JeongSeungsu
 * @description 액티비티에서 백그라운드에서 버튼을 누르면 주소록에 4초당 한개씩 주소를 넣는다.
 */
public class InsertService extends Service  {

	static int i = 0;
	static int j = 1000;
	Thread th;
	Runnable mRun = new Runnable() {
		
		public void run() {
			// TODO Auto-generated method stub
			try {
				while (!Thread.currentThread().isInterrupted()){
					Thread.sleep(4000);
					//새로운 Account Data 생성
					ContentValues values = new ContentValues();
					  values.put(ContactsContract.RawContacts.CONTACT_ID, 0);
					  values.put(ContactsContract.RawContacts.AGGREGATION_MODE, ContactsContract.RawContacts.AGGREGATION_MODE_DISABLED);
					  Uri rawContactUri = getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, values);
					  long rawContactId = ContentUris.parseId(rawContactUri);

					//Data를 삽입한다.

					  values.clear();
					  values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
					  values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
					  values.put(ContactsContract.CommonDataKinds.Phone.TYPE,Phone.TYPE_HOME);
					  values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, Integer.toString(j));
					  values.put(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME,Integer.toString(i));
		
					  /**
					   *  주수록 쿼리에 위에 임의의 데이터를 넣는다. 
					   */
					  Uri dataUri = getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);

					  i++;
					  j++;
					Log.d("Service","InsertData");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};
	
	public InsertService() {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Log.d("Service","Create");
	}


	/**
	 * 쓰레드 멈춤
	 */
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("Service","Destory");
		th.interrupt();
	}


	/**
	 * 쓰레드 시작 
	 */
	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
		Log.d("Service","Start");
		th = new Thread(mRun);
		th.start();
		
		
	}

}
