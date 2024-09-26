public class MyMathException extends Exception {
    public MyMathException() {
        super("수학 점수가 범위를 벗어났습니다.");
    }

    public MyMathException(String message) {
        super(message);
    }
}
