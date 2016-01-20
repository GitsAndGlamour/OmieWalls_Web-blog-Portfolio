

import java.text.DecimalFormat;

public class Project {

	public static final double PERCENT_DONATED = 5.0;
	private static int nextProjectId = 1;
	private final double GOAL_AMOUNT;
	private final double MINIMUM_DONATION_AMOUNT;
	private static int MAX_NUM_DONATIONS;
	
	private int projectId;
	private String description;
	private Donation[] donations;
	private int numDonations;
	
	public Project(double goalAmount, int maxNumDonations, double minNumDonations) {
		
		this.projectId = nextProjectId++;
		this.GOAL_AMOUNT = goalAmount;
		this.MAX_NUM_DONATIONS = maxNumDonations;
		this.MINIMUM_DONATION_AMOUNT = minNumDonations;
		this.donations = new Donation[maxNumDonations];
		
	}
	
	public int getProjectId() {
		return this.projectId;
	}
	
	public double getGoalAmount() {
		return this.GOAL_AMOUNT;
	}
	
	public double getMinDonationAmount() {
		return MINIMUM_DONATION_AMOUNT;
	}
	
	public static int getMaxNumDonations() {
		return MAX_NUM_DONATIONS;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public Donation[] getDonations() {
		return this.donations;
	}
	
	public int getNumDonations() {
		return this.numDonations;
	}
	
	public void receiveDonation(Donation donation) throws MaxDonationsReceivedException {
		MaxDonationsReceivedException mdr = new MaxDonationsReceivedException(numDonations);
		InsufficientDonationException ide = new InsufficientDonationException(donation.getAmount(), this.MINIMUM_DONATION_AMOUNT);
		boolean validDonation = false;
		this.donations[numDonations++] = donation; 
		validDonation = true;
	}
	
	public double calculateTotalDonationAmount() {
		double totalDonationAmount = 0.0;
		for(int i=0; i<numDonations; ++i) {
			totalDonationAmount += this.donations[i].getAmount();
		}
		return totalDonationAmount;
	}
	
	public boolean isFunded() {
		return this.calculateTotalDonationAmount() >= this.GOAL_AMOUNT;
	}
	
	public double getCrowdFunderFee() {
		if(isFunded()) {
			return PERCENT_DONATED/100 * this.calculateTotalDonationAmount();
		} else {
			return 0.0;
		}
	}
	
	public double getCollectionAmount() {
		if(isFunded()) {
			return this.calculateTotalDonationAmount() - this.getCrowdFunderFee();
		} else {
			return 0.0;
		}
	}
	
	public boolean equals(Project other) {
		return this.projectId == other.projectId;
	}
	
	public String toString() {
		return "" + this.projectId +": " + description + " raised " + DecimalFormat.getCurrencyInstance().format(this.calculateTotalDonationAmount())
				+ " of " + DecimalFormat.getCurrencyInstance().format(this.GOAL_AMOUNT) + " and has collected " + 
				DecimalFormat.getCurrencyInstance().format(this.getCollectionAmount());
	}
}
