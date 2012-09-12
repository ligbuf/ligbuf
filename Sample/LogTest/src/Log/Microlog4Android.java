package Log;


import android.util.Log;

import com.google.code.microlog4android.*;
import com.google.code.microlog4android.appender.*;
import com.google.code.microlog4android.format.*;

/**
 * Microlog4Android 
 * 2012. 8. 23.?¤í›„ 2:56:52
 * TODO Microlog4Android ?©í¼ ?´ë˜??
 * @author JeongSeungsu
 * @description ì´ˆê¸°?”ë§Œ ?´ì???
 */
public class Microlog4Android {
	/**
	 * ?„ì—­?ìœ¼ë¡??¸ìˆ˜ ?ˆëŠ” Logger ?´ê²ƒ?¼ë¡œ ?´ì œ ë¡œê·¸ë¥??¨ê¸´??
	 */
	static public Logger logger = LoggerFactory.getLogger();
		
	/**
	 * 2012. 8. 31.?¤í›„ 5:18:31
	 * TODO MicroLog4Android ì´ˆê¸°??
	 * @author JeongSeungsu
	 * @param PackageName ?¨í‚¤ì§??´ë¦„
	 * @param appendername ?´íœ???´ë¦„??
	 */
	public static void init(String PackageName, String appendernames)
	{
		try {
			PatternFormatter formatter = new PatternFormatter();
			formatter.setPattern("   %d{ISO8601}    [%P]  %m  %T  ");
			logger.setLevel(Level.DEBUG);

			String[] StrArray;

			StrArray = appendernames.split("\\|");

			for (String s : StrArray) {

				Appender appender = InitAppender(PackageName,s);

				appender.setFormatter(formatter);
				logger.addAppender(appender);
			}
			
			logger.info("LogInit");
		} catch (Exception e) { // ?¸ìŠ¤?´ìŠ¤(new)?¤íŒ¨?œì— ??•œ ?ˆì™¸?¬í•­
			Log.e("LOG_ERROR", "FAIL Log4Andorid : " + appendernames);
		}

	}
	
	/**
	 * 2012. 8. 31.?¤í›„ 5:17:57
	 * TODO		Appender?ì„±
	 * @author JeongSeungsu
	 * @param PackageName ?¨í‚¤ì§??´ë¦„
	 * @param appendername ?´íœ???´ë¦„
	 * @return ?ì„±???ìœ„ ?¸í„°?˜ì´???´íœ??
	 */
	private static Appender InitAppender(String PackageName, String appendername) {

		Log4Appender appender = null;

		try {
			
			appendername = PackageName+ "." + appendername;
			Class c = Class.forName(appendername);
			appender = (Log4Appender) c.newInstance();
			appender.CreateAppender();

		} catch (ClassNotFoundException e1) { // ?´ë˜?¤ë? ì°¾ì?ëª»í–ˆ??ê²½ìš°????•œ ?ˆì™¸?¬í•­
			Log.e("LOG_ERROR", "Class is Not Found");
			return null;
		} catch (InstantiationException e2) { // ?¸ìŠ¤?´ìŠ¤(new)?¤íŒ¨?œì— ??•œ ?ˆì™¸?¬í•­
			Log.e("LOG_ERROR", "new Instance Fail");
			return null;
		} catch (IllegalAccessException e3) { // ?Œì¼?‘ê·¼????•œ ?ˆì™¸?¬í•­
			Log.e("LOG_ERROR", "Class File Access Error");
			return null;
		}

		return appender.GetAppender();
	}

	

	
}
