import java.util.Scanner;

public class quiz6 {
    public static void main(String[] args) {
        int answer = 0;
        Scanner reader = new Scanner(System.in);

        System.out.print("과자 한 개의 가격(1000이하의 양의 정수) :");
        int K = reader.nextInt();
        System.out.print("사려고하는 과자의 개수(1000이하의 양의 정수) :");
        int N = reader.nextInt();
        System.out.print("동수가 가진 돈(10만 이하의 양의 정수) :");
        int M = reader.nextInt();
        reader.close();

        if( M - (K*N) > 0 ) {
            System.out.println("0");
        } else {
            answer = (M - (K*N)) * -1;
            System.out.println(answer);
        }
        
    }
}
