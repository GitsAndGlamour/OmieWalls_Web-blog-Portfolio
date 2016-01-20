import java.text.NumberFormat;

public class CheckingAccount extends BankAccount {
		/* CheckingAccount Instructions:
	 * monthlyInterestRate variable stores the monthly interest rate (as a %) for all CheckingAccounts
	 * Constructor assigns its parameter value to the balance variable 
	 * (and?)
	 */
	private static double monthlyInterestRate = 2.0;
	
	public CheckingAccount(double balance) {
		super(balance);
	}
	@Override
	public void endMonth() {
	//Adds interest to the account balance		
		this.balance += balance * .01 * monthlyInterestRate;
	}
	public static boolean setMonthlyInterestRate(double mir) {
	//Updates the monthlyInterestRate class variable only if the parameter value is in the acceptable range
		if(mir >= 1.0 && mir <= 4.0){
			monthlyInterestRate = mir;
			return true;
			}
		else
			return false;
	}
	public double getMonthlyInterestRate() {
		return monthlyInterestRate;
	}
	@Override
	public String toString() {
			/* toString Instructions:
		 *String representation: (using NumberFormat.getCurrencyInstance().format(<double>) to format the balance in dollars):
		*“Checking account 1 balance: $100.00”!
		*/
		String checkingString = "Checking account " + this.accountNum + " balance: " +  NumberFormat.getCurrencyInstance().format(balance);
		return checkingString;
	}
}