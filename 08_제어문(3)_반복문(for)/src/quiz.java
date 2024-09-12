public class quiz {
    public static void main(String[] args) {
        int sum = 0;
        for(int i=0; i<101;i+=2) {
            sum +=i;
        }
        System.out.printf("%d", sum);
    }
}
