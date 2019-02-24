package gr.aueb.mscis.sample.helper;

import java.util.Date;
import java.util.Calendar;

public class DateConversion {

    public static Date calculateNotificationDate(Date birthdate, int days) {
        Date notificationDate = birthdate;

        Calendar c = Calendar.getInstance();
        c.setTime(notificationDate);
        c.add(Calendar.DATE, days);
        notificationDate = c.getTime();
        System.out.println(notificationDate);

        return  notificationDate;
    }

}
