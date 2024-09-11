import java.util.Scanner;

public class quizObesity {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("키를 입력하세요: ");
        int myHeight = reader.nextInt();

        System.out.print("몸무게를 입력하세요: ");
        int myWeight = reader.nextInt();

        reader.close();
        

        double standardWeight;

        if( myHeight < 151 ) {
            standardWeight = myHeight - 110;
        } else {
            standardWeight = (myWeight - 110) * 0.9;
        }

        double obesit = (myWeight - standardWeight) / standardWeight;

        if( obesit < 21) {
            System.out.println("정상(안심)");
        } else if ( obesit < 31) {
            System.out.println("경도비만(주의)");
        } else if ( obesit < 41) {
            System.out.println("중등도 비만(위험)");
        } else if ( obesit > 51) {
            System.out.println("고도비만(위험)");
        }

    }
}
