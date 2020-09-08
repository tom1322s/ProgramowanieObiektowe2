package game;

import java.util.ArrayList;

public interface CardInterface extends Cloneable{


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

    public boolean getIsHealth() ;

    public void setIsHealth(boolean isHealth);

    public int getHealing();

    public void setHealing(int healing);

    public void countRealAttack(int attackDamage, int magicDamage);

    public boolean isHasAttacked();

    public void setHasAttacked(boolean hasAttacked);

}
