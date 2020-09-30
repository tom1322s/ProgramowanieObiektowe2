package pack;

import java.awt.*;
import java.util.ArrayList;

public class Neardenthal  extends Card{
    public Neardenthal() {
        super("Neardenthal", 3, 1, "he has damage", 10, 20, 0, 0.0, 0.0, new Color(217, 158, 66, 255));
    }

    public Neardenthal(Neardenthal copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
    }

    @Override
    public CardInterface copy() {
        Neardenthal neardenthal = new Neardenthal(this);
        return (CardInterface) neardenthal;
    }

}
