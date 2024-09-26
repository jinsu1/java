import java.util.Calendar;

public class Ex01_날짜출력 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        int yy = cal.get(Calendar.YEAR);
        //자바에서 월은 0부터 시작
        int mm = cal.get(Calendar.MONTH) + 1;
        int dd = cal.get(Calendar.DAY_OF_MONTH);
        int hh = cal.get(Calendar.HOUR_OF_DAY);
        int mi = cal.get(Calendar.MINUTE);
        int ss = cal.get(Calendar.SECOND);

        System.out.printf("%04d년 %02d월 %02d일 %02d시 %02d분 %02d초\n", yy, mm, dd, hh, mi, ss);

        yy = cal.get(Calendar.YEAR);
        mm = cal.get(Calendar.MONTH) + 1;
        dd = cal.get(Calendar.DAY_OF_MONTH);
        //12시간제 시간
        hh = cal.get(Calendar.HOUR);
        mi = cal.get(Calendar.MINUTE);
        ss = cal.get(Calendar.SECOND);

        int ampm = cal.get(Calendar.AM_PM);
        String[] apname = { "오전", "오후" };

        System.out.printf("%04d년 %02d월 %02d일 %s %02d시 %02d분 %02d초\n", yy, mm, dd, apname[ampm], hh, mi, ss);
    }
}