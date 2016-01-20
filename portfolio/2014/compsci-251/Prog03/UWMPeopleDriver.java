import java.util.*;
import java.util.Scanner;

public class UWMPeopleDriver {
	public static void addStudent(Scanner stdIn, ArrayList<UWMStudent> students) {
		int id;
		String first, last;
		double gpa;
		
		System.out.print("Enter id: ");
		id = stdIn.nextInt();
		
		System.out.print("Enter first name: ");
		first = stdIn.next();
		
		System.out.print("Enter last name: ");
		last = stdIn.next();
		
		do{
			System.out.print("Enter gpa: ");
			gpa = stdIn.nextDouble();
		}
		while(gpa<0.0 || gpa>4.0);
		
		UWMStudent student = new UWMStudent(id, first, last, gpa);
		students.add(student);
	}
	public static void addStaff(Scanner stdIn, ArrayList<UWMStaff> staff) {
		int id;
		String first, last, title;
		double hourlyPay, hoursPerWeek;
		
		System.out.print("Enter id: ");
		id = stdIn.nextInt();
		
		System.out.print("Enter first name: ");
		first = stdIn.next();
		
		System.out.print("Enter last name: ");
		last = stdIn.next();
		
		System.out.print("Enter title: ");
		title = stdIn.next();
		
		System.out.print("Enter hourly pay:");
		hourlyPay = stdIn.nextDouble();
		
		System.out.print("Enter hours per week: ");
		hoursPerWeek = stdIn.nextDouble();
		
		UWMStaff staffMember = new UWMStaff(id, first, last);
		staff.add(staffMember);
		staffMember.setHourlyPay(hourlyPay);
		staffMember.setHoursPerWeek(hoursPerWeek);
	}
	public static void printStudents(ArrayList<UWMStudent> students) {
		for(int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i).toString());
		}
	}
	public static void printStaff( ArrayList<UWMStaff> staff) {
		for(int i = 0; i < staff.size(); i++) {
			System.out.println(staff.get(i).toString());
		}
	}
	public static int getMenuChoice(Scanner stdIn) {
			int choice;
			do{
				System.out.print("Enter an option (1-5): ");
				choice = stdIn.nextInt();
				System.out.println();
			}
			while(choice < 1 || choice > 5);
		return choice;
	}
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		boolean quit = false;
		ArrayList<UWMStudent> students = new ArrayList<UWMStudent>();
		ArrayList<UWMStaff> staff = new ArrayList<UWMStaff>(); 
		
		System.out.println("UWM People Driver:\n\n+++++++++++++++++++++++++"
								+"\n1. Add Student" 
								+"\n2. Add Staff"
								+"\n3. Print Students"
								+"\n4. Print Staff"
								+"\n5. Quit"
								+"\n+++++++++++++++++++++++++");
		while(quit==false) {
			int menu = getMenuChoice(stdIn);
			switch(menu) {
				case 1: { //Add Student
					addStudent(stdIn, students);
					break;
				}
				case 2: { //Add Staff
					addStaff(stdIn, staff);
					break;
				}
				case 3: { //Print Students
					if(students.size()<1)
						System.out.print("No students found.\n");
					else
						printStudents(students);
					break;
				}
				case 4: { //Print Staff
					if(staff.size()<1)
						System.out.print("No staff found.\n");
					else
						printStaff(staff);
					break;
				}
				case 5: { //Quit
					System.out.print("-End-");
					quit=true;
					break;
				}
			}
		}
	}
}
