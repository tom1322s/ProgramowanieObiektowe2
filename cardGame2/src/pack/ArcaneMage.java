package pack;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ArcaneMage extends Card{
    public int initialMagicDamage = 10;
    public ArcaneMage() {
        super("Arcane Mage", 11, 3, "he has damage", 10, 0, 20, 0.0, 0.0, new Color(0, 85, 255, 255));
    }

    public ArcaneMage(ArcaneMage copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
    }

    @Override
    public CardInterface copy() {
        ArcaneMage arcaneMage = new ArcaneMage(this);
        return (CardInterface) arcaneMage;
    }

    public void onInit(Player myPlayer, Player enemy)
    {
        for(int i = 0; i < enemy.cards.size(); i++)
        {
            enemy.cards.get(i).countRealAttack(0, initialMagicDamage);
        }

    }

}
