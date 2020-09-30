package pack;

import java.awt.*;
import java.util.Random;

public class MindFlyer extends Card{
    public MindFlyer() {
        super("MindFlyer", 14, 5, "he has damage", 40, 0, 20, 0.0, 0.0, new Color(59, 17, 52, 255));
    }

    public MindFlyer(MindFlyer copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
    }

    @Override
    public CardInterface copy() {
        MindFlyer mindFlyer = new MindFlyer(this);
        return (CardInterface) mindFlyer;
    }

    public void onInit(Player myPlayer, Player enemy)
    {
        int index = -1;
        for(int i = 0; i < enemy.cards.size(); i++)
        {
            if(enemy.cards.get(i).getAttackDamage() <= 20)
            {
                index = i;
                break;
            }
        }
        if(index>-1) {
            myPlayer.cards.add(enemy.cards.remove(index));
        }
    }

}
