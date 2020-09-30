package pack;

import java.awt.*;

public class InsectSwarm extends Card{
    public InsectSwarm() {
        super("InsectSwarm", 9, 3, "he has damage", 10, 10, 0, 0.0, 0.0, new Color(250, 255, 23, 255));
    }

    public InsectSwarm(InsectSwarm copy){
        super(copy.name,copy.id,copy.cost,copy.description,copy.health,copy.attackDamage,copy.magicDamage,copy.armor,copy.magicResistance,copy.color);
    }

    @Override
    public CardInterface copy() {
        InsectSwarm insectSwarm = new InsectSwarm(this);
        return (CardInterface) insectSwarm;
    }

    public void onInit(Player myPlayer, Player enemy)
    {
        CardInterface newIS= this.copy();
        newIS.setPoint(this.getPoint().x+10,this.getPoint().y);
        myPlayer.cards.add(newIS);
        newIS= this.copy();
        newIS.setPoint(this.getPoint().x+20,this.getPoint().y);
        myPlayer.cards.add(newIS);
    }

}
