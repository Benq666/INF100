package ex1;
import java.util.Scanner;

/**
 * NOK conversion to some of the other currencies
 * with Loop and check of input data
 */

public class ExchangeLoopAndCheck {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    double NOKtoUSDrate = 0.12851;
    double NOKtoEURrate = 0.10765;
    double NOKtoGBPrate = 0.09837;
    double NOKtoRUBrate = 7.37630;
    double out = 0.0;      /* var for the converted amount of NOK */
    double NOK = 0.0; 
    String inp;             /* var for user input */
    boolean stop = false;   /* var that can be used for stopping the program completely */
    boolean stop2 = false;  /* var to end the loop that works with numbers and prints the result */
    boolean Rname = false;  /* var for storing info about currency type checking */
    while (!stop) {
      Rname = false;        /* resetting the boolean vars for future loops */
      stop2 = false;        
      System.out.printf("Please specify the currency you want to convert to.%nType: USD/EUR/GBP/RUB%n");
      inp = in.next();

      // check if entered information is valid or not
      if (inp.equalsIgnoreCase("EUR") || inp.equalsIgnoreCase("USD") ||
          inp.equalsIgnoreCase("GBP") || inp.equalsIgnoreCase("RUB")) {
        Rname = true;
      }
      if (Rname) {
        while (!stop2){
          System.out.println("Please enter the amount of NOK you want to convert: ");
          if (in.hasNextDouble()) {
            NOK = in.nextDouble();

            // main calculations depending on the type of chosen currency
            if (inp.equalsIgnoreCase("USD")) {
              out = NOK*NOKtoUSDrate;
            } else if (inp.equalsIgnoreCase("EUR")) {
              out = NOK*NOKtoEURrate;
            } else if (inp.equalsIgnoreCase("GBP")) {
              out = NOK*NOKtoGBPrate;
            } else if (inp.equalsIgnoreCase("RUB")) {
              out = NOK*NOKtoRUBrate;
            }
            System.out.printf("%.2f NOK equals %.2f %S.%nNext operation.%n", NOK, out, inp);
            stop2 = true;
          } else {
            System.out.println("Invalid number. Try again!");
            in.next();
          }
        }
      } else {
        System.out.println("Invalid currency type. Try again!");
      }
    }
  }
}