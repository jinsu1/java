public class Ex05_While문_증감식설정 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 0;

        while(i<100) {
            sum+=i;
            System.out.printf("i=%d, sum=%d\n", i, sum);

            i+=10;
        }
    }
}
