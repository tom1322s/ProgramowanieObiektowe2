package game;

import java.util.ArrayList;

public class Tank extends Card{
    public Tank() {
        super("Tank", 0001, 3, "he is tanky", 2000, 5, 0, 0.5, 0.0, false, 0);
    }

    public Tank(Tank tank){
        super(tank.name,tank.id,tank.cost,tank.description,tank.health,tank.attackDamage,tank.magicDamage,tank.armor,tank.magicResistance,tank.isPoisoned,tank.poisoned);
    }

    @Override
    public CardInterface clonee() {
        Tank tank = new Tank(this);
        return (CardInterface) tank;
    }

    // binarnie czy atakowac czy nie jako int
    @Override
    public void attack(ArrayList<CardInterface> myList, ArrayList<CardInterface> enemyList, String info) {

        int goal = Integer.parseInt(info);

        enemyList.get(goal).countRealAttack(this.getAttackDamage(),this.getMagicDamage());

    }
}
