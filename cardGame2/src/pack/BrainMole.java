package pack;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BrainMole  extends Card{
    int initialMagicDamage = 10;
    public BrainMole() {
        super("BrainMole", 5, 1, "Deals 10 dmg to random", 10, 10, 0, 0.0, 0.0, new Color(203, 0, 160, 255));
    }

    public BrainMole(BrainMole copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
    }

    @Override
    public CardInterface copy() {
        BrainMole brainMole = new BrainMole(this);
        return (CardInterface) brainMole;
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
