package assignment08;

import java.awt.geom.Point2D;
import java.io.Serializable;




//public class Point extends Point2D implements Serializable{
public class TesterFace {
  int[][] p;
  int n;
  double sum = 0.0;
  double hold = 0.0;
  int i = 0;
  
  public TesterFace(int[][] polygon){
    this.p = polygon;
    n = p.length;
  }
  
  
  
  
  
//  public double area() {
//    if(i != n-2) {
//      hold = Math.abs(p[i].x*p[i+1].y + p[i+1].x*p[i+2].y + p[i+2].x*p[i].y 
//          - p[i].y*p[i+1].x - p[i+1].y*p[i+2].x - p[i+2].y*p[i].x)/2.0;
//      sum = sum + hold;
//      i++;
//    area();
//    }
//    return sum;
//  }
  
  public double area() {
    if(i != n-2) {
      hold = Math.abs(p[i][0]*p[i+1][1] + p[i+1][0]*p[i+2][1] + p[i+2][0]*p[i][1] - p[i][1]*p[i+1][0] - p[i+1][1]*p[i+2][0] - p[i+2][1]*p[i][0])/2.0;
      sum = sum + hold;
      i++;
    area();
    }
    return sum;
  }
  
  public static void main(String[] args) {
    int[][] poly = {{2,0},{4,0},{6,2},{6,4},{4,8},{2,8},{0,4},{0,2}};
    TesterFace test = new TesterFace(poly);
    System.out.println(test.area());
  }



//
//  @Override
//  public double getX()
//  {
//    // TODO Auto-generated method stub
//    return 0;
//  }
//
//
//
//
//
//  @Override
//  public double getY()
//  {
//    // TODO Auto-generated method stub
//    return 0;
//  }
//
//
//
//
//
//  @Override
//  public void setLocation(double arg0, double arg1)
//  {
//    // TODO Auto-generated method stub
//    
//  }
//  
  
  
  
  
}
