package ex3;
/*
 * 
 *    Simple dice emulation program.
 *    Two dice, input data cheking, loops and exit menu.
 * 
 *    (I've put several input checks iside loops. Later I discovered, that it's better
 *    to put those checks in separate loops. It's hard to restructure the program now,
 *    but I'll use this method in next exercises).
 * 
 * 
 */
import java.util.Scanner;
public class Ex3problem3 {
    public static void main(String[] args) { 
        Scanner in = new Scanner(System.in);
        int diceVal1 = 0;           // vars for values of dice rolls
        int diceVal2 = 0;
        int inp = 0;                // vars for input data from user
        int inp2 = 0;
        int counter = 0;            // counter for number of rolls
        int counter2 = 0;           // counter for number of matches of dice roll and roll that user specified
        String inpStrng = "";       
        boolean stop1 = false;      // vars to control loops
        boolean stop2 = false;
        
        
        while (!stop1) {
            counter = 1;              // resetting vars used by inside loops 
            stop2 = false;            //                                     
            System.out.println("Enter desired dice roll (2-12): ");
            if (in.hasNextInt()) {                 //                     
                inp = in.nextInt();                  // checking input data
                if (inp >= 2 && inp <= 12) {         //                    
                    
                    
                    while (!stop2) {
                        counter2 = 1;                   // another reset
                        System.out.println("And how many times you want to roll "+inp+"?");
                        if (in.hasNextInt()) {          //              
                            inp2 = in.nextInt();          // another check
                            if (inp2 < 1) {               //              
                                System.out.printf("Hey, you can't roll the dice "+inp2+" times! Pick another number!%n%n");
                            } else {
                                System.out.println("You want to roll -> "+inp+" <- "+inp2+" time(s). Let's see how lucky you are this time!");
                                diceVal1 = (int)(1+6*Math.random());                 // recording first rolls of dice for the first check
                                diceVal2 = (int)(1+6*Math.random());
                                if (inp2 == 1 && inp == (diceVal1+diceVal2)) {       // checking if user is fantastically lucky
                                    System.out.printf("Roll number "+counter+". Rolled "+diceVal1+" and "+diceVal2+". -> %2d <- in total!%n",(diceVal1+diceVal2));
                                    System.out.printf("You are very lucky! Got "+inp+" from the first try! Congrats!%n%n");
                                    stop2 = true;
                                } else {
                                    
                                    
                                    while (counter2 <= inp2) {                // main loop that imulates two dice
                                        System.out.printf("Roll # "+counter+".\tRolled "+diceVal1+" and "+diceVal2+". -> %2d <- in total!%n",(diceVal1+diceVal2));
                                        if (inp == (diceVal1+diceVal2)) {       // just to announce when we get a match
                                            System.out.printf("GOT IT! "+(counter2-1)+" time(s) already!%n%n");
                                        }
                                        diceVal1 = (int)(1+6*Math.random());
                                        diceVal2 = (int)(1+6*Math.random());
                                        counter++;                              // number of rolls
                                        if (inp == (diceVal1+diceVal2)) {
                                            counter2++;                           // number of matches
                                        }
                                    }
                                    if (counter2 > inp2) {                    // outputting statistics after the main loop ends
                                        System.out.printf("Roll # "+counter+".\tRolled "+diceVal1+" and "+diceVal2+". -> %2d <- in total!%nBINGO!%n%n", (diceVal1+diceVal2));
                                        stop2 = true;
                                        System.out.printf("Rolled -> "+inp+" <- "+inp2+" time(s) after "+counter+" rolls!%n%n");
                                    }
                                }
                            }
                        } else {
                            System.out.printf("Wrong input data! Try again!%n%n");
                            in.next();
                        }
                    }
                } else {
                    System.out.printf("Wrong number. Try again!%n%n");
                }
            } else {
                System.out.printf("Wrong input data. Try again!%n%n");
                in.next();
            }
            
            
            while (stop2) {                           // simple exit menu
                System.out.println("Roll again? (y/n):");
                inpStrng = in.next();
                if (inpStrng.equalsIgnoreCase("n") || inpStrng.equalsIgnoreCase("y")||
                    inpStrng.equalsIgnoreCase("no")|| inpStrng.equalsIgnoreCase("yes")) {
                    if (inpStrng.equalsIgnoreCase("n") || inpStrng.equalsIgnoreCase("no")) {
                        System.out.println("Thank you for using my program!");
                        stop1 = true;
                        stop2 = false;
                    } else if (inpStrng.equalsIgnoreCase("y") || inpStrng.equalsIgnoreCase("y")) {
                        System.out.printf("Next iteration.%n%n");
                        stop2 = false;
                    }
                } else {
                    System.out.printf("Wrong input data! Try again!%n%n");
                }
            }
        }
    }
}