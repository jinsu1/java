public class arr_quiz12 {
    public static void main(String[] args) {
        String[] student = {"둘리", "도우너", "또치", "희동" };
        int[][] grade = { { 78, 89, 96 }, { 62, 77, 67 }, { 54, 90, 80 }, { 100, 99, 98 } };
        
        for(int i=0; i<student.length; i++) {
            int sum = 0;
            double avgSum = 0;
            
            for(int j=0; j<grade[i].length; j++) {
                sum += grade[i][j];
            }
            avgSum += sum / grade[i].length;
            System.out.print(avgSum /
             student.length);
        }
    }
}
