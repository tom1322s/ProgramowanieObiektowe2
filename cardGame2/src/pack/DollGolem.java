package pack;

import java.awt.*;

public class DollGolem extends Card{
    public DollGolem() {
        super("Doll Golem", 15, 3, "After death summon Bonegolem", 30, 20, 0, 0.0, 0.0, new Color(243, 109, 240, 255));
    }

    public DollGolem(DollGolem copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
    }

    @Override
    public CardInterface copy() {
        DollGolem dollGolem = new DollGolem(this);
        return (CardInterface) dollGolem;
    }

    @Override
    public void onDead(Player myPlayer, Player enemy)
    {
        CardInterface card = (CardInterface) (new BoneGolem());
        card.setPoint(this.getPoint().x+10,this.getPoint().y);
        myPlayer.cards.add(card);
    }


}
