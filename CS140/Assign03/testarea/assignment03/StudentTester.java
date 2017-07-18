package assignment03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentTester
{
  Student s = new Student("Bob", "Math", 70);
  Student s1 = new Student("Bo", "CS", 87);
  Student s2 = new Student("Eben", "Eng", 66);
  Student s3 = null;
  
  Student[] array = {s,s1,s2,s3};
  @Before
  public void setUp() throws Exception
  {
  }
  

  
  @Test
  public void testLongName(){
    assertEquals("This should be Eben", s2,Question3.longestName(array));
  }
  
  @Test
  public void testHighestGPA(){
    assertEquals("This should be Bo", s1,Question3.highestGPA(array));
  }
  
  
  
  
  
}
