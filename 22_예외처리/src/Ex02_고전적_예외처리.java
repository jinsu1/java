public class Ex02_고전적_예외처리 {
    public static void main(String[] args) {
        int[] k = { 10, 20 ,30 };

        for(int i=0; i<5; i++) {
            if (i < 3) {
                System.out.println(k[i]);
            }
        }
        System.out.println("fin :)");
    }
}