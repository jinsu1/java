public class quiz2 {
    public static void main(String[] args) {
        int time[] = { 7, 5, 5, 5, 5, 10, 7 };
        int pay = 4500;
        int newPay = 5200;
        int total = 0;
        for(int i=0; i<time.length; i++) {
            if(i > 4) {
                total += newPay*time[i];
                continue;
            }

            total += pay*time[i];
        }

        System.out.printf("총 급여 : %d\n", total);
    }
}