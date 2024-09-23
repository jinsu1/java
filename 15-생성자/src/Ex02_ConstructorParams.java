class Student {
    String name;
    int level;
    int age;

    Student(String n, int l, int a) {
        System.out.println("----" + n + "아의 생성자가 실행되었습니다.1");
        name = n;
        level = l;
        age = a;
    }
}

public class Ex02_ConstructorParams {
    public static void main(String[] args) {
        Student s1 = new Student("민영", 4, 24);
        Student s2 = new Student("영민", 3, 22);

        System.out.println(s1.name + "," + s1.level + "학년" + s1.age + "세\n");
        System.out.println(s2.name + "," + s2.level + "학년" + s2.age + "세\n");
    }
}
