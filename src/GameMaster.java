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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

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
                    enemy.add(new Matango((char)('A' + matangoC),45));
                    matangoC++;
                    break;
                case 1:
                    enemy.add(new Goblin((char)('A' + goblinC),50));
                    goblinC++;
                    break;
                case 2:
                    enemy.add(new Slime((char)('A' + slimecC),40));
                    slimecC++;
                    break;
            }//敵集団生成完了
        }



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

        //ここにIteratorを用いた拡張for文がいる
        Iterator<Character> aliveParty = party.iterator();
        Iterator<Monster> aliveEnemy = enemy.iterator();

        System.out.println("味方のターン");
        int count = 0;
        while (aliveParty.hasNext()) { //自傷で死ぬ可能性あり
            System.out.print(++count + "人目:");
            Character point = aliveParty.next();
            if (point instanceof Hero ) {
                System.out.println("勇者の行動！");
                System.out.println("1.攻撃");
                System.out.println("2.SuperHeroになる");
                int action = IntReader();
                switch (action) {
                    case 1:
                        int cnt = 1; //cnt補正付与
                        System.out.println("対象を選択");
                        for(Monster select : enemy) {
                            System.out.println(cnt + ":" + select.getName() + select.getSuffix());
                            cnt++;
                        }
                        int select = IntReader() - 1;//cnt補正の削除
                        point.attack(enemy.get(select));
                        if (damageShock(enemy.get(select))) {
                            enemy.remove(select);
                        }
                        break;
                    case 2:
                        System.out.println(point.getName() + "はスーパーヒーローに進化した！");
                        System.out.println(point.getName() + "は力を開放する代償として30のダメージを受けた！");
                        if (point.getHp() <= 30) {
                            point.die();
                        }else {
                            SuperHero sHero = new SuperHero(hero);
                            party.set(0, sHero); //ここでジョブチェン
                        }
                }
            }else if(point instanceof Wizard) {
                System.out.println("魔法使いの行動！");
                System.out.println("1.攻撃");
                System.out.println("2.魔法攻撃");
                int action = IntReader();
                int cnt;

                switch (action) {
                    case 1:
                        cnt = 1; //cnt補正付与
                        System.out.println("対象を選択");
                        for(Monster select : enemy) {
                            System.out.println(cnt + ":" + select.getName() + select.getSuffix());
                            cnt++;
                        }
                        int select = IntReader() - 1;//cnt補正の削除
                        point.attack(enemy.get(select));
                        if (damageShock(enemy.get(select))) {
                            enemy.remove(select);
                        }
                        break;
                    case 2:
                        cnt = 1; //cnt補正付与
                        System.out.println("対象を選択");
                        for(Monster select : enemy) {
                            System.out.println(cnt + ":" + select.getName() + select.getSuffix());
                            cnt++;
                        }
                        int select = IntReader() - 1;//cnt補正の削除
                        point.attack(enemy.get(select));
                        if (damageShock(enemy.get(select))) {
                            enemy.remove(select);
                        }

                }
            }



        }






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

    public static int IntReader() {
        int choice = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            choice = Integer.parseInt(br.readLine());
        } catch (NumberFormatException | NullPointerException | IOException e) {
            System.out.println("エラー" + e.getMessage());
        }
        return choice;
    }

    public static boolean damageShock(Monster monster) {
        if (monster.getHp() <= 0) {
            monster.die();
            return true;
        }else if(monster.getHp() <= 5) {
            monster.run();
            return true;
        }
        return false;
    }


}
