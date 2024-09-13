public class quiz {
    public static void main(String[] args) {
        System.out.println("------1번문제--------");
        int count = 0;
        for(int i=1;i<7;i++) {
            for(int j=1;j<7;j++) {
                if ( i+j == 6) {
                    System.out.printf("[ %d, %d ]\n", i, j);
                    count++;
                }
            }
        }
        System.out.printf("경우의 수는 %d개 입니다.\n", count);
    
        System.out.println("-------2번문제--------");
        for(int i=0; i<4; i++) {
            for(int j=i; j<4+i; j++) {
                System.out.printf("%d ",j);
            }
            System.out.println();
        }

        System.out.println("-------3번문제--------");
        for(int i=0; i<8; i++) {
            for(int j=1; j<i+1; j++) {
                System.out.printf("%d",j);
            }
            System.out.println();
        }

        System.out.println("-------4번문제--------");
        int number = 1;
        if ( number == 1) {
            for( int i=3; i<10; i+=2) {
                for(int j=1; j<10; j++) {
                    System.out.printf("%d x %d = %d\n", i, j, i*j);
                }
            }
        } else {
            for( int i=2; i<10; i+=2) {
                for(int j=1; j<10; j++) {
                    System.out.printf("%d x %d = %d\n", i, j, i*j);
                }
            }
        }
    }
}