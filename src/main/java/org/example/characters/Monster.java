package org.example.characters;

/**
 * Abstrakt klass för monster (t.ex. Goblin och Boss).
 * Har belöning för XP och guld.
 */

public abstract class Monster extends Characters {
    protected int xpReward;
    protected int goldReward;

    public Monster(String name, int maxHp, int xpReward, int goldReward) {
        super(name, maxHp);
        this.xpReward = xpReward;
        this.goldReward = goldReward;
    }

    public int getXpReward() {
        return xpReward;
    }

    public int getGoldReward() {
        return goldReward;
    }

    // Måste implementeras av subklasser
    @Override
    public abstract void attack(Characters target);

    @Override
    public abstract void takeDamage(int damage);
}
