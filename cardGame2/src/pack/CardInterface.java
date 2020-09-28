package pack;

import java.awt.*;
import java.util.ArrayList;

public interface CardInterface {

    public CardInterface copy();
    public void attack(ArrayList<CardInterface> myList, ArrayList<CardInterface> enemyList, String info);

    public String getName();
    public void setName(String name);
    public int getId();
    public void setId(int id);
    public int getCost();
    public void setCost(int cost);
    public String getDescription();
    public void setDescription(String description);
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
    public int getPoisoned();
    public void setPoisoned(int poisoned);
    public boolean isHasAttacked();
    public void setHasAttacked(boolean hasAttacked);
    public boolean isHasGiveBack();
    public void setHasGiveBack(boolean hasGiveBack);
    public boolean isMoving();
    public void setMoving(boolean moving);
    public Point getMovingGoal();
    public void setMovingGoal(Point movingGoal);
    public Point getPoint();
    public void setPoint(Point point);
    public Point getSize();
    public void setSize(Point size);
    public void setMovingGoal(int x, int y);
    public void setPoint(int x, int y);
    public void setSize(int x, int y);
    public boolean isSpecialMoving();
    public void setSpecialMoving(boolean specialMoving);
    public void move();
}
