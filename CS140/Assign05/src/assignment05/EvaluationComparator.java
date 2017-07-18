package assignment05;

import java.util.Comparator;


/*
 * it takes in the enum types and compares them against each other. the rank
 * it uses goes by the elements passed in. the first one being the lowest and
 * last one being the highest.
 */





public class EvaluationComparator 
  implements Comparator<Evaluation> {
    
    @Override
    public int compare(Evaluation arg0, Evaluation arg1) {
      
      int returnValue = arg0.type.compareTo(arg1.type);
      
      if (returnValue == 0) {
        
        if(arg0.getScore() < arg1.getScore()) {
          returnValue = -1;
        } else if (arg0.getScore() > arg1.getScore()) {
          returnValue = 1;
        }
      }
    return returnValue;
  }
}