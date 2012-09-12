package Log;

import com.google.code.microlog4android.appender.Appender;

/**
 * Log4Appender 
 * 2012. 8. 28.?¤í›„ 7:59:45
 * TODO FactoryMethod?ì„œ ???´ë˜?¤ë“¤??ê°? ¸??„œ ì´ˆê¸°???˜ëŠ”??™œ
 * @author JeongSeungsu
 * @description 
 */
public abstract class Log4Appender 
{
	/**
	 * 2012. 8. 28.?¤í›„ 8:00:22
	 * TODO ëª¨ë“  ?´íœ?”ë“¤???´ì•¼??ê¸°ë³¸?ì¸ ì´ˆê¸°??ê³¼ì • 
	 * @author JeongSeungsu
	 * @param appender ë¬´ìŠ¨ ?´íœ?”ë? ë§Œë“¤ì§?ê²°ì •...
	 */
	public abstract void CreateAppender();
	
	public abstract Appender GetAppender();
	
}
