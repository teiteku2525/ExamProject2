package creature.character;

import creature.Character;
import creature.Creature;
import weapon.Weapon;

public class Thief extends Character {

    private boolean guard;

    public Thief(String name, int hp, Weapon weapon){
        super(name, hp, weapon);
    }

    public void attack(Creature target) {
        int damage = getWeapon().getDamage() * 2;
        System.out.println(this.getName() + "は素早く2回攻撃した！");
        System.out.println(getWeapon().getName() + getWeapon().attackMessage());
        System.out.println(target.getName() + "に" + damage + "のダメージを与えた！");
        target.setHp(target.getHp() - damage);
    }

}
