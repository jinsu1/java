class Student1 {
    String name;
    int point;

    Student1(String name, int point) {
        this.name = name;
        this.point = point;
    }

    String getValues() {
        return String.format("이름: %s, 점수: %d", name, point);
    }
}

public class Ex01_멤버변수_접근의_한계 {
    public static void main(String[] args) {
        Student1 s = new Student1("홍길동", -50);
        System.out.println(s.getValues());

        s.point = 12345;
        System.out.println(s.getValues());
    }
}
