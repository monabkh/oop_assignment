package org.example.characters;

public interface Purchasable {
    String getName();
    int getPrice();
    void purchase(Hero hero);  // effekten när hjälten köper
}

