package assignment08;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Question5Test
{
  int f;
  
  
  @Before
  public void setUp() throws Exception
  {
 
  }
  
  @Test
  public void test1()
  {
    assertEquals("This should return 7.0.", 7.0, Question5.squareRootGuess(49, 8),1E-8);
  }
  
  @Test
  public void test2()
  {
    assertEquals("This should return 8.0.", 8.0, Question5.squareRootGuess(64, 22),1E-8);
  }
  
  @Test
  public void test3()
  {
    assertEquals("This should return 7.0.", Math.sqrt(49), Question5.squareRootGuess(49),1E-8);
  }
  
  @Test
  public void test4()
  {
    assertEquals("This should return 7.0.", Math.sqrt(49), Question5.squareRootGuess(49),1E-8);
  }
  
  @Test
  public void test5()
  {
    assertEquals("This should return 10.0.", Math.sqrt(100), Question5.squareRootGuess(100),1E-8);
  }
  
  @Test
  public void testBlank1
  ()
  {
    assertEquals("This should return -1.", -1.0, Question5.squareRootGuess(0),1E-8);
  }
  
  @Test
  public void testBlank2()
  {
    assertEquals("This should return -1.", -1.0, Question5.squareRootGuess(0,5),1E-8);
  }
  
  @Test
  public void testNull()
  {
    assertEquals("This should return -1.0.", -1.0, Question5.squareRootGuess(f),1E-8);
  }
  
  
}
