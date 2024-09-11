
public class Ex08_Switch {
    public static void main(String[] args) {
        String grade = "B";

        switch (grade) {
            case "A":
                System.out.println("91~100점 사이 입니다....(1)");
                break;
            case "B":
                System.out.println("81~90점 사이 입니다....(1)");
                break;
            case "C":
                System.out.println("71~80점 사이 입니다....(1)");
                break;
            default:
                System.out.println("70점 이하 입니다....(1)");
                break;
        }

        if(grade == "A") {
            System.out.println("91~100점 사이 입니다....(1)");
        } else if (grade == "B") {
            System.out.println("81~90점 사이 입니다....(1)");
        } else if (grade == "C") {
            System.out.println("71~80점 사이 입니다....(1)");
        } else {
            System.out.println("70점 이하 입니다....(1)");
        }
    }
}
