public class quiz2{
    public static void main(String[] args) {
        int bit = 1;
        for(int i=1; i<10;i++) {
            bit *= 2;
            System.out.printf("이진수 %d개는 %d개의 정보를 표시가능", i, bit);
        }
    }
}
