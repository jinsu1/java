public class Ex01_While문 {
    public static void main(String[] args) {
        int x = 0;

        while ( x < 10) {
            System.out.printf("x=%d\n", x);

            x++;
        }

        System.out.println("----------------");
        System.out.printf("x의 최종값: %d\n", x);
    }
}
