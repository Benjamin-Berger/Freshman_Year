package assignment04;

import java.util.Arrays;

public class GradeStats
{
  private double[] grades;
  private int[] groups ={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
  
  public GradeStats(double[ ] grades) {
   this.grades = grades;
   for(int i = 0;i<= grades.length -1;i++){
     if(grades[i] >= 0.0 && grades[i] <=5.0){ //0
       groups[0] = groups[0] + 1;
     }
     else if(grades[i] >= 6.0 && grades[i] <=10.0){//1
       groups[1] = groups[1] + 1;
     }
     else if(grades[i] >= 11.0 && grades[i] <=15.0){//2
       groups[2] = groups[2] + 1;
     }
     else if(grades[i] >= 16.0 && grades[i] <=20.0){//3
       groups[3] = groups[3] + 1;
     }
     else if(grades[i] >= 21.0 && grades[i] <=25.0){//4
       groups[4] = groups[4] + 1;
     }
     else if(grades[i] >= 26.0 && grades[i] <=30.0){//5
       groups[5] = groups[5] + 1;
     }
     else if(grades[i] >= 31.0 && grades[i] <=35.0){//6
       groups[6] = groups[6] + 1;
     }
     else if(grades[i] >= 36.0 && grades[i] <=40.0){//7
       groups[7] = groups[7] + 1;
     }
     else if(grades[i] >= 41.0 && grades[i] <=45.0){//8
       groups[8] = groups[8] + 1;
     }
     else if(grades[i] >= 46.0 && grades[i] <=50.0){//9
       groups[9] = groups[9] + 1;
     }
     else if(grades[i] >= 51.0 && grades[i] <=55.0){//10
       groups[10] = groups[10] + 1;
     }
     else if(grades[i] >= 56.0 && grades[i] <=60.0){//11
       groups[11] = groups[11] + 1;
     }
     else if(grades[i] >= 61.0 && grades[i] <=65.0){//12
       groups[12] = groups[12] + 1;
     }
     else if(grades[i] >= 66.0 && grades[i] <=70.0){//13
       groups[13] = groups[13] + 1;
     }
     else if(grades[i] >= 71.0 && grades[i] < 75.0){//14
       groups[14] = groups[14] + 1;
     }
     else if(grades[i] >= 76.0 && grades[i] <=80.0){//15
       groups[15] = groups[15] + 1;
     }
     else if(grades[i] >= 81.0 && grades[i] <=85.0){//16
       groups[16] = groups[16] + 1;
     }
     else if(grades[i] >= 86.0 && grades[i] <=90.0){//17
       groups[17] = groups[17] + 1;
     }
     else if(grades[i] >= 91.0 && grades[i] <=95.0){//18
       groups[18] = groups[18] + 1;
     }
     else if(grades[i] >= 95.0){//19
       groups[19] = groups[19] + 1;
     }
   }
}
  public double mean(double[] grades){
    double retVal;
    if(grades == null || grades.length == 0){
      retVal = 0;
    }
    else{
    double stor = 0.0;
    for(int i = 0; i<=grades.length -1;i++){
      stor = stor + grades[i];
    }
    retVal = stor/grades.length;
    }
    return retVal;
  }
  
  public double median(double[] grades){
    double[] data2 = grades.clone();
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
  
  
  
  public String mode(){    
    int holder = 0;
    int pos = 0;
    int counter = 0;
    int finMode;
    String retVal = "";
    for(int i = 0;i<=19;i++){
      if(groups[i] > holder){
        holder = groups[i];
        pos = i;
      }
    }
      for(int j = 0;j<=19;j++){
        if(groups[j] == holder){
          counter++;
        }
      }
    if(counter > 1){
      finMode = -1;
    }
    else {
      finMode = pos;
    }
    if(finMode == -1){
      retVal = "This division into 5 point classes does not identify a unique mode.";
    }
    else{
      retVal = ("Unimodal. The mode is the class with mid-point " + finMode + ".");
    }
    return retVal;
  }
  
  
  
  
}
