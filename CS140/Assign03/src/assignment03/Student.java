package assignment03;

public class Student
{
  private String name;
  private String major;
  private double GPA;
  
  public Student(String name, String major, double GPA){
    this.name = name;
    this.major = major;
    this.GPA = GPA;
  }
  
  public String getName()
  {
    return name;
  }

  public String getMajor()
  {
    return major;
  }


  public double getGPA()
  {
    return GPA;
  }



  @Override
  public String toString()
  {
    return "Student [name=" + name + ", major=" + major + ", GPA=" + GPA + "]";
  }
  
  
  





  
  
  
  
  
  
}
