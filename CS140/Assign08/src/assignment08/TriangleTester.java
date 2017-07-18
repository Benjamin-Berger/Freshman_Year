package assignment08;

public class TriangleTester {
  public static void main(String[] args) {
     Triangle t = new Triangle(10);
     int area = t.getArea();
     System.out.println("Area: " + area);
     System.out.println("Expected: 55");
     t.draw();
     System.out.println();
     System.out.println(t);
     try{
     Triangle bad = new Triangle(0);
     } 
     catch (BadTriangleException ex) {
       System.out.print(ex);
     }
     }
  }