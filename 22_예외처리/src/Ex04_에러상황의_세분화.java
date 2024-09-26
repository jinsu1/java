public class Ex04_에러상황의_세분화 {
    public static void main(String[] args) {
        int[] data = { 100, 200, 300};

        try{
            for(int i = 2; i>-1; i--) {
                int k = i != 0 ? data[i] / i : i;
                System.out.println(k);
            }
        } catch (ArrayIndexOutOfBoundsException e1) {
            System.out.println("배열의 인덱스를 초과했습니다.");
        } catch (ArithmeticException e2) {
            System.out.println("잘못된 연산입니다.");
        } catch (Exception e) {
            System.out.println("알 수 없는 에러가 발생했습니다.");
        } 
    }
}
