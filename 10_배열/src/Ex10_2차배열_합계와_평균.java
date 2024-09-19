public class Ex10_2차배열_합계와_평균 {
    public static void main(String[] args) {
        String[] names = {"철수", "영희", "민혁"};

        int[][] grade = {
            { 92, 81, 76 },
            { 72, 95, 84 },
            { 80, 86, 98 }
        };

        int sum = 0;
        
        for(int i=0; i<grade.length; i++) {
            int personalSum = 0;

            for(int j=0; j<grade[i].length; j++) {
                sum+=grade[i][j];
                personalSum += grade[i][j];
            }

            int personalAvg = personalSum / grade[i].length;

            System.out.printf("%d번째 행에 대한 %s의 합계: %d, 평균: %d\n", i, names[i], personalSum, personalAvg);
        }
        System.out.printf("모든 원소에 대한 합계: %d\n", sum);
    }
}
