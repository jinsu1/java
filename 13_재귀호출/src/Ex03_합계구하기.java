public class Ex03_합계구하기 {
    public static void main(String[] args) {
        int a = sum(10);

        System.out.println(a);
    }

    public static int sum(int n) {
        if( n == 1) {
            return 1;
        }

        return n+sum( n-1 );
    }
}
