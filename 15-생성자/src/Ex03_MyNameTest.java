class Foo {
    String name = "자바";

    public void setMyName() {
        String name;
        name="JAVA";
    }

    public void printMyName() {
        System.out.println(name);
    }
}

public class Ex03_MyNameTest {
    public static void main(String[] args) {
        Foo f = new Foo();
        f.setMyName();
        f.printMyName();        
    }
}
