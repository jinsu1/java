public class Ex03_객체형변환 {
    public static void main(String[] args) {
        Protoss2 p0 = new Protoss2("프로브1호", 50, 30, 2);

        //자식 객체로 생성 후 부모 형식의 객체에 참조
        Zilot2 z = new Zilot2("질럿1호", 300, 150, 120);
        Protoss2 p1 = z;

        Protoss2 p2 = new Dragun2("드라군1호", 280, 120, 170);

        //부모 객체로 변환되더라도 자식 클래스가 Override한 기능은 자식의 기능 그대로 유지된다.
        p0.move("저그본진");
        p0.attack("저그본진");
        System.out.println("------");

        p1.move("저그본진");
        p1.attack("저그본진");
        System.out.println("------");

        p2.move("저그본진");
        p2.attack("저그본진");
        System.out.println("------");

        //자식 객체로 생성 후 부모 형식의 객체에 참조한 경우 부모에게 선언되지 않은 기능은 사용할 수 없도록 잠김 (boxing)
        // 부모 형태로 변환된 객체를 다시 자식 형태로 역변환하면 잠긴 기능이 해제된다. (unBoxing)
        Zilot2 rz = (Zilot2) p1;
        Dragun2 rd = (Dragun2) p2;
        rz.swardAttack("저그본진");
        rd.fireAttack("저그본진");
    }
}