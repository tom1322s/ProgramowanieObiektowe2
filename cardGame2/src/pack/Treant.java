package pack;

import java.awt.*;

public class Treant extends Card{
    public Treant() {
        super("Treant", 24, 7, "Add 3 card to hand", 40, 30, 10, 0.0, 0.0, new Color(10, 61, 49, 255));
    }

    public Treant(Treant copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
    }

    @Override
    public CardInterface copy() {
        Treant treant = new Treant(this);
        return (CardInterface) treant;
    }

    @Override
    public void onInit(Player myPlayer, Player enemy) {
        if(myPlayer.handCards.size() < Player.MAX_HAND_CARDS)
            myPlayer.addRandomCardToHand(myPlayer.getTemple());
        if(myPlayer.handCards.size() < Player.MAX_HAND_CARDS)
            myPlayer.addRandomCardToHand(myPlayer.getTemple());
        if(myPlayer.handCards.size() < Player.MAX_HAND_CARDS)
            myPlayer.addRandomCardToHand(myPlayer.getTemple());
    }
}
