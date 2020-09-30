package pack;

import java.awt.*;

public class BoneGolem extends Card{
    public BoneGolem() {
        super("Bone Golem", 16, 0, "he has damage", 10, 20, 0, 0.0, 0.0, new Color(248, 248, 248, 255));
    }

    public BoneGolem(BoneGolem copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
    }

    @Override
    public CardInterface copy() {
        BoneGolem boneGolem = new BoneGolem(this);
        return (CardInterface) boneGolem;
    }



}
