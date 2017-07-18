package assignment03;
/**
 * Class representing a triangle
 * @author CS140
 *
 */
public class Triangle {
  private double side1;
  private double side2;
  private double side3;
  /**
   * Constructor of Trangle that sets the three sides.
   * @param side1 first side of the triangle
   * @param side2 second side of the triangle
   * @param side3 third side of the triangle
   */
  public Triangle(double side1, double side2, double side3) {
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
  }
  /**
   * Getter method for first side
   * @return value of side1
   */
  public double getSide1() {
    return side1;
  }
  /**
   * Getter method for second side
   * @return value of side2
   */
  public double getSide2() {
    return side2;
  }
  /**
   * Getter method for third side
   * @return value of side3
   */
  public double getSide3() {
    return side3;
  }
  
}
