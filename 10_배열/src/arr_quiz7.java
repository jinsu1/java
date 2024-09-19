public class arr_quiz7 {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 8, 9};

        for(int i=0; i<arr.length / 2; i++) {
            int k = arr.length - i - 1;

            int tmp = arr[i];
            arr[i] = arr[k];
            arr[k] = tmp;
        }

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
