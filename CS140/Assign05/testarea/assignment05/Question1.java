package assignment05;

import java.util.ArrayList;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Question1
{
  ArrayList<Student> list = new ArrayList<Student>();
  StudentComparator test = new StudentComparator();

  
  @Before
  public void setUp() throws Exception
  {
    Student s;
    list.add(s = new GraduateStudent(new Person("Jane", "Jones"), "B00012345", "ABC"));
    s.setMajor("CCC");
    list.add(s = new GraduateStudent(new Person("Kevin", "Kay"), "B00012340", "DEF"));
    s.setMajor("AAA");
    list.add(s = new GraduateStudent(new Person("Colin", "Clarke"), "B00012350", "UUU"));
    s.setMajor("AAA");
    list.add(s = new Student(new Person("Linda", "Lake"), "B00012342"));
    s.setMajor("EEE");
    list.add(s = new Student(new Person("Bryan", "Brooks"), "B00012341"));
    s.setMajor("DDD");
    list.add(s = new Student(new Person("Alan", "Addams"), "B00012347"));
    s.setMajor("DDD");
  }
  
  
  
  @Test
  public void TwoGradStuWithSameMajor(){
  assertTrue("Two Grad Student with same Major are ordered by name" , test.compare(list.get(1), list.get(2)) > 0);
  }
  
  @Test
  public void TwoGradStudWithDifMajor(){
    assertTrue("Two Grad Student with different Major are ordered by Major" , test.compare(list.get(0), list.get(1)) > 0);
  }
  
  @Test
  public void TwoStuWithSameMajor(){
    assertTrue("Two Student with same Major are ordered by name" , test.compare(list.get(4), list.get(5)) > 0);
  }
  
  @Test
  public void TwoStuWithDifMajor(){
    assertTrue("Two Student with different Major are ordered by Major" , test.compare(list.get(3), list.get(4)) > 0);
  }
  
  @Test
  public void GradAndStu(){
    assertTrue("A Grad Student and a regular Student are ordered by Rank" , test.compare(list.get(0), list.get(5)) > 0);
  }
  
  @Test
  public void TestAgaisntSelf(){
    assertTrue("A Grad Student tested against himself will return 0", test.compare(list.get(0), list.get(0)) == 0);
  }
  
}
