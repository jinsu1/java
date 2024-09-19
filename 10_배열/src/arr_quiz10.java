public class arr_quiz10 {
    public static void main(String[] args) {
        int[] price = {977750, 1649000, 1738950, 549000, 1419000, 479000, 2098000, 519000, 2449000, 1498000 };
        int count = 0;
        for(int i=0; i<price.length; i++) {
            if(price[i] >= 1400000 && price[i] <= 1700000) {
                count++;
            }
        }
        System.out.print(count);
    }
}
