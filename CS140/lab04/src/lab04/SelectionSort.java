package lab04;

public class SelectionSort
{
  public static void sort(double[] a){
    for(int i = 0;i < a.length -1;i++){
      int minPos = minimumPosition(a,i);
      swap(a,minPos,i);
    }
  }
  
  public static int minimumPosition(double[] a,int from){
    int minPos = from;
    for(int i = from + 1;i<a.length; i++){
      if(a[i]<a[minPos]){
        minPos = i;
      }
    }
    return minPos;
  }
  
  public static void swap(double[] a, int i, int j){
    double temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
  
  
  
  
}
