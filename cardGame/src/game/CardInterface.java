package game;

import java.awt.*;
import java.util.ArrayList;

public interface CardInterface{


    public void attack(ArrayList<CardInterface> myList, ArrayList<CardInterface> enemyList, String info);
    public String getDescription();

    public void setDescription(String description);

    public String getName();

    public void setName(String name);

    public int getId();

    public void setId(int id);

    public int getCost();

    public void setCost(int cost);

    public int getHealth();

    public void setHealth(int health);

    public int getAttackDamage();

    public void setAttackDamage(int attackDamage);

    public int getMagicDamage();

    public void setMagicDamage(int magicDamage);

    public double getArmor();

    public void setArmor(double armor);

    public double getMagicResistance();

    public void setMagicResistance(double magicResistance);

    public boolean isPoisoned();

    public void setPoisoned(boolean poisoned);

    public int getPoisoned();

    public void setPoisoned(int poisoned);

    public void countRealAttack(int attackDamage, int magicDamage);

    public boolean isHasAttacked();

    public void setHasAttacked(boolean hasAttacked);

    public CardInterface clonee();

    public Point getPoint();

    public void setPoint(Point point);

    public Point getSize();

    public void setSize(Point size);

}
