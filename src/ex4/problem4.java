package ex4;
import java.util.Arrays;

// This program shuffles the deck (array) of 13 cards and then prints it out on the terminal.
public class problem4 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shuffledDeck()));
    }

    // shuffle and return the deck
    public static String[] shuffledDeck() {
        String[] deck = sortedDeck();
        shuffle(deck);
        return deck;
    }

    // fill the array (deck) with cards
    public static String[] sortedDeck() {
        String[] deck = new String[13];
        for (int i = 0; i < deck.length ; i++) {
            deck[i] = "Hearts" + (i + 1);
        }
        return deck;
    }

    // shuffling every card, starting from the end of array
    public static void shuffle(String[] deck) {
        for (int i = deck.length - 1; i > 0; i--) {
            int j = randInt(i);     //finding the element of the array (card) to swap places with
            swap(deck, i, j);
        }
    }

    public static int randInt(int max) {
        max = (int) (Math.random() * (max + 1));
        return max;
    }

    // swapping algorithm
    public static void swap(String[] deck, int i, int j) {
        String temp = deck[i];
        deck[i] = deck[j];
        deck[j] = temp;
    }
}