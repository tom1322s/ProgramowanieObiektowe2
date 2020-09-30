package pack;

import java.awt.*;

public class OrcChieftain extends Card{
    public OrcChieftain() {
        super("OrcChieftain", 8, 4, "he has damage", 40, 50, 0, 0.0, 0.0, new Color(18, 82, 15, 255));
    }

    public OrcChieftain(OrcChieftain copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
    }

    @Override
    public CardInterface copy() {
        OrcChieftain orcChieftain = new OrcChieftain(this);
        return (CardInterface) orcChieftain;
    }


}
