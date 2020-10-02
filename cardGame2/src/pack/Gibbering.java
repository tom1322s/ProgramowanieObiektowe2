package pack;

import java.awt.*;
import java.util.ArrayList;

public class Gibbering extends Card{
    public Gibbering() {
        super("Gibbering", 0001, 2, "Summon his copy", 20, 10, 0, 0.0, 0.0, new Color(187, 0, 255, 255));
    }

    public Gibbering(Gibbering copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
    }

    @Override
    public CardInterface copy() {
        Gibbering gibbering = new Gibbering(this);
        return (CardInterface) gibbering;
    }

    public void onInit(Player myPlayer, Player enemy)
    {
        CardInterface newGib = this.copy();
        newGib.setPoint(this.getPoint().x+10,this.getPoint().y);
        myPlayer.cards.add(newGib);
    }
}
