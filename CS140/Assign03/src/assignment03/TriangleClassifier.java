package assignment03;

public class TriangleClassifier {
  public static String classify(Triangle triangle) {
    double side1 = triangle.getSide1();
    double side2 = triangle.getSide2();
    double side3 = triangle.getSide3();
    int triType = 0;
    int triAng = 0;
    String msg = "";
    
    
    if(((side1 + side2) < side3) || ((side2 + side3) < side1)
        || ((side1 + side3) < side2) || (side1 <= 0) || (side2 <= 0)
            || (side3 <= 0)){
        triType = 0;
      }
//    else if((side1 == side2) && (side2 == side3)){
//      triType = 1;
//    }
    else if(Math.abs(side1 - side2) < 1E-12 && Math.abs(side2 -side3) < 1E-12){
      triType = 1;
    }
//    else if(((side1 == side2) && (side1 != side3)) || (side1 == side3) && 
//        (side1 != side2)){
//      triType = 2;
//    }
    else if((Math.abs(side1 - side2) < 1E-12 && Math.abs(side1 - side3) > 1E-12)
        || (Math.abs(side1 - side3) < 1E-12 && Math.abs(side1 - side2) > 1E-12)
        || (Math.abs(side2 - side3) < 1E-12 && Math.abs(side1 - side2) > 1E-12)){
      triType = 2;
    }
//    else if((side1 != side2) && (side1 != side3) && (side2 != side3)){
//      triType = 3;
//    }
    else if(Math.abs(side1 - side2) > 1E-12 && Math.abs(side1 - side3) > 1E-12
        && Math.abs(side2 - side3) > 1E-12){
          triType = 3;
        }
    
      if(triType != 0){
        if((Math.abs(((side1*side1) + (side2*side2)) - (side3*side3)) < 1E-12)
        || (Math.abs(((side1*side1) + (side3*side3)) - (side2*side2)) < 1E-12)
           ||(Math.abs(((side3*side3) + (side2*side2)) - (side1*side1)) < 1E-12)) {
          triAng=1;
        }
        else if((((side1*side1) + (side2*side2)) < (side3*side3)) || 
            (((side3*side3) + (side2*side2)) < (side1*side1)) 
                || (((side1*side1) + (side3*side3)) < (side2*side2))){
          triAng = 2;
        }

        else if(((side1*side1) + (side2*side2)) > (side3*side3)){
          triAng = 3;
        }
      }
    if(triType == 0){
      msg = "This is not a valid Triangle";
    }
    else if(triType == 1){
      msg = "The triangle is equilateral";
    }
    else if((triType == 2) && (triAng == 1)){
      msg = "The triangle is right-angled isosceles";
    }
    else if((triType == 2) && (triAng != 1)){
      msg = "The triangle is isosceles";
    }
    else if((triType == 3) && (triAng == 1)){
      msg = "The triangle is right-angled scalene";
    }
    else if((triType == 3) && (triAng == 2)){
      msg = "The triangle is scalene and obtuse";
    }
    else if((triType == 3) && (triAng == 3)){
      msg = "The triangle is scalene and acute-angled";
    }

    
    return msg;
  }
}
