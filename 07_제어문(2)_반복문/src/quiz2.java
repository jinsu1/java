public class quiz2 {
    public static void main(String[] args) {
        int x = 1;
        int y = 1;
        
        while(x < 11) {
            y *= 2;
            System.out.printf("이진수 %d개는 %d개의 정보를 표시가능\n", x, y);
            x++;
        }
    }
}
