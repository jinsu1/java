import java.util.Calendar;

import kr.hossam.helpers.DatePrinter;

public class Ex02_날짜지정 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        DatePrinter.printDateTime(cal);

        cal.set(Calendar.YEAR, 2020);
        cal.set(Calendar.MONTH, 4);
        cal.set(Calendar.DAY_OF_MONTH, 5);
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 33);
        DatePrinter.printDateTime(cal);

        cal.set(1982, 4, 17);
        DatePrinter.printDateTime(cal);

        cal.set(1982, 5, 18, 13, 2, 3);
        DatePrinter.printDateTime(cal);

    }
}
