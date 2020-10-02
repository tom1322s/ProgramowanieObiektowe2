package pack;

import java.awt.*;

public class HellHound extends Card{
    public HellHound() {
        super("Hell Hound", 18, 4, "he has damage", 50, 0, 40, 0.0, 0.0, new Color(153, 10, 52, 255));
    }

    public HellHound(HellHound copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
    }

    @Override
    public CardInterface copy() {
        HellHound hellHound = new HellHound(this);
        return (CardInterface) hellHound;
    }



}
