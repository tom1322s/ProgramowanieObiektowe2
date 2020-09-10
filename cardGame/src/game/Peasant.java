package game;

import java.util.ArrayList;

public class Peasant extends Card{
    public Peasant() {
        super("Peasant", 0003, 1, "he is week", 120, 100, 0, 0.4, 0.4, false, 0);
    }

    public Peasant(Peasant peasant){
        super(peasant.name,peasant.id,peasant.cost,peasant.description,peasant.health,peasant.attackDamage,peasant.magicDamage,peasant.armor,peasant.magicResistance,peasant.isPoisoned,peasant.poisoned);
    }

    @Override
    public CardInterface clonee() {
        Peasant peasant = new Peasant(this);
        return (CardInterface) peasant;
    }

    // binarnie czy atakowac czy nie jako int
    @Override
    public void attack(ArrayList<CardInterface> myList, ArrayList<CardInterface> enemyList, String info) {

        int goal = Integer.parseInt(info);

        enemyList.get(goal).countRealAttack(this.getAttackDamage(),this.getMagicDamage());

    }
}
