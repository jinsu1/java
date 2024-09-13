public class Ex09_별찍기 {
    public static void main(String[] args) {
        for(int i = 0; i<7; i++) {
            for(int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
