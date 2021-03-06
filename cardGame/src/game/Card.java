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

    protected boolean hasAttacked = true;
    protected boolean hasGiveBack = false;
    protected boolean isMoving = false;
    protected Point movingGoal = new Point(0,0);

    protected Point point = new Point(0,0);
    protected Point size = new Point(0,0);

    public Card(String name, int id, int cost, String description, int health, int attackDamage, int magicDamage, double armor, double magicResistance, boolean isPoisoned, int poisoned) {
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

    public boolean isHasGiveBack() {
        return hasGiveBack;
    }

    public void setHasGiveBack(boolean hasGiveBack) {
        this.hasGiveBack = hasGiveBack;
    }

    public void giveAttackBack(CardInterface defender)
    {
        if(defender.getHealth()>0 && !defender.isHasGiveBack()) {
            countRealAttack(defender.getAttackDamage(), defender.getMagicDamage());
            defender.setHasGiveBack(true);
        }
    }

    public void standardAttack(CardInterface defender)
    {
        defender.countRealAttack(this.getAttackDamage(),this.getMagicDamage());
        giveAttackBack(defender);
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public Point getMovingGoal() {
        return movingGoal;
    }

    public void setMovingGoal(Point movingGoal) {
        this.movingGoal = movingGoal;
    }

    public void moveStepTo()
    {
        int dx = Math.abs(point.x - movingGoal.x);
        int dy = Math.abs(point.y - movingGoal.y);

        if(dx==0) {
            moveY();
            moveY();
        }
        else if(dy==0) {
            moveX();
            moveX();
        }
        else {
            for (int i = 0; i < (dx / dy) + 1; i++) {
                moveX();
            }
            for (int i = 0; i < (dy / dx) + 1; i++) {
                moveY();
            }
        }
    }

    private void moveX()
    {
        if(point.x<movingGoal.x)
            point.x++;
        if(point.x>movingGoal.x)
            point.x--;
    }

    private void moveY()
    {
        if(point.y<movingGoal.y)
            point.y++;
        if(point.y>movingGoal.y)
            point.y--;
    }
}
