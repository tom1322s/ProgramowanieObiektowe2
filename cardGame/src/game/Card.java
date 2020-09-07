package game;

public abstract class Card implements CardInterface{

    private String name;
    private int id;
    private int cost;
    private String description;
    private int health;
    private int attackDamage;
    private int magicDamage;
    private double armor;
    private double magicResistance;

    private boolean isPoisoned;
    private int poisoned;

    private boolean isHealth;
    private int healing;

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

    public int countRealAttack(int attackDamage, int magicDamage)
    {
        return health - (int)(((1.0-armor)*attackDamage)+((1.0-magicResistance)*magicDamage));
    }

}
