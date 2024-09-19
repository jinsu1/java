public class quiz4 {
    public static void main(String[] args) {
        int price[] = { 38000, 20000, 17900, 17900 };
        int qty[] = { 6, 4, 3, 5 };
        int total[] = new int[4];

        for(int i=0;i<price.length;i++) {
            total[i] = price[i]*qty[i];
        }

        int max = total[0];

        for(int i=1;i<total.length; i++) {
            if(max < total[i]) {
                max = total[i];
            }
        }

        System.out.printf("가장 비싼 금액: %d",  max);
    }
}
