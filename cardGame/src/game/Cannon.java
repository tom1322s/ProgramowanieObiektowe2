package game;

import java.util.ArrayList;

public class Cannon extends Card{
    public Cannon() {
        super("Cannon", 8, 4, "deals area damage", 5000, 400, 0, 0.7, 0.2, false, 0);
    }

    public Cannon(Cannon cannon){
        super(cannon.name,cannon.id,cannon.cost,cannon.description,cannon.health,cannon.attackDamage,cannon.magicDamage,cannon.armor,cannon.magicResistance,cannon.isPoisoned,cannon.poisoned);
    }

    @Override
    public CardInterface clonee() {
        Cannon cannon = new Cannon(this);
        return (CardInterface) cannon;
    }

    // binarnie czy atakowac czy nie jako int
    @Override
    public void attack(ArrayList<CardInterface> myList, ArrayList<CardInterface> enemyList, String info) {

        int goal = Integer.parseInt(info);

        enemyList.get(goal).countRealAttack(this.getAttackDamage(),this.getMagicDamage());

        if(goal+1 <enemyList.size())
        {
            enemyList.get(goal+1).countRealAttack((int)(0.4*this.getAttackDamage()),(int)(0.4*this.getMagicDamage()));
        }
        if(goal-1 >= 0)
        {
            enemyList.get(goal-1).countRealAttack((int)(0.4*this.getAttackDamage()),(int)(0.4*this.getMagicDamage()));
        }

    }
}
