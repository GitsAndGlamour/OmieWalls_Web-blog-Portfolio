/*
User
- nextUserId : int = 1!
- userId : int!
- name : String!
- donations : ArrayList<Donation>
+ User(name : String)!
+ getUserId() : int!
+ getName() : String!
+ getDonations() : ArrayList<Donation>!
+ donate(project : Project, amount : double) : void!
+ equals(other : User) : boolean!
+ toString() : String
 */
import java.util.*;
public class User {
	private static int nextUserId = 1;
	private int userId = nextUserId++;
	private String name;
	private ArrayList<Donation> donations = new ArrayList<Donation>();
	
	public User(String name) {
		this.name = name;
	}
	public int getUserId() {
		return this.userId;
	}
	public String getName() {
		return this.name;
	}
	public ArrayList<Donation> getDonations() {
		return this.donations;
	}
	public void donate(Project project, double amount) {
		Donation donation = new Donation(this,project,amount);
		if(amount > 0){
			project.receiveDonation(donation);
			this.donations.add(donation);
		}
	}
	public boolean equals(User other) {
		return this.userId == other.userId;
	}
	public String toString() {
		String formatUserString = this.userId + ": " + this.name;
		return formatUserString;
	}
	
	
}
