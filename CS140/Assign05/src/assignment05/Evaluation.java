package assignment05;

public abstract class Evaluation {
  protected EvaluationType type;
  private double score;
  public Evaluation(double score) {
      this.score = score;
  }

  public double getScore() {
      return score;
  }

  public String toString() {
      return getClass().getSimpleName()+ "(" + score + ")";
  }
}