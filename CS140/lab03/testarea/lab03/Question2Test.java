package lab03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Question2Test
{
  
  @Before
  public void setUp() throws Exception
  {
  }
  
  
  @Test
  public void testBook2NotRequired()
  {
    Book2 test = new Book2("My Book",400, false, 100);
    assertEquals("The title of the book should be My Book", "My Book", test.getTitle());
    assertEquals("The book should have 400 pages", 400, test.getPageCount());
    assertEquals("The book should not be required", false, test.isRequired());
    assertEquals("The reader should be on page 100", 100, test.getBookmark());
  }
  
  @Test
  public void testBook2Required()
  {
    Book2 test = new Book2("My Book",300, true, 299);
    assertEquals("The title of the book should be My Book", "My Book", test.getTitle());
    assertEquals("The book should have 300 pages", 300, test.getPageCount());
    assertEquals("The book should not be required", true, test.isRequired());
    assertEquals("The reader should be on page 299", 299, test.getBookmark());
  }
  
  @Test
  public void testBook2HasBeenRead()
  {
    Book2 test = new Book2("Face", 200, true, 200);
    assertEquals("The book has been read because the page count matches the bookmark", true , test.hasBeenRead());
  }
  
  @Test
  public void testBook2HasNotBeenRead()
  {
    Book2 test = new Book2("Face", 201, true, 200);
    assertEquals("The book has not been read because the page count matches the bookmark", false , test.hasBeenRead());
  }
  
  @Test
  public void testBook2computeCompleted()
  {
    Book2 test = new Book2("Blag", 100, false, 10);
    assertEquals("The student has only completed 10% of the book", 0.1 ,test.computeCompleted(), 1E-10);
  }
  
  @Test
  public void testBook2toString()
  {
    Book2 test = new Book2("CS 140", 50, true, 1);
    assertEquals("Should read: CS 140, 50, required, currently up to page 1, 2% completed", "CS 140, 50, required, currently up to page 1, 2.00% completed", test.toString());
  }
  
  @Test
  public void testBook2outputLine()
  {
    Book2 test = new Book2("This", 10, false, 0);
    assertEquals("Should read: This \t 10 \t false \t 0", "This" + "\t" + "10" + "\t" + "false" + "\t" + "0", test.outputLine());
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
