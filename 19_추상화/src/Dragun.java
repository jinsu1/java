public class Dragun extends Protoss2 {
    public Dragun(String name, int hp, int speed, int dps) {
        super(name, hp, speed, dps);
    }

    @Override
    public void attack(String target) {
        super.attack(target);

        System.out.println(">>>> 원거리 공격을 위한 포탄 발사");
    }

    @Override
    public void move(String position) {
        super.move(position);
        System.out.println(">>>>>> 지정된 위치까지 지상으로 이동");
    }
}
