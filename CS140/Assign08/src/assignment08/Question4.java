package assignment08;

import java.awt.Point;

public class Question4{
  //int[][] p;
  int n;
  double sum = 0.0;
  double hold = 0.0;
  int i = 0;
  Point[] p;
  int j = 1;
  int q = 2;
  
  public Question4(Point[] p){
    this.p = p;
    n = p.length;
  }
  
  public double area(){
    if (i != n-2) {
      hold = Math.abs(p[0].x*p[j].y + p[j].x*p[q].y + p[q].x*p[0].y - p[0].y*p[j].x - p[j].y*p[q].x - p[q].y*p[0].x)/2.0;
      sum = sum + hold;
      i++;
      j++;
      q++;
      area();
    }
    return sum;
  }
}