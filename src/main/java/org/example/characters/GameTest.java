package org.example.characters;

public class GameTest {
    public static void main(String[] args) {
        // Skapa ett vapen
        Weapon sword = new Weapon("Steel Sword", 15);

        // Skapa hjälten
        Hero hero = new Hero("Artemis", sword);

        // Skapa ett goblin-monster
        Goblin goblin = new Goblin();

        // Skapa en boss
        Boss boss = new Boss("Dark Lord");

        System.out.println("\n--- Battle: Hero vs Goblin ---");
        hero.attack(goblin);
        goblin.attack(hero);

        System.out.println("\n--- Hero gains XP & Gold from Goblin ---");
        hero.gainXp(goblin.getXpReward());
        hero.earnGold(goblin.getGoldReward());

        System.out.println("\n--- Battle: Hero vs Boss ---");
        boss.attack(hero);
        hero.attack(boss);

        System.out.println("\n--- Hero status ---");
        System.out.println("HP: " + hero.getHp() + "/" + hero.getMaxHp());
        System.out.println("Level: " + hero.getLevel());
        System.out.println("XP: " + hero.getXp());
        System.out.println("Gold: " + hero.getGold());
    }
}
