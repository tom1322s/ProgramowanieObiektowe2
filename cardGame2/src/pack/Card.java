package pack;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

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
    protected int poisoned = 0;

    protected boolean hasAttacked = true;
    protected boolean hasGiveBack = false;
    protected boolean isMoving = false;
    protected boolean isSpecialMoving = false;
    protected Point movingGoal;

    protected Point point;
    protected Point size;

    protected int thisTurnDamage = 0;
    protected Color color;

    private int moveCounter = 0;
    private int moveCapacity = 0;
    private boolean moveDirection = false;

    public Card(String name, int id, int cost, String description, int health, int attackDamage, int magicDamage, double armor, double magicResistance, Color color) {
        this.name = name;
        this.id = id;
        this.cost = cost;
        this.description = description;
        this.health = health;
        this.attackDamage = attackDamage;
        this.magicDamage = magicDamage;
        this.armor = armor;
        this.magicResistance = magicResistance;
        movingGoal = new Point(0,0);
        point = new Point(0,0);
        size = new Point(0,0);
        this.color = color;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getPoisoned() {
        return poisoned;
    }

    public void setPoisoned(int poisoned) {
        this.poisoned = poisoned;
    }

    public boolean isHasAttacked() {
        return hasAttacked;
    }

    public void setHasAttacked(boolean hasAttacked) {
        this.hasAttacked = hasAttacked;
    }

    public boolean isHasGiveBack() {
        return hasGiveBack;
    }

    public void setHasGiveBack(boolean hasGiveBack) {
        this.hasGiveBack = hasGiveBack;
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

    public void setMovingGoal(int x, int y) {
        this.movingGoal.x = x;
        this.movingGoal.y = y;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(int x, int y) {
        this.point.x = x;
        this.point.y = y;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Point getSize() {
        return size;
    }

    public void setSize(int x, int y) {
        this.size.x = x;
        this.size.y = y;
    }

    public void setSize(Point size) {
        this.size = size;
    }

    public boolean isSpecialMoving() {
        return isSpecialMoving;
    }

    public void setSpecialMoving(boolean specialMoving) {
        isSpecialMoving = specialMoving;
    }

    public void move()
    {
        if(point.equals(movingGoal))
        {
            isMoving = false;
            //isSpecialMoving = false;
        }
        else
        {
            //moveX();
            //moveY();
            if(moveCounter==moveCapacity)
            {
                moveX();
                moveY();
                moveCounter = 0;
                int dx = Math.abs(point.x-movingGoal.x);
                int dy = Math.abs(point.y-movingGoal.y);
                if(dx!=0 && dy!=0) {
                    if (dx > dy) {
                        moveCapacity = dx / dy;
                        moveDirection = true;
                    } else if (dy > dx) {
                        moveCapacity = dy / dx;
                        moveDirection = false;
                    } else moveCapacity = 0;
                } else moveCapacity = 0;

            }
            else
            {
                moveCounter++;
                if(moveDirection) moveX();
                else moveY();
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

    public void setMovingGoalPlayer(CardInterface goal) {
        this.movingGoal.x = goal.getPoint().x;
        this.movingGoal.y = goal.getPoint().y+goal.getSize().y/2;
        isSpecialMoving = true;
        isMoving = true;
    }

    public void setMovingGoalEnemy(CardInterface goal) {
        this.movingGoal.x = goal.getPoint().x;
        this.movingGoal.y = goal.getPoint().y-goal.getSize().y/2;
        isSpecialMoving = true;
        isMoving = true;
    }

    public void setMovingGoalPlayerHero(Hero goal)
    {
        this.movingGoal.x = goal.getPoint().x;
        this.movingGoal.y = goal.getPoint().y+goal.getSize().y/2;
        isSpecialMoving = true;
        isMoving = true;
    }

    public void setMovingGoalEnemyHero(Hero goal) {
        this.movingGoal.x = goal.getPoint().x;
        this.movingGoal.y = goal.getPoint().y-goal.getSize().y/2;
        isSpecialMoving = true;
        isMoving = true;
    }

    public int getThisTurnDamage() {
        return thisTurnDamage;
    }

    public void setThisTurnDamage(int thisTurnDamage) {
        this.thisTurnDamage = thisTurnDamage;
    }

    @Override
    public void attack(ArrayList<CardInterface> myList, ArrayList<CardInterface> enemyList, String info) {

        int goal = Integer.parseInt(info);
        CardInterface defender = enemyList.get(goal);

        defender.countRealAttack(this.getAttackDamage(),this.getMagicDamage());
        giveAttackBack(defender);
    }

    public void giveAttackBack(CardInterface defender)
    {
        if(defender.getHealth() - defender.getThisTurnDamage() >0 && !defender.isHasGiveBack()) {
            countRealAttack(defender.getAttackDamage(), defender.getMagicDamage());
            defender.setHasGiveBack(true);
        }
    }

    public void countRealAttack(int attackDamage, int magicDamage)
    {
        thisTurnDamage = (int)(((1.0-armor)*attackDamage)+((1.0-magicResistance)*magicDamage));
    }

    public void executeDamage()
    {
        if(thisTurnDamage != 0){
            health -= thisTurnDamage;
            thisTurnDamage = 0;
        }
    }

    public CardInterface enemyFindToAttack(ArrayList<CardInterface> list)
    {
        Random rm = new Random();
        int index = rm.nextInt(list.size());
        return list.get(index);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void onInit(Player myPlayer, Player enemy)
    {

    }

    public void onDead(Player myPlayer, Player enemy)
    {

    }

    public void onEndTurn(Player myPlayer, Player enemy)
    {

    }

    public void boost(Boost b)
    {
        attackDamage +=b.getAd();
        magicDamage += b.getAp();
        health += b.getH();
        armor += b.getA();
        magicResistance += b.getMr();
    }
}
