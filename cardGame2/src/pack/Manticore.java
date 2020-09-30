package pack;

import java.awt.*;

public class Manticore extends Card{
    public Manticore() {
        super("Manticore", 7, 4, "he has damage", 50, 40, 0, 0.0, 0.0, new Color(161, 32, 0, 255));
    }

    public Manticore(Manticore copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
    }

    @Override
    public CardInterface copy() {
        Manticore manticore = new Manticore(this);
        return (CardInterface) manticore;
    }


}
