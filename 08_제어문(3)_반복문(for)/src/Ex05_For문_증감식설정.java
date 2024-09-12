public class Ex05_For문_증감식설정 {
    public static void main(String[] args) {
        int sum = 0;

        for(int i=0; i < 100; i+=10) {
            sum+=i;
            System.out.printf("i=%d, sum=%d\n", i, sum);
        }
    }   
}
