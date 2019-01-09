package ex5;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
    This program reads two files with names of students and graders
    then assigns students to each grader as evenly as possible
    and finally writes acquired information to a file.
 */

public class Problem3 {
    public static void main(String[] args) {
        try {
            ArrayList<String> students = namesFromFilename("src\\ex5\\students.csv");
            ArrayList<String> graders = namesFromFilename("src\\ex5\\graders.csv");
            ArrayList<String> assignedGraders = assignGraders(students, graders);
            writeAssignment(assignedGraders, "src\\ex5\\assigned_graders.csv");
        } catch (FileNotFoundException error1) {
            System.out.println(error1);
        }
    }

    // getting the text data from files and storing it in the ArrayList.
    public static ArrayList<String> namesFromFilename (String filename) throws FileNotFoundException {
        ArrayList<String> array = new ArrayList<>();
        File file = new File(filename);
        Scanner content = new Scanner(file);
        while (content.hasNextLine()) {
            array.add(content.nextLine());
        }
        content.close();
        return array;
    }

    // assigning graders to students as evenly as possible
    // using the result of "students % graders" operation.
    public static ArrayList<String> assignGraders(ArrayList<String> students, ArrayList<String> graders) {
        int studsPerGrader = students.size() / graders.size();
        // calculating the number of graders, which get 1 additional student.
        int gradersLimit = graders.size() - (students.size() % graders.size());
        ArrayList<String> assignedArrList = new ArrayList<>();
        int position = 0;

        // graders which get "studsPerGrader" amount of students.
        for (int i = 0; i < gradersLimit; i++) {
            int loopLimit = position + studsPerGrader;
            for (int j = position; j < loopLimit; j++) {
                assignedArrList.add(students.get(j) + ", " + graders.get(i));
                position++;
            }
        }

        // graders which get one additional student.
        for (int i = gradersLimit; i < graders.size(); i++) {
            int loopLimit = position + studsPerGrader + 1;
            for (int j = position; j < loopLimit; j++) {
                assignedArrList.add(students.get(j) + ", " + graders.get(i));
                position++;
            }
        }

        // adding the info about assigned students to each grader.
        for (int i = 0; i < gradersLimit; i++) {
            assignedArrList.add("Assigned " + studsPerGrader + " students to " + graders.get(i));
        }
        for (int i = gradersLimit; i < graders.size(); i++) {
            assignedArrList.add("Assigned " + (studsPerGrader + 1) + " students to " + graders.get(i));
        }
        return assignedArrList;
    }

    // writing the ArrayList to a file.
    public static void writeAssignment(ArrayList<String> assignment, String filename) throws FileNotFoundException {
        PrintWriter print = new PrintWriter(filename);
        for (int i = 0; i < assignment.size(); i++) {
            print.println(assignment.get(i));
        }
        print.close();
        print.flush();
    }
}