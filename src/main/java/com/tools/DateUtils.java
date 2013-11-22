package com.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.junit.Assert;

public class DateUtils {

	public static Date getNow() {
		return Calendar.getInstance().getTime();
	}

	public static Date getStringAsDate(String date) {
		try {
			return new SimpleDateFormat("MM/dd/yyyy").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			Assert.fail("The date format is incorrect!");
			return null;
		}
	}

	public static String getDateAsString(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return new SimpleDateFormat("MM/dd/yyyy").format(cal.getTime());
	}

	public static String getTodayAsString() {
		Calendar cal = Calendar.getInstance();
		return new SimpleDateFormat("MM/dd/yyyy").format(cal.getTime());
	}

	public static String getDateInTheFutureAsString(int daysOffset) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, daysOffset);
		return new SimpleDateFormat("MM/dd/yyyy").format(cal.getTime());
	}

	public static String addDaysToStringDate(String date, int days) {
		Calendar cal = Calendar.getInstance();
		Date outputDate = getStringAsDate(date);
		cal.setTime(outputDate);
		cal.add(Calendar.DATE, days);
		return getDateAsString(cal.getTime());
	}

	public static Date getYesterday() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	public static Date addMinutes(Date date, int minutes) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, minutes);
		return cal.getTime();
	}

	public static Date addHours(Date date, int hours) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, hours);
		return cal.getTime();
	}

	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	/**
	 * Returns a list of the dates that are situated in different days between
	 * the given dates. The hour and minute of the days in the list are the same
	 * as the @initialDate
	 * 
	 * @param initialDate
	 * @param finalDate
	 * @return
	 */
	public static List<Date> getListOfDatesBetweenDates(Date initialDate, Date finalDate) {
		List<Date> dates = new ArrayList<Date>();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(initialDate);
		while (calendar.getTime().before(finalDate)) {
			Date currentDate = calendar.getTime();
			dates.add(currentDate);
			calendar.add(Calendar.DATE, 1);
		}
		return dates;
	}

	/**
	 * Returns a random date that is situated between the given dates
	 * 
	 * @param initialDate
	 * @param finalDate
	 * @return
	 */
	public static Date getRandomDateBetweenDates(Date initialDate, Date finalDate) {
		List<Date> dates = getListOfDatesBetweenDates(initialDate, finalDate);
		return StringUtils.getRandomItemFromList(dates);
	}

	public static String toStringForTags(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy", Locale.US);
		String desiredDate = formatter.format(date);
		return desiredDate;
	}

	/**
	 * @param date
	 *            : "27-Nov-2012 09:24 AM"
	 * @return "27-Nov-2012"
	 */
	public static String getDayMonthYearFromString(String date) {
		String dateParts[] = date.split(" ");
		return dateParts[0];
	}

	/**
	 * @param date
	 *            : "27-Nov-2012 09:24 AM"
	 * @return
	 */
	public static String getHourMinuteFromString(String date) {
		String dateParts[] = date.split(" ");
		return dateParts[1];
	}

	/**
	 * @param date
	 *            : "27-Nov-2012 09:24 AM"
	 * @return
	 */
	public static String getHourMinuteWithAmPmFromString(String date) {
		String dateParts[] = date.split(" ");
		return dateParts[1] + " " + dateParts[2];
	}

	public static String toString(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("d-MMM-yyyy", Locale.US);
		String desiredDate = formatter.format(date);
		return desiredDate;
	}

	public static String toString(Date date, String dateFormat) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat, Locale.US);
		String desiredDate = formatter.format(date);
		return desiredDate;
	}

	/**
	 * This method format is : dd-MMM-yyyy HH:mm a (eg: 6-Oct-2012 03:18:33)
	 */
	public static String toStringTime(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("d-MMM-yyyy hh:mm:ss", Locale.US);
		String desiredDate = formatter.format(date);
		return desiredDate;
	}

	public static Date fromStringTime(String dateString) {
		SimpleDateFormat formatter = new SimpleDateFormat("d-MMM-yyyy hh:mm:ss", Locale.US);
		Date date = null;
		try {
			date = formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date fromStringTime(String dateString, String formatType) {
		SimpleDateFormat formatter = new SimpleDateFormat(formatType, Locale.US);
		Date date = null;
		try {
			date = formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date fromString(String dateString) {
		SimpleDateFormat formatter = new SimpleDateFormat("d-MMM-yyyy", Locale.US);
		Date date = null;
		try {
			date = formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date getDate(int daysDeviation) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, daysDeviation);
		return cal.getTime();
	}

	public static String getMonthName(Date date) {
		return new SimpleDateFormat("MMMMM").format(date);
	}

	public static String getShortMonthName(Date date) {
		return new SimpleDateFormat("MMM").format(date);
	}

	public static String getDayName(Date date) {
		return new SimpleDateFormat("EEEEE", new Locale("en", "US")).format(date);
	}

	public static Integer getDateYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}

	public static int getDateMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH) + 1;
	}

	public static Integer getDateDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DATE);
	}

	public static String getDateDayToString(Date date) {
		return new SimpleDateFormat("dd").format(date);
	}

	public static String getDateMonthToStringWithZeroPadding(Date date) {
		return new SimpleDateFormat("MM").format(date);
	}

	public static String getDateMonthToString(Date date) {
		return new SimpleDateFormat("M").format(date);
	}

	public static String getDateHourAndMinute(Date date) {
		return new SimpleDateFormat("hh:mm aa").format(date);
	}

	public static String toStringForTagsWithDecimalPoint(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM.-yyyy", Locale.US);
		String desiredDate = formatter.format(date);
		return desiredDate;
	}

	public static String getMonthNumberFromString(String monthName) {
		Date date = null;
		try {
			date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(monthName);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat formatter = new SimpleDateFormat("MM", Locale.US);
		String desiredDate = formatter.format(date);
		return desiredDate;
	}

	public static String formatStringDate(String date, String initialDateFormat, String finalDateFormat) {
		SimpleDateFormat formatter = new SimpleDateFormat(finalDateFormat, Locale.US);
		String desiredDate = formatter.format(fromStringTime(date, initialDateFormat));
		return desiredDate;
	}
	
}
