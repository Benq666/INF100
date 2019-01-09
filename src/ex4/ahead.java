package ex4;

// This program shuffles the deck (2d array) of 52 cards and then prints it out on the terminal
public class ahead {
    public static void main(String[] args) {
        System.out.printf("Sorted deck:");
        printDeck(sortedDeck());
        System.out.printf("%n%nDeck after shuffling:");
        printDeck(shuffledDeck());
        System.out.println();
    }

    // perform shuffling
    public static String[][] shuffledDeck() {
        String[][] deck = sortedDeck();
        shuffle(deck);
        return deck;
    }

    // filling the 2D array with all 52 cards
    public static String[][] sortedDeck() {
        String[][] deck = new String[4][13];
        for (int i = 0; i < deck[0].length; i++) {
            deck[0][i] = "Hrts"+(i + 1);   // hearts
            deck[1][i] = "Clbs"+(i + 1);   // clubs
            deck[2][i] = "Spds"+(i + 1);   // spades
            deck[3][i] = "Dmds"+(i + 1);   // diamonds
        }
        return deck;
    }

    // going through every card, starting from the last card in last row
    public static void shuffle(String[][] deck) {
        for (int row = deck.length - 1; row >= 0; row--) {  // array[row][column] - card we are swapping
            for (int column = deck[0].length - 1; column >= 0; column--) {
                int randRow = randInt(row + 1);        // array[randRow][randCol] - card we are swapping with
                int randCol = randInt(column + 1);
                swap(deck, row, column, randRow, randCol);
            }
        }
    }

    public static int randInt(int max) {
        max = (int) (Math.random() * max);
        return max;
    }

    // swapping algorithm
    public static void swap(String[][] deck, int row, int column, int randRow, int randCol) {
        String temp = deck[row][column];
        deck[row][column] = deck[randRow][randCol];
        deck[randRow][randCol] = temp;
    }

    // separate method to print the array in more convenient way
    // Arrays.deepToString(); returns a very long line
    public static void printDeck(String[][] deck) {
        for (int i = 0; i < deck.length; i++) {
            System.out.printf("%nRow %d", (i+1));
            for (int j = 0; j < deck[0].length; j++) {
                System.out.printf("\t%s\t", deck[i][j]);
            }
        }
    }
}
