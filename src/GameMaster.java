import creature.Character;
import creature.Monster;
import creature.character.Hero;
import creature.character.SuperHero;
import creature.character.Thief;
import creature.character.Wizard;
import creature.monster.Goblin;
import creature.monster.Matango;
import creature.monster.Slime;
import weapon.Dagger;
import weapon.Sword;
import weapon.Wand;
import weapon.Weapon;

import java.util.ArrayList;
import java.math.*;
public class GameMaster {
    public static void main(String[] args) {

        //武器の宣言
        Weapon sword = new Sword();
        Weapon wand = new Wand();
        Weapon dagger = new Dagger();

        Hero hero = new Hero("勇者", 100, sword);
        Wizard wizard = new Wizard("魔法使い", 60, wand,40);
        Thief thief = new Thief("盗賊", 70, dagger);
        ArrayList<creature.Character> party = new ArrayList<creature.Character>();
        party.add(hero);
        party.add(wizard);
        party.add(thief);

        Matango matango = new Matango('A', 45);
        Goblin goblin = new Goblin('A', 50);
        Slime slime = new Slime('A', 40);
        ArrayList<Monster> enemy = new ArrayList<Monster>();

        int matangoC = 0;
        int goblinC = 0;
        int slimecC = 0;

        for (int i = 0; i < 5; i++) {
            int choice = (int)(Math.random() * 3);
            switch (choice) {
                case 0:
                    enemy.add(matango);
                    enemy.get(i).setSuffix((char)('A' + matangoC));
                    matangoC++;
                    break;
                case 1:
                    enemy.add(goblin);
                    enemy.get(i).setSuffix((char)('A' + goblinC));
                    goblinC++;
                    break;
                case 2:
                    enemy.add(slime);
                    enemy.get(i).setSuffix((char)('A' + slimecC));
                    slimecC++;
                    break;
            }

        }
        enemy.add(matango);
        enemy.add(goblin);
        enemy.add(slime);

        //エンティティの状態表示
        System.out.println("---味方パーティ---");
        for (creature.Character member : party) {
            member.showStatus();
        }
        System.out.println("---敵グループ---");
        for (Monster member: enemy) {
            member.showStatus();
        }
        //ここから戦闘開始
        System.out.println("\n味方の総攻撃！");
        for (creature.Character tripleAtk: party) { //殴るクリーチャーを変更
            for (int i = 0; i < 3; i++) { //殴られるクリーチャーを変更
                tripleAtk.attack(enemy.get(i));
            }
        }
        System.out.println("\n敵の総攻撃！");
        for (Monster tripleAtk: enemy) { //殴るクリーチャーを変更
            for (int i = 0; i < 3; i++) { //殴られるクリーチャーを変更
                tripleAtk.attack(party.get(i));
            }
        }
        System.out.println("\nダメージを受けた" + hero.getName() + "が突然光りだした！");
        System.out.println(hero.getName() + "はスーパーヒーローに進化した");
        SuperHero sHero = new SuperHero(hero);
        party.set(0, sHero); //ここでジョブチェン
        for (int i = 0; i < 3; i++) {
            sHero.attack(enemy.get(i));
        }

        System.out.println("\n味方パーティ最終ステータス");
        for (Character member : party) {
            member.showStatus();
            if(member.isAlive()) {
                System.out.println("生存状況:生存");
            } else {
                System.out.println("生存状況:戦闘不能");
            }
        }

        System.out.println("\n敵グループ最終ステータス");
        for (Monster member : enemy) {
            member.showStatus();
            if(member.isAlive()) {
                System.out.println("生存状況:生存");
            } else {
                System.out.println("生存状況:討伐済み");
            }
        }
    }
}
