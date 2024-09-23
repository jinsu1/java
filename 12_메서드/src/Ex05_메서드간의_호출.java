public class Ex05_메서드간의_호출 {
    public static void main(String[] args) {
        int a = 10;
        int b = f2(a);
        System.out.printf("f2(%d) = %d\n", a, b);
    }

    public static int f1(int x1) {
        System.out.printf("f1(%d) = %d + 1\n", x1, x1);
        return x1 + 1;
    }

    public static int f2(int x2) {
        System.out.printf("f2(%d) = f1(%d) * 2\n", x2, x2);
        int y = f1(x2) * 2;
        return y;

        
    }
}
