public class arr_quiz5 {
    public static void main(String[] args) {
        int price[] = { 38000, 20000, 17900, 17900 };
        int qty[] = { 6, 4, 3, 5 };
        int total[] = new int[4];
        int count = 0;

        for(int i=0;i<price.length;i++) {
            total[i] = price[i]*qty[i];
            if(total[i] >= 80000) {
                count++;
            }
        }

        System.out.print(count);
    }
}
