package pack;

import java.awt.*;

public class Obelisk extends Card{
    public Obelisk() {
        super("Obelisk", 20, 5, "Summon 10/10 ape at end of turn", 70, 0, 0, 0.5, 0, new Color(86, 111, 134, 255));
    }

    public Obelisk(Obelisk copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
    }

    @Override
    public CardInterface copy() {
        Obelisk obelisk = new Obelisk(this);
        return (CardInterface) obelisk;
    }

    @Override
    public void onEndTurn(Player myPlayer, Player enemy)
    {
        CardInterface card = (CardInterface) (new Ape());
        card.setPoint(this.getPoint().x+10,this.getPoint().y);
        myPlayer.cards.add(card);
        this.setHasAttacked(true);
    }



}
