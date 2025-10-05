package org.example.characters;

public class HealthPotion implements Purchasable {
    private final String name = "Health Potion";
    private final int price = 25;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void purchase(Hero hero) {
        if (hero.getGold() >= price) {
            hero.earnGold(-price); // dra av guld
            hero.heal(30);
            System.out.println(hero.getName() + " köpte en " + name + " och återfick 30 HP!");
        } else {
            System.out.println("Inte tillräckligt med guld för att köpa " + name + ".");
        }
    }
}
