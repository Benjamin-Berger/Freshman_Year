package assignment05;

public class Quiz extends Evaluation {
  
  public Quiz(double score) {
    super(score);
    type = EvaluationType.QUIZ;
  }
}
