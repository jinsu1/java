public class Ex07_doWhile차이점 {
    public static void main(String[] args) {
        int a = 10;

        while (a < 10) {
            System.out.printf("[while문] a=%d\n", a);
        }

        do {
            System.out.printf("[do~while문] a=%d\n", a);
        } while (a < 10);
    }
}
