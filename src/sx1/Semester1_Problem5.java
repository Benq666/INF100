package sx1;

/*
 *       Pirate Survival Simulator 1.0
 *    This small program emulates movements of pirate Jack on the island of Mojang.
 */
public class Semester1_Problem5 {
    public static void main(String[] args) {
        final int ITERATIONS = 100000;
        int steps = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            steps += simulate();                // all the steps of the pirate
        }
        System.out.printf("Pirate Jack was eaten by the sharks after %.3f steps (averaged over %d runs).",
                (double) steps / ITERATIONS, ITERATIONS);
    }

    // separate method that simulates movement
    public static int simulate() {
        int counter = 0;       // amount of steps after single loop (single "life")
        int x = 5;             // resetting the coordinates to starting position
        int y = 5;
        while ((x >= 1 && 10 >= x) && (y >= 1 && 10 >= y)) {      // loop stops when pirate gets eaten
            int direction = (int) (Math.random() * 4);
            switch (direction) {        // decide where will the pirate move
                case 0:
                    x -= 1;
                    break;
                case 1:
                    x += 1;
                    break;
                case 2:
                    y -= 1;
                    break;
                case 3:
                    y += 1;
                    break;
            }
            counter++;
        }
        return counter;
    }
}