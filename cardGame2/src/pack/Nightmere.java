package pack;

import java.awt.*;

public class Nightmere extends Card{
    int initialMagicDamage = 10;
    public Nightmere() {
        super("Nightmere", 22, 6, "Deals 10 en attack to all", 50, 30, 20, 0.0, 0.0, new Color(44, 11, 95, 255));
    }

    public Nightmere(Nightmere copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
    }

    @Override
    public CardInterface copy() {
        Nightmere nightmere = new Nightmere(this);
        return (CardInterface) nightmere;
    }

    @Override
    public void onEndTurn(Player myPlayer, Player enemy)
    {
        for(int i = 0; i < myPlayer.cards.size(); i++)
        {
            if(!this.equals(myPlayer.cards.get(i)))
            {
                myPlayer.cards.get(i).countRealAttack(0,10);
            }
        }
        for(int i = 0; i < enemy.cards.size(); i++)
        {
            enemy.cards.get(i).countRealAttack(0,10);
        }
    }



}
