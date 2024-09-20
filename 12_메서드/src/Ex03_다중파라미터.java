public class Ex03_다중파라미터 {
    public static void main(String[] args) {
        f(5, 10);
        f(10, 20);
    }

    public static void f(int x1, int  x2) {
        int y = x1 + x2 + 1;
        System.out.printf("f(%d, %d) = %d\n", x1, x2, y);
    }
}
