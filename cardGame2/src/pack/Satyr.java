package pack;

import java.awt.*;

public class Satyr extends Card{
    public Satyr() {
        super("Satyr", 25, 2, "Add 1 card to hand on dead", 20, 10, 0, 0.0, 0.0, new Color(173, 119, 27, 255));
    }

    public Satyr(Satyr copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
    }

    @Override
    public CardInterface copy() {
        Satyr satyr = new Satyr(this);
        return (CardInterface) satyr;
    }

    @Override
    public void onDead(Player myPlayer, Player enemy) {
        if(myPlayer.handCards.size() < Player.MAX_HAND_CARDS)
            myPlayer.addRandomCardToHand(myPlayer.getTemple());
    }
}
