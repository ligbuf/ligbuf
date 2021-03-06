package Log;


import android.util.Log;

import com.google.code.microlog4android.*;
import com.google.code.microlog4android.appender.*;
import com.google.code.microlog4android.format.*;

/**
 * Microlog4Android 
 * 2012. 8. 23.?€ν 2:56:52
 * TODO Microlog4Android ?©νΌ ?΄λ??
 * @author JeongSeungsu
 * @description μ΄κΈ°?λ§ ?΄μ???
 */
public class Microlog4Android {
	/**
	 * ?μ­?μΌλ‘??Έμ ?λ Logger ?΄κ²?Όλ‘ ?΄μ  λ‘κ·Έλ₯??¨κΈ΄??
	 */
	static public Logger logger = LoggerFactory.getLogger();
		
	/**
	 * 2012. 8. 31.?€ν 5:18:31
	 * TODO MicroLog4Android μ΄κΈ°??
	 * @author JeongSeungsu
	 * @param PackageName ?¨ν€μ§??΄λ¦
	 * @param appendername ?΄ν???΄λ¦??
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
		} catch (Exception e) { // ?Έμ€?΄μ€(new)?€ν¨?μ ?? ?μΈ?¬ν­
			Log.e("LOG_ERROR", "FAIL Log4Andorid : " + appendernames);
		}

	}
	
	/**
	 * 2012. 8. 31.?€ν 5:17:57
	 * TODO		Appender?μ±
	 * @author JeongSeungsu
	 * @param PackageName ?¨ν€μ§??΄λ¦
	 * @param appendername ?΄ν???΄λ¦
	 * @return ?μ±???μ ?Έν°?μ΄???΄ν??
	 */
	private static Appender InitAppender(String PackageName, String appendername) {

		Log4Appender appender = null;

		try {
			
			appendername = PackageName+ "." + appendername;
			Class c = Class.forName(appendername);
			appender = (Log4Appender) c.newInstance();
			appender.CreateAppender();

		} catch (ClassNotFoundException e1) { // ?΄λ?€λ? μ°Ύμ?λͺ»ν??κ²½μ°???? ?μΈ?¬ν­
			Log.e("LOG_ERROR", "Class is Not Found");
			return null;
		} catch (InstantiationException e2) { // ?Έμ€?΄μ€(new)?€ν¨?μ ?? ?μΈ?¬ν­
			Log.e("LOG_ERROR", "new Instance Fail");
			return null;
		} catch (IllegalAccessException e3) { // ?μΌ?κ·Ό???? ?μΈ?¬ν­
			Log.e("LOG_ERROR", "Class File Access Error");
			return null;
		}

		return appender.GetAppender();
	}

	

	
}
