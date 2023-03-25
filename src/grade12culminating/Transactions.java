/** 
* Project: Grade12Culminating
* Programmer: Taha Hashim 
* Date: January 21, 2022
* Program: Transactions.java 
* Description: Taha Hashim's final culminating project
*/ 
package grade12culminating;

public class Transactions 
{
    //creates the fields 
    private double totalBalance;
    private double chequingBalance;
    private double savingsBalance;
    private double creditCardBalance;
 
    //creates a no-arg constructor for the default values
    Transactions()
    {
        chequingBalance = 0.00;
        savingsBalance = 0.00;
        creditCardBalance = 0.00;
    }
    
    //creates arg constructor that initializes data in fields of Transactions object
    Transactions(double c, double s, double cc)
    {
        chequingBalance = c;
        savingsBalance = s;
        creditCardBalance = cc;
    }

    /**
     * setChequingBalance
     * Assigns chequing balance to the Transactions object
     * @param c - chequing balance
     */
    public void setChequingBalance(double c)
    {
        chequingBalance = c;
    }
    
    /**
     * setSavingsBalance
     * Assigns savings balance to the Transactions object
     * @param s - savings balance
     */
    public void setSavingsBalance(double s)
    {
        savingsBalance = s;
    }
    
    /**
     * setCreditCardBalance
     * Assigns credit card balance to the Transactions object
     * @param cc 
     */
    public void setCreditCardBalance(double cc)
    {
        creditCardBalance = cc;
    }
    
    /**
     * getChequingBalance
     * Obtains the chequing balance
     * @return chequingBalance - the chequing balance
     */
    public double getChequingBalance()
    {
        return chequingBalance;
    }
    
    /**
     * getSavingsBalance
     * Obtains the savings balance
     * @return savingsBalance - the savings balance
     */
    public double getSavingsBalance()
    {
        return savingsBalance;
    }
    
    /**
     * getCreditCardBalance
     * Obtains the credit card balance
     * @return creditCardBalance - the credit card balance
     */
    public double getCreditCardBalance()
    {
        return creditCardBalance;
    }
    
    /**
     * chequingDeposit
     * Takes a double variable and adds it to the chequingBalance field
     * @param c - deposit amount
     */
    public void chequingDeposit(double c)
    {
        chequingBalance = chequingBalance + c;
    }
    
    /**
     * chequingWithdraw
     * Takes a double variable and subtracts it from the chequingBalance field
     * @param c - withdraw amount
     */
    public void chequingWithdraw(double c)
    {
        chequingBalance = chequingBalance - c;
    }
    
    /**
     * savingsDeposit
     * Takes a double variable and adds it to the savingsBalance field
     * @param s - deposit amount
     */
    public void savingsDeposit(double s)
    {
        savingsBalance = savingsBalance + s;
    }
    
    /**
     * savingsWithdraw
     * Takes a double variable and subtracts it from the savingsBalance fuekd
     * @param s - withdraw amount
     */
    public void savingsWithdraw(double s)
    {
        savingsBalance = savingsBalance - s;
    }
    
    /**
     * creditCardWithdraw
     * Takes a double variable and subtracts it from the creditCardBalance field
     * @param cc 
     */
    public void creditCardWithdraw(double cc)
    {
        creditCardBalance = creditCardBalance - cc;
    }
    
    /**
     * totalBalance
     * Calculates the total balance
     * @return totalBalance - the total balance
     */
    public double totalBalance()
    {
        totalBalance = chequingBalance + savingsBalance + creditCardBalance;
        return totalBalance;
    }
}//end of class
