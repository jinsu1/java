public class Ex04_리턴값 {
    public static void main(String[] args) {
        int a = div(10, 2);
        System.out.println("10 / 2 = " + a);

        int b = div(3, 0);
        System.out.println("3 / 0 = " + b);
    }

    public static int div(int x, int y) {
        if(y==0) {
            System.out.println("0으로 나눌 수 없습니다.");
            return 0;
        }

        int z = x / y;
        return z;
    }
}
