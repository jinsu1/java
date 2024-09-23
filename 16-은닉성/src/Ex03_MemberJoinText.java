public class Ex03_MemberJoinText {
    public static void main(String[] args) {
        Member s = new Member("JAVA학생", 20);

        String name = s.getName();
        System.out.println("이름" + name);

        int age = s.getAge();
        System.out.println("나이" + age);
    }
}