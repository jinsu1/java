public class Ex01_팩토리얼_반복문 {
    public static void main(String[] args){
        int n = 5;
        int result = 1;
        for(int i=1; i <= n; i++) {
            result *= i;
        }
        System.out.println(result);
    }
}