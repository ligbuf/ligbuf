package Log;

import com.google.code.microlog4android.appender.Appender;

/**
 * Log4Appender 
 * 2012. 8. 28.?�후 7:59:45
 * TODO FactoryMethod?�서 ???�래?�들??�?��??�� 초기???�는??��
 * @author JeongSeungsu
 * @description 
 */
public abstract class Log4Appender 
{
	/**
	 * 2012. 8. 28.?�후 8:00:22
	 * TODO 모든 ?�펜?�들???�야??기본?�인 초기??과정 
	 * @author JeongSeungsu
	 * @param appender 무슨 ?�펜?��? 만들�?결정...
	 */
	public abstract void CreateAppender();
	
	public abstract Appender GetAppender();
	
}
