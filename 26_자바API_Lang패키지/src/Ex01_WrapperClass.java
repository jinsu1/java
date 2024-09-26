public class Ex01_WrapperClass {
        public static void main(String[] args) {
            int number = 100;
            Integer a = number;
            System.out.printf("a=%d\n", a);

            Integer b = new Integer(number);
            System.out.printf("b=%d\n", b);

            int c = 100;
            String s1 ="20";
            String s2 = "3.14";

            int num_a = Integer.parseInt(s1);
            float num_b = Float.parseFloat(s2);

            int v1 = num_a + 500;
            float v2 = num_b + 500;
            System.out.println("v1=" + v1);
            System.out.println("v2=" + v2);
        }
}