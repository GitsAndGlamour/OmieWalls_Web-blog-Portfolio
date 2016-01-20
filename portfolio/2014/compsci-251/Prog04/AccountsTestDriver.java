

import java.text.NumberFormat;
import java.util.ArrayList;


public class AccountsTestDriver {

	private static boolean passedAllTests = true;
	private static final int CHECKING = 1;
	private static final int SAVINGS = 2;
	private static final int SUPER_SAVER = 3;
	
	public static void main(String[] args) {
		// BANK ACCOUNT TESTS //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if(!testBankAccountConstructor()) {
			passedAllTests = false;
			System.out.println("\nBankAccount's constructor and/or getAccountNum() and/or getBalance() is/are broken\n");
		} else {
			System.out.println("BankAccount's constructor, getAccountNum() and getBalance() look good...");
		}
		
		if(!testBankAccountDeposit()) {
			passedAllTests = false;
			System.out.println("\nBankAccount's deposit() is broken\n");
		} else {
			System.out.println("BankAccount's deposit() looks good...");
		}
		
		if(!testBankAccountWithdrawal()) {
			passedAllTests = false;
			System.out.println("\nBankAccount's withrdrawl() is broken\n");
		} else {
			System.out.println("BankAccount's withdrawal() looks good...");
		}
		
		if(!testBankAccountEquals()) {
			passedAllTests = false;
			System.out.println("\nBankAccount's equals() is broken\n");
		} else {
			System.out.println("BankAccount's equals() looks good...");
		}
		
