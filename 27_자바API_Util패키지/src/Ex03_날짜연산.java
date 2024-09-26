import java.util.Calendar;

import kr.hossam.helpers.DatePrinter;

public class Ex03_날짜연산 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        DatePrinter.printDateTime(cal);

        //100일 후
        cal.add(Calendar.DAY_OF_MONTH, 100);
        DatePrinter.printDateTime(cal);

        cal.add(Calendar.YEAR, -75);
        DatePrinter.printDateTime(cal);

        cal.add(Calendar.HOUR, 9);
        DatePrinter.printDateTime(cal);

        cal.add(Calendar.MONTH, 8);
        DatePrinter.printDateTime(cal);
        
    }
}
