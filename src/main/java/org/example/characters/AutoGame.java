package org.example.characters;

import java.util.Random;
import java.util.Scanner;

public class AutoGame {
    private Hero hero;
    private final Random random = new Random();
    private final Shop shop = new Shop();

    public void start() {
        System.out.println("Välkommen till äventyret!");

        createHero();

        for (int i = 1; i <= 10; i++) {
            System.out.println("\n== Äventyr " + i + " ==");
            int chance = random.nextInt(100);

            if (chance < 70) {
                startBattle(new Goblin());
            } else if (chance < 80) {
                startBattle(new Boss("Demon King"));
            } else {
                System.out.println("Inget monster hittades denna gång.");
            }

            if (!hero.isAlive()) {
                System.out.println("\n" + hero.getName() + " har dött... Game Over.");
                return;
            }

            if (hero.hasReachedMaxLevel()) {
                System.out.println("\n " + hero.getName() + " har nått max level! Du vann spelet!");
                break;
            }
        }

        System.out.println("\n Äventyret är över!");
        mainMenu(); // Öppna meny efter äventyret
    }

    private void createHero() {
        Weapon startWeapon = new Weapon("Träsvärd", 10);
        hero = new Hero("Artemis", startWeapon);
        System.out.println("Hjälten " + hero.getName() + " är redo med vapen: " + startWeapon.getName());
    }

    private void startBattle(Monster monster) {
        System.out.println("battle" + hero.getName() + " möter " + monster.getName());

        while (hero.isAlive() && monster.isAlive()) {
            hero.attack(monster);
            if (monster.isAlive()) {
                monster.attack(hero);
            }
        }

        if (hero.isAlive()) {
            System.out.println("✅ " + hero.getName() + " besegrade " + monster.getName());
            hero.gainXp(monster.getXpReward());
            hero.earnGold(monster.getGoldReward());
        }
    }

    private void showHeroStats() {
        System.out.println("\n=== HJÄLTESTATUS ===");
        System.out.println("Namn: " + hero.getName());
        System.out.println("HP: " + hero.getHp() + "/" + hero.getMaxHp());
        System.out.println("Level: " + hero.getLevel());
        System.out.println("XP: " + hero.getXp());
        System.out.println("Guld: " + hero.getGold());
        System.out.println("Vapen: " + hero.getWeapon().getName() + " (+" + hero.getWeapon().getDamage() + " dmg)");
    }

    private void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== HUVUDMENY ===");
            System.out.println("[1] Visa hjältestatus");
            System.out.println("[2] Gå till affären");
            System.out.println("[9] Avsluta");
            System.out.print("Välj ett alternativ: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showHeroStats();
                    break;
                case "2":
                    shop.openShop(hero);
                    break;
                case "9":
                    System.out.println("Spelet avslutas. Tack för att du spelade!");
                    running = false;
                    break;
                default:
                    System.out.println("Ogiltigt val, försök igen.");
            }
        }
    }
}
