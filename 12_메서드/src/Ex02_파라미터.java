public class Ex02_파라미터 {
    public static void main(String[] args) {
        f(5);
        f(10);

        int a = 100;
        f(a);
    }

    public static void f(int x) {
        int y = x + 1;
        System.out.printf("f(%d) = %d\n", x ,y);
    }
}
