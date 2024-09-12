public class quiz1 {
    public static void main(String[] args) {
        int x = 0;
        int sum = 0;

        while ( x < 101) {
            sum += x;
            x += 2;
        }
        System.out.printf("0부터 100까지의 짝수의 합: %d\n", sum);
    }
}
