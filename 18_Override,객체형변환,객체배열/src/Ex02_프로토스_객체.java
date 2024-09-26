public class Ex02_프로토스_객체 {
    public static void main(String[] args) {
        Protoss2 p1 = new Protoss2("프로브1", 50, 30, 1);
        p1.move("테란본진");
        p1.attack("테란본진");
        System.out.println(p1.toString());
        System.out.println("--------------");

        Zilot2 z1 = new Zilot2("질럿1", 500, 300, 120);
        z1.move("테란본진");
        z1.attack("테란본진");
        z1.swardAttack("테란본진");
        System.out.println(z1.toString());
        System.out.println("------------");

        Dragun2 d1 = new Dragun2("드라군1", 450, 250, 200);
        d1.move("테란의 본진");
        d1.attack("테란의 본진");
        d1.fireAttack("테란의 본진");
        System.out.println(d1.toString());
        System.out.println("-----------");
    }
}
