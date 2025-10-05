package org.example.characters;

/**
 * Abstrakt basklass för alla karaktärer i spelet (hjälte och monster).
 * Innehåller namn, HP och maxHP.
 * Definierar metoder som måste implementeras: attack() och takeDamage().
 */

    public abstract class Characters {
        protected String name;
        protected int hp;
        protected int maxHp;

        public Characters(String name, int maxHp) {
            this.name = name;
            this.maxHp = maxHp;
            this.hp = maxHp;
        }

        public boolean isAlive() {
            return hp > 0;
        }

        public void heal(int amount) {
            hp += amount;
            if (hp > maxHp) {
                hp = maxHp;
            }
        }

        public String getName() {
            return name;
        }

        public int getHp() {
            return hp;
        }

        public int getMaxHp() {
            return maxHp;
        }

        public abstract void attack(Characters target);

        public abstract void takeDamage(int damage);
    }


