package creature.monster;

import creature.Creature;
import creature.Monster;

public class Matango extends Monster {
    public Matango(char suffix, int hp) {
        super("お化けキノコ", suffix,hp);
    }

    public void attack(Creature target) {
        System.out.println(this.getName() + getSuffix() + "は体当たり攻撃！ " + target.getName() + "に6のダメージを与えた！");
        target.setHp(target.getHp() - 6);
    }


}
