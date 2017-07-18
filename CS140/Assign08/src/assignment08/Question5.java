package assignment08;

public class Question5 {
  public static double retVal = -1;
  public static double retVal2 = -1;
  

  
  public static double squareRootGuess(double x, double g) {
    if(x > 0 && g > 0) {
      if(Math.abs((g*g) - x) < 1E-9) {
       retVal = g;
      } else {
        squareRootGuess(x, g = (g + x/g) / 2);
      }
    } else {
      retVal = -1;
    }
    return retVal;
  }  
  
//  public static double squareRootGuess(double x) {
//    if(x > 0) {
//      if(Math.abs((y*y) - x) < 1E-9) {
//        retVal2 = y;
//      } else {
//        y = (y + x/y) / 2;
//        squareRootGuess(x);
//      }
//    }
//    return retVal2;
//  }
  
  public static double squareRootGuess(double x) {
    if (x > 0) {
      double rand = 1.0;
      retVal2 = squareRootGuess(x,rand);
    } else {
      retVal2 = -1;
    }
    return retVal2;
  }
  
  
  
  
}
