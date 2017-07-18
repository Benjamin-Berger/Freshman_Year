package assignment03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuestionTester
{
  private int[] array1 = null;
  private int[] array2 = {};
  private int[] array3 = {1,2,3,3,4,1};
  
  private double[] array4 = null;
  private double[] array5 = {};
  private double[] array6 = {1.0,-2.0,3.0,3.0,4.0,1.0};
  
  BankAccount bank1 = new BankAccount(1234.0);
  BankAccount bank2 = new BankAccount(1000.0);
  BankAccount bank3 = new BankAccount(9000.0);
  BankAccount bank4 = new BankAccount(0.0);
  BankAccount bank5 = null;
  
  BankAccount[] arrayBank1 = {bank1,bank2,bank3,bank4};
  BankAccount[] arrayBank2 = {bank1,bank2,bank3,bank5};
  
  @Before
  public void setUp() throws Exception
  {
  }
  
  @Test
  public void testSum1Null()
  {
    assertEquals("This should be 0", 0, Question.sum1(array1));
  }
  
  @Test
  public void testSum1Empty()
  {
    assertEquals("This should be 0", 0, Question.sum1(array2));
  }
  
  @Test
  public void testSum1Var()
  {
    assertEquals("This should be 14", 14, Question.sum1(array3));
  }
  
  @Test
  public void testSum2Null()
  {
    assertEquals("This should be 0", 0, Question.sum2(array1));
  }
  
  @Test
  public void testSum2Empty()
  {
    assertEquals("This should be 0", 0, Question.sum2(array2));
  }
  
  @Test
  public void testSum2Var()
  {
    assertEquals("This should be 14", 14, Question.sum2(array3));
  }
  
  @Test
  public void testMinElem1Null()
  {
    assertEquals("This should be 0.0", 0.0, Question.minElement1(array4), 1E-10);
  }
  
  @Test
  public void testMinElem1Empty()
  {
    assertEquals("This should be 0.0", 0.0, Question.minElement1(array5), 1E-10);
  }
  
  @Test
  public void testMinElem1Var()
  {
    assertEquals("This should be -2.0", -2.0, Question.minElement1(array6), 1E-10);
  }
  
  @Test
  public void testMinElem2Null()
  {
    assertEquals("This should be 0.0", 0.0, Question.minElement2(array4), 1E-10);
  }
  
  @Test
  public void testMinElem2Empty()
  {
    assertEquals("This should be 0.0", 0.0, Question.minElement2(array5), 1E-10);
  }
  
  @Test
  public void testMinElem2Var()
  {
    assertEquals("This should be -2.0", -2.0, Question.minElement2(array6), 1E-10);
  }
  
  @Test
  public void testminBalBad1()
  {
    assertEquals("This should be bank4", bank4, Question.minBalBAD(arrayBank1));
  }
  
//  @Test
//  public void testminBalBad2()
//  {
//    assertEquals("This should be bank5", bank5, Question.minBalBAD(arrayBank2));
//  }
  
  @Test
  public void testminBal1()
  {
    assertEquals("This should be bank4", bank4, Question.minBal(arrayBank1));
  }
  
  @Test
  public void testminBal2()
  {
    assertEquals("This should be bank2", bank2, Question.minBal(arrayBank2));
  }
  
  @Test
  public void testIndexFirstMin1Null()
  {
    assertEquals("This should be -1", -1, Question.indexFirstMin1(array4));
  }
  
  @Test
  public void testIndexFirstMin1Empty()
  {
    assertEquals("This should be -1", -1, Question.indexFirstMin1(array5));
  }
  
  @Test
  public void testIndexFirstMin1var()
  {
    assertEquals("This should be 1", 1, Question.indexFirstMin1(array6));
  }
  
  @Test
  public void testIndexFirstMin2Null()
  {
    assertEquals("This should be -1", -1, Question.indexFirstMin2(array4));
  }
  
  @Test
  public void testIndexFirstMin2Empty()
  {
    assertEquals("This should be -1", -1, Question.indexFirstMin2(array5));
  }
  
  @Test
  public void testIndexFirstMin2var()
  {
    assertEquals("This should be 1", 1, Question.indexFirstMin2(array6));
  }
  
  @Test
  public void testFirstAbsMinNull(){
    assertEquals("This should be -1", -1, Question.indexFirstMin2(array4));
  }
  
  @Test
  public void testFirstAbsMinEmpty(){
    assertEquals("This should be -1", -1, Question.indexFirstMin2(array5));
  }
  
  @Test
  public void testFirstAbsMinVar(){
    assertEquals("This should be 1.0", 1.0, Question.indexFirstMin2(array6), 1E-10);
  }
  
}
