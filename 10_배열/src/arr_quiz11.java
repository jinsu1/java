public class arr_quiz11 {
    public static void main(String[] args) {
        String[] student = {"둘리", "도우너", "또치", "희동" };
        int[][] grade = { { 78, 89, 96 }, { 62, 77, 67 }, { 54, 90, 80 }, { 100, 99, 98 } };
        
        for(int i=0; i<student.length; i++) {
            int sum = 0;
            double avg = 0;
            
            for(int j=0; j<grade[i].length; j++) {
                sum += grade[i][j];
            }
            avg = sum / grade[i].length;
            System.out.printf("%s 총점: %d, 평균: %.2f점\n", student[i], sum, avg);
        }
    }
}
