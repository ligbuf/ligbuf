package Log;


import android.util.Log;

import com.google.code.microlog4android.*;
import com.google.code.microlog4android.appender.*;
import com.google.code.microlog4android.format.*;

/**
 * Microlog4Android 
 * 2012. 8. 23.?�후 2:56:52
 * TODO Microlog4Android ?�퍼 ?�래??
 * @author JeongSeungsu
 * @description 초기?�만 ?��???
 */
public class Microlog4Android {
	/**
	 * ?�역?�으�??�수 ?�는 Logger ?�것?�로 ?�제 로그�??�긴??
	 */
	static public Logger logger = LoggerFactory.getLogger();
		
	/**
	 * 2012. 8. 31.?�후 5:18:31
	 * TODO MicroLog4Android 초기??
	 * @author JeongSeungsu
	 * @param PackageName ?�키�??�름
	 * @param appendername ?�펜???�름??
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
		} catch (Exception e) { // ?�스?�스(new)?�패?�에 ??�� ?�외?�항
			Log.e("LOG_ERROR", "FAIL Log4Andorid : " + appendernames);
		}

	}
	
	/**
	 * 2012. 8. 31.?�후 5:17:57
	 * TODO		Appender?�성
	 * @author JeongSeungsu
	 * @param PackageName ?�키�??�름
	 * @param appendername ?�펜???�름
	 * @return ?�성???�위 ?�터?�이???�펜??
	 */
	private static Appender InitAppender(String PackageName, String appendername) {

		Log4Appender appender = null;

		try {
			
			appendername = PackageName+ "." + appendername;
			Class c = Class.forName(appendername);
			appender = (Log4Appender) c.newInstance();
			appender.CreateAppender();

		} catch (ClassNotFoundException e1) { // ?�래?��? 찾�?못했??경우????�� ?�외?�항
			Log.e("LOG_ERROR", "Class is Not Found");
			return null;
		} catch (InstantiationException e2) { // ?�스?�스(new)?�패?�에 ??�� ?�외?�항
			Log.e("LOG_ERROR", "new Instance Fail");
			return null;
		} catch (IllegalAccessException e3) { // ?�일?�근????�� ?�외?�항
			Log.e("LOG_ERROR", "Class File Access Error");
			return null;
		}

		return appender.GetAppender();
	}

	

	
}
