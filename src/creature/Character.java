package creature;

import weapon.Weapon;

public abstract class Character implements Creature {
    private String name;
    private int hp;
    private Weapon weapon;

    public Character(String name, int hp, Weapon weapon) {
        setName(name);
        if (hp < 0) {
            throw new IllegalArgumentException("初期設定に誤りがあるため、キャラクターを作成できませんでした");
        }
        setHp(hp);
        setWeapon(weapon);
    }

    public final boolean isAlive() {
        return getHp() > 0;
    }
    public void showStatus() {
        System.out.println(getName() + ":HP " + getHp());
    }
    public void die() {
        System.out.println(getName() + "は死んでしまった！");
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setHp(int hp) {
        this.hp = Math.max(hp, 0);
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public int getHp() {
        return this.hp;
    }
    public String getName() {
        return this.name;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }
}
