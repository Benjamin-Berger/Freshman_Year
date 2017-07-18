package assignment01;

public class InvestmentTester {

    public static void main(String[] args) {
        BankInvestmentOffering bankOffering1 = 
                new BankInvestmentOffering(1980, 4.7,4.8,4.9,5,5.3,
                        5.2,5.3,5.45,5.5,5.66,5.71,5.85,6,4.36,4.32,4,4.12,4);
        MyInvestment invest1 = new MyInvestment(bankOffering1, 10000);
        System.out.println("1977: " + invest1.getValue(1977));
        System.out.println("1980: " + invest1.getValue(1980));
        System.out.println("1981: " + invest1.getValue(1981));
        System.out.println("1990: " + invest1.getValue(1990));
        System.out.println("1996: " + invest1.getValue(1996));
        System.out.println("1997: " + invest1.getValue(1997));
        System.out.println("1998: " + invest1.getValue(1998));
        System.out.println("1999: " + invest1.getValue(1999));
        System.out.println("2000: " + invest1.getValue(2000));
        System.out.println("2001: " + invest1.getValue(2001));
        System.out.println("");
        
        
        BankInvestmentOffering bankOffering2 = 
            new BankInvestmentOffering(1850,0.5,0.1,0.4,0.8,0.1,1.1,1.7,0.8);
         MyInvestment invest2 = new MyInvestment(bankOffering2, 150);
         System.out.println("1849: " + invest2.getValue(1849));
         System.out.println("1850: " + invest2.getValue(1850));
         System.out.println("1851: " + invest2.getValue(1851));
         System.out.println("1852: " + invest2.getValue(1852));
         System.out.println("1855: " + invest2.getValue(1855));
         System.out.println("1856: " + invest2.getValue(1856));
         System.out.println("1857: " + invest2.getValue(1857));


    }

}