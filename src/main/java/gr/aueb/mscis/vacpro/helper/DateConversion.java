package gr.aueb.mscis.vacpro.helper;

import java.util.Date;
import java.util.Calendar;

/**
 * The type Date conversion.
 */
public final class DateConversion {

	private DateConversion() {
	}

	/**
	 * Calculate notification date date.
	 *
	 * @param birthdate the birthdate
	 * @param days      the days
	 * @return the date
	 */
	public static Date calculateNotificationDate(final Date birthdate, final int days) {
		Date notificationDate = birthdate;
		System.out.println("Birth date: " + birthdate);

		Calendar c = Calendar.getInstance();
		c.setTime(notificationDate);
		c.add(Calendar.DATE, days);
		notificationDate = c.getTime();
		System.out.println("For notification in " + days + " the notification Date is " + notificationDate);

		return notificationDate;
	}

}
