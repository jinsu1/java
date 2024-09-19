public class Ex06_최대값 {
    public static void main(String[] args) {
        int[] data = { 5, 2, 7, 9, 2};

        int max = data[0];

        for(int i=1;i<data.length; i++) {
            System.out.printf("max=%d, data[%d]=%d\n", max, i, data[i]);

            if(max<data[i]) {
                System.out.printf(">> max에 data[%d]인 %d를 복사\n", i, data[i]);
                max = data[i];
            }
        }

        System.out.println("최대값 =" + max);
    }
}
