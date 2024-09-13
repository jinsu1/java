import java.util.Scanner;

public class quiz5 {
    public static void main(String[] args) {
        int sum = 0;
        Scanner reader = new Scanner(System.in);

        System.out.print("100~200사이의 숫자를 입력하세요: ");
        int number = reader.nextInt();
        reader.close();

        for(int i=3; i<number+1; i+=3) {
            sum += i;
        }

        System.out.printf("%d까지의 3의 배수의 합: %d\n", number, sum);
    }

    
}
