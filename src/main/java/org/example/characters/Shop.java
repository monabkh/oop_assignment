package org.example.characters;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
    private final List<Purchasable> items = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public Shop() {
        items.add(new HealthPotion());
        // Du kan lägga till fler i framtiden
    }

    public void openShop(Hero hero) {
        System.out.println("\n🛒 Välkommen till affären!");
        boolean shopping = true;

        while (shopping) {
            System.out.println("\n--- Tillgängliga varor ---");
            for (int i = 0; i < items.size(); i++) {
                Purchasable item = items.get(i);
                System.out.println("[" + (i + 1) + "] " + item.getName() + " - " + item.getPrice() + " guld");
            }
            System.out.println("[0] Tillbaka till meny");

            System.out.print("Vad vill du köpa? ");
            String input = scanner.nextLine();

            try {
                int choice = Integer.parseInt(input);
                if (choice == 0) {
                    shopping = false;
                } else if (choice > 0 && choice <= items.size()) {
                    Purchasable selected = items.get(choice - 1);
                    selected.purchase(hero);
                } else {
                    System.out.println("Ogiltigt val.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Skriv en siffra.");
            }
        }
    }
}
