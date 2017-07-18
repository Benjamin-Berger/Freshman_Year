package assignment05;

public enum EvaluationType {
  QUIZ(1,3) {
      public Evaluation makeGradeObject(double grade) {
          return new Quiz(grade);
      }
      public Evaluation makeMaxGradeObject(boolean useZero) {
          return new Quiz(useZero?0:5);
      }
  }, 
  LAB(1,1) {
      public Evaluation makeGradeObject(double grade) {
          return new Lab(grade);
      }
      public Evaluation makeMaxGradeObject(boolean useZero) {
          return new Lab(useZero?0:10);
      }
  }, 
  ASSIGNMENT(3,1){
      public Evaluation makeGradeObject(double grade) {
          return new Assignment(grade);
      }
      public Evaluation makeMaxGradeObject(boolean useZero) {
          return new Assignment(useZero?0:10);
      }       
  }, PROJECT(1,0){
      public Evaluation makeGradeObject(double grade) {
          return new Project(grade);
      }
      public Evaluation makeMaxGradeObject(boolean useZero) {
          return new Project(useZero?0:10);
      }       
  }, 
  EXAM(3,0){
      public Evaluation makeGradeObject(double grade) {
          return new Exam(grade);
      }
      public Evaluation makeMaxGradeObject(boolean useZero) {
          return new Exam(useZero?0:15);
      }       
  };

  private double contributionFactor;
  private int numDropped;
  EvaluationType(double contrib, int numDropped) {
      contributionFactor =  contrib;
      this.numDropped = numDropped;
  }
  public double getContributionFactor() {
      return contributionFactor;
  }
  public int getNumDropped() {
      return numDropped;
  }
  public Evaluation makeGradeObject(double grade) {
      return null;
  }
  public Evaluation makeMaxGradeObject(boolean useZero) {
      return null;
  }
}