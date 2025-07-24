package creature.character;

import creature.Character;
import creature.Creature;
import weapon.Weapon;

public class Wizard extends Character {
    int mp;

    public Wizard(String name, int hp, Weapon weapon, int mp) {
        super(name, hp, weapon);
        setMp(mp);
    }

    public void magic(Creature target) {
        if (getMp() < getWeapon().getCost()) {
            System.out.println("MPが足りない！");
            return;
        }
        int damage = getWeapon().getDamage();
        System.out.println(this.getName() + "は" + getWeapon().getName() + getWeapon().attackMessage());
        System.out.println( target.getName() + "に" + damage + "のダメージを与えた！");
        target.setHp(target.getHp() - damage);
        this.setMp(this.getMp() - getWeapon().getCost());
    }

    public void attack(Creature target) {
        System.out.println(this.getName() + "は石を投げた！");
        System.out.println( target.getName() + "に3のダメージを与えた！");
        target.setHp(target.getHp() - 3);
    }

    public void showStatus() {
        System.out.println(getName() + ":HP " + getHp() + " MP " + getMp());
    }


    public void setMp(int mp) {
        this.mp = mp;
    }
    public int getMp() {
        return this.mp;
    }
}
