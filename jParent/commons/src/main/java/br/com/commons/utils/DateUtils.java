package br.com.commons.utils;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Generic methods to use with date.
 */
public class DateUtils {

	/**
	 * Log4j.
	 */
	public static Log logger = LogFactory.getLog(DateUtils.class);

	/**
	 * @return Current date
	 */
	public static String currentDate() {
		final Format formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		final String data = formatter.format(new Date());

		return data;
	}

	/**
	 * Removing business days in the date.
	 *
	 * @param date     object will be calculated
	 * @param plusDays Quantity of days to make calculate
	 * @return Calculated date
	 */
	public static Date removeBusinessDays(final Date date, Integer plusDays) {
		final Calendar initDate = Calendar.getInstance();

		initDate.setTime(date);
		while (plusDays > 0) {
			initDate.add(Calendar.DAY_OF_MONTH, -1);

			final int weekDay = initDate.get(Calendar.DAY_OF_WEEK);
			if (weekDay != Calendar.SATURDAY && weekDay != Calendar.SUNDAY) {
				--plusDays;
			}
		}
		return initDate.getTime();
	}

	/**
	 * Adding business days in the date.
	 *
	 * @param date     object will be calculated
	 * @param plusDays Quantity of days to make calculate
	 * @return Calculated date
	 */
	public static Date addBusinessDays(final Date date, Integer plusDays) {
		final Calendar initDate = Calendar.getInstance();

		initDate.setTime(date);
		while (plusDays > 0) {
			initDate.add(Calendar.DAY_OF_MONTH, 1);

			final int weekDay = initDate.get(Calendar.DAY_OF_WEEK);
			if (weekDay != Calendar.SATURDAY && weekDay != Calendar.SUNDAY) {
				--plusDays;
			}
		}
		return initDate.getTime();
	}

	/**
	 * Adding days in the date.
	 *
	 * @param date object will be calculated
	 * @param days Quantity of days to make calculate
	 * @return Calculated date
	 */
	public static Date addDays(final Date date, final int days) {
		final Calendar calendar = Calendar.getInstance();
		Date newDate = (Date) date.clone();

		calendar.setTime(newDate);
		calendar.add(Calendar.DATE, +days);
		newDate = calendar.getTime();

		return newDate;
	}

	/**
	 * Removing days in the date.
	 *
	 * @param date object will be calculated
	 * @param days Quantity of days to make calculate
	 * @return Calculated date
	 */
	public static Date removeDays(final Date date, final int days) {
		final Calendar calendar = Calendar.getInstance();
		Date newDate = (Date) date.clone();

		calendar.setTime(newDate);
		calendar.add(Calendar.DATE, -days);
		newDate = calendar.getTime();

		return newDate;
	}

	/**
	 * Business day verification. If the date be a weekend, the final date will be
	 * the next business day.
	 *
	 * @param date object will be calculated
	 * @return Calculated date
	 */
	public static Date nextBusinessDay(Date date) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		final int day = calendar.get(Calendar.DAY_OF_WEEK);

		if (day == 1) {
			date = addDays(date, 1);
		} else if (day == 7) {
			date = addDays(date, 2);
		}

		return date;
	}

	/**
	 * Convert <code>String</code> date to <code>Calendar</code> date.
	 *
	 * @param date String date
	 * @return <code>Calendar</code> date
	 */
	public static Calendar convertStringToCalendar(final String date) {
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			final Calendar cal = Calendar.getInstance();
			cal.setTime(sdf.parse(date));
			return cal;
		} catch (final ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Convert date to <code>String</code>.
	 *
	 * @param date Data will be formatted
	 * @return <code>String</code> date
	 */
	public static String convertDateToString(final Date date) {
		try {
			final Format formatter = new SimpleDateFormat("dd/MM/yyyy");
			final String strDate = formatter.format(date);
			return strDate;
		} catch (final Exception e) {
			return null;
		}
	}

	/**
	 * Change Hour/Minute/Second/Millisecond to zero.
	 *
	 * @param date Change Hour/Minute/Second/Millisecond of the date
	 * @return Date without time
	 */
	public static Date clearTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();
	}
}
