public class Ex02_For문_합계 {
    public static void main(String[] args) {
        int sum=0;
        for(int i=0; i<10; i++) {
            sum += i;
            System.out.printf("x=%d, sum=%d\n", i, sum);
        }
    }
}
