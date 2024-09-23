class Calc {
    public int plus(int x, int y){
        return x + y;
    }

    public int minus(int x, int y){
        return x - y;
    }
}

public class Ex02_메서드만_갖는_클래스 {
    public static void main(String[] args) {
        Calc c = new Calc();
        System.out.println(c.plus(1, 2));
        System.out.println(c.minus(10, 5));
    }
}
