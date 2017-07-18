package assignment01;
/**
 * An investment offering from a bank. for simplicity the rates of
 * return are predicted for each year of the investment offering.
 * @author cs140
 */
public class BankInvestmentOffering {
    private int startYear;
    private int endYear;
    private double[] rates; 

    /**
     * Constructor that takes the start year and the predicted interest
     * rates for the length of the investment. This constructor uses the
     * "vararg" parameter notation, although it is legal to pass an array
     * as the argument. For example, a three year investment could be:
     * new BankInvestmentOffering(2004, 5.1, 5.5, 4.6)
     * @param startYear the first year of the investment offering
     * @param rates the sequence of rates year by year
     */
    public BankInvestmentOffering (int startYear, double... rates) {
        this.startYear = startYear;
        this.rates = rates;
        endYear = startYear + rates.length - 1;
    }

    /**
     * Give the rate of interest for a specific year.
     * @param year the year of the requested rate  
     * @return the rate of the investment for that year
     */
    public double interestRate(int year) {
        double retVal = 0;
        if (year >= startYear && year <= endYear) {
            retVal = rates[year - startYear];
        }
        return retVal;
    }

    /**
     * Getter method for the start year of the investment
     * @return startYear
     */
    public int getStartYear() {
        return startYear;
    }

    /**
     * Getter method for the end year of the investment
     * @return endYear
     */
    public int getEndYear() {
        return endYear;
    }   
}