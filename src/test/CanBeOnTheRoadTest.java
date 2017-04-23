package test;

import java.util.Calendar;
import java.util.Date;

import main.PicoPlacaAllow;
import main.PicoPlacaDate;
import main.PicoPlacaHour;
import main.Plate;

import org.junit.Assert;
import org.junit.Test;

public class CanBeOnTheRoadTest {

	PicoPlacaHour picoPlacaHour = new PicoPlacaHour();
	Calendar calendar = Calendar.getInstance();
	PicoPlacaDate picoPlacaDate = new PicoPlacaDate();
	PicoPlacaAllow ppa = new PicoPlacaAllow();

	@Test
	public void returnLastDigitTest() {

		Plate plate = new Plate();

		String last = plate.getLastDigit("PBU7210");

		Assert.assertEquals("Last Digit Test: ", "0", last);
	}

	@Test
	public void returnDayOfWeekTest() {

		calendar.set(Calendar.DAY_OF_WEEK, 5);

		String day = picoPlacaDate.getDayOfWeek(calendar.getTime());

		Assert.assertEquals("Day of Week: ", "thursday", day);

	}

	@Test
	public void returnDateFromStringTest() {

		Date date = new Date();

		date = picoPlacaDate.getDateFromString("20/04/2017");

		Assert.assertNotNull("String is date: ", date);

	}

	@Test
	public void getHoursFromATime() {

		calendar.set(Calendar.HOUR_OF_DAY, 16);

		int hours = picoPlacaHour.getHours(calendar.getTime());

		Assert.assertEquals("get Hours: ", 16, hours);

	}

	@Test
	public void geMinutesFromATimeTest() {

		calendar.set(Calendar.MINUTE, 06);

		int minutes = picoPlacaHour.getMinutes(calendar.getTime());

		Assert.assertEquals("get Hours: ", 06, minutes);

	}

	@Test
	public void returnTimeAllowToBeInRoadTest() {

		boolean isTimeAllow = picoPlacaHour.timeAlowToBeInRoad(calendar
				.getTime());

		Assert.assertEquals("Time Allow: ", false, isTimeAllow);

	}

	@Test
	public void returnDateAllowToBeInRoadTest() {

		boolean isDateAllow = picoPlacaDate.dateAlowToBeInRoad("monday",
				"PBU-7216");

		Assert.assertEquals("Date Allow: ", true, isDateAllow);

	}

	@Test
	public void returnPicoPlacaNotAllowTest() {

		// MONDAY
		Date hourMinutes = picoPlacaHour.getHoursMinutesAsDate("08:20");

		boolean isAllow = ppa.allowToBeOnTheRoad("PBU-7211", "17/04/2017",
				hourMinutes);

		Assert.assertFalse("Pico Placa allow: ", isAllow);

		// TUESDAY
		isAllow = ppa.allowToBeOnTheRoad("PBU-7213", "18/04/2017", hourMinutes);

		Assert.assertFalse("Pico Placa allow: ", isAllow);

		// WEDNESDAY
		isAllow = ppa.allowToBeOnTheRoad("PBU-7215", "19/04/2017", hourMinutes);

		Assert.assertFalse("Pico Placa allow: ", isAllow);

		// THURSDAY
		isAllow = ppa.allowToBeOnTheRoad("PBU-7217", "20/04/2017", hourMinutes);

		Assert.assertFalse("Pico Placa allow: ", isAllow);

		// FRIDAY
		isAllow = ppa.allowToBeOnTheRoad("PBU-7219", "21/04/2017", hourMinutes);

		Assert.assertFalse("Pico Placa allow: ", isAllow);



	}

	@Test
	public void returnPicoPlacaAllowTest() {

		// MONDAY
		Date hourMinutes = picoPlacaHour.getHoursMinutesAsDate("08:20");

		boolean isAllow = ppa.allowToBeOnTheRoad("PBU-7216", "17/04/2017",
				hourMinutes);

		Assert.assertTrue("Pico Placa allow: ", isAllow);

		// TUESDAY
		isAllow = ppa.allowToBeOnTheRoad("PBU-7215", "18/04/2017", hourMinutes);

		Assert.assertTrue("Pico Placa allow: ", isAllow);

		// WEDNESDAY
		isAllow = ppa.allowToBeOnTheRoad("PBU-7213", "19/04/2017", hourMinutes);

		Assert.assertTrue("Pico Placa allow: ", isAllow);

		// THURSDAY
		isAllow = ppa.allowToBeOnTheRoad("PBU-7213", "20/04/2017", hourMinutes);

		Assert.assertTrue("Pico Placa allow: ", isAllow);

		// FRIDAY
		isAllow = ppa.allowToBeOnTheRoad("PBU-7212", "21/04/2017", hourMinutes);

		Assert.assertTrue("Pico Placa allow: ", isAllow);

		// SATURDAY
		isAllow = ppa.allowToBeOnTheRoad("PBU-7211", "22/04/2017", hourMinutes);

		Assert.assertTrue("Pico Placa allow: ", isAllow);

		// SUNDAY
		isAllow = ppa.allowToBeOnTheRoad("PBU-7210", "22/04/2017", hourMinutes);

		Assert.assertTrue("Pico Placa allow: ", isAllow);

	}

}
