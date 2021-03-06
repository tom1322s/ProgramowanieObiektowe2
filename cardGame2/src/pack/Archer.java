package pack;

import java.awt.*;
import java.util.ArrayList;

public class Archer extends Card{
    public Archer() {
        super("Archer", 0002, 2, "he has damage", 20, 30, 0, 0.0, 0.0, new Color(255, 102, 0, 255));
    }

    public Archer(Archer archer){
        super(archer.name,archer.id,archer.cost,archer.description,archer.health,archer.attackDamage,archer.magicDamage,archer.armor,archer.magicResistance,archer.color);
    }

    @Override
    public CardInterface copy() {
        Archer archer = new Archer(this);
        return (CardInterface) archer;
    }

}
