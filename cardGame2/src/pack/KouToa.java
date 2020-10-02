package pack;

import java.awt.*;

public class KouToa extends Card{
    public int extraAttackDamage = 10;
    public KouToa() {
        super("Kou-Toa", 6, 3, "Add 10 ad to all", 20, 20, 0, 0.0, 0.0, new Color(42, 255, 157, 255));
    }

    public KouToa(KouToa copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
    }

    @Override
    public CardInterface copy() {
        KouToa kouToa = new KouToa(this);
        return (CardInterface) kouToa;
    }

    public void onInit(Player myPlayer, Player enemy)
    {
        for(int i = 0; i < myPlayer.cards.size();i++)
        {
            myPlayer.cards.get(i).setAttackDamage(myPlayer.cards.get(i).getAttackDamage()+extraAttackDamage);
        }
        myPlayer.getBoost().setAd(myPlayer.getBoost().getAd()+extraAttackDamage);
    }

    public void onDead(Player myPlayer, Player enemy)
    {
        for(int i = 0; i < myPlayer.cards.size();i++)
        {
            myPlayer.cards.get(i).setAttackDamage(myPlayer.cards.get(i).getAttackDamage()-extraAttackDamage);
        }
        myPlayer.getBoost().setAd(myPlayer.getBoost().getAd()-extraAttackDamage);
    }
}
