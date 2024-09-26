import java.util.Calendar;
import java.util.Scanner;

public class Ex05_날짜처리_응용 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        Scanner reader = new Scanner(System.in);

        System.out.print("년도를 입력하세요: ");
        int year = reader.nextInt();

        System.out.print("월을 입력하세요: ");
        int month = reader.nextInt();

        reader.close();

        System.out.println("------------------");

        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);

        int weekCount = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
        int dayCount = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        cal.set(Calendar.DAY_OF_MONTH, 1);
        int firstDay = cal.get(Calendar.DAY_OF_WEEK);
        
        int[][] data = new int[weekCount][7];

        int count = 1;

        for(int i=0; i<data.length; i++) {
            for(int j=0; j<data[i].length; j++) {
                if(!( i == 0 && j+1 < firstDay) && count <= dayCount) {
                    data[i][j] = count;
                    count++;
                }
            }
        }

        for(int i=0; i<data.length; i++) {
            for(int j=0; j<data[i].length; j++) {
                if(data[i][j] == 0) {
                    System.out.print("\t");
                } else {
                    System.out.printf("%d\t", data[i][j]);
                }
            }
            System.out.println();
        }
    }
}
