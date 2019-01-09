package sx3;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
    This program emulates some of the functionality of the post office.
    It registers information about sender and recipient of the parcel,
    prints all registered parcels to the terminal, writes parcels to a file.
    Finally, it can delete information about all registered parcels.
 */

public class Problem7 {
    public static void main(String[] args) {
        ArrayList<Parcel> savedParcels = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        boolean ferdig = false;
        while (!ferdig) {
            System.out.printf("%nEnter command (%d parcel(s) registered)"
                    + "%nr: register parcel"
                    + "%np: print parcels to display"
                    + "%nw: write parcels to file"
                    + "%nc: clear parcel queue"
                    + "%nq: quit%n> ", savedParcels.size());
            String command = input.next();

            // register parcel
            if (command.equals("r")) {
                savedParcels.add(registerParcel());
                System.out.printf("%nParcel registered!%n");
            }

            // print parcels
            else if (command.equals("p")) {
                parcelsToTerminal(savedParcels);
            }

            // write parcels to a file
            else if (command.equals("w")) {
                System.out.println("Please enter the name of the file:");
                String filename = input.next();
                try {
                    parcelsToFile(filename, savedParcels);
                } catch (FileNotFoundException fileNotFound) {
                    System.out.println(fileNotFound);
                }
                System.out.printf("%nParcels were written to a file %s.txt!%n", filename);
            }

            // clear parcels
            else if (command.equals("c")) {
                System.out.printf("Are you sure you want to delete all: %d parcel(s)?%n"+
                        "YES / NO%n", savedParcels.size());
                String decision = input.next();
                if (decision.equalsIgnoreCase("yes")) {
                    savedParcels.clear();
                    System.out.println("Cleared registered parcels!");
                }
            }

            // quit program
            else if (command.equals("q")) {
                System.out.println("Closing the program ...");
                ferdig = true;
            }

            // wrong input
            else {
                System.out.println("Unknown command!");
            }
        }
    }

    // creating new parcel using the info provided by the user
    public static Parcel registerParcel() {
        System.out.printf("%nRegister sender%n----------------%n");
        String name = checkIfValidString("Enter person name:");
        String street = checkIfValidString("Enter street name:");
        int streetNumber = checkIfValidNumber("Enter street number:");
        int postalCode = checkIfValidNumber("Enter postal code:");
        String town = checkIfValidString("Enter town:");
        String country = checkIfValidString("Enter country:");
        Address senderAddress = new Address(street, streetNumber, postalCode, town, country);
        Person sender = new Person(name, senderAddress);
        System.out.printf("%nRegister recipient%n----------------%n");
        name = checkIfValidString("Enter person name:");
        street = checkIfValidString("Enter street name:");
        streetNumber = checkIfValidNumber("Enter street number:");
        postalCode = checkIfValidNumber("Enter postal code:");
        town = checkIfValidString("Enter town:");
        country = checkIfValidString("Enter country:");
        Address recipientAddress = new Address(street, streetNumber, postalCode, town, country);
        Person recipient = new Person(name, recipientAddress);
        Parcel parcel = new Parcel(sender, recipient);
        return parcel;
    }

    // checking if entered information is a valid word(s), containing letters A-Z and a-z.
    public static String checkIfValidString (String message) {
        while (true) {
            Scanner inp = new Scanner(System.in);
            System.out.println(message);
            if (inp.hasNext("(?i)[a-z]+")) {
                String input = inp.nextLine();
                return input;
            } else {
                System.out.println("Wrong input data! Try again!");
                inp.nextLine();
            }
        }
    }

    // checking if entered information is a valid number (in our case - integer).
    public static int checkIfValidNumber (String message) {
        while (true) {
            Scanner inp = new Scanner(System.in);
            System.out.println(message);
            if (inp.hasNextInt()) {
                int input = inp.nextInt();
                return input;
            } else {
                System.out.println("Wrong input data! Try again!");
                inp.nextLine();
            }
        }
    }

    // printing the parcels.
    public static void parcelsToTerminal(ArrayList<Parcel> registeredParcels) {
        for (int i = 0; i < registeredParcels.size() ; i++) {
            System.out.println(registeredParcels.get(i));
        }
        System.out.printf("%n--------------------");
    }

    // writing parcels to a file "filename.txt".
    public static void parcelsToFile(String filename, ArrayList<Parcel> registeredParcels)
            throws FileNotFoundException {
        PrintWriter print = new PrintWriter("src\\sx3\\" + filename + ".txt");
        for (int i = 0; i < registeredParcels.size(); i++) {
            print.println(registeredParcels.get(i));
        }
        print.close();
        print.flush();
    }
}
