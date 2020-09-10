package game;

import java.util.ArrayList;

public class Healer extends Card{

    public int healDamage = 30;

    public Healer() {
        super("Healer", 0006, 5, "heals everybody", 700, 70, 30, 0.5, 0.7, false, 0);
    }

    public Healer(Healer healer){
        super(healer.name,healer.id,healer.cost,healer.description,healer.health,healer.attackDamage,healer.magicDamage,healer.armor,healer.magicResistance,healer.isPoisoned,healer.poisoned);
    }

    @Override
    public CardInterface clonee() {
        Healer healer = new Healer(this);
        return (CardInterface) healer;
    }

    // binarnie czy atakowac czy nie jako int
    @Override
    public void attack(ArrayList<CardInterface> myList, ArrayList<CardInterface> enemyList, String info) {

        int goal = Integer.parseInt(info);

        enemyList.get(goal).countRealAttack(this.getAttackDamage(),this.getMagicDamage());

        for(int i = 0; i < myList.size(); i++)
        {
            myList.get(i).setHealth(myList.get(i).getHealth()+healDamage);
        }

    }
}
