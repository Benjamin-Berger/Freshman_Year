package assignment08;

public class Question3 {
  private double[] test1;
  private double holder = -99999999999999999999999999999999999999999999999999.0;
  private int i = 0;
  private int y = 0;
  private double holder2 = 0;

  
  public Question3(double[] test1){
    this.test1 = test1;
  }
  
  public double largest(){
    if(i != test1.length){
      if(test1[i] > holder){
        holder = test1[i];
      }
      i++;
      largest();
    }
    return holder;
  }

  public double sum() {
    if(y != test1.length){
      holder2 = holder2 + test1[y];
      y++;
      sum();
    }
    return holder2;
  }
  
  
  
  
  
}
