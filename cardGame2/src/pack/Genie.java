package pack;

import java.awt.*;

public class Genie extends Card{
    public Genie() {
        super("Genie", 23, 2, "Add 1 mana", 10, 10, 0, 0.0, 0.0, new Color(44, 11, 95, 255));
    }

    public Genie(Genie copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
    }

    @Override
    public CardInterface copy() {
        Genie genie = new Genie(this);
        return (CardInterface) genie;
    }

    @Override
    public void onInit(Player myPlayer, Player enemy) {
        myPlayer.setManaCapacity(myPlayer.getManaCapacity()+1);
    }
}
