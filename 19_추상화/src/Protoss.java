public abstract class Protoss {
    private String name;
    private int hp;
    private int speed;
    private int dps;
    
    public Protoss(String name, int hp, int speed, int dps) {
        this.name = name;
        this.hp = hp;
        this.speed = speed;
        this.dps = dps;
        System.out.printf(">>유닛이 생성되었습니다. ==> 이름: %s, 체력: %d, 공격력: %d\n", name, hp, dps);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDps() {
        return dps;
    }

    public void setDps(int dps) {
        this.dps = dps;
    }

    @Override
    public String toString(){
        return "{" +
            " name='" + getName() + "'" +
            ", hp='" + getHp() + "'" +
            ", speed='" + getSpeed() + "'" +
            ", dps='" + getDps() + "'" +
            "}";
    }
}
