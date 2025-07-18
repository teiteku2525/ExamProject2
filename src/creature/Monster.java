package creature;

public abstract class Monster implements Creature {
    private String name;
    private int hp;
    private char suffix;

    public Monster(String name, char suffix,int hp) {
        setName(name);
        setSuffix(suffix);
        if (hp < 0) {
            throw new IllegalArgumentException("初期設定に誤りがあるため、キャラクターを作成できませんでした");
        }
        setHp(hp);
    }

    public void run() {
        System.out.println(getName() + getSuffix() + "は逃げ出した");
    }
    public void die() {
        System.out.println(getName() + getSuffix() + "を倒した！");
    }

    public final boolean isAlive() {
        return hp > 0;
    }
    public void showStatus() {
        System.out.println(getName() + getSuffix() + ": HP" + getHp());
    }

    public void setName(String name){
        this.name = name;
    }
    public void setSuffix(char suffix) {
        this.suffix = suffix;
    }
    public void setHp(int hp) {
        this.hp = Math.max(hp, 0);
    }
    public String getName() {
        return this.name;
    };
    public char getSuffix() {
        return this.suffix;
    }
    public int getHp() {
        return this.hp;
    }

}
