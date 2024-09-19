public class Ex05_순차정렬 {
    public static void main(String[] args) {
        int[] data = {1, 5, 2, 4, 3};

        for(int i=0; i<data.length-1; i++) {
            for(int j=i+1; j<data.length; j++) {
                if(data[i] > data[j]) {
                    int tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                }
            }
        }

        for (int i=0; i<data.length; i++) {
            System.out.print(data[i] + "\t");
        }
    }
}
