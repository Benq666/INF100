package sx2;

import java.util.Formatter;
import java.util.Random;

/**
 * This program writes the report to a file 'report.txt' instead of printing it to the terminal.
 * The file is created in the root folder of a project or where the java file is located.
 *
 * @author Andrey Belinskiy
 *
 */
public class ahead {
    public static void main(String[] args) {
        double[] array = cooldownSamples(27, 100000);
        double[] counts = countsFromArray(array, 20);
        String[][] array2d = array2dFromCounts(counts);
        openFile();
        addRecords(array2d,maxFromArray(array),minFromArray(array));
        closeFile();
    }

    // using global Formatter var to create a file
    static Formatter x;
    public static void openFile() {
        try {
            x = new Formatter("src\\sx1\\report.txt");
            System.out.println("File 'report.txt' was created successfully.");
        }
        catch (Exception e) {
            System.out.println("Error." + e);
        }
    }

    // writing the data into the file using for loops to write the array,
    // so it will look the same way as after printing it using the 'printf' method
    public static void addRecords(String[][]array2d, double arrayMax, double arrayMin) {
        x.format("Time since death probability distribution.%nEach line corresponds to %.2f hours.%n" +
                        "==============================================%n%.2f hours",
                (arrayMax-arrayMin)/array2d.length, arrayMin);
        for (int i = 0; i < array2d.length; i++) {
            x.format("%n");
            for (int j = 0; j < array2d[i].length; j++) {
                x.format(array2d[i][j]);
            }
        }
        x.format("%n%.2f hours%n==============================================", arrayMax);
    }

    // closing the file
    public static void closeFile() {
        x.close();
    }

    // methods to calculate the time of death from the problem 6
    public static double cooldown(double temperature) {
        // we need this object to generate Gaussian random variables
        // (remember to import java.util.Random)
        Random random = new Random();

        // the average body temperature of a (living) human
        double bodyTemperature = 37;

        // add noise to simulate that the body temperature of the victim at the
        // time of death is uncertain
        bodyTemperature += random.nextGaussian();

        // compute the time required for the body to cool down from
        // bodyTemperature to temperature using Newton's law of cooling.
        double cooldownTime = Math.log(bodyTemperature / temperature);
        cooldownTime *= 1 / bodyTemperature;

        // normalize this value such that cooling down from 37 to 32 degrees
        // takes 1 hour. we assume that we have measured this for the
        // environment that the body is found in. we add Gaussian noise to
        // simulate measurement uncertainty.
        cooldownTime *= 255 + random.nextGaussian();

        return cooldownTime;
    }

    public static double[] cooldownSamples(int temperature, int numSamples) {
        double[] samples = new double[numSamples];
        for (int i = 0; i < samples.length; i++) {
            samples[i] = cooldown(temperature);
        }
        return samples;
    }

    public static double minFromArray(double[] array) {
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static double maxFromArray(double[] array) {
        double max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static double[] countsFromArray(double[] array, int numRanges) {
        double[] counts = new double[numRanges];
        double rangeSize = (maxFromArray(array) - minFromArray(array)) / (numRanges - 1);
        for (int i = 0; i < array.length; i++) {
            int j = (int) ((array[i] - minFromArray(array)) / rangeSize);
            counts[j]++;
        }
        return counts;
    }

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
}
