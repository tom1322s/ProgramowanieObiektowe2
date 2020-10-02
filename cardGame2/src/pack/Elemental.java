package pack;

import java.awt.*;

public class Elemental extends Card{
    public Elemental() {
        super("Elemental", 19, 2, "he has damage", 20, 0, 30, 0.0, 0.5, new Color(109, 107, 107, 255));
    }

    public Elemental(Elemental copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
    }

    @Override
    public CardInterface copy() {
        Elemental elemental = new Elemental(this);
        return (CardInterface) elemental;
    }



}
