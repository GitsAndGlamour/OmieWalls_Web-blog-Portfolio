/*
 * The driver contains the same members and behaviors with the following modifications:! !
• Any time an int or a double is input by the user, the InputMismatchException should be
handled when the user enters something other than an int or double (respectively). If this
exception occurs, an “Invalid input.” message should be printed to the console, and the value
should be read again repeatedly until a valid value is entered. You may need to use
Scanner’s nextLine method to clear the contents of the input buffer.!
• If a MaxDonationsReceivedException or InsufficientDonationException is thrown, the driver
should print their messages to the console.!
 */

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class CrowdFunderDriver {
	
	
	public static void addNewUser(Scanner stdIn, ArrayList<User> users) {
		stdIn.nextLine();
		System.out.print("Enter name: ");
		User user = new User(stdIn.nextLine());
		users.add(user);
	}

	public static void addNewProject(Scanner stdIn, ArrayList<Project> projects) {
		stdIn.nextLine();
		System.out.print("Enter description: ");
		String description = stdIn.nextLine();
		
		double goalAmount = 0.0;
		boolean valid=false;
		String inputMaxDonations = null;
		int maxNumDonations = 0, validCnt = 0;
		double minNumDonations = 0.0;
		while (!valid){
		try{
			System.out.print("Enter goal amount: ");
			goalAmount = stdIn.nextDouble();
			valid = true; 
		}
		catch(InputMismatchException e) {
			System.out.println("Please enter a numeric value.");
			stdIn.nextLine();
		}
		}
		while (valid){
		try{
		System.out.print("Enter minimum donation amount: ");
		minNumDonations = stdIn.nextDouble();
		valid = false;
		}
		catch(InputMismatchException f) {
			valid = true;
			System.out.println("Please enter a numeric value.");
			stdIn.nextLine();
		}
		}
		while(!valid){
		System.out.print("Enter maximum number of donations: ");
		inputMaxDonations = stdIn.next();
		for(int i = 0; i < inputMaxDonations.length(); i++) {
			if(inputMaxDonations.charAt(i)<='9' && inputMaxDonations.charAt(i)>='0'){
				valid=true;
			}
			else
				++validCnt;
		}
		if(validCnt>0){
			validCnt=0;
			System.out.println("Please enter a numeric value.");
		}
		}
		maxNumDonations = Integer.parseInt(inputMaxDonations);
		Project project = new Project(goalAmount, maxNumDonations, minNumDonations);
		project.setDescription(description);
		projects.add(project);
	}
	
	public static void printUsers(ArrayList<User> users) {
		if(users.size() == 0) {
			System.out.println("No users found.");
		} else {
			for(int i=0; i<users.size(); i++) {
				System.out.println(users.get(i).toString());
			}
		}
	}
	
	public static void printProjects(ArrayList<Project> projects) {
		if(projects.size() == 0) {
			System.out.println("No projects found.");
		} else {
			for(int i=0; i<projects.size(); i++) {
				System.out.println(projects.get(i).toString());
			}
		}
	}
	
	public static void printDonations(ArrayList<User> users) {
		boolean donationsFound = false;
		for(int i=0; i<users.size(); i++) {
			ArrayList<Donation> donations = users.get(i).getDonations();
			for(int j=0; j<donations.size(); j++) {
				donationsFound = true;
				System.out.println(donations.get(j).toString());
			}
		}
		if(!donationsFound) {
			System.out.println("No donations found.");
		}
	}
	
	public static void enterDonation(Scanner stdIn, ArrayList<User> users, ArrayList<Project> projects) throws MaxDonationsReceivedException, InsufficientDonationException {
		int dealId=0, userId=0;
		boolean valid=false;
		double amount=0.0;
		while(valid==false){
		try{
		System.out.print("Enter user id: ");
		userId = stdIn.nextInt();
		valid=true;
		}
		catch(InputMismatchException g) {
			System.out.print("Please enter a numerical value.");
			stdIn.nextLine();
		}
		}
		for(int i=0; i<users.size(); i++) {
			
			if(users.get(i).getUserId() == userId) {
				while(valid){
				try{
				System.out.print("Enter project id: ");
				dealId = stdIn.nextInt();
				valid=false;
				}
				catch(InputMismatchException h){
					System.out.print("Please enter a numerical value.");
					stdIn.nextLine();
				}
			}
				for(int j=0; j<projects.size(); j++) {
					if(projects.get(j).getProjectId() == dealId) {
						amount = 0;
						System.out.print("Enter donation amount: ");
						amount = stdIn.nextDouble();
						users.get(i).donate(projects.get(j), amount);
						throw new InsufficientDonationException(projects.get(j).getMinDonationAmount(), amount);
						
						
					}
				}
				System.out.println("Project not found.");
				return;
			}
		}
		System.out.println("User not found.");
	}
	
	public static void printSummary(ArrayList<User> users, ArrayList<Project> projects) {
		int numDonations = 0;
		double totalDonationAmount = 0.0;
		for(int i=0; i<users.size(); i++) {
			ArrayList<Donation> userDonations = users.get(i).getDonations();
			for(int j=0; j<userDonations.size(); j++) {
				numDonations++;
				totalDonationAmount += userDonations.get(j).getAmount();
			}
		}
		int numFundedProjects = 0;
		double totalFeesGenerated = 0.0;
		for(int i=0; i<projects.size(); i++) {		
			Project project = projects.get(i);
			if(project.isFunded()) {
				numFundedProjects++;
				totalFeesGenerated += project.getCrowdFunderFee();
			}
		}
		
		System.out.println("" + users.size() + " users made a total of " + numDonations + " donations for a total of " 
				+ DecimalFormat.getCurrencyInstance().format(totalDonationAmount));
		System.out.println("" + numFundedProjects + " out of " + projects.size() + " projects were funded and generated " 
				+ DecimalFormat.getCurrencyInstance().format(totalFeesGenerated) + " for CrowdFunder");
	}

	public static int getMenuChoice(Scanner stdIn) {
		String inputChoice = null;
		int choice = 0;
		
		System.out.println("---------------------------");
		System.out.println("1.  Add User");
		System.out.println("2.  Add Project");
		System.out.println("3.  Enter Donation");
		System.out.println("4.  Print Users");
		System.out.println("5.  Print Projects");
		System.out.println("6.  Print Donations");
		System.out.println("7.  Print Summary");
		System.out.println("8.  Quit");
		System.out.println("---------------------------");
		
		boolean valid = false;
		int validCnt = 0;
		do { 
			System.out.print("Choose an option: ");
			inputChoice = stdIn.next();
			
			for(int i = 0; i < inputChoice.length(); i++) {
				if(inputChoice.charAt(i)<='9' && inputChoice.charAt(i)>='0') {
					valid = true;
				}
				else
					++validCnt;
			}
			if(valid && validCnt==0)
				choice = Integer.parseInt(inputChoice);
			if(choice < 1 || choice > 8) {
				System.out.println("Invalid Option");
			}
		} while((choice < 1 || choice > 8) || valid == false);
		
		return choice;
	}
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		ArrayList<User> users = new ArrayList<User>();
		ArrayList<Project> projects = new ArrayList<Project>();
		int choice;
		
		System.out.println("WELCOME TO CROWDFUNDER MANAGER");
		System.out.println("==============================\n");
		do {
			choice = getMenuChoice(stdIn);
			
			if(choice == 1) {
				addNewUser(stdIn, users);
			} else if(choice == 2) {
				addNewProject(stdIn, projects);
			} else if(choice == 3) {
				try {
					enterDonation(stdIn, users, projects);
				} catch (MaxDonationsReceivedException e) {
					stdIn.nextLine();
				} catch (InsufficientDonationException e) {
					stdIn.nextLine();
				}
			} else if(choice == 4) {
				printUsers(users);
			} else if(choice == 5) {
				printProjects(projects);
			} else if(choice == 6) {
				printDonations(users);	
			} else if(choice == 7) {
				printSummary(users, projects);
			}
		} while(choice != 8);
		
		System.out.println("Goodbye!");
	}
}
