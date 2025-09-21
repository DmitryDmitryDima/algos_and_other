package language.time;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DateClass {

    public static void main(String[] args) {

        /*
        старый подход с классом Date
         */

        Date dateObject = Date.from(Instant.now());

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(dateObject);

        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.YEAR));


        /*
        современный подход с LocalDate
         */
        LocalDate localDate = LocalDate.now();

        System.out.println(localDate.getMonthValue());
    }
}
