import java.text.NumberFormat;

public class SuperSaverAccount extends SavingsAccount {
		/* SuperSaverAccount Instructions:
	 * The SUPER_MONTHLY_INTEREST_RATE class constant stores the SuperSaverAccount interest rate of 10%. 
	 * SuperSaverAccount constructor assigns its parameter value to the balance instance variable (and?). The endMonth method adds interest using
	 * SUPER_MONTHLY_INTEREST_RATE if no withdrawals have been made during the month,
	 * otherwise it adds interest using the current SavingsAccount monthly interest rate. 
	 */
	private static final double SUPER_MONTHLY_INTEREST_RATE = 10.0;
	
	public SuperSaverAccount(double balance) {
		super(balance);
	}
	@Override
	public void endMonth() {
			if(numWithdrawalsInMonth ==0) {
				this.balance += balance * .01 * SUPER_MONTHLY_INTEREST_RATE;
			}
			else if(setMonthlyInterestRate(monthlyInterestRate)) {
				this.balance += balance * .01 * monthlyInterestRate;
			}
			numWithdrawalsInMonth = 0;
			}
	@Override
	public String toString() {
			/* toString Instructions: 
		 *Returns a string representation in the following format:
		 *(using NumberFormat.getCurrencyInstance().format(<double>)
		 *to format the balance in dollars):“Super saver account 1 balance: $100.00”
		 */String superSaverString = "Super saver account " + this.accountNum + " balance: " +  NumberFormat.getCurrencyInstance().format(balance);
			return superSaverString;
	}
}