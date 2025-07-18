package creature.character;

import creature.Character;
import creature.Creature;
import weapon.Weapon;

public class Hero extends Character {

    public Hero(String name, int hp, Weapon weapon) {
        super(name, hp,weapon);
    }

    public void attack(Creature target) {
        int damage = getWeapon().getDamage();
        System.out.println(getName() + "は" + getWeapon().getName() + getWeapon().attackMessage());
        System.out.println(target.getName() + "に" + damage + "のダメージを与えた！" );
        target.setHp(target.getHp() - damage);
    }



}
