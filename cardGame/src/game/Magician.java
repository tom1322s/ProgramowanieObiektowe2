package game;

import java.util.ArrayList;

public class Magician extends Card{
    public Magician() {
        super("Magician", 0004, 3, "ton of MD", 250, 20, 200, 0.2, 0.7, false, 0);
    }

    public Magician(Magician magician){
        super(magician.name,magician.id,magician.cost,magician.description,magician.health,magician.attackDamage,magician.magicDamage,magician.armor,magician.magicResistance,magician.isPoisoned,magician.poisoned);
    }

    @Override
    public CardInterface clonee() {
        Magician magician = new Magician(this);
        return (CardInterface) magician;
    }

    // binarnie czy atakowac czy nie jako int
    @Override
    public void attack(ArrayList<CardInterface> myList, ArrayList<CardInterface> enemyList, String info) {

        int goal = Integer.parseInt(info);

        enemyList.get(goal).countRealAttack(this.getAttackDamage(),this.getMagicDamage());

    }
}
