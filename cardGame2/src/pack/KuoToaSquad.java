package pack;

import java.awt.*;

public class KuoToaSquad extends Card{
    public KuoToaSquad() {
        super("Kuo-Toa Squad", 26, 9, "Summon Qua-toa squad", 0, 0, 0, 0.0, 0.0, new Color(239, 202, 14, 255));
    }

    public KuoToaSquad(KuoToaSquad copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
    }

    @Override
    public CardInterface copy() {
        KuoToaSquad kuoToaSquad = new KuoToaSquad(this);
        return (CardInterface) kuoToaSquad;
    }

    @Override
    public void onInit(Player myPlayer, Player enemy) {
        CardInterface card = (CardInterface) (new KouToa());
        card.setPoint(this.getPoint().x+10,this.getPoint().y);
        card.setAttackDamage(40);
        card.setHealth(40);
        card.setName("Kou-Toa warrior");
        myPlayer.cards.add(card);
        card = (CardInterface) (new KouToa());
        card.setPoint(this.getPoint().x+10,this.getPoint().y);
        card.setAttackDamage(30);
        card.setHealth(30);
        card.setHasAttacked(false);
        card.setName("Kou-Toa Ninja");
        myPlayer.cards.add(card);
        card = (CardInterface) (new KouToa());
        card.setPoint(this.getPoint().x+10,this.getPoint().y);
        card.onInit(myPlayer,enemy);
        card.setName("Kou-Toa LT");
        myPlayer.cards.add(card);
    }
}
