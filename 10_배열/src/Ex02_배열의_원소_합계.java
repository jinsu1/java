public class Ex02_배열의_원소_합계 {
    public static void main(String[] args) {
        int[] point = {98, 72, 86, 90, 80, 77};
        int sum = 0;

        for (int i=0; i < point.length; i++) {
            sum += point[i];
        }

        int avg = sum / point.length;

        System.out.printf("총점은 %d, 평균은 %d 입니다.\n", sum, avg);
    }
}
