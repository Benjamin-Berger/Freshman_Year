package assignment01;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Question1 asks the user for an input number
 * and computes and prints its factorial.
 */
public class Question1 {
    /**
     * Compute the factorial of the input value if the
     * input is positive or zero. If the input is negative the
     * function returns the <em>erroneous</em> value 1.
     * The code uses a loop with the invariant:
     * retVal = (count-1)!
     * @param input positive or 0 value to compute factorial
     * @return the factorial of the input
     */
    public static int factorial(int input) {
        int retVal = 1;
        int count = 1;
        while (count <= input) {
            retVal *= count;
            count++;
        }
        return retVal;
    }
    
    public static long factorialL(int input){
      long retVal = 1;
      int count = 1;
      while (count <= input) {
          retVal *= count;
          count++;
      }
      return retVal;
    }
    
    public static BigInteger factorialBig(int input){
      BigInteger retVal = BigInteger.ONE;
      int count = 1;
      while (count <= input) {
        retVal = retVal.multiply(BigInteger.valueOf(count));
          count++;
      }
      return retVal;
    }

    public static void main(String[] args) {
        System.out.println("Running main of Question1");
        System.out.println("Please enter a whole number and press enter");
        Scanner keyboard = new Scanner(System.in);
        if(keyboard.hasNextInt()) {
            int input = keyboard.nextInt();
            System.out.println("factorial(" + input + ") = " + factorial(input));
            System.out.println("factorialL(" + input + ") = " + factorialL(input));
            System.out.println("factorialBig(" + input + ") = " + factorialBig(input));
        } else {
            System.out.println("You did not enter an integer");
        }    
    }
}