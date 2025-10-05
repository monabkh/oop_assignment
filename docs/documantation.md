# Dokumentation: Textbaserat Äventyrsspel i Java

## Översikt

Detta är ett textbaserat turordningsspel skrivet i Java, där spelaren styr en hjälte som går på äventyr, strider mot monster, samlar guld och XP, och levlar upp. Spelet innehåller en huvudmeny, stridslogik, en shop, samt ett leveling- och encountersystem.

Projektet är uppbyggt med tydlig objektorientering, inklusive abstrakta basklasser och arv.

---

## Klassdiagram / Arvstruktur

Character (abstract)
├── Hero
└── Monster (abstract)
├── Goblin (konkret)
└── Boss (konkret)

---

## Klassbeskrivningar

### 🔹 Character (abstract)
- **Beskrivning:** Gemensam basklass för alla karaktärer (spelare och fiender)
- **Attribut:** `name`, `hp`, `maxHp`
- **Metoder:**
    - `abstract void attack(Character target)`
    - `abstract void takeDamage(int amount)`
    - `boolean isAlive()`

### 🔹 Hero (extends Character)
- **Beskrivning:** Den spelbara karaktären
- **Attribut:** `xp`, `level`, `gold`, `weapon`
- **Metoder:**
    - `attack()` – gör skada baserat på level + weapon
    - `gainXp()`, `levelUp()` – leveling-system
    - `earnGold()` – ökar guld
    - `hasReachedMaxLevel()` – check för vinst
- **Startvärden:** 100 HP, level 1, träsvärd (10 dmg)

### 🔹 Monster (abstract)
- **Beskrivning:** Basklass för alla fiender
- **Attribut:** `xpReward`, `goldReward`
- **Metoder:** `attack()`, `takeDamage()`

### 🔹 Goblin (extends Monster)
- **Beskrivning:** En enkel fiende
- **Startvärden:** 30 HP, 10 dmg, 20 XP, 10 guld
- **Logik:** Enkel attack som gör fast skada

### 🔹 Boss (extends Monster)
- **Beskrivning:** En starkare fiende med specialattack
- **Special:** 30% chans att göra dubbel skada
- **Startvärden:** 100 HP, 20 dmg, 100 XP, 50 guld

### 🔹 Weapon
- **Beskrivning:** Vapen som hjälten bär
- **Attribut:** `name`, `damage`
- **Exempel:** `"Träsvärd"` – 10 dmg

---

## Shop & Interface

### 🔹 Purchasable (interface)
- Definierar metoden `purchase(Hero hero)`
- Alla shop-items implementerar detta interface

### 🔹 Shop
- Innehåller en lista av `Purchasable`-objekt
- Visar tillgängliga varor
- Hanterar köp baserat på guld

### 🔹 Exempelitem: HealthPotion
- Ger +30 HP upp till max
- Kostar t.ex. 20 guld

---

## Spelloop / Flöde

1. **Spelet startar**: Hjälten skapas, börjar på level 1 med träsvärd
2. **Menyval**:
    - [1] Gå på äventyr
    - [2] Visa info
    - [3] Gå till affären
    - [9] Avsluta
3. **Äventyr**:
    - 70% vanligt monster (Goblin)
    - 10% boss (Boss)
    - 20% säker plats (får 5–10 XP och 2–5 guld)
4. **Strid**:
    - Turbaserad: hjälten slår först, sen monstret
    - Specialattack från Boss möjlig
    - Efter vinst får man XP + guld
5. **Level up**:
    - Varje 100 XP → level upp
    - HP ökar med +20
    - HP återställs till max
    - Max level: 10
6. **Affär**:
    - Köp t.ex. nya vapen eller potions med guld

---

## Designbeslut

- **Abstrakta klasser** användes för att definiera gemensamma drag men hindra direkt instansiering av `Character` och `Monster`.
- **Arv** håller koden ren och återanvändbar.
- **Interface (`Purchasable`)** gör shoppen flexibel – fler item-typer kan enkelt läggas till.
- **Random encounter system** skapar variation i spelet.

---

## Framtida förbättringar (idéer)

- Fler vapen med olika egenskaper
- Mer avancerade monster
- Spel med sparfil
- Fler menyer eller kartsystem
- Visuellt gränssnitt (t.ex. Swing eller JavaFX)

---

## Sammanfattning

Projektet visar hur objektorientering kan användas för att skapa ett spel med arv, polymorfism, interface, och spelmekanik som XP, strid och shop. Koden är strukturerad i paket, med tydlig separation mellan logik, meny och karaktärer.
