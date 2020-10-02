package pack;

import java.awt.*;
import java.util.ArrayList;

public class LavaImp extends Card{
    public LavaImp() {
        super("Lava Imp", 10, 2, "Fast attack", 5, 0, 30, 0.0, 0.0, new Color(255, 0, 0, 255));
    }

    public LavaImp(LavaImp copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
        //hasAttacked = false;
    }

    @Override
    public CardInterface copy() {
        LavaImp lavaImp = new LavaImp(this);
        return (CardInterface) lavaImp;
    }

    @Override
    public void attack(ArrayList<CardInterface> myList, ArrayList<CardInterface> enemyList, String info) {

        int goal = Integer.parseInt(info);
        CardInterface defender = enemyList.get(goal);

        defender.countRealAttack(this.getAttackDamage(),this.getMagicDamage());
        giveAttackBack(defender);
        health = 0;
    }

    @Override
    public void onInit(Player myPlayer, Player enemy)
    {
        hasAttacked = false;
    }

}
