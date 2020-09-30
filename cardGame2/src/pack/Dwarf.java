package pack;

import java.awt.*;

public class Dwarf   extends Card{
    public Dwarf() {
        super("Dwarf", 4, 2, "he has damage", 30, 20, 0, 0.0, 0.0, new Color(132, 80, 0, 255));
    }

    public Dwarf(Dwarf copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
    }

    @Override
    public CardInterface copy() {
        Dwarf dwarf = new Dwarf(this);
        return (CardInterface) dwarf;
    }

}
