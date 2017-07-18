package assignment04;

import java.util.ArrayList;
import java.util.Arrays;
public class Stats
{
  private int[] data;
  
  public Stats(int[] data){
    this.data = data;
  }
  
  public double mean(int[] data){
    double retVal;
    if(data == null || data.length ==0){
      retVal = 0;
    }
    else{
    double stor = 0.0;
    for(int i = 0; i<=data.length -1;i++){
      stor = stor + data[i];
    }
    retVal = stor/data.length;
    }
    return retVal;
  }
  
  public double median(int[] data){
    int[] data2 = data.clone();
    double retVal = 1.0;
    Arrays.sort(data2);
    int len = data2.length;
    if(data2 == null || len == 0){
      retVal = 0.0;
    }
    if((len %2 == 0) && retVal != 0.0){
      int mid1 = len/2;
      int mid2 = mid1 -1;
      retVal = (data2[mid1] + data2[mid2])/2;
    }
    else if((len %2 != 0) && retVal != 0.0){
      int mid = len/2;
      retVal = data2[mid];
    }
    return retVal;
  }
  
  public double mode(int[] data){
    double retVal;
    if(data == null || data.length ==0){
      retVal = 0;
    }
    else{
    int copy[] = data.clone();
    Arrays.sort(copy);
    int maxVal = 0;
    int counter =0;

    int pos = 0;
    int[] count = new int[1+ copy[copy.length - 1]];
    for(int i = 0; i <= copy.length;i++){
      count[copy[i]] = count[copy[i]] + 1;
    }
    for(int j = 0;j <=count.length -1;j++){
      if(count[j] > maxVal){
        maxVal = count[j];
        pos = j;
      }
    }
    for(int x = 0;x <= count.length -1;x++){
      if(count[x] == maxVal){
        counter++;
      }
    }
    if(counter > 1){
      retVal = -1.0;
    }
    else {
      retVal = pos;
    }
    }
    return retVal;
  }
  
}
