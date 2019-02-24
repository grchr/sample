package gr.aueb.mscis.vacpro.helper;

import java.util.Date;
import java.util.Calendar;

public class DateConversion {

    public static Date calculateNotificationDate(Date birthdate, int days) {
        Date notificationDate = birthdate;
        System.out.println("Birth date: " + birthdate);

        Calendar c = Calendar.getInstance();
        c.setTime(notificationDate);
        c.add(Calendar.DATE, days);
        notificationDate = c.getTime();
        System.out.println("For notification in " + days + " the notification Date is " + notificationDate);

        return  notificationDate;
    }

}
