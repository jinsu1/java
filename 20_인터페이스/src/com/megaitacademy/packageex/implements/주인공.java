import IFight;
import IMove;
import IMovement;
import Unit;

package com.megaitacademy.packageex.implements;
public class 주인공 extends Unit implements IMove, IFight, IMovement {
    public 주인공(String name, int hp, int speed, int dps){
        super(name,hp,speed,dps);
}

    
    @Override
    public void pickUpItem() {
        System.out.printf("[주인공] %s(이)가 %d의 속력으로 걷습니다.\n", this.getName(), this.getSpeed());
    }
}

    @Override
    public void pickUpItem() {
        System.out.printf("[주인공] %s(이)가 %d의 속력으로 걷습니다.\n", this.getName(), this.getSpeed());
    }
}
