package pack;

import java.awt.*;

public class Dryad extends Card{
    public Dryad() {
        super("Dryad", 17, 2, "he has damage", 30, 0, 20, 0.0, 0.0, new Color(78, 253, 25, 255));
    }

    public Dryad(Dryad copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
    }

    @Override
    public CardInterface copy() {
        Dryad dryad = new Dryad(this);
        return (CardInterface) dryad;
    }



}
