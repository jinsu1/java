public class Ex06_doWhile문 {
    public static void main(String[] args) {
        int y = 0;

        do {
            System.out.printf("y=%d\n", y);
            y++;
        } while (y < 10);

        System.out.println("-----------");
        System.out.printf("y의 최종값: %d\n", y);
    }
}
