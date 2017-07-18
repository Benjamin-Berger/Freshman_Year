package assignment08;

/**
 * A triangular shape composed of stacked unit squares like this:
 * []
 * [][]
 * [][][]
 * . . .
 */
public class Triangle {
    private int width;
    private int holder = 0;
    private int holder2 = 0;
    private StringBuilder bldr = new StringBuilder();

    /**
     * Constructs a triangular shape.
     * @param aWidth the width (and height) of the triangle
     */
    public Triangle(int aWidth) {
        width = aWidth;
        if(width <= 0){
          throw new BadTriangleException("Does not work, enter one with a greater than 0 width.");
        }
    }

    /**
     * Computes the area of the triangle.
     * @return the area
     */
    public int getArea() {
        int retVal = 0;
        if (width == 1) { 
            retVal = 1; }
        else if (width > 1) { 
            Triangle smallerTriangle = new Triangle(width - 1);
            int smallerArea = smallerTriangle.getArea();
            retVal = smallerArea + width;
        }
        return retVal;
    }

    /**
     * Draws the following figure: 
     * []
     * [][]
     * [][][]
     * . . .
     */
    public void draw() {
        //if width is positive
        //use recursion to draw the whole triangle above the bottom row and use 
        //System.out.print("[]");
        //in a loop to draw the bottom row of boxes
      
      //Upside down
//      if(width >= 0) {
//        for(int i = 0; i <= width; i++) {
//          System.out.print("[]");
//        }
//      width--;
//      System.out.println();
//      draw();
//    } 
      
      if(holder != width){
        holder++;
      if(holder > 0){
        for(int i = 0; i < holder; i++){
          System.out.print("[]");
        }
        System.out.println();
        draw();
      }
      } 
    }
    
    
    public String toString(){
      
      if(holder2 != width){
        holder2++;
        if(holder2 > 0){
          for(int j = 0; j < holder2; j++){
            bldr.append("[]");
          }
          bldr.append("\n");
          toString();
        }
      }
        return bldr.toString();
    }
}