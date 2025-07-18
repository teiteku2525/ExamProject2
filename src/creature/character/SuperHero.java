package creature.character;

import creature.Creature;

public class SuperHero extends Hero {
    public SuperHero(Hero hero) {
        super(hero.getName(),hero.getHp() - 30,hero.getWeapon());
    }
    public void attack(Creature target) {
        int damage = (int)(getWeapon().getDamage() * 2.5);
        System.out.println(getName() + "は" + getWeapon().getName() + getWeapon().attackMessage());
        System.out.println(target.getName() + "に" + damage + "のダメージを与えた！" );
        target.setHp(target.getHp() - damage);
    }
}
