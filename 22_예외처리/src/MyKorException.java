public class MyKorException extends Exception {
    public MyKorException() {
        super("국어 점수가 범위를 벗어났습니다.");
    }

    public MyKorException(String message) {
        super(message);
    }
}
