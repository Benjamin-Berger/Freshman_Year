package lab03;
/**
 Class that stores an array that can be used to test the code
 of sum and average
*/
public class Question1 {
    private int[] array;

    /**
     * Constructor for Question 1
     * @param array the value of the array field of this object
     */
    public Question1(int[] array) {
        this.array = array;
    }

    int[] getArray() { // package private
        return array;
    }

    /**
     * Method to compute the sum of the elements in the array field
     * @return the sum of the elements in array, or 0 if array is null
     * or empty
     */
    public int sum() {
        int value = 0;
        if (array != null) {
            for (int  j : array) {
                value += j;
            }
        }
        return value;
    } 

    /**
     * Method to compute the average value of the elements of the
     * array field 
     * @return the average of the numbers in the array or 0.0 if the array
     * is null or empty
     */
    public double average() {
      double avg = 0.0;
      if(array != null && array.length > 0) {
          int sum = sum();
          avg = sum/array.length;
      }
      return avg;
  }
}