package game;

import java.util.ArrayList;

public class Fairy extends Card{
    public Fairy() {
        super("Fairy", 0007, 2, "she is tiny", 200, 10, 160, 0.3, 0.4, false, 0);
    }

    public Fairy(Fairy fairy){
        super(fairy.name,fairy.id,fairy.cost,fairy.description,fairy.health,fairy.attackDamage,fairy.magicDamage,fairy.armor,fairy.magicResistance,fairy.isPoisoned,fairy.poisoned);
    }

    @Override
    public CardInterface clonee() {
        Fairy fairy = new Fairy(this);
        return (CardInterface) fairy;
    }

    // binarnie czy atakowac czy nie jako int
    @Override
    public void attack(ArrayList<CardInterface> myList, ArrayList<CardInterface> enemyList, String info) {

        int goal = Integer.parseInt(info);

        enemyList.get(goal).countRealAttack(this.getAttackDamage(),this.getMagicDamage());

    }
}
