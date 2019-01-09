package ex1;
import java.util.Scanner;

/**
 * Simple NOK conversion to some of the other currencies
 * without loop and check of input data
 */

public class ExchangeProblem5 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    double NOKtoUSDrate = 0.12851;
    double NOKtoEURrate = 0.10765;
    double NOKtoGBPrate = 0.09837;
    double NOKtoRUBrate = 7.37630;
    double out = 0.0; // var for the converted amount of NOK
    System.out.printf("Please specify the currency you want to convert to.%nType: USD/EUR/GBP/RUB%n");
    String inp = in.next();
    System.out.println("Please enter the amount of NOK you want to convert: ");
    double NOK = in.nextDouble();

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
    System.out.printf("%.2f NOK equals %.2f %S%n", NOK, out, inp);
  }
}