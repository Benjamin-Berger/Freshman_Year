package assignment03;

public class Question3
{
  
  /*
   * What the longestName method does is first it creates an empty array.
   * then it moves through the Student array and takes all the names and adds
   * them to the arrayName. Then a for loop iterates through the length of the
   * list of names. Then it checks the length of the name at each position. If
   * it is bigger than the current biggest then it replaces it in holder and
   * position 
   */
  public static Student longestName(Student[ ] array){
    int holder = array.length;
    String holder1 = "";
    int holder2 = 0;
    int count = 0;
    int position = 0;
    
    for(int i = 0;i<holder;i++){
      if(array[i] == null){
        continue;
      }
      holder1 =  array[i].getName();
      holder2 = holder1.length();
      if(count < holder2){
        count = holder2;
        position = i;
      }
    }
    return array[position];
  }
  
  
  
  /*
   * Same deal, moves the gpa into a new array. checked the current highest gpa
   * against the one at the current position. which ever is higher is set as
   * holder and position.
   */
    public static Student highestGPA(Student[ ] array){
      int holder = array.length;
      double holder1 = 0;
      double count = 0.0;
      int position = 0;
      
      for(int i = 0;i<holder;i++){
        if(array[i] == null){
          continue;
        }
        holder1 =  array[i].getGPA();
        if(count < holder1){
          count = holder1;
          position = i;
        }
      }
      return array[position];

    }
  
  
  
  
  
}
