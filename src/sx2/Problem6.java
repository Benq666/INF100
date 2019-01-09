package sx2;
import java.util.Random;

/*
    This program calculates the time of victim's death,
    using temperature of a body and other methods to get the estimated time of death.
    And then it prints this information out in a convenient way.
*/

public class Problem6 {
    public static void main(String[] args) {
        double[] array = cooldownSamples(27, 100000);
        double[] counts = countsFromArray(array, 20);
        String[][] array2d = array2dFromCounts(counts);
        printReport(array2d, minFromArray(array), maxFromArray(array));
    }

    // using Newton's law of cooling to compute the time that has passed since death,
    // based on the current temperature of the body
    public static double cooldown(double temperature) {
        Random random = new Random();
        double bodyTemperature = 37;
        bodyTemperature += random.nextGaussian();
        double cooldownTime = Math.log(bodyTemperature / temperature);
        cooldownTime *= 1 / bodyTemperature;
        cooldownTime *= 255 + random.nextGaussian();
        return cooldownTime;
    }

    // creating the array of temperature samples
    public static double[] cooldownSamples(int temperature, int numSamples) {
        double[] samples = new double[numSamples];
        for (int i = 0; i < samples.length; i++) {
            samples[i] = cooldown(temperature);
        }
        return samples;
    }

    // finding minimum value in the array
    public static double minFromArray(double[] array) {
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    // finding maximum value in the array
    public static double maxFromArray(double[] array) {
        double max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // making 'counts' array from the array, created by 'cooldownSamples' method
    public static double[] countsFromArray(double[] array, int numRanges) {
        double[] counts = new double[numRanges];
        double max = maxFromArray(array);
        double min = minFromArray(array);
        double rangeSize = (max - min) / (numRanges - 1);
        for (int i = 0; i < array.length; i++) {
            int j = (int) ((array[i] - min) / rangeSize);
            counts[j]++;
        }
        return counts;
    }

    // printing the 2D array
    public static void printArray2d(String[][] array2d) {
        for (int i = 0; i < array2d.length; i++) {
            System.out.println();
            for (int j = 0; j < array2d[i].length; j++) {
                System.out.print(array2d[i][j]);
            }
        }
    }

    // making the 2D array with '#' and ' ' symbols, using the information from 'counts' array
    public static String[][] array2dFromCounts(double[] counts) {
        final int PRINT_WIDTH = 50;
        double max = maxFromArray(counts);
        String[][] array2d = new String[counts.length][PRINT_WIDTH];
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < (int)((counts[i] * PRINT_WIDTH) / max) ; j++) {
                array2d[i][j] = "#";
            }
            for (int j = (int)((counts[i] * PRINT_WIDTH) / max); j < PRINT_WIDTH; j++) {
                array2d[i][j] = " ";
            }
        }
        return array2d;
    }

    // printing the final report based on the information from the 2D array created by 'array2dFromCounts' method
    public static void printReport(String[][] array2d, double arrayMin, double arrayMax) {
        System.out.printf("Time since death probability distribution.%nEach line corresponds to %.2f hours.",
                (arrayMax-arrayMin)/array2d.length);
        System.out.printf("%n==============================================%n%.2f hours", arrayMin);
        printArray2d(array2d);
        System.out.printf("%n%.2f hours%n==============================================", arrayMax);
    }
}
