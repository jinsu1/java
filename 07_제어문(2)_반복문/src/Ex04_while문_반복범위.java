import java.util.Scanner;

public class Ex04_while문_반복범위 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("x를 입력하세요: ");
        int x = reader.nextInt();

        System.out.print("y를 입력하세요: ");
        int y = reader.nextInt();
        reader.close();
        
        int i = x;
        int sum = 0;

        while (i < y+1 ) {
            System.out.printf("%d + %d\n", sum, i);

            sum += i;

            i++;
        }
        System.out.printf("%d부터 %d까지의 총 합은 %d 입니다.", x, y, sum);
    }
}
