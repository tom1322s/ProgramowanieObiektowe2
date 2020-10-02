package pack;

import java.awt.*;
import java.util.Random;

public class Phoenix extends Card{
    public int initialMagicDamage = 50;
    public Phoenix() {
        super("Phoenix", 13, 6, "Deals 50 MA to rand enemy", 50, 60, 0, 0.0, 0.0, new Color(255, 84, 1, 255));
    }

    public Phoenix(Phoenix copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
    }

    @Override
    public CardInterface copy() {
        Phoenix phoenix = new Phoenix(this);
        return (CardInterface) phoenix;
    }

    public void onInit(Player myPlayer, Player enemy)
    {
        Random rm = new Random();
        if(enemy.cards.size()>0) {
            int index = rm.nextInt(enemy.cards.size());

            enemy.cards.get(index).countRealAttack(0, initialMagicDamage);
        }
    }

}
