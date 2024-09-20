public class Ex01_메서드사용 {
    public static void main(String[] args) {
        f();
        f();
    }
    
    public static void f() {
        int x = 5;
        System.out.println(x+1);

        x = 10;
        System.out.println(x+1);
    }
}
