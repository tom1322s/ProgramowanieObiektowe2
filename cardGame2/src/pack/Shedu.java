package pack;

import java.awt.*;

public class Shedu extends Card{
    public int healDamage = 30;
    public Shedu() {
        super("Shedu", 26, 8, "Add 1 card to hand on dead", 70, 40, 30, 0.0, 0.0, new Color(173, 119, 27, 255));
    }

    public Shedu(Shedu copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
    }

    @Override
    public CardInterface copy() {
        Shedu shedu = new Shedu(this);
        return (CardInterface) shedu;
    }

    @Override
    public void onInit(Player myPlayer, Player enemy) {
        for(int i = 0; i < myPlayer.cards.size(); i++)
        {
            myPlayer.cards.get(i).setThisTurnDamage(-30);
        }

        if(myPlayer.getHero().getHealth()<=70)
        {
            myPlayer.getHero().setInjuries(-healDamage);
        }
        else
        {
            int num = 100 - myPlayer.getHero().getHealth();
            myPlayer.getHero().setInjuries(-num);
        }
    }
}
