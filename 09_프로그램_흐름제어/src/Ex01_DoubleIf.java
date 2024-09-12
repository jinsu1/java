import java.util.Scanner;

public class Ex01_DoubleIf {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("수학 점수를 입력하세요: ");
        int math = reader.nextInt();

        System.out.print("영어 점수를 입력하세요: ");
        int eng = reader.nextInt();

        reader.close();

        if(math >= 60) {
            if (eng >= 60) {
                System.out.println("통과(1)");
            } else {
                System.out.println("탈락(1)");
            }
        } else {
            System.out.println("탈락(1)");;
        }

        
    }
}
