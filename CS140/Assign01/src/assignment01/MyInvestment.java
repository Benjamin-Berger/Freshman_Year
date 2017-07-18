package assignment01;

public class MyInvestment
{
  private BankInvestmentOffering investmentPlan;
  private double initialBalance;
  
 
  
  
  
  public MyInvestment(BankInvestmentOffering investmentPlan,
      double initialBalance)
  {
    this.investmentPlan = investmentPlan;
    this.initialBalance = initialBalance;
  }
  /*
   * The constructed takes in the variables passed in from the Tester and puts
   * them into variables that will be used in the class.
   */
  
  public double getValue(int year){
    int endYear = year;
    double newBal = initialBalance;
    int startYear = this.investmentPlan.getStartYear();
    
    if(endYear <= startYear){
        return newBal;
    }
    else
    {
    
    int holder = endYear - startYear;
    for(int count = 0; count < holder; count++){
      int years = startYear + count;
      double rate = investmentPlan.interestRate(years);
      rate = (1+ (rate/100));
      
      newBal = newBal * rate;
    }
    return newBal;
  }
  }
  
  /*
   * Very simply the method asks if the date being asked is before the
   * investment time period. If so the balance has not changed. Otherwise,
   * it gets the number of ticks in needs to go through, starts the for loop,
   * gets the rate for the current year and does the appropriate recalulation
   * of the new balance. After the loop the new and final balance is returned. 
   */

}