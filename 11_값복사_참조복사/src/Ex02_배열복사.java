public class Ex02_배열복사 {
    public static void main(String[] args) {
        int[] origin = { 1, 2};
        int[] copy = origin;

        System.out.println("origin[0]=" + origin[0]);
        System.out.println("origin[1]=" + origin[1]);
        System.out.println("copy[0]=" + copy[0]);
        System.out.println("copy[1]=" + copy[1]);
        System.out.println("=============");

        copy[0] += 100;
        copy[1] += 200;

        System.out.println("origin[0]=" + origin[0]);
        System.out.println("origin[1]=" + origin[1]);
        System.out.println("copy[0]=" + copy[0]);
        System.out.println("copy[1]=" + copy[1]);
    }
    
}
