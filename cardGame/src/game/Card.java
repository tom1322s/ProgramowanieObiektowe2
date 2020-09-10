package game;

import java.awt.*;

public abstract class Card implements CardInterface{

    protected String name;
    protected int id;
    protected int cost;
    protected String description;
    protected int health;
    protected int attackDamage;
    protected int magicDamage;
    protected double armor;
    protected double magicResistance;

    protected boolean isPoisoned;
    protected int poisoned;

    protected boolean isHealth;
    protected int healing;

    protected boolean hasAttacked = true;

    protected Point point = new Point(0,0);
    protected Point size = new Point(0,0);

    public Card(String name, int id, int cost, String description, int health, int attackDamage, int magicDamage, double armor, double magicResistance, boolean isPoisoned, int poisoned, boolean isHealth, int healing) {
        this.name = name;
        this.id = id;
        this.cost = cost;
        this.description = description;
        this.health = health;
        this.attackDamage = attackDamage;
        this.magicDamage = magicDamage;
        this.armor = armor;
        this.magicResistance = magicResistance;
        this.isPoisoned = isPoisoned;
        this.poisoned = poisoned;
        this.isHealth = isHealth;
        this.healing = healing;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getMagicDamage() {
        return magicDamage;
    }

    public void setMagicDamage(int magicDamage) {
        this.magicDamage = magicDamage;
    }

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public double getMagicResistance() {
        return magicResistance;
    }

    public void setMagicResistance(double magicResistance) {
        this.magicResistance = magicResistance;
    }

    public boolean isPoisoned() {
        return isPoisoned;
    }

    public void setPoisoned(boolean poisoned) {
        isPoisoned = poisoned;
    }

    public int getPoisoned() {
        return poisoned;
    }

    public void setPoisoned(int poisoned) {
        this.poisoned = poisoned;
    }

    public boolean getIsHealth() {
        return isHealth;
    }

    public void setIsHealth(boolean isHealth) {
        this.isHealth = isHealth;
    }

    public int getHealing() {
        return healing;
    }

    public void setHealing(int healing) {
        this.healing = healing;
    }

    public void countRealAttack(int attackDamage, int magicDamage)
    {
        health -= (int)(((1.0-armor)*attackDamage)+((1.0-magicResistance)*magicDamage));
    }

    public boolean isHasAttacked() {
        return hasAttacked;
    }

    public void setHasAttacked(boolean hasAttacked) {
        this.hasAttacked = hasAttacked;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Point getSize() {
        return size;
    }

    public void setSize(Point size) {
        this.size = size;
    }
}
