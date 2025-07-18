package weapon;

public abstract class Weapon {
    private String name;
    private int damage;
    private int cost = 0;

    public Weapon (String name,int damage) {
        this.name = name;
        this.damage = damage;
    }

    public Weapon (String name,int damage,int cost) {
        this.name = name;
        this.damage = damage;
        this.cost = cost;
    }

    public abstract String attackMessage();

    public String getName() {
        return this.name;
    }
    public int getDamage() {
        return this.damage;
    }
    public int getCost() {
        return this.cost;
    }
}
