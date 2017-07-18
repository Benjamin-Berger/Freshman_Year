package lab03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Question1Test
{
  private int[] array1 = null;
  private int[] array2 = {};
  private int[] array3 = {1,2,3,3,4,1};
  
  @Before
  public void setUp() throws Exception
  {
  }
  
  
  @Test
  public void testQuestion1NullArray()
  {
    Question1 test = new Question1(array1);
    assertNull("The array field should be null", test.getArray());
  }
  
  @Test
  public void testQuestion1EmptyArray()
  {
    Question1 test = new Question1(array2);
    assertEquals("The array field should have length 0", 0, test.getArray().length);
  }
  @Test
  public void testQuestion1NormalArray()
  {
    Question1 test = new Question1(array3);
    assertArrayEquals("The array field should be array3", array3, test.getArray());
  }
  @Test
  public void testSumNullArray()
  {
    Question1 test = new Question1(array1);
    assertEquals("The sum for a null array is 0", 0, test.sum());
  }
  
  @Test
  public void testSumEmptyArray()
  {
    Question1 test = new Question1(array2);
    assertEquals("The sum for an empty array is 0", 0, test.sum());
  }
  
  @Test
  public void testSumNormalArray()
  {
    Question1 test = new Question1(array3);
    assertEquals("The sum for a non-empty array is " + (1+2+3+3+4+1), (1+2+3+3+4+1), test.sum());
  }
  
  @Test
  public void testAverageNullArray()
  {
    Question1 test = new Question1(array1);
    assertEquals("The average for a null array is 0.0", 0.0, test.average(), 1E-10);
  }
  
  @Test
  public void testAverageEmptyArray()
  {
    Question1 test = new Question1(array2);
    assertEquals("The average for an empty array is 0.0", 0.0, test.average(), 1E-10);
  }
  
  @Test
  public void testAverageNormalArray()
  {
    Question1 test = new Question1(array3);
    assertEquals("The average for a non-empty array is " + (1+2+3+3+4+1)/6.0, (1+2+3+3+4+1)/6.0, test.average(), 1E-10);
  }
}
