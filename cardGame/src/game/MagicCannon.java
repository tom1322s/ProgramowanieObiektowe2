package game;

import java.util.ArrayList;

public class MagicCannon extends Card{
    public MagicCannon() {
        super("MCannon", 8, 5, "deals area damage", 550, 0, 450, 0.7, 0.3, false, 0);
    }

    public MagicCannon(MagicCannon magicCannon){
        super(magicCannon.name,magicCannon.id,magicCannon.cost,magicCannon.description,magicCannon.health,magicCannon.attackDamage,magicCannon.magicDamage,magicCannon.armor,magicCannon.magicResistance,magicCannon.isPoisoned,magicCannon.poisoned);
    }

    @Override
    public CardInterface clonee() {
        MagicCannon magicCannon = new MagicCannon(this);
        return (CardInterface) magicCannon;
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
