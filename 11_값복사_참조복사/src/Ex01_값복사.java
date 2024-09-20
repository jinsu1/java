public class Ex01_값복사 {
    public static void main(String[] args) {
        int a = 10;
        int b = a;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.out.println("-----------");

        a += 10;
        System.out.println("a=" + a);
        System.out.println("b=" + b);

        b -= 10;
        System.out.println("a=" +a);
        System.out.println("b=" + b);
    }
}
