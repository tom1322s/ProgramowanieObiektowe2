package game;

import java.util.ArrayList;

public class Archer extends Card{
    public Archer() {
        super("Archer", 0002, 2, "he has damage", 1000, 20, 0, 0.0, 0.0, false, 0);
    }

    public Archer(Archer archer){
        super(archer.name,archer.id,archer.cost,archer.description,archer.health,archer.attackDamage,archer.magicDamage,archer.armor,archer.magicResistance,archer.isPoisoned,archer.poisoned);
    }

    @Override
    public CardInterface clonee() {
        Archer archer = new Archer(this);
        return (CardInterface) archer;
    }


    // binarnie czy atakowac czy nie jako int
    @Override
    public void attack(ArrayList<CardInterface> myList, ArrayList<CardInterface> enemyList, String info) {

        int goal = Integer.parseInt(info);

        standardAttack(enemyList.get(goal));

    }
}
