public class quiz7 {
    public static void main(String[] args) {
        int height = 100;
        int count = 0;
        
        while(true) {
            height = (int)(height * 3/5);
            count++;
            System.out.printf("%d번, %d\n", count, height);
            if( height < 1) {
                break;
            }
        }
    }
}
