package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PicoPlacaHour {

	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

	public boolean timeAlowToBeInRoad(Date date) {

		boolean isTimeAllow = false;

		int hours = getHours(date);
		int minutes = getMinutes(date);
		if ((hours >= 7 && hours <= 9) || (hours >= 16 && hours <= 19)) {
			if (minutes >= 0 && minutes <= 30) {
				isTimeAllow = false;
			}
		} else {
			isTimeAllow = true;
		}

		//System.out.println(isTimeAllow);
		return isTimeAllow;

	}

	public int getHours(Date date) {

		String hours = sdf.format(date).substring(0, 2);

		//System.out.println(hours);

		return Integer.parseInt(hours);

	}

	public int getMinutes(Date date) {

		String minutes = (sdf.format(date)).substring(3, 5);

		//System.out.println(minutes);

		return Integer.parseInt(minutes);

	}
	
	public Date getHoursMinutesAsDate(String hoursMinutesAsString) {

		Date hoursMinutestringToDate = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm",
				Locale.getDefault());

		try {
			hoursMinutestringToDate = sdf.parse(hoursMinutesAsString);
			//System.out.println(hoursMinutestringToDate);

		} catch (ParseException e) {			
			e.printStackTrace();
		}

		return hoursMinutestringToDate;
	}

	
}
