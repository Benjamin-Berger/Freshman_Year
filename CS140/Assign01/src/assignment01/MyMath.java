package assignment01;

import java.math.BigInteger;

public class MyMath {
  /**
   * Compute the factorial of the input value as an int if the
   * input is positive or zero. If the input is negative the    
   * function returns the <em>erroneous</em> value 1.
   * The code uses a loop with the invariant:
   * retVal = (count-1)!
   * @param input positive or 0 value to compute factorial
   * @return the int value of the factorial of the input
   */
  public static int factorial1(int input) {
      int retVal = 1;
      for(int count = 2; count <= input; count++) {
          retVal *= count;
      }
      return retVal;
  }

  /**
   * Compute the factorial of the input value as a long if the
   * input is positive or zero. If the input is negative the
   * function returns the <em>erroneous</em> value 1.
   * The code uses a loop with the invariant:
   * retVal = (count-1)!
   * The code uses abbreviated operators "*=" and "++".
   * @param input positive or 0 value to compute factorial
   * @return the long value of the factorial of the input
   */
  public static long factorial2(int input) {
      long retVal = 1;
      for(int count = 2; count <= input; count++) {
        retVal *= count;
    }
//MORE CODE HERE
      return retVal;
  }

  /**
   * Compute the factorial of the input value as a BigInteger if the
   * input is positive or zero. If the input is negative the
   * function returns the <em>erroneous</em> value 1.
   * The code uses a loop with the invariant:
   * retVal = (count-1)!
   * @param input positive or 0 value to compute factorial
   * @return the BigInteger value of the factorial of the input
   */
  public static BigInteger factorial3(int input) {
      BigInteger retVal = BigInteger.ONE;
      int count = 1;
      while (count <= input) {
        retVal = retVal.multiply(BigInteger.valueOf(count));
          count++;
      }
//MORE CODE HERE
      return retVal;
  }
}