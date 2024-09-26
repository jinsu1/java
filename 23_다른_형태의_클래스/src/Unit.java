public class Unit {
    private String name;
    private int hp;
    private int speed;
    private int dps;

    public Unit(String name, int hp, int  speed, int dps) {
        this.name = name;
        this.hp = hp;
        this.speed = speed;
        this.dps = dps;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDps() {
        return this.dps;
    }

    public void setDps(int dps) {
        this.dps = dps;
    }
}
