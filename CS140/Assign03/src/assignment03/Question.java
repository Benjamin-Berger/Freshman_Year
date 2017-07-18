package assignment03;

public class Question {
  /**
   * Method to compute the sum of the elements in an array of
   * int. Returns 0 if the array is null or empty.
   * @param array the input array
   * @return the sum of the elements in the array or 0 if the array 
   * is null or empty
   */
  public static int sum1(int[] array) {
    int value = 0;
    if(array != null) {
      for (int i = 0; i < array.length; ++i) {
        value += array[i];
      }
    }
    return value;
  }
  /**
   * Method to compute the sum of the elements in an array of
   * int. Returns 0 if the array is null or empty.
   * @param array the input array
   * @return the sum of the elements in the array or 0 if the array 
   * is null or empty
   */
  public static int sum2(int[] array) {
    int value = 0;
    if (array != null) {
      for (int  j : array) {
        value += j;
      }
    }
    return value;
  } 
  
  /**
   * Method to find the minimum element in an array of
   * doubles. The method returns 0.0 if the array is null
   * or empty
   * @param array the input array
   * @return the minimum element in the array or 0.0 if the array is null
   * or empty
   */
  public static double minElement1(double[] array) {
    double minVal = 0;
    if (array != null && array.length > 0) {  //NOTE
      minVal = array[0];
      for (int i = 1; i < array.length; i++) {
        if (array[i] < minVal) {
          minVal = array[i];
        } 
      }
    }
    return minVal;  
  }   

  /**
   * Method to find the minimum element in an array of
   * doubles. The method returns 0.0 if the array is null
   * or empty
   * @param array the input array
   * @return the minimum element in the array or 0.0 if the array is null
   * or empty
   */
  public static double minElement2(double[] array) {
    double minVal = 0;
    if (array != null && array.length > 0) {  //NOTE
      minVal = array[0];
      for (double d : array) {
        if (d < minVal) {
          minVal = d;
        } 
      }
    }
    return minVal;
  }   
  
  /**
   * Method to find the BankAccount with the lowest balance in
   * an array of BankAccounts. The code is written with the
   * assumption that all accounts in the array, if any, at non-null.
   * @param arr an array of BankAccounts
   * @return the reference to a BankAccount that has the smallest balance. 
   * If there is more than one possible account, return the first. If the 
   * array is null or empty return null.
   */
  public static BankAccount minBalBAD(BankAccount[] arr) {
    BankAccount minAcc = null;
    if (arr != null && arr.length > 0) {  
      //FIRST ASSUME ALL ELEMENTS ARE NOT null
      minAcc = arr[0];
      for (int i = 1; i < arr.length; i++) {
        if (arr[i].getBalance() < minAcc.getBalance()) {
          minAcc = arr[i];
        } 
      }
    }
    return minAcc;
  } 
  
  /**
   * Method to find the BankAccount with the lowest balance in
   * an array of BankAccounts. The code allows null elements to appear in 
   * the array.
   * @param arr an array of BankAccounts
   * @return the reference to a BankAccount that has the smallest balance. 
   * If there is more than one possible account, return the first. If the 
   * array is null or empty, or if all the elements in the array are null
   * then return null.
   */
  public static BankAccount minBal(BankAccount[] array) {
    BankAccount minAcc = null;
    if (array != null && array.length > 0) {  
      minAcc = array[0];
      int i = 0;
      while(minAcc == null && i < array.length - 1 ) {
        i++;
        minAcc = array[i];
      }
      for (i++; i < array.length; i++) {
        if (array[i] != null && 
            array[i].getBalance() < minAcc.getBalance()) {
          minAcc = array[i];
        } 
      }
    }
    return minAcc;
  }
  
  /**
   * Method to find the first index where the minimum value occurs in 
   * an array of doubles. The method returns -1 if the array is null
   * or empty.
   * @param array the input array of doubles 
   * @return the first index where the minimum value occurs in the array or
   * -1 if the array is null or empty.
   */
  public static int indexFirstMin1(double[] array) {
    int minIndex = -1;
    if (array != null && array.length > 0) {
      minIndex = 0;
      for (int i = 1; i < array.length; i++) {
        if (array[i] < array[minIndex]) {
          minIndex = i;
        } 
      }
    }
    return minIndex;
  }   
  
  /**
   * Method to find the first index where the minimum value occurs in 
   * an array of doubles. The method returns -1 if the array is null
   * or empty.
   * @param array the input array of doubles 
   * @return the first index where the minimum value occurs in the array or
   * -1 if the array is null or empty.
   */
  public static int indexFirstMin2(double[] array) {
    int minIndex = -1;
    if (array != null && array.length > 0) {
      minIndex = 0;
      int count = 0;
      for (double d : array) {    // uses the fact 
        if (d < array[minIndex]) {  // that the enhanced
          minIndex = count;   // loop advances
        }               // through the array
        count++;          // from 0 to 
      }               // array.length-1
    }
    return minIndex;
  }
  
  /**
   * Method to find the first index where the minimum absolute value occurs in 
   * an array of doubles. The method returns -1 if the array is null
   * or empty.
   * @param array the input array of doubles 
   * @return the first index where the minimum absolute value occurs in 
   * the array or -1 if the array is null or empty.
   */
  public static int firstAbsMin(double[] array) {
    int minIndex = -1;
    if (array != null && array.length > 0) {
      minIndex = 0;
      for (int i = 1; i < array.length; i++) {
        if (Math.abs(array[i]) < 
                Math.abs(array[minIndex])) {
          minIndex = i;
        } 
      }
    }
    return minIndex;
  }
}
