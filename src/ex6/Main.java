package ex6;
import java.util.Scanner;

/*
    This program recreates basic features of a pokemon game.
 */

public class Main {
    public static void main(String[] args) {
        Pokemon poke1 = namePoke("first");
        Pokemon poke2 = namePoke("second");
        System.out.printf("%n%s%s%n", poke1, poke2);
        while (poke1.isConscious() && poke2.isConscious()) {
            poke1.attack(poke2);
            if (poke2.isConscious()) {
                poke2.attack(poke1);
            }
        }
    }

    // simple method to get the name for poke from the user
    public static Pokemon namePoke(String pokeNum) {
        Scanner inp = new Scanner(System.in);
        System.out.printf("Please enter the name of the %s pokemon:%n", pokeNum);
        String name = inp.next();
        System.out.printf("%s is created!%n", name);
        return new Pokemon(name);
    }
}
