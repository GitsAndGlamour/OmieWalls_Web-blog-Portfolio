import java.util.*;
public class AccountsDriver {
	//3 constants used to indicate account type:
	public static final int CHECKING = 1;
	public static final int SAVINGS = 2;
	public static final int SUPER_SAVER = 3;

	public static void main(String[] args) {
		/* main Instructions:
			Instantiates ArrayList of BankAccount OBJECTS
			*Calls getMenuChoice(Scanner) until quit
			*Calls appropriate AccountDriver methods until quit
			*Gathers necessary input
			*Generates output indicating whether the selected output was successful
			*Ensures initial balances are appropriate
		*/
		ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
		BankAccount removedAccount;
		Scanner stdIn = new Scanner(System.in);
		
		int accountType, accountNum = 0, choice;
		double balance, amount, interestRate;
		boolean validAccountType, validBalance, deposited, withdrawn, updated;
		do {
		choice = getMenuChoice(stdIn);
			switch(choice) {
				case 1:  
					//Add Account
					accountType = getAccountType(stdIn);
					validAccountType = accountType >= 1 && accountType <= 3;

					if(validAccountType) {
						System.out.print("Enter initial balance: ");
						balance = stdIn.nextDouble();
						
						validBalance = balance < 0 || (accountType > 1 && balance < 100);
							
							if(validBalance)
								System.out.println("Account could not be created.\n");
							else {
								accountNum = addBankAccount(bankAccounts,balance,accountType);
								System.out.printf("Account %d has been added.\n\n",accountNum);
							}
					}
					break;
				
				case 2: 
					//Remove Account
					System.out.print("Enter the account number to remove: ");
					accountNum = stdIn.nextInt();
					
					removedAccount = removeBankAccount(bankAccounts, accountNum);
					
					if(removedAccount !=null)
						System.out.printf("Account %d removed.\n\n", removedAccount.accountNum);
					else
						System.out.println("Account not found.\n");
					
					break;
				case 3: 
					//Account Deposit
					System.out.print("Enter account number: ");
					accountNum = stdIn.nextInt();
					
					System.out.print("Enter an amount: ");
					amount = stdIn.nextDouble();
					
					deposited = accountDeposit(bankAccounts, accountNum, amount);
					
					if(deposited)
						System.out.printf("Deposit made to account %d.\n\n",accountNum);
					else
						System.out.println("Deposit unsuccessful.\n");
					break;
				
				case 4: 
					//Account Withdrawal
					System.out.print("Enter account number: ");
					accountNum = stdIn.nextInt();
					
					System.out.print("Enter withdrawal amount: ");
					amount = stdIn.nextDouble();
					
					withdrawn = accountWithdrawal(bankAccounts, accountNum, amount);
					
					if(withdrawn)
						System.out.printf("Withdraw made from account %d.\n\n", accountNum);
					else
						System.out.println("Withdraw unsuccessful.\n");
					break;			
				case 5: 
					//Update Account Interest
					String accountTypeString = null;
					
					accountType = getAccountType(stdIn);
			
					validAccountType = accountType >= 1 && accountType <= 3;
					
					switch(accountType) {
					case 1:
						accountTypeString = "Checking";
						break;
					case 2:
						accountTypeString = "Savings";
						break;
					case 3:
						accountTypeString = "Super Saver";
						break;
					}

					if(validAccountType) {
						System.out.print("Enter new account interest as a percentage [%d - %d]: ");
						interestRate = stdIn.nextDouble();
						
						updated = updateAccountInterest(interestRate, accountType);
						
							if(updated) {
								System.out.printf("Updates to all %s accounts were successful.\n\n", accountTypeString);
							}
							else
								System.out.println("Account interest could not be updated.\n");
					break;
					}
				case 6: 
					//Add Monthly Interest
					addMonthlyInterest(bankAccounts);
					System.out.println("Monthly interest added.\n");
					break;
				
				case 7: 
					System.out.println("\nAccount Balances:\n");
					if(accountNum==0)
						System.out.printf("There are %d accounts to be displayed.\n\n",accountNum);
					printAllAccounts(bankAccounts);
					//Print All Accounts
					break;
				
				case 8: 
					System.out.print("Accounting Session has ended.");
					//Quit
					break;	
			}
		}
		while(choice!=8 && (choice < 9 && choice > 0)); 
		stdIn.close();
	}
	public static int getAccountType(Scanner stdIn) {
		/* getAccountType Instructions:
			*Prompts and obtains valid account type from User
			***Called from Main(args) method ONLY! (Component CLass of Main(args)) ***
			*Does not determine account type from account number when operations are performed
		*/
		int accountType;
		
		System.out.print("Enter account type: (1. Checking, 2. Savings, 3. Super Saver): ");
		accountType = stdIn.nextInt();
		
		if(accountType >= 1 && accountType <=3)
			return accountType;
		else
			return 0;
	}
	public static int getMenuChoice(Scanner stdIn) {
		/* getMenuChoice Instructions:
			*Displays and prompts for a valid User response
		*/
		int choice;
		System.out.println("WELCOME TO ACCOUNT MANAGER"
				+ "\n========================== "
				+ "\n------------------------------------"
				+ "\n1. Add Account"
				+ "\n2. Remove Account"
				+ "\n3. Account Deposit"
				+ "\n4. Account Withdrawal"
				+ "\n5. Update Account Interest"
				+ "\n6. Add Monthly Interest"
				+ "\n7. Print All Accounts"
				+ "\n8. Quit"
				+ "\n------------------------------------");
		
		System.out.print("Choose an option: ");
		choice = stdIn.nextInt();
		
		return choice;
	}
	public static int addBankAccount(ArrayList<BankAccount> bankAccounts, double balance, int accountType) {
		/* addBankAccount Instructions:
			*Creates the appropriate account(according to the accountType)
			*Returns created account's accountNum
		*/
		int accountNum = BankAccount.nextAccountNum;
		
		switch(accountType) {
			case CHECKING: {
				CheckingAccount checking = new CheckingAccount(balance);
				bankAccounts.add(checking);
				accountNum = checking.getAccountNum();
				break;
			}
			case SAVINGS: {
				SavingsAccount savings = new SavingsAccount(balance);
				bankAccounts.add(savings);
				accountNum = savings.getAccountNum();
				break;
			}
			case SUPER_SAVER: {
				SuperSaverAccount superSaver = new SuperSaverAccount(balance);
				bankAccounts.add(superSaver);
				accountNum = superSaver.getAccountNum();
				break;
			}
		}
		return accountNum;
	}
	public static BankAccount removeBankAccount(ArrayList<BankAccount> bankAccounts, int accountNum) {
		/* removeBankAccount Instructions:
			*Remove and returns indicated account
			*If account cannot be removed, returns null
		*/
		for(int i = 0; i < bankAccounts.size(); i++) {
			if(bankAccounts.get(i).equals(accountNum)) {
				
				BankAccount removedAccount = bankAccounts.remove(i);
				
				return removedAccount;
			}
		}
		return null;
	}
	public static boolean accountDeposit(ArrayList<BankAccount> bankAccounts, int accountNum, double amount) {
		/* accountDeposit Instructions:
			*Deposits the indicated amount to the indicated account
			*Returns true if successful
		*/
		for(int i = 0; i < bankAccounts.size(); i++) {
			if(bankAccounts.get(i).equals(accountNum)) {
				return bankAccounts.get(i).deposit(amount);
			}
		}
		return false;
	}
	public static boolean accountWithdrawal(ArrayList<BankAccount> bankAccounts, int accountNum, double amount) {
		/* accountWithdrawal Instructions:
			*Withdraws the indicated amount from the indicated account.
			*Returns true if successful
		*/
		for(int i = 0; i < bankAccounts.size(); i++) {
			if(bankAccounts.get(i).equals(accountNum)) {
				return bankAccounts.get(i).withdraw(amount);
			}
		}
		return false;
	}
	public static boolean updateAccountInterest(double interestRate, int accountType) {
		/* updateAccountInterest Instructions:
			*Updates the appropriate account type's monthy interest rate with the indicated value
			*Returns true if successful
		*/
		switch(accountType) {
			case CHECKING: {
				return CheckingAccount.setMonthlyInterestRate(interestRate);
			}
			case SAVINGS: {
				return SavingsAccount.setMonthlyInterestRate(interestRate);
			}
			case SUPER_SAVER: {
				return SuperSaverAccount.setMonthlyInterestRate(interestRate);	
			}
		}
		return false;
	}
	public static void addMonthlyInterest(ArrayList<BankAccount> bankAccounts) {
		/* addMonthlyInterest Instructions:
			*Adds Interest to all accounts (calls endMonth)
		*/
		for(int i = 0; i < bankAccounts.size(); i++) {
			bankAccounts.get(i).endMonth();
		}
		
	}
	public static void printAllAccounts(ArrayList<BankAccount> bankAccounts) {
		/* printAllAccounts Instructions:
			*Prints account info for all accounts (calls toString)
		*/
		for(int i = 0; i < bankAccounts.size(); i ++) {
			System.out.println(bankAccounts.get(i).toString());
		}
	}
}