package assignment05;

public class Ex {
  public static int countLonger(String[] strs, int len) {
      int retVal = 0;
      if(strs != null) {
          for(String str : strs) {
              if(str != null && str.length() > len) {
                  retVal++;
              }
          }
      }
      return retVal;
  }
}