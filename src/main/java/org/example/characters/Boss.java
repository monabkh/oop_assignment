package org.example.characters;

import java.util.Random;

/**
 * En boss är ett starkt monster med chans till specialattack (dubbel skada).
 */

public class Boss extends Monster {
    private Random random;

    public Boss(String name) {
        super(name, 100, 100, 50); // name, maxHp, xpReward, goldReward
        this.random = new Random();
    }

    @Override
    public void attack(Characters target) {
        int roll = random.nextInt(100);
        if (roll < 30) {
            specialAttack(target);
        } else {
            int damage = 20;
            System.out.println(name + " attacks " + target.getName() + " for " + damage + " damage.");
            target.takeDamage(damage);
        }
    }

/**
 * Specialattack som gör dubbel skada.
 */

    public void specialAttack(Characters target) {
        int damage = 40;
        System.out.println(name + " uses a SPECIAL ATTACK on " + target.getName() + " for " + damage + " damage!");
        target.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
        System.out.println(name + " takes " + damage + " damage, hp left: " + hp + "/" + maxHp);
    }
}
