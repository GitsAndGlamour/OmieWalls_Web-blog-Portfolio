public abstract class BankAccount {
		/*BankAccount Variable Instructions: 
	accountNum is an inheritance variable(at the top of the inheritance hierarchy)
	*No two accounts share the same account number
	*The Construct assigns the parameter value to the balance instance variable
	*The Construct updates all account number-related variables
	*/
	protected static int nextAccountNum = 1;
	protected int accountNum = nextAccountNum++;
	protected double balance;
	
	public BankAccount(double balance) {
		this.balance = balance;
	}
	public final double getBalance() {
	//No need to override in a subclass
		return this.balance;
	}
	public final int getAccountNum() {
	//No need to override in a subclass
		return this.accountNum;
	}
	public boolean deposit(double amount) {
		/* deposit Instructions:
	*Add its parameter value to the balance
	*Parameter value has to be > 0 (returns true)
	*Otherwise returns false
	*/
		if(amount > 0) {
			balance += amount;
			return true;
		}
		else
			return false;
	}
	public boolean withdraw(double amount) {
		/* withdraw Instructions:
	*Subtract its parameter value from the balance
	*Parameter value has to be > 0 && <= balance (returns true)
	*Otherwise returns false
	*/	
		if(amount > 0 && amount <= balance) {
			balance -= amount;
			return true;
		}
		else
			return false;
	}
	public abstract void endMonth();
	// N/a
	public abstract String toString();
	// N/a
	public  boolean equals(Object other) {
		/* equals Instructions:	
	*Returns true only if the accountNum values of the calling instance and the parameter are the same
	*Otherwise returns false
	*/
	 if (other.equals(this.getAccountNum())) {
		 return true;
	 }
	 else
		 return false;
	}	
}