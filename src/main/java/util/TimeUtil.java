package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

	public static String getTimeStamp(){
		SimpleDateFormat dateFormate = new SimpleDateFormat("ddMMYYYYHHmmssa");
		Date date = new Date();
		/*Calendar calendar = Calendar.getInstance();
		int monthIndex = calendar.get(Calendar.MONTH) + 1;
		System.out.println(monthIndex);
		*/
		String timeStamp  = dateFormate.format(date);
		return timeStamp;
	}
	
}
