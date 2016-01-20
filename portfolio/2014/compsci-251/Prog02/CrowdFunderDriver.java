import java.util.*;
public class CrowdFunderDriver {
public static void addNewUser(Scanner stdIn, ArrayList<User> users) {
	System.out.print("Enter name: ");
	String name = stdIn.next();
	User user = new User(name);
	users.add(users.size(),user);
}
public static void addNewProject(Scanner stdIn, ArrayList<Project> projects) {
	System.out.print("Enter descrpition: ");
	String description = stdIn.next();
	System.out.print("Enter goal amount: ");
	double goal = stdIn.nextDouble();
	Project project = new Project(goal);
	projects.add(project);
}
public static void printUsers(ArrayList<User> users) {
	for(int i=0; i < users.size();i++) {
	System.out.println(users.get(i).toString());
	}
}
public static void printProjects(ArrayList<Project> projects) {
	for(int i=0; i < projects.size();i++) {
		System.out.println(projects.get(i).toString());
		}
}
public static void printDonations(ArrayList<User> users) {
	for(int i=0; i < users.size();i++) {
		System.out.println(users.get(i).getDonations().toString());
		}
}
public static void enterDonation (Scanner stdIn, ArrayList<User> users, ArrayList<Project> projects) {
	boolean userIdValid=false;
	boolean projIdValid=false;
	int userId;
	int projId=0;
	while(userIdValid==false){
	System.out.print("Enter user id: ");
	userId = stdIn.nextInt();
	for(int i = 0; i < users.size(); i++) {
		if(users.get(i).getUserId() == userId)
			userIdValid=true;
		}
	if (userIdValid==false) {
		System.out.print("Invalid userId. Please try again.");
	}
	}
	
	if (userIdValid==true) {
		while(projIdValid==false){
	System.out.print("Enter project id: ");
	projId = stdIn.nextInt();
		for(int i = 0; i < projects.size();i++) {
			if(projects.get(i).getProjectId() == projId)
				projIdValid=true;
		}
		if (projIdValid==false) {
			System.out.print("Invalid projectId. Please try again.");
		}
	}
	if (projIdValid==true){
	System.out.print("Enter donation amount: ");
	double amount = stdIn.nextDouble();
	}
	
	}
}
public static void printSummary(ArrayList<User> users, ArrayList<Project> projects) {
	System.out.printf("%d users made a total of %d donations for a total of ", users.size(),projects.size());
}
public static int getMenuChoice(Scanner stdIn) {
	int option;
	do{
	System.out.print("Enter an option: ");
	option = stdIn.nextInt();
	}
	while(option <1 && option >8);
	return option;   
	}
public static void main(String[]args) {
	Scanner stdIn = new Scanner(System.in);
	User user;
	Project project;
	ArrayList<User> users = new ArrayList<User>();
	ArrayList<Project> projects = new ArrayList<Project>();
	int choices = 1;
	do{
	switch(getMenuChoice(stdIn)) {
	case 1: {
		addNewUser(stdIn, users);
		break;
	}
	case 2: {
		addNewProject(stdIn,projects);
		break;
	}
	case 3: {
		enterDonation(stdIn, users, projects);
	
		break;
	}
	case 4: {
		printUsers(users);
		break;
	}
	case 5: {
		printProjects(projects);
		break;
	}
	case 6: {
		printDonations(users);
		break;
	}
	case 7: {
		printSummary(users,projects);
		break;
	}
	case 8: {
		System.out.print("Goodbye!");
		choices = 0;
		break;
	}
	default: {
		System.out.println("Invalid entry. Please try again.");
		break;
	}
	}
	}
	while(choices == 1);
	
}
}