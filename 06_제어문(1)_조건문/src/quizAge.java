import java.util.Scanner;

public class quizAge {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("나이를 입력하세요: ");
        int age = reader.nextInt();
        reader.close();

        switch (age / 10) {
            case 0:
                System.err.println("당신은 어린이 입니다.");
                break;
            case 1:
                System.out.println("당신은 10대 입니다.");
                break;
            case 2:
                System.out.println("당신은 20대 입니다.");
                break;
            case 3:
                System.out.println("당신은 30대 입니다.");
                break;
            case 4:
                System.out.println("당신은 40대 입니다.");
                break;
            case 5:
                System.out.println("당신은 50대 입니다.");
                break;
            default:
                System.out.println("당신은 노년층 입니다.");
        }
    }
}
