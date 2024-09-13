public class Ex10_역방향_별찍기 {
    public static void main(String[] args) {
        for(int i = 0; i<7; i++) {
            for(int j = 0
            ; j < 7 - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
