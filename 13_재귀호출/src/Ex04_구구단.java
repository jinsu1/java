public class Ex04_구구단 {
    public static void main(String[] args) {
        gugudan(1);
    }
    public static void gugudan(int n) {
        if(n>9) {
            return;
        }

        System.out.printf("%d x %d = %d\n", 7, n, 7*n);
        gugudan(n+1);
    }
}
