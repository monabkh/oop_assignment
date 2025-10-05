package org.example.characters;

/**
 * En enkel monsterklass.
 * Har 30 HP och gör 10 skada per attack.
 */

public class Goblin extends Monster {

    public Goblin() {
        super("Goblin", 30, 20, 10);  // name, maxHp, xpReward, goldReward
    }

    @Override
    public void attack(Characters target) {
        int damage = 10;
        System.out.println(name + " attacks " + target.getName() + " for " + damage + " damage.");
        target.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
        System.out.println(name + " takes " + damage + " damage, hp left: " + hp + "/" + maxHp);
    }
}
