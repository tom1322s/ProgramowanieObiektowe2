package pack;

import java.awt.*;

public class Ape extends Card{
    public Ape() {
        super("Ape", 21, 0, "he has damage", 10, 10, 0, 0.0, 0.0, new Color(109, 107, 107, 255));
    }

    public Ape(Ape copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
    }

    @Override
    public CardInterface copy() {
        Ape ape = new Ape(this);
        return (CardInterface) ape;
    }



}
