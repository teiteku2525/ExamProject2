package creature;

public interface Creature {
    boolean isAlive();

    void showStatus();

    void attack(Creature target);

    String getName();
    int getHp();
    void setHp(int hp);

}
