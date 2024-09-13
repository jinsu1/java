public class Ex07_구구단 {
    public static void main(String[] args) {
        for(int i = 2; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.printf("%d x %d = %d\n", i, j, i*j);
            }

            if( i + 1 < 10) {
                System.out.println("-----------------");
            }
        }
    }
}
