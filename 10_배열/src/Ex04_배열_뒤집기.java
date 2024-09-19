public class Ex04_배열_뒤집기 {
    public static void main(String[] args) {
        int[] data = {1, 5, 2, 4, 3};

        for(int i=0; i<data.length / 2; i++) {
            int k = data.length - i - 1;

            int tmp = data[i];
            data[i] = data[k];
            data[k] = tmp;
        }

        for(int i=0; i<data.length; i++) {
            System.out.print(data[i] + "\t");
        }
    }
}
