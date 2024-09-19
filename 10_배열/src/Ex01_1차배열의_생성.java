public class Ex01_1차배열의_생성 {
    public static void main(String[] args) {
        int [] arr1;

        arr1 = new int[3];

        System.out.println("arr1[0]=" + arr1[0]);
        System.out.println("arr1[1]=" + arr1[1]);
        System.out.println("arr1[2]=" + arr1[2]);
        System.out.println("------------------");

        int[] arr2 = new int[4];

        for(int i=0; i<arr2.length; i++) {
            arr2[i] = i * 10;
            System.out.printf("arr2의 %d번째 칸 >> %d\n", i, arr2[i]);
        }

        System.out.println("---------------");

        int[] arr3 = { 100, 200, 300, 400};
        System.out.println(arr3); // 안나옴

        for(int i=0; i<arr3.length; i++) {
            System.out.println(arr3[i]);
        }
    }
}