		// CHECKING TESTS //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if(!testCheckingAccountConstructor()) {
			passedAllTests = false;
			System.out.println("\nCheckingAccount's constructor and/or getAccountNum() and/or getBalance() is/are broken\n");
		} else {
			System.out.println("CheckingAccount's constructor, getAccountNum() and getBalance() look good...");
		}
		
		if(!testCheckingAccountDeposit()) {
			passedAllTests = false;
			System.out.println("\nCheckingAccount's deposit() is broken\n");
		} else {
			System.out.println("CheckingAccount's deposit() looks good...");
		}
		
		if(!testCheckingAccountWithdraw()) {
			passedAllTests = false;
			System.out.println("\nCheckingAccount's withdraw() is broken\n");
		} else {
			System.out.println("CheckingAccount's withdraw() looks good...");
		}
		
		if(!testCheckingAccountMonthlyInterestRate()) {
			passedAllTests = false;
			System.out.println("\nCheckingAccount's setMonthlyInterestRate() and/or endMonth() is/are broken\n");
		} else {
			System.out.println("CheckingAccount's setMonthlyInterestRate() and endMonth() look good...");
		}
		
		if(!testCheckingAccountToString()) {
			passedAllTests = false;
			System.out.println("\nCheckingAccount's toString() method is broken (or its method signature is incorrect)\n");
		} else {
			System.out.println("CheckingAccount's toString() method looks good...");
		}
		
		if(!testCheckingAccountEquals()) {
			passedAllTests = false;
			System.out.println("\nCheckingAccount's equals() method is broken (or its method signature is incorrect)\n");
		} else {
			System.out.println("CheckingAccount's equals() method looks good...");
		}
		
		// SAVINGS TESTS //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if(!testSavingsAccountConstructor()) {
			passedAllTests = false;
			System.out.println("\nSavingsAccount's constructor and/or getAccountNum() and/or getBalance() is/are broken\n");
		} else {
			System.out.println("SavingsAccount's constructor, getAccountNum() and getBalance() look good...");
		}
		
		if(!testSavingsAccountDeposit()) {
			passedAllTests = false;
			System.out.println("\nSavingsAccount's deposit() is broken\n");
		} else {
			System.out.println("SavingsAccount's deposit() looks good...");
		}
		
		if(!testSavingsAccountWithdraw()) {
			passedAllTests = false;
			System.out.println("\nSavingsAccount's withdraw() is broken\n");
		} else {
			System.out.println("SavingsAccount's withdraw() looks good...");
		}
		
		if(!testSavingsAccountMonthlyInterestRate()) {
			passedAllTests = false;
			System.out.println("\nSavingsAccount's setMonthlyInterestRate() and/or endMonth() is/are broken\n");
		} else {
			System.out.println("SavingsAccount's setMonthlyInterestRate() and endMonth() look good...");
		}
		
		if(!testSavingsAccountToString()) {
			passedAllTests = false;
			System.out.println("\nSavingsAccount's toString() method is broken (or its method signature is incorrect. only works if no previous tests have failed.)\n");
		} else {
			System.out.println("SavingsAccount's toString() method looks good...");
		}
		
		if(!testSavingsAccountEquals()) {
			passedAllTests = false;
			System.out.println("\nSavingsAccount's equals() method is broken (or its method signature is incorrect. only works if no previous tests have failed.)\n");
		} else {
			System.out.println("SavingsAccount's equals() method looks good...");
		}
		
		// SUPER SAVER TESTS //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if(!testSuperSaverConstructor()) {
			passedAllTests = false;
			System.out.println("\nSuperSaver's constructor and/or getAccountNum() and/or getBalance() is/are broken\n");
		} else {
			System.out.println("SuperSaver's constructor, getAccountNum() and getBalance() look good...");
		}
		
		if(!testSuperSaverDeposit()) {
			passedAllTests = false;
			System.out.println("\nSuperSaver's deposit() is broken\n");
		} else {
			System.out.println("SuperSaver's deposit() looks good...");
		}
		
		if(!testSuperSaverWithdraw()) {
			passedAllTests = false;
			System.out.println("\nSuperSaver's withdraw() is broken\n");
		} else {
			System.out.println("SuperSaver's withdraw() looks good...");
		}
		
		if(!testSuperSaverMonthlyInterestRate()) {
			passedAllTests = false;
			System.out.println("\nSuperSaver's setMonthlyInterestRate() and/or endMonth() is/are broken\n");
		} else {
			System.out.println("SuperSaver's setMonthlyInterestRate() and endMonth() look good...");
		}
		
		if(!testSuperSaverToString()) {
			passedAllTests = false;
			System.out.println("\nSuperSaver's toString() method is broken (or its method signature is incorrect. only works if no previous tests have failed.)\n");
		} else {
			System.out.println("SuperSaver's toString() method looks good...");
		}
		
		if(!testSuperSaverEquals()) {
			passedAllTests = false;
			System.out.println("\nSuperSaver's equals() method is broken (or its method signature is incorrect. only works if no previous tests have failed.)\n");
		} else {
			System.out.println("SuperSaver's equals() method looks good...");
		}
		
		// DRIVER TESTS ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if(!testAddBankAccount()) {
			passedAllTests = false;
			System.out.println("\nAccountsDriver's addBankAccount method is broken\n");
		} else {
			System.out.println("AccountsDriver's addBankAccount method looks good...");
		}
		
		if(!testRemoveBankAccount()) {
			passedAllTests = false;
			System.out.println("\nAccountsDriver's removeBankAccount method is broken\n");
		} else {
			System.out.println("AccountsDriver's removeBankAccount method looks good...");
		}
		
		if(!testAccountDeposit()) {
			passedAllTests = false;
			System.out.println("\nAccounstDriver's accountDeposit method is broken\n");
		} else {
			System.out.println("AccountsDriver's accountDeposit method looks good...");
		}
		
		if(!testAccountWithdrawal()) {
			passedAllTests = false;
			System.out.println("\nAccountsDriver's accountWithdrawal method is broken\n");
		} else {
			System.out.println("AccountsDriver's accountWithdrawal method looks good...");
		}
		
		if(!testUpdateBankAccountInterest()) {
			passedAllTests = false;
			System.out.println("\nAccountsDriver's updateAccountInterest method is broken\n");
		} else {
			System.out.println("AccountsDriver's updateAccountInterest method looks good...");
		}
		
		if(!testAddMonthlyInterest()) {
			passedAllTests = false;
			System.out.println("\nAccountsDriver's addMonthlyInterest method is broken (or testAccountWithdrawal is broken)\n");
		} else {
			System.out.println("AccountsDriver's addMonthlyInterest method looks good...");
		}
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if(passedAllTests) {
			System.out.println("You passed all tests!");
		} else {
			System.out.println("You failed one or more tests.");
		}
	}
	
	// BANKACCOUNT TESTS //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static boolean testBankAccountConstructor() {
		try {
			int cab = (int)(Math.random()*100);
			int sab = (int)(Math.random()*100) + 100;
			int ssab = (int)(Math.random()*100) + 200;
			
			BankAccount ca = new CheckingAccount(cab);
			BankAccount sa = new SavingsAccount(sab);
			BankAccount ssa = new SuperSaverAccount(ssab);
			
			if(ca.getAccountNum() != 1) {
				return false;
			}
			if(ca.getBalance() != cab) {
				return false;
			}
			if(sa.getAccountNum() != 2) {
				return false;
			}
			if(sa.getBalance() != sab) {
				return false;
			}
			if(ssa.getAccountNum() != 3) {
				return false;
			}
			if(ssa.getBalance() != ssab) {
				return false;
			}
			
		} catch(Exception e) {
			System.out.println("An exception was thrown in testBankAccountConstructor");
			return false;
		}
		return true;
	}
	
	public static boolean testBankAccountDeposit() {
		try {
			int cab = (int)(Math.random()*100);
			int sab = (int)(Math.random()*100) + 100;
			int ssab = (int)(Math.random()*100) + 200;
			int r = (int)(Math.random()*100) + 100;
			
			BankAccount ca = new CheckingAccount(cab);
			BankAccount sa = new SavingsAccount(sab);
			BankAccount ssa = new SuperSaverAccount(ssab);
			
			if(ca.deposit(0)) {
				return false;
			}
			if(ca.deposit(-1)) {
				return false;
			}
			if(!ca.deposit(r)) {
				return false;
			}
			if(ca.getBalance() != cab + r) {
				return false;
			}
			
			if(sa.deposit(0)) {
				return false;
			}
			if(sa.deposit(-1)) {
				return false;
			}
			if(!sa.deposit(r)) {
				return false;
			}
			if(sa.getBalance() != sab + r) {
				return false;
			}
			
			if(ssa.deposit(0)) {
				return false;
			}
			if(ssa.deposit(-1)) {
				return false;
			}
			if(!ssa.deposit(r)) {
				return false;
			}
			if(ssa.getBalance() != ssab + r) {
				return false;
			}
			
		} catch(Exception e) {
			System.out.println("An exception was thrown in testBankAccountDeposit");
			return false;
		}
		return true;
	}
	
	public static boolean testBankAccountWithdrawal() {
		try {
			int cab = (int)(Math.random()*100) + 2;
			int sab = (int)(Math.random()*100) + 102;
			int ssab = (int)(Math.random()*100) + 202;
			
			BankAccount ca = new CheckingAccount(cab);
			BankAccount sa = new SavingsAccount(sab);
			BankAccount ssa = new SuperSaverAccount(ssab);
			
			if(ca.withdraw(0)) {
				return false;
			}
			if(ca.withdraw(-1)) {
				return false;
			}
			if(!ca.withdraw(1)) {
				return false;
			}
			if(!ca.withdraw(cab-1)) {
				return false;
			}
			if(ca.getBalance() != 0) {
				return false;
			}
			
			if(sa.withdraw(0)) {
				return false;
			}
			if(sa.withdraw(-1)) {
				return false;
			}
			if(!sa.withdraw(1)) {
				return false;
			}
			if(!sa.withdraw(sab-101)) {
				return false;
			}
			if(sa.getBalance() != 100) {
				return false;
			}
			
			if(ssa.withdraw(0)) {
				return false;
			}
			if(ssa.withdraw(-1)) {
				return false;
			}
			if(!ssa.withdraw(1)) {
				return false;
			}
			if(!ssa.withdraw(ssab-101)) {
				return false;
			}
			if(ssa.getBalance() != 100) {
				return false;
			}
			
		} catch(Exception e) {
			System.out.println("An exception was thrown in testBankAccountWithdrawal");
			return false;
		}
		return true;
	}
	
	public static boolean testBankAccountEquals() {
		try {
			int cab = (int)(Math.random()*100);
			int sab = (int)(Math.random()*100) + 100;
			int ssab = (int)(Math.random()*100) + 200;
			
			BankAccount ca = new CheckingAccount(cab);
			BankAccount sa = new SavingsAccount(sab);
			BankAccount ssa = new SuperSaverAccount(ssab);
			
			BankAccount ca2 = new CheckingAccount(cab);
			BankAccount sa2 = new SavingsAccount(sab);
			BankAccount ssa2 = new SuperSaverAccount(ssab);
			
			if(!ca.equals(ca)) {
				return false;
			}
			if(!sa.equals(sa)) {
				return false;
			}
			if(!ssa.equals(ssa)) {
				return false;
			}
			
			if(ca.equals(ca2)) {
				return false;
			}
			if(ca2.equals(ca)) {
				return false;
			}
			if(sa.equals(sa2)) {
				return false;
			}
			if(sa2.equals(sa)) {
				return false;
			}
			if(ssa.equals(ssa2)) {
				return false;
			}
			if(ssa2.equals(ssa)) {
				return false;
			}
		} catch(Exception e) {
			System.out.println("An exception was thrown in testBankAccountEquals");
			return false;
		}
		return true;
	}
	
	// CHECKING TESTS //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static boolean testCheckingAccountConstructor() {
		int initialAccountNum = 0;
		
		try {
			BankAccount ba = (BankAccount)new CheckingAccount(0);
			initialAccountNum = ba.getAccountNum();
		} catch(ClassCastException e) {
			System.out.println("Looks like your inheritance hierarchy wasn't setup correctly.");
			return false;
		}
		try {
			CheckingAccount ca;
			double balance;
			for(int i=1; i<=101; i++) {
				balance = Math.random() * 100;
				ca = new CheckingAccount(balance);
				if(ca.getAccountNum() != i+initialAccountNum) {
					return false;
				}
				if(ca.getBalance() != balance) {
					return false;
				}
			}
			
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testCheckingAccountConstructor");
			return false;
		}
	}
	
	public static boolean testCheckingAccountDeposit() {
		try {
			CheckingAccount ca = new CheckingAccount(100);
			double balance;
			double amount;
			
			if(ca.deposit(0)) {
				return false;
			} else if(ca.deposit(-1)) {
				return false;
			} else if(ca.getBalance() == 99) {
				return false;
			}
			
			for(int i=1; i<=100; i++) {
				balance = Math.random() * 100;
				amount = Math.random() * 10;
				ca = new CheckingAccount(balance);
				if(!ca.deposit(amount)) {
					return false;
				}
				if(ca.getBalance() != balance + amount) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testCheckingAccountDeposit");
			return false;
		}
	}
	
	public static boolean testCheckingAccountWithdraw() {
		try {
			CheckingAccount ca = new CheckingAccount(100);
			double balance;
			double amount;
			
			if(ca.withdraw(0)) {
				return false;
			} else if(ca.withdraw(101)) {
				return false;
			} else if(ca.getBalance() == -1) {
				return false;
			}
			
			for(int i=1; i<=100; i++) {
				balance = Math.random() * 100;
				amount = balance * .1;
				ca = new CheckingAccount(balance);
				if(!ca.withdraw(amount)) {
					return false;
				}
				if(ca.getBalance() != balance - amount) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testCheckingAccountWithdraw");
			return false;
		}
	}
	
	public static boolean testCheckingAccountMonthlyInterestRate() {
		try {
			CheckingAccount ca = new CheckingAccount(100);
			double balance;
			double interestRate;
			
			ca.endMonth();
			if(ca.getBalance() != 102) {
				System.out.println("Looks like you didn't initialize your monthly interest rate correctly.");
				return false;
			}
			
			for(int i=-10; i<1; i++) {
				ca = new CheckingAccount(100);
				if(CheckingAccount.setMonthlyInterestRate(i)) {
					return false;
				}
				ca.endMonth();
				if(ca.getBalance() != 102) {
					return false;
				}
			}
			
			for(int i=15; i>4; i--) {
				ca = new CheckingAccount(100);
				if(CheckingAccount.setMonthlyInterestRate(i)) {
					return false;
				}
				ca.endMonth();
				if(ca.getBalance() != 102) {
					return false;
				}
			}
			
			for(int i=1; i<=4; i++) {
				ca = new CheckingAccount(100);
				if(!CheckingAccount.setMonthlyInterestRate(i)) {
					return false;
				}
				ca.endMonth();
				if(ca.getBalance() != 100+i) {
					return false;
				}
			}
			
			for(int i=1; i<=100; i++) {
				balance = Math.random() * 100;
				interestRate = Math.random() * 3 + 1;
				ca = new CheckingAccount(balance);
				if(!CheckingAccount.setMonthlyInterestRate(interestRate)) {
					return false;
				}
				ca.endMonth();
				if(ca.getBalance() != (balance + balance * .01 *  interestRate)) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testMonthlyInterestRate");
			return false;
		}
	}
	
	public static boolean testCheckingAccountToString() {
		try {
			CheckingAccount ca;
			double balance;
			for(int i=0; i<=100; i++) {
				balance = Math.random() * 100;
				ca = new CheckingAccount(balance);
				if(!ca.toString().equals("Checking account " + ca.getAccountNum() + " balance: " + NumberFormat.getCurrencyInstance().format(balance))) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testCheckingAccountToString");
			return false;
		}
	}
	
	public static boolean testCheckingAccountEquals() {
		try {
			CheckingAccount ca;
			CheckingAccount ca2;
			double balance = Math.random() * 100;
			
			ca = new CheckingAccount(balance);
			ca2 = new CheckingAccount(balance);
			
			if(ca.equals(ca2)) {
				return false;
			}
			if(!ca.equals(ca)) {
				return false;
			}
			if(!ca2.equals(ca2)) {
				return false;
			}
			
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testCheckingAccountEquals");
			return false;
		}
	}
	
	// SAVINGS TESTS //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static boolean testSavingsAccountConstructor() {
		try {
			BankAccount ba = (BankAccount)new SavingsAccount(0);
		} catch(ClassCastException e) {
			System.out.println("Looks like your inheritance hierarchy wasn't setup correctly.");
			return false;
		}
		try {
			SavingsAccount ca;
			double balance;
			int initialAccountNum = 0;
			for(int i=0; i<=100; i++) {
				balance = Math.random() * 100 + 100;
				ca = new SavingsAccount(balance);
				if(i==0) {
					initialAccountNum = ca.getAccountNum();
				}
				if(ca.getAccountNum() != i+initialAccountNum) {
					return false;
				}
				if(ca.getBalance() != balance) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testSavingsAccountConstructor");
			return false;
		}
	}
	
	public static boolean testSavingsAccountDeposit() {
		try {
			SavingsAccount ca = new SavingsAccount(100);
			double balance;
			double amount;
			
			if(ca.deposit(0)) {
				return false;
			} else if(ca.deposit(-1)) {
				return false;
			} else if(ca.getBalance() == 99) {
				return false;
			}
			
			for(int i=1; i<=100; i++) {
				balance = Math.random() * 100 + 100;
				amount = Math.random() * 10;
				ca = new SavingsAccount(balance);
				if(!ca.deposit(amount)) {
					return false;
				}
				if(ca.getBalance() != balance + amount) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testSavingsAccountDeposit");
			return false;
		}
	}
	
	public static boolean testSavingsAccountWithdraw() {
		try {
			SavingsAccount ca = new SavingsAccount(200);
			double balance;
			double amount;
			
			if(ca.withdraw(0)) {
				return false;
			} else if(ca.withdraw(101)) {
				return false;
			} else if(ca.getBalance() == 99) {
				return false;
			} else if(!ca.withdraw(100)) {
				return false;
			} else if(ca.getBalance() != 100) {
				return false;
			}
			
			for(int i=1; i<=100; i++) {
				balance = Math.random() * 100 + 100;
				amount = balance * .3;
				ca = new SavingsAccount(balance);
				if(balance-amount < 100 && ca.withdraw(amount)) {
					return false;
				}
				if(balance-amount >= 100) {
					if(!ca.withdraw(amount)) {
						return false;
					}
					if(ca.getBalance() != balance - amount) {
						return false;
					}
				}
			}
			
			ca = new SavingsAccount(200);
			if(!ca.withdraw(10)){
				return false;
			}
			if(!ca.withdraw(10)) {
				return false;
			}
			if(!ca.withdraw(10)) {
				return false;
			}
			if(!ca.withdraw(10)) {
				return false;
			}
			if(ca.withdraw(10)) {
				return false;
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testSavingsAccountWithdraw");
			return false;
		}
	}
	
	public static boolean testSavingsAccountMonthlyInterestRate() {
		try {
			SavingsAccount ca = new SavingsAccount(100);
			
			ca.endMonth();
			if(ca.getBalance() != 106) {
				System.out.println("Looks like monthlyInterestRate isn't initialized correctly.");
				return false;
			}
			
			for(int i=-5; i<5; i++) {
				ca = new SavingsAccount(100);
				if(SavingsAccount.setMonthlyInterestRate(i)) {
					return false;
				}
				ca.endMonth();
				if(ca.getBalance() != 106) {
					return false;
				}
			}
			
			for(int i=19; i>9; i--) {
				ca = new SavingsAccount(100);
				if(SavingsAccount.setMonthlyInterestRate(i)) {
					return false;
				}
				ca.endMonth();
				if(ca.getBalance() != 106) {
					return false;
				}
			}
			
			for(int i=5; i<=9; i++) {
				ca = new SavingsAccount(100);
				if(!SavingsAccount.setMonthlyInterestRate(i)) {
					return false;
				}
				ca.endMonth();
				if(ca.getBalance() != 100+i) {
					return false;
				}
			}
			
			ca = new SavingsAccount(200);
			ca.withdraw(10);
			ca.withdraw(10);
			ca.withdraw(10);
			ca.withdraw(10);
			ca.endMonth();
			if(!ca.withdraw(10)) {
				System.out.println("Looks like numWithdrawalsInMonth isn't being reset when it should be.");
				return false;
			}
			
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testMonthlyInterestRate");
			return false;
		}
	}
	
	public static boolean testSavingsAccountToString() {
		try {
			SavingsAccount ca;
			double balance;
			for(int i=0; i<=100; i++) {
				balance = Math.random() * 100;
				ca = new SavingsAccount(balance);
				if(!ca.toString().equals("Savings account " + ca.getAccountNum() + " balance: " + NumberFormat.getCurrencyInstance().format(balance))) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testSavingsAccountToString");
			return false;
		}
	}
	
	public static boolean testSavingsAccountEquals() {
		try {
			SavingsAccount ca;
			SavingsAccount ca2;
			double balance = Math.random() * 100;
			
			ca = new SavingsAccount(balance);
			ca2 = new SavingsAccount(balance);
			
			if(ca.equals(ca2)) {
				return false;
			}
			if(!ca.equals(ca)) {
				return false;
			}
			if(!ca2.equals(ca2)) {
				return false;
			}
			
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testSavingsAccountEquals");
			return false;
		}
	}
	
	// SUPER SAVER TESTS //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static boolean testSuperSaverConstructor() {
		try {
			SavingsAccount sa = (SavingsAccount)new SuperSaverAccount(0);
			BankAccount ba = (BankAccount)new SuperSaverAccount(0);
		} catch(ClassCastException e) {
			System.out.println("Looks like your inheritance hierarchy wasn't setup correctly.");
			return false;
		}
		try {
			SuperSaverAccount ca;
			double balance;
			int initialAccountNum = 0;
			for(int i=0; i<=50; i++) {
				balance = Math.random() * 100 + 100;
				ca = new SuperSaverAccount(balance);
				if(i==0) {
					initialAccountNum = ca.getAccountNum();
				}
				if(ca.getAccountNum() != i+initialAccountNum) {
					return false;
				}
				if(ca.getBalance() != balance) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testSuperSaverConstructor");
			return false;
		}
	}
	
	public static boolean testSuperSaverDeposit() {
		try {
			SuperSaverAccount ca = new SuperSaverAccount(100);
			double balance;
			double amount;
			
			if(ca.deposit(0)) {
				return false;
			} else if(ca.deposit(-1)) {
				return false;
			} else if(ca.getBalance() == 99) {
				return false;
			}
			
			for(int i=1; i<=100; i++) {
				balance = Math.random() * 100 + 100;
				amount = Math.random() * 10;
				ca = new SuperSaverAccount(balance);
				if(!ca.deposit(amount)) {
					return false;
				}
				if(ca.getBalance() != balance + amount) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testSuperSaverDeposit");
			return false;
		}
	}
	
	public static boolean testSuperSaverWithdraw() {
		try {
			SuperSaverAccount ca = new SuperSaverAccount(200);
			double balance;
			double amount;
			
			if(ca.withdraw(0)) {
				return false;
			} else if(ca.withdraw(101)) {
				return false;
			} else if(ca.getBalance() == 99) {
				return false;
			} else if(!ca.withdraw(100)) {
				return false;
			} else if(ca.getBalance() != 100) {
				return false;
			}
			
			for(int i=1; i<=100; i++) {
				balance = Math.random() * 100 + 100;
				amount = balance * .3;
				ca = new SuperSaverAccount(balance);
				if(balance-amount < 100 && ca.withdraw(amount)) {
					return false;
				}
				if(balance-amount >= 100) {
					if(!ca.withdraw(amount)) {
						return false;
					}
					if(ca.getBalance() != balance - amount) {
						return false;
					}
				}
			}
			
			ca = new SuperSaverAccount(200);
			if(!ca.withdraw(10)){
				return false;
			}
			if(!ca.withdraw(10)) {
				return false;
			}
			if(!ca.withdraw(10)) {
				return false;
			}
			if(!ca.withdraw(10)) {
				return false;
			}
			if(ca.withdraw(10)) {
				return false;
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testSuperSaverWithdraw");
			return false;
		}
	}
	
	public static boolean testSuperSaverMonthlyInterestRate() {
		try {
			SuperSaverAccount ca = new SuperSaverAccount(100);
			SavingsAccount.setMonthlyInterestRate(6);
			double balance;
			
			ca.endMonth();
			if(ca.getBalance() != 110) {
				System.out.println("Looks like SuperSaver's SUPER_MONTHLY_INTEREST_RATE isn't initialized correctly.");
				return false;
			}
			
			ca.withdraw(10);
			ca.endMonth();
			if(ca.getBalance() != 106) {
				return false;
			}
			
			for(int i=5; i<=9; i++) {
				ca = new SuperSaverAccount(i*100);
				ca.withdraw(100);
				balance = ca.getBalance();
				SavingsAccount.setMonthlyInterestRate(i);
				ca.endMonth();
				balance += balance * (i*.01);
				if(ca.getBalance() != balance) {
					return false;
				}
			}
			
			ca = new SuperSaverAccount(200);
			ca.withdraw(10);
			ca.withdraw(10);
			ca.withdraw(10);
			ca.withdraw(10);
			ca.endMonth();
			if(!ca.withdraw(10)) {
				System.out.println("Looks like SuperSaver's numWithdrawalsInMonth isn't being reset when it should be.");
				return false;
			}
			
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testSuperSaverMonthlyInterestRate");
			return false;
		}
	}
	
	public static boolean testSuperSaverToString() {
		try {
			SuperSaverAccount ca;
			double balance;
			for(int i=0; i<=100; i++) {
				balance = Math.random() * 100;
				ca = new SuperSaverAccount(balance);
				if(!ca.toString().equals("Super saver account " + ca.getAccountNum() + " balance: " + NumberFormat.getCurrencyInstance().format(balance))) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testSuperSaverToString");
			return false;
		}
	}
	
	public static boolean testSuperSaverEquals() {
		try {
			SuperSaverAccount ca;
			SuperSaverAccount ca2;
			double balance = Math.random() * 100;
			
			ca = new SuperSaverAccount(balance);
			ca2 = new SuperSaverAccount(balance);
			
			if(ca.equals(ca2)) {
				return false;
			}
			if(!ca.equals(ca)) {
				return false;
			}
			if(!ca2.equals(ca2)) {
				return false;
			}
			
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testSuperSaverEquals");
			return false;
		}
	}
	
	// DRIVER TESTS ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static boolean testAddBankAccount() {
		ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
		int[] accountNums = new int[9];
		
		for(int i=1; i<=9; i+=3) {
			accountNums[i-1] = AccountsDriver.addBankAccount(bankAccounts, i*100, CHECKING);
			accountNums[i] = AccountsDriver.addBankAccount(bankAccounts, (i+1)*100, SAVINGS);
			accountNums[i+1] = AccountsDriver.addBankAccount(bankAccounts, (i+2)*100, SUPER_SAVER);
		}
		if(bankAccounts.size() != 9) {
			return false;
		}
		for(int i=1; i<=9; i++) {
			if(bankAccounts.get(i-1).getAccountNum() != accountNums[i-1] || bankAccounts.get(i-1).getBalance() != i*100) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean testRemoveBankAccount() {
		ArrayList<BankAccount> bankAccounts = createBankAccounts();
		int r, accountNum;
		
		BankAccount ba = AccountsDriver.removeBankAccount(bankAccounts, (int)(Math.random() * 100) + 1000);
		if(ba != null) {
			return false;
		}
		
		for(int i=0; i<9; i++) {
			r = (int)(Math.random() * bankAccounts.size());
			accountNum = bankAccounts.get(r).getAccountNum();
			ba = AccountsDriver.removeBankAccount(bankAccounts, accountNum);
			if(bankAccounts.contains(ba)) {
				return false;
			}
			if(AccountsDriver.removeBankAccount(bankAccounts, (int)(Math.random() * 100) + 10000) != null) {
				return false;
			}
		}
		
		if(bankAccounts.size() != 0) {
			return false;
		}
		
		return true;
	}
	
	public static boolean testAccountDeposit() {
		ArrayList<BankAccount> bankAccounts = createBankAccounts();
		int r, accountNum;
		double balance;
		
		for(int i=-9; i<=0; i++) {
			r = (int)(Math.random() * bankAccounts.size());
			accountNum = bankAccounts.get(r).getAccountNum();
			balance = bankAccounts.get(r).getBalance();
			if(AccountsDriver.accountDeposit(bankAccounts, accountNum, i)) {
				return false;
			}
			if(bankAccounts.get(r).getBalance() != balance) {
				return false;
			}
		}
		
		for(int i=1; i<=9; i++) {
			r = (int)(Math.random() * bankAccounts.size());
			accountNum = bankAccounts.get(r).getAccountNum();
			balance = bankAccounts.get(r).getBalance();
			if(!AccountsDriver.accountDeposit(bankAccounts, accountNum, i)) {
				return false;
			}
			if(bankAccounts.get(r).getBalance() != balance+i) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean testAccountWithdrawal() {
		//TEST WITH CHECKING
		ArrayList<BankAccount> checkingAccounts = createCheckingAccounts();
		int accountNum;
		double balance;
		
		for(int i=-9; i<=0; i++) {
			accountNum = checkingAccounts.get(i+9).getAccountNum();
			balance = checkingAccounts.get(i+9).getBalance();
			if(AccountsDriver.accountWithdrawal(checkingAccounts, accountNum, i)) {
				return false;
			}
			if(checkingAccounts.get(i+9).getBalance() != balance) {
				return false;
			}
		}
		
		if(AccountsDriver.accountWithdrawal(checkingAccounts, checkingAccounts.get(0).getAccountNum(), 1)) {
			return false;
		}
		if(checkingAccounts.get(0).getBalance() != 0) {
			return false;
		}
		
		for(int i=1; i<10; i++) {
			accountNum = checkingAccounts.get(i).getAccountNum();
			balance = checkingAccounts.get(i).getBalance();
			if(!AccountsDriver.accountWithdrawal(checkingAccounts, accountNum, i*100)) {
				return false;
			}
			if(checkingAccounts.get(i).getBalance() != 0) {
				return false;
			}
		}
		
		//TEST WITH SAVINGS
		ArrayList<BankAccount> savingsAccounts = createSavingsAccounts();
		
		for(int i=-9; i<=0; i++) {
			accountNum = savingsAccounts.get(i+9).getAccountNum();
			balance = savingsAccounts.get(i+9).getBalance();
			if(AccountsDriver.accountWithdrawal(savingsAccounts, accountNum, i)) {
				return false;
			}
			if(savingsAccounts.get(i+9).getBalance() != balance) {
				return false;
			}
		}
		
		if(AccountsDriver.accountWithdrawal(savingsAccounts, savingsAccounts.get(0).getAccountNum(), 1)) {
			return false;
		}
		if(savingsAccounts.get(0).getBalance() != 100) {
			return false;
		}
		
		for(int i=1; i<10; i++) {
			accountNum = savingsAccounts.get(i).getAccountNum();
			balance = savingsAccounts.get(i).getBalance();
			if(!AccountsDriver.accountWithdrawal(savingsAccounts, accountNum, (i)*100)) {
				return false;
			}
			if(savingsAccounts.get(i).getBalance() != 100) {
				return false;
			}
		}
		
		savingsAccounts.add(new SavingsAccount(200));
		for(int i=0; i<4; i++) {
			if(!AccountsDriver.accountWithdrawal(savingsAccounts, savingsAccounts.get(10).getAccountNum(), 25)) {
				return false;
			}
		}
		if(AccountsDriver.accountWithdrawal(savingsAccounts, savingsAccounts.get(10).getAccountNum(), 1)) {
			return false;
		}
		if(savingsAccounts.get(10).getBalance() != 100) {
			return false;
		}
		
		//TEST WITH SUPERSAVER
		ArrayList<BankAccount> superSaverAccounts = createSuperSaverAccounts();
		
		for(int i=-9; i<=0; i++) {
			accountNum = superSaverAccounts.get(i+9).getAccountNum();
			balance = superSaverAccounts.get(i+9).getBalance();
			if(AccountsDriver.accountWithdrawal(superSaverAccounts, accountNum, i)) {
				return false;
			}
			if(superSaverAccounts.get(i+9).getBalance() != balance) {
				return false;
			}
		}
		
		if(AccountsDriver.accountWithdrawal(superSaverAccounts, superSaverAccounts.get(0).getAccountNum(), 1)) {
			return false;
		}
		if(superSaverAccounts.get(0).getBalance() != 100) {
			return false;
		}
		
		for(int i=1; i<10; i++) {
			accountNum = superSaverAccounts.get(i).getAccountNum();
			balance = superSaverAccounts.get(i).getBalance();
			if(!AccountsDriver.accountWithdrawal(superSaverAccounts, accountNum, (i)*100)) {
				return false;
			}
			if(superSaverAccounts.get(i).getBalance() != 100) {
				return false;
			}
		}
		
		superSaverAccounts.add(new SuperSaverAccount(200));
		if(!AccountsDriver.accountWithdrawal(superSaverAccounts, superSaverAccounts.get(10).getAccountNum(), 100)) {
			return false;
		}
		if(AccountsDriver.accountWithdrawal(superSaverAccounts, superSaverAccounts.get(10).getAccountNum(), 1)) {
			return false;
		}
		if(superSaverAccounts.get(10).getBalance() != 100) {
			return false;
		}
		
		return true;
	}
	
	public static boolean testUpdateBankAccountInterest() {
		//TEST WITH CHECKING
		ArrayList<BankAccount> accounts = createCheckingAccounts();
		accounts.add(new SavingsAccount(100));
		double balance;
		
		if(AccountsDriver.updateAccountInterest(5, CHECKING)) {
			return false;
		}
		if(!AccountsDriver.updateAccountInterest(4, CHECKING)) {
			return false;
		}
		
		for(int i=0; i<accounts.size()-1; i++) {
			balance = accounts.get(i).getBalance();
			accounts.get(i).endMonth();
			balance += balance*0.04;
			if(accounts.get(i).getBalance() != balance) {
				return false;
			}
		}
		balance = accounts.get(10).getBalance();
		accounts.get(10).endMonth();
		balance += balance*0.09;
		if(accounts.get(10).getBalance() != balance) {
			return false;
		}
		
		//TEST WITH SAVINGS
		ArrayList<BankAccount> moreAccounts = createSavingsAccounts();
		
		if(AccountsDriver.updateAccountInterest(10, SAVINGS)) {
			return false;
		}
		if(!AccountsDriver.updateAccountInterest(9, SAVINGS)) {
			return false;
		}
		
		for(int i=0; i<moreAccounts.size(); i++) {
			balance = moreAccounts.get(i).getBalance();
			moreAccounts.get(i).endMonth();
			balance += balance*0.09;
			if(moreAccounts.get(i).getBalance() != balance) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean testAddMonthlyInterest() {
		ArrayList<BankAccount> checkingAccounts = createCheckingAccounts();
		ArrayList<BankAccount> savingsAccounts = createSavingsAccounts();
		ArrayList<BankAccount> superSaverAccounts = createSuperSaverAccounts();
		SavingsAccount.setMonthlyInterestRate(6);
		
		double[] balances = new double[checkingAccounts.size() + savingsAccounts.size() + superSaverAccounts.size()];
		double balance;
		
		for(int i=0; i<checkingAccounts.size(); i++) {
			balances[i] = checkingAccounts.get(i).getBalance();
		}
		for(int i=0; i<savingsAccounts.size(); i++) {
			balances[checkingAccounts.size()+i] = savingsAccounts.get(i).getBalance();
		}
		for(int i=0; i<superSaverAccounts.size(); i++) {
			balances[checkingAccounts.size()+savingsAccounts.size()+i] = superSaverAccounts.get(i).getBalance();
		}
		
		savingsAccounts.addAll(superSaverAccounts);
		checkingAccounts.addAll(savingsAccounts);
		AccountsDriver.addMonthlyInterest(checkingAccounts);
		
		for(int i=0; i<10; i++) {
			balance = balances[i];
			balance += balance*0.04;
			if(checkingAccounts.get(i).getBalance() != balance) {
				return false;
			}
		}
		for(int i=0; i<10; i++) {
			balance = balances[10 + i];
			balance += balance*0.06;
			if(savingsAccounts.get(i).getBalance() != balance) {
				return false;
			}
		}
		for(int i=0; i<superSaverAccounts.size(); i++) {
			balance = balances[20 + i];
			balance += balance*0.10;
			if(superSaverAccounts.get(i).getBalance() != balance) {
				return false;
			}
		}
		
		return true;
	}
	
	private static ArrayList<BankAccount> createBankAccounts() {
		ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
		for(int i=1; i<=9; i+=3) {
			bankAccounts.add(new CheckingAccount(i*100));
			bankAccounts.add(new SavingsAccount((i+1)*100));
			bankAccounts.add(new SuperSaverAccount((i+2)*100));
		}
		return bankAccounts;
	}
	
	private static ArrayList<BankAccount> createCheckingAccounts() {
		ArrayList<BankAccount> checkingAccounts = new ArrayList<BankAccount>();
		for(int i=0; i<10; i++) {
			checkingAccounts.add(new CheckingAccount(i*100));
		}
		return checkingAccounts;
	}
	
	private static ArrayList<BankAccount> createSavingsAccounts() {
		ArrayList<BankAccount> savingsAccounts = new ArrayList<BankAccount>();
		for(int i=1; i<=10; i++) {
			savingsAccounts.add(new SavingsAccount(i*100));
		}
		return savingsAccounts;
	}
	
	private static ArrayList<BankAccount> createSuperSaverAccounts() {
		ArrayList<BankAccount> superSaverAccounts = new ArrayList<BankAccount>();
		for(int i=1; i<=10; i++) {
			superSaverAccounts.add(new SuperSaverAccount(i*100));
		}
		return superSaverAccounts;
	}
}
