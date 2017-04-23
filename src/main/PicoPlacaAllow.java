package main;

import java.util.Date;

public class PicoPlacaAllow {
	
	public boolean allowToBeOnTheRoad(String plateNumber, String dateAsString, Date hour){
		
		boolean isAllowToBeOntheRoad = false;		
		
		PicoPlacaDate ppd = new PicoPlacaDate();		
		PicoPlacaHour pph = new PicoPlacaHour();
		
		
		//Date
		Date date = ppd.getDateFromString(dateAsString);
		String dayOfWeek = ppd.getDayOfWeek(date);
		boolean isDateAllow = ppd.dateAlowToBeInRoad(dayOfWeek, plateNumber);
		
		//Hour
		boolean isTimeAllow = pph.timeAlowToBeInRoad(date);
		
		if(isDateAllow &&  isTimeAllow)
		{ 
			isAllowToBeOntheRoad = true;
		}
		
		
		return isAllowToBeOntheRoad;
		
		
	}
	

}
