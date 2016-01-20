import java.text.DecimalFormat;

/*
Donation
- nextDonationId : int = 1!
- donationId : int!
- user : User!
- project : Project!
- amount : double
+ Donation(user : User, project : Project, amount : double)!
+ getDonationId() : int!
+ getAmount() : double!
+ equals(other : Donation) : boolean!
+ toString() : String
 */
public class Donation {
	private static int nextDonationId = 1;
	private int donationId = nextDonationId++;
	private User user;
	private Project project;
	private double amount;
	public Donation(User user, Project project, double amount) {
		this.user = user;
		this.project = project;
		this.amount = amount;
	}
	public int getDonationId() {
	return this.donationId;	
	}
	public double getAmount() {
	return this.amount;	
	}
	public boolean equals(Donation other) {
	return this.donationId == other.donationId;	
	}
	public String toString() {
	
			String formatDonationString = "" + (getDonationId() + ": " + user.getName() + " donated " + 
					DecimalFormat.getCurrencyInstance().format(amount) + " to project " + project.getProjectId());
			
		return formatDonationString;
	}	 
}		
