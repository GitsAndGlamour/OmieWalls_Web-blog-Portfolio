import java.text.NumberFormat;
public class SavingsAccount extends BankAccount {
		/* SavingsAccount Instructions:
	 *monthlyInterestRate class variable stores current monthly interest rate (%) for all SavingsAccounts
	 *numWithdrawalsInMonth instance variable stores number of withdrawals that occured during the current month
	 *Constructor assigns its parameter value to the balance instance variable
	 *(and?)
	 */
	protected static double monthlyInterestRate = 6.0;
	protected int numWithdrawalsInMonth = 0;
	
	public SavingsAccount(double balance) {
		super(balance);
	}
	public boolean withdraw(double amount) {
			/*withdraw(double) subtracts its parameter value from the account balance
		 *Only if parameter value > 0 
		 *(and?)
		 */
		if(numWithdrawalsInMonth < 4) {
			if(amount > 0 && balance - amount >= 100) {
					balance -= amount;
					++numWithdrawalsInMonth;
					return true;
			}
		}
		return false;
	}
	@Override
	public void endMonth() {
		//endMonth() adds the interest to the monthlyInterestRate class variable only if parameter value is in acceptable range
		if(setMonthlyInterestRate(monthlyInterestRate)) {
			this.balance += balance * .01 * monthlyInterestRate;
			numWithdrawalsInMonth = 0;
		}
	}
	public static boolean setMonthlyInterestRate(double mir) {
		if(mir >= 5.0 && mir <= 9.0){
			monthlyInterestRate = mir;
			return true;
		}
		else
			return false;
	}
	@Override
	public String toString() {
		NumberFormat.getCurrencyInstance();
			/* toString Instructions: 
		 *  *toString() returns string representation: (using NumberFormat.getCurrencyInstance().getCurrencyInstance().format(<double>) to format the balance in dollars):!
		 *“Savings account 1 balance: $100.00”
		 */
		String savingsString = "Savings account " + this.accountNum + " balance: " +  NumberFormat.getCurrencyInstance().format(balance);
		return savingsString;
	}

	
}