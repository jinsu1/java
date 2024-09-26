public class Ex02_Math_기본기능 {
    public static void main(String[] args) {
        int max = Math.max(100, 9999);
        System.out.println("최대값=" + max);

        int min = Math.min(100, 9999);
        System.out.println("최소값=" + min);

        int abs = Math.abs(-234);
        System.out.println("절대값" + abs);

        long num = Math.round(3.12345);
        System.out.println("소수점 반올림=" + num);

        double rnd = Math.random();
        System.out.println("랜덤값: " + rnd);
    }
}
