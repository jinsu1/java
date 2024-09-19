public class quiz1 {
    public static void main(String[] args) {
        int grade[] = { 75, 82, 91 };
        int sum = 0;
        int avg = 0;
        for(int i=0; i<grade.length; i++) {
            sum+=grade[i];
        }
        avg = sum / grade.length;
        System.out.printf("총점: %d, 평균: %d", sum, avg);
    }
}
