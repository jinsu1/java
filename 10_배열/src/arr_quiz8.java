public class arr_quiz8 {
    public static void main(String[] args) {
        String[] names = { "재석", "민영", "종민", "광수", "승기", "새정" };
        int[] points = { 82, 91, 54, 62, 88, 90 };

        for(int i=0; i<points.length-1; i++) {
            for(int j=i+1; j<points.length; j++) {
                if(points[i] < points[j]) {
                    int tmp = points[i];
                    points[i] = points[j];
                    points[j] = tmp;

                    String tmp2 = names[i];
                    names[i] = names[j];
                    names[j] = tmp2;
                }
            }
        }

        for (int i=0; i<names.length; i++) {
            System.out.print(names[i] + " ");
        }
    }
}
