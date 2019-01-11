package ex6;

import java.util.Random;

/**
 * A pokemon with stats.
 *
 * @author Andrey Belinskiy
 *
 */
public class Pokemon {
    private String name;
    private int healthPoints;
    private int maxHealthPoints;
    private int strength;
    private double criticalChance;
    private Random random;

    // generating random stats for poke
    public Pokemon(String name) {
        random = new Random();
        this.name = name;
        this.healthPoints = (int) Math.abs(Math.round(100 + 10 * random.nextGaussian()));
        this.maxHealthPoints = this.healthPoints;
        this.strength = (int) Math.abs(Math.round(20 + 10 * random.nextGaussian()));
        this.criticalChance = Math.abs(0.1 * random.nextGaussian());
    }

    public String toString() {
        return String.format("%s HP: (%d/%d) STR: %d CHC: %.0f%%%n",
                name, healthPoints, maxHealthPoints, strength, 100 * criticalChance);
    }

    public String getName() {
        return this.name;
    }

    public boolean isConscious() {
        return this.healthPoints > 0;
    }

    // reducing poke's HP by the "damageTaken" amount
    public void damage(int damageTaken) {
        if (damageTaken >= this.healthPoints) {
            this.healthPoints = 0;
        } else {
            this.healthPoints -= damageTaken;
        }
        System.out.printf("%s takes %d damage and is left with %d/%d HP%n",
                name, damageTaken, healthPoints, maxHealthPoints);
    }

    public void attack(Pokemon target) {
        int damageInflicted =
                (int) (this.strength + this.strength / 2 * random.nextGaussian());
        if (damageInflicted < 0) {
            damageInflicted = 0;
        }
        System.out.printf("%s attacks %s.%n", this.getName(), target.getName());
        target.damage(damageInflicted);
        if (this.criticalChance > Math.random() && target.isConscious()) {
            System.out.println("Critical strike!");
            target.damage(damageInflicted);
        }
        if (!target.isConscious()) {
            System.out.printf("%s is defeated by %s%n", target.getName(), this.getName());
        }
    }
}
