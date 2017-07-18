package assignment05;

public class CD extends BankAccount {
private double interestRate;
private int ageOfAccount = 0;
static final double MIN_DEPOSIT = 20000.0;
static final int MIN_DEPOSIT_TIME = 6;
static final double EARLY_WITHDRAWAL_PENALTY = .05;

private CD(double interestRate, double aBalance, int anAccNum){
  super(aBalance, anAccNum);
  this.interestRate = interestRate;
}

@Override
public void monthEnd(){
  double bal = getBalance();
  bal = bal * interestRate;
  deposit(bal);
  ageOfAccount++;
}

public static CD createCD(double interestRate, double aBalance, int anAccNum){
  CD retVal;
  if(aBalance < MIN_DEPOSIT) {
    retVal = null;
  } else {
    retVal = new CD(interestRate, aBalance, anAccNum);
  }
  return retVal;
}

public void withdraw(double ammount){
  double aBalance = getBalance();
  if(ageOfAccount < MIN_DEPOSIT_TIME){
    aBalance = aBalance - (ammount + (EARLY_WITHDRAWAL_PENALTY * ammount));
  } else {
    aBalance = aBalance - ammount;
  }
}

}
