package pack;

import java.awt.*;

public class MountainGigant extends Card{
    public MountainGigant() {
        super("Mountain Gigant", 12, 6, "he has damage", 70, 60, 0, 0.0, 0.0, new Color(88, 88, 88, 255));
    }

    public MountainGigant(MountainGigant copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
    }

    @Override
    public CardInterface copy() {
        MountainGigant mountainGigant = new MountainGigant(this);
        return (CardInterface) mountainGigant;
    }

}
