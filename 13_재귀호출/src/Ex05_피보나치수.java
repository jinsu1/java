public class Ex05_피보나치수 {
    public static void main(String[] args) {
        for(int i=1; i<=10; i++) {
            System.out.printf("%d에 대한 피보나치 수는 %d\n", i, fibonacci(i));
        }
    }

    public static int fibonacci(int n) {
        if(n <= 1) {
            return n;
        } else {
            return fibonacci(n-2) + fibonacci(n-1);
        }
    }
}
