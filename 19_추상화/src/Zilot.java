public class Zilot extends Protoss2 {
    
    public Zilot(String name, int hp, int speed, int dps) {
        super(name, hp, speed, dps);
    }


    //자식 클래스의 객체를 통해 이 메서드를 호출하면 부모가 갖고 있는 기능은 비활성화 된다.
    @Override
    public void move(String target) {
        //부모 클래스의 멤버변수는 은닉된 상태이므로 접근 불가
        //getter, setter 상속으로 이를 통해 접근 가능
        System.out.printf("[Zilot] %s(이)가 %s까지 빠른 속도로 이동합니다.\n", this.getName(), target);
    }

    @Override
    public void attack(String target) {
        System.out.printf("[Zilot] %s(이)가 %s(을)를 칼로 찌릅니다. >> 데미지 : %d\n", this.getName(), target, this.getDps());
    }
}
