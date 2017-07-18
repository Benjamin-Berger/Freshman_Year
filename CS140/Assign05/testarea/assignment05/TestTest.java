package assignment05;


import static org.junit.Assert.*;
import org.junit.Test;
public class TestTest {
    String[] test1 = null;
    String[] test2 = {};
    String[] test3 = {null, null, null, null, null, null};
    String[] test4 = {null, "abcdefgh", "ijklmnopqrst", null, "uvwxyz", null};


    @Test
    public void testNullCase() {
      assertEquals("This null should return 0.", 0, Ex.countLonger(test1, 1));
    }

    @Test
    public void testZeroCase() {
      assertEquals("This zero case should return 0.", 0, Ex.countLonger(test2, 2));
    }
    
    @Test
    public void testSetOfNull() {
      assertEquals("This should return 0.", 0, Ex.countLonger(test3, 1));
    }
    
    @Test
    public void testStringGreaterThan1() {
      assertEquals("This should return 3.", 3, Ex.countLonger(test4, 1));
    }
    
    @Test
    public void testStringGreaterThan7() {
      assertEquals("This should return 2.", 2, Ex.countLonger(test4, 7));
    }
}
