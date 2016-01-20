import java.text.DecimalFormat;
public class Project {
	public static final double PERCENT_DONATED = 5.0;
	private static int nextProjectId = 1;
	private final double GOAL_AMOUNT;
	private int projectId=nextProjectId++;
	private String description;
	private Donation[] donations= new Donation[100]; 
	private int numDonations;
Project(double goalAmount) { 	
	 this.GOAL_AMOUNT = goalAmount;
}
public int getProjectId() {
	return projectId;
}
public double getGoalAmount() {
	return GOAL_AMOUNT; 
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
public void receiveDonation(Donation donation) {
	this.donations[projectId]=donation;
	++this.numDonations;
}
public double calculateTotalDonationAmount() {
	double totalDonationAmount = 0.0;
	
	for(int i = 0; i < donations.length;i++) {
		if(donations[i]!=null)
		totalDonationAmount += donations[i].getAmount();
	}
	return totalDonationAmount;
}
public boolean isFunded() {
	return calculateTotalDonationAmount() >= GOAL_AMOUNT;
}
public double getCrowdFunderFee() {
	if (!isFunded()) 
		return 0.0;
	else
	return calculateTotalDonationAmount() *.01 * PERCENT_DONATED;
}
public double getCollectionAmount() {
	if (!isFunded()) 
		return 0.0;
	else
	return calculateTotalDonationAmount()*.95;
}
public boolean equals(Project other) {
	return other.projectId == this.projectId; 
	
	}
public String toString() {
	String formatProjectString = "" + (projectId +": raised " + DecimalFormat.getCurrencyInstance().format(calculateTotalDonationAmount())
			+ " of " + DecimalFormat.getCurrencyInstance().format(GOAL_AMOUNT) + " and has collected " + 
			DecimalFormat.getCurrencyInstance().format(getCollectionAmount()));
	return formatProjectString;
}
}
