package abhishek2495.com.timeutilization.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DateWeekCalculationService {
	
	public DateWeekCalculationService() {
		// TODO Auto-generated constructor stub
	}

	public int getWeek(String dateinput) {

		String format = "ddMMyyyy";
		SimpleDateFormat df = new SimpleDateFormat(format);
		Date date = new Date();
		try {
			date = df.parse(dateinput);
		} catch (ParseException e) {
			
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week = cal.get(Calendar.WEEK_OF_YEAR);
		
		return week;
		
	}
}
