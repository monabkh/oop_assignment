package org.example.characters;

public class Hero extends Characters {
    private int xp;
    private int level;
    private int gold;
    private Weapon weapon;

    public Hero(String name, Weapon weapon) {
        super(name, 100);  // start maxHp 100
        this.xp = 0;
        this.level = 1;
        this.gold = 0;
        this.weapon = weapon;
    }


    /**
     * Hero attackerar en fiende med sitt vapen.
     * Skada baseras på level + vapnets skada.
     */

    @Override
    public void attack(Characters target) {
        int damage = (level * 5) + weapon.getDamage();
        System.out.println(name + " attacks " + target.getName() + " with " + weapon.getName() + " for " + damage + " damage.");
        target.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
        System.out.println(name + " takes " + damage + " damage, hp left: " + hp + "/" + maxHp);
    }

    public boolean hasReachedMaxLevel() {
        return level >= 10;
    }
    /**
     * Hjälten får XP. Om han når gränsen levlar han upp.
     */


    public void gainXp(int amount) {
        xp += amount;
        System.out.println(name + " gains " + amount + " XP.");
        if (xp >= level * 100) {
            levelUp();
            xp = 0;
        }
    }

    public void heal(int amount) {
        hp += amount;
        if (hp > maxHp) {
            hp = maxHp;
        }
        System.out.println(name + " helas med " + amount + " HP. Nuvarande HP: " + hp + "/" + maxHp);
    }


    private void levelUp() {
        level++;
        maxHp += 20;
        hp = maxHp;
        System.out.println(name + " leveled up! Now level " + level + " with max HP " + maxHp);
    }

    public int getXp() {
        return xp;
    }

    public int getLevel() {
        return level;
    }

    public int getGold() {
        return gold;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void earnGold(int amount) {
        gold += amount;
        System.out.println(name + " earns " + amount + " gold. Total gold: " + gold);
    }
}
