package creature.monster;

import creature.Creature;
import creature.Monster;

public final class Slime extends Monster {
    public Slime(char suffix, int hp) {
        super("スライム", suffix,hp);
    }

    public void attack(Creature target) {
        System.out.println(this.getName() + this.getSuffix() + "は体当たり攻撃！ " +target.getName() + "に5のダメージを与えた！");
        target.setHp(target.getHp()-5);
    }
}
