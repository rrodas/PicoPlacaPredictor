package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class PicoPlacaDate {

	public String getDayOfWeek(Date date) {

		String dayOfWeek = "";

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		// System.out.println("calendar:" + calendar.get(Calendar.DAY_OF_WEEK));

		switch (calendar.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			dayOfWeek = "sunday";
			break;
		case 2:
			dayOfWeek = "monday";
			break;
		case 3:
			dayOfWeek = "tuesday";
			break;
		case 4:
			dayOfWeek = "wednesday";
			break;
		case 5:
			dayOfWeek = "thursday";
			break;
		case 6:
			dayOfWeek = "friday";
			break;
		case 7:
			dayOfWeek = "saturday";
			break;
		default:
			break;
		}
		// System.out.println("DayOfWeek: " +dayOfWeek );
		return dayOfWeek;

	}

	public Date getDateFromString(String dateAsString) {

		Date dateStringToDate = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",
				Locale.getDefault());

		try {
			dateStringToDate = sdf.parse(dateAsString);
			// System.out.println(dateStringToDate);

		} catch (ParseException e) {			
			e.printStackTrace();
		}

		return dateStringToDate;
	}

	public boolean dateAlowToBeInRoad(String dayOfWeek, String plateNumber) {

		Plate plate = new Plate();
		String lastDigit = plate.getLastDigit(plateNumber);
		boolean idDateAllowToBeInRoad = true;
		switch (lastDigit) {
		case "1":

		case "2":
			if (dayOfWeek.equals("monday")) {
				idDateAllowToBeInRoad = false;
			}
			break;
		case "3":

		case "4":
			if (dayOfWeek.equals("tuesday")) {
				idDateAllowToBeInRoad = false;
			}
			break;
		case "5":

		case "6":
			if (dayOfWeek.equals("wednesday")) {
				idDateAllowToBeInRoad = false;
			}
			break;

		case "7":

		case "8":
			if (dayOfWeek.equals("thursday")) {
				idDateAllowToBeInRoad = false;
			}
			break;			

		case "9":
			
		case "0":
			if (dayOfWeek.equals("friday")) {
				idDateAllowToBeInRoad = false;
			}
			break;

		default:
			break;
		}
		
		//System.out.println("is allow: " +idDateAllowToBeInRoad );

		return idDateAllowToBeInRoad;

	}
	

}
