/*
 * A donation contains the same members and behaviors as it did in assignment 3.!
 */

import java.text.DecimalFormat;

public class Donation {
	
	private static int nextDonationId = 1;
	private int donationId;
	private User user;
	private Project project;
	private double amount;
	
	public Donation(User user, Project project, double amount) {
		this.donationId = nextDonationId++;
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
		return "" + this.donationId + ": " + user.getName() + " donated " + 
				DecimalFormat.getCurrencyInstance().format(this.getAmount()) + " to project " + project.getProjectId();
			}
}
