package assignment06;

import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class MoveUp
{
  Processor cpu = new Processor();
  Memory mem = new Memory();
  private int[] dataList = new int[Memory.DATA_SIZE];
  Instruction inst = new MVUP(cpu, mem);
  private int arg = 0;
  
  @Before
  public void setUp() throws Exception
  {      
    for (int i = 0; i < Memory.DATA_SIZE; i++) {
    dataList[i] = -5*Memory.DATA_SIZE + 10*i;
    try {
        mem.setData(i, -5*Memory.DATA_SIZE + 10*i);
    } catch (DataAccessException e) {
        e.printStackTrace();
    }
    
    mem.setData(509, 4);
    mem.setData(510, 9);
    mem.setData(511, 10);
    mem.setData(0, 1);
    mem.setData(1, 3);
    mem.setData(2, 6);
    mem.setData(3, 7);
    mem.setData(4, 9);//
    mem.setData(5, 11);
    mem.setData(6, 11);//
    mem.setData(7, 18);
    mem.setData(8, 18);
    mem.setData(9, 18);//
    mem.setData(10, 18);//
    mem.setData(11, 28);//
    mem.setData(12, 38);//
    mem.setData(13, 19);//
    mem.setData(14, 21);//
    mem.setData(15, 65);//
    mem.setData(16, 32);//
    mem.setData(17, 72);//
    mem.setData(18, 32);//18
    mem.setData(19, 10);//18
    }
    
    
  }
  
  @Test
  public void testFalseFalse() throws DataAccessException
  {
    arg = 509;
    inst.execute(arg, false, false);
    
    assertEquals("This should work", 0 , mem.getData(4));
    assertEquals("This should work", 0 , mem.getData(5));
    assertEquals("This should work", 0 , mem.getData(6));
    assertEquals("This should work", 0 , mem.getData(7));
    assertEquals("This should work", 0 , mem.getData(8));
    assertEquals("This should work", 9 , mem.getData(9));
    assertEquals("This should work", 11 , mem.getData(10));
    assertEquals("This should work", 11 , mem.getData(11));
    assertEquals("This should work", 18 , mem.getData(12));
    assertEquals("This should work", 18 , mem.getData(13));
    assertEquals("This should work", 18 , mem.getData(14));
    assertEquals("This should work", 18 , mem.getData(15));
    assertEquals("This should work", 28 , mem.getData(16));
    assertEquals("This should work", 38 , mem.getData(17));
    assertEquals("This should work", 19 , mem.getData(18));
    assertEquals("This should work", 10 , mem.getData(19));
  }
  
  
  @Test
  public void testFalseTrue() throws DataAccessException
  {
    arg = 509;
    inst.execute(arg, false, true);
    
    assertEquals("This should work", 0 , mem.getData(9));
    assertEquals("This should work", 0 , mem.getData(10));
    assertEquals("This should work", 0 , mem.getData(11));
    assertEquals("This should work", 0 , mem.getData(12));
    assertEquals("This should work", 0 , mem.getData(13));
    assertEquals("This should work", 0 , mem.getData(14));
    assertEquals("This should work", 0 , mem.getData(15));
    assertEquals("This should work", 0 , mem.getData(16));
    assertEquals("This should work", 0 , mem.getData(17));
    assertEquals("This should work", 18 , mem.getData(18));
    assertEquals("This should work", 18 , mem.getData(19));
    assertEquals("This should work", 28 , mem.getData(20));
    assertEquals("This should work", 38 , mem.getData(21));
  }
  
  @Test
  public void testTrueFalse() throws DataAccessException
  {
    arg = 50;
    inst.execute(arg, true, false);
    
    assertEquals("This should work", 18 , mem.getData(9));
    assertEquals("This should work", 18 , mem.getData(10));
    assertEquals("This should work", 28 , mem.getData(11));
    assertEquals("This should work", 38 , mem.getData(12));
    assertEquals("This should work", 19 , mem.getData(13));
    assertEquals("This should work", 21 , mem.getData(14));
    assertEquals("This should work", 65 , mem.getData(15));
    assertEquals("This should work", 32 , mem.getData(16));
    assertEquals("This should work", 72 , mem.getData(17));
    assertEquals("This should work", 32 , mem.getData(18));
    assertEquals("This should work", 10 , mem.getData(19));
  }
  
}
