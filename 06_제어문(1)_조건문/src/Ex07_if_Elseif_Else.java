import java.util.Scanner;

public class Ex07_if_Elseif_Else {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("점수를 입력하세요: ");
        int point = reader.nextInt();
        reader.close();

        if(point > 90) {
            System.out.println("A");
        } else if (point > 80) {
            System.out.println("B");
        } else if (point > 70) {
            System.out.println("C");
        } else {
            System.out.println("F");
        }
    }
}
