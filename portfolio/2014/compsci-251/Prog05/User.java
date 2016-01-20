/*
 * A user contains the same members and behaviors with the following modifications:! !
• The donate method should handle the two exceptions possibly thrown by Project’s
receiveDonation method. It should do so by throwing them itself.!
 */

import java.util.ArrayList;

public class User {

	private static int nextUserId = 1;
	private int userId;
	private String name;
	private ArrayList<Donation> donations;
	
	public User(String name) {
		donations = new ArrayList<Donation>();
		this.userId = nextUserId++;
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
	
	public void donate(Project project, double amount) throws MaxDonationsReceivedException {
		if(amount > 0.0) {
			Donation donation = new Donation(this, project, amount);
			donations.add(donation);
			try {
				project.receiveDonation(donation);
			} catch (MaxDonationsReceivedException e) {
				e.printStackTrace();
				System.out.println("The maximum amount of donations have been reached.");
			}
		}
	}
	
	public boolean equals(User other) {
		return this.userId == other.userId;
	}
	
	public String toString() {
		return "" + userId + ": " + this.name;
	}
}
