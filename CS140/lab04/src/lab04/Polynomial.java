package lab04;
public class Polynomial {
    double[] coefficients;
    /**
     * Constructor of the Polynomial class representing a polynomial
     * a0 + a1*x + a2*x^2 + a3*x^3 + ... + aN1x^N1 (where N1 is N-1).
     * @param coeffs the list of the coefficients of the Polynomial in the
     * order a0, a1, a2, a3, ..., aN1, where N1 = N-1.
     */
    public Polynomial(double... coeffs) {
        coefficients = new double[coeffs.length];
        for(int i = 0; i < coeffs.length; i++) {
            coefficients[i] = coeffs[i];
        }
    }

    /**
     * Compute the value of the polynomial for the given value of x 
     * @param x input value of the variable in the polynomial
     * @return the value of a0 + a1*x + a2*x^2 + a3*x^3 + ... + aN1x^N1, where N1=N-1.
     */
    public double value(double x) {
//COMPLETE THIS WITH A FOR LOOP FOLLOWING 
// retVal = aN1 (where N1 = N-1)
// in a loop retVal = retVal*x + ak 
// do this in a "descending loop" for(int i = coefficients.length - 2; i >= 0; i--) 
      int k = coefficients.length,i;
      double hold, holder, retVal = 0.0;
      for(i= 0; i < coefficients.length;i++){
        k = i;
        hold = 1.0;
        while(k>0){
          hold = hold*x;
          k--;
        }
        holder = coefficients[i]*hold;
        retVal = retVal + holder;
      }
      return retVal;
    }

    public static void main(String[] args) {
        Polynomial p = new Polynomial(1, 2, -6, 2);
        System.out.println("Expected value -1.0");
        System.out.println(p.value(1));
        System.out.println("Expected value -2.75");
        System.out.println(p.value(1.5));
    }
}