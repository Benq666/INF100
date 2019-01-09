package sx1;

// in this program we calculate the probability of Jack's death after n steps over 100000 runs.
public class Semester1_Ahead {
    public static void main(String[] args) {
        int array[] = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = simulate();
        }
        probability(array);
    }

    static int simulate() {
        int counter = 0;
        int x = 5;
        int y = 5;
        while ((x > 0 && 10 >= x) && (y > 0 && 10 >= y)) {
            int direction = (int) (Math.random() * 4);
            switch (direction) {
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

    static void probability(int array[]) {
        System.out.printf("The probability of Jack's death after n steps over %d runs:%n", array.length);
        for (int stepToCheck = 6; stepToCheck <= 200; stepToCheck++) {
            int numberOfDeaths = 0;
            for (int i = 0; i < array.length; i++) {
                if (stepToCheck >= array[i]) {
                    numberOfDeaths++;
                }
            }
            System.out.printf("After %d steps - %.2f%s (died in total %d times);%n",
                    stepToCheck, (double) 100*numberOfDeaths/array.length, "%", numberOfDeaths);
        }
    }
}