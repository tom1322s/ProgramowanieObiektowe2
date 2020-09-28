package game;

import java.util.ArrayList;

public class Dragon extends Card{
    public Dragon() {
        super("Dragon", 0005, 8, "Deals damage\n to all champs", 1000, 400, 200, 0.9, 0.5, false, 0);
    }

    public Dragon(Dragon dragon){
        super(dragon.name,dragon.id,dragon.cost,dragon.description,dragon.health,dragon.attackDamage,dragon.magicDamage,dragon.armor,dragon.magicResistance,dragon.isPoisoned,dragon.poisoned);
    }

    @Override
    public CardInterface clonee() {
        Dragon dragon = new Dragon(this);
        return (CardInterface) dragon;
    }

    // binarnie czy atakowac czy nie jako int
    @Override
    public void attack(ArrayList<CardInterface> myList, ArrayList<CardInterface> enemyList, String info) {

        int goal = Integer.parseInt(info);

        for(int i = 0; i < enemyList.size(); i++)
        {
            if(i == goal)
                enemyList.get(goal).countRealAttack(this.getAttackDamage(),this.getMagicDamage());
            else
                enemyList.get(i).countRealAttack((int)(0.1*this.getAttackDamage()),(int)(0.1*this.getMagicDamage()));
        }

    }
}
