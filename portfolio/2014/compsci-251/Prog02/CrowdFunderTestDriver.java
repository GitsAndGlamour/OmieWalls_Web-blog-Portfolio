import java.text.DecimalFormat;
import java.util.ArrayList;

public class CrowdFunderTestDriver {

	private static boolean passedAllTests = true;
	
	public static void main(String[] args) {
		
		// PROJECT TESTS //////////////////////////////////////////////////////////////////////////////////////////////////////////
		if(!testProjectConstructor()) {
			passedAllTests = false;
			System.out.println("\nProject's constructor (and/or accessors) is/are broken\n");
		} else {
			System.out.println("Project's constructor look good...");
		}
		if(!testProjectDescription()) {
			passedAllTests = false;
			System.out.println("\nProject's accessors and mutators for description is/are broken\n");
		} else {
			System.out.println("Project's accessors and mutators for description look good...");
		}
		if(!testProjectDonation()) {
			passedAllTests = false;
			System.out.println("\nProject's getDonation and/or receiveDonation is/are broken\n");
		} else {
			System.out.println("Project's getDonation and/or receiveDonation look good...");
		}
		if(!testProjectEquals()) {
			passedAllTests = false;
			System.out.println("\nProject's equals method is broken\n");
		} else {
			System.out.println("Project's equals method looks good...");
		}
		if(!testProjectCalculateTotalDonationAmount()) {
			passedAllTests = false;
			System.out.println("\nProject's calculateTotalDonationAmount method is broken\n");
		} else {
			System.out.println("Project's calculateTotalDonationAmount method looks good...");
		}
		if(!testProjectIsFunded()) {
			passedAllTests = false;
			System.out.println("\nProject's isFunded method is broken\n");
		} else {
			System.out.println("Project's isFunded method looks good...");
		}
		if(!testProjectGetCrowdFunderFee()) {
			passedAllTests = false;
			System.out.println("\nProject's getCrowdFunderFee method is broken\n");
		} else {
			System.out.println("Project's getCrowdFunderFee method looks good...");
		}
		if(!testProjectGetCollectionAmount()) {
			passedAllTests = false;
			System.out.println("\nProject's getCollectionAmount method is broken\n");
		} else {
			System.out.println("Project's getCollectionAmount method looks good...");
		}
		if(!testProjectToString()) {
			passedAllTests = false;
			System.out.println("\nProject's toString method is broken\n");
		} else {
			System.out.println("Project's toString method looks good...");
		}
		
		// DONATION TESTS /////////////////////////////////////////////////////////////////////////////////////////////////////////
		if(!testDonationConstructor()) {
			passedAllTests = false;
			System.out.println("\nDonation's constructor (and/or accessors) is/are broken");
		} else {
			System.out.println("Donation's constructor looks good...");
		}
		if(!testDonationEquals()) {
			passedAllTests = false;
			System.out.println("\nDonation's equals method is broken\n");
		} else {
			System.out.println("Donation's equals method looks good...");
		}
		if(!testDonationToString()) {
			passedAllTests = false;
			System.out.println("\nDonation's toString method is broken\n");
		} else {
			System.out.println("Donation's toString method looks good...");
		}
		
		// USER TESTS //////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		if(!testUserConstructor()) {
			passedAllTests = false;
			System.out.println("\nUser's constructor (and/or accessors) is/are broken\n");
		} else {
			System.out.println("User's constructor look good...");
		}
		if(!testUserDonate()) {
			passedAllTests = false;
			System.out.println("\nUser's donate (and/or getDonations) methods is/are broken\n");
		} else {
			System.out.println("User's donate (and getDonations) methods look good...");
		}
		if(!testUserEquals()) {
			passedAllTests = false;
			System.out.println("\nUser's equals method is broken\n");
		} else {
			System.out.println("User's equals method looks good...");
		}
		if(!testUserToString()) {
			passedAllTests = false;
			System.out.println("\nUser's toString method is broken\n");
		} else {
			System.out.println("User's toString method looks good...");
		}
		
		if(passedAllTests) {
			System.out.println("You passed all tests!");
		} else {
			System.out.println("You failed one or more tests");
		}
	}
	
	// DONATION TESTS /////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static boolean testDonationConstructor() {
		try {
			int savedDonationId = 0;
			
			for(int i=0; i<10; i++) {
				int random = (int)(Math.random()*1000) + 1;
				User gu = null;
				Project gd = null;
				Donation go = new Donation(gu, gd, random);
				
				if(i==0) {
					savedDonationId = go.getDonationId();
				}
				
				if(go.getDonationId() != savedDonationId+i) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testDonationConstructor");
			return false;
		}
	}
	
	public static boolean testDonationEquals() {
		try {
			for(int i=0; i<10; i++) {
				int random = (int)(Math.random()*1000) + 1;
				User gu = null;
				Project gd = null;
				Donation go = new Donation(gu, gd, random);
				Donation go2 = new Donation(gu, gd, random);
				
				if(go.equals(go2)) {
					return false;
				}
				if(go2.equals(go)) {
					return false;
				}
				if(!go.equals(go)) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testDonationEquals");
			return false;
		}
	}
	
	public static boolean testDonationToString() {
		try {
			int savedDonationId = 0;
			for(int i=0; i<10; i++) {
				int random = (int)(Math.random()*1000) + 1;
				User gu = new User(""+i);
				Project gd = new Project((i+1)*100);
				Donation go = new Donation(gu, gd, random);
				
				if(i==0) {
					savedDonationId = go.getDonationId();
				}
				
				String s = "" + (savedDonationId + i) + ": " + gu.getName() + " donated " + 
						DecimalFormat.getCurrencyInstance().format(random) + " to project " + gd.getProjectId();
				
				if(!go.toString().equals(s)) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testDonationToString");
			return false;
		}
	}
	
	// PROJECT TESTS //////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static boolean testProjectConstructor() {
		try {
			for(int i=0; i<10; i++) {
				int random = (int)(Math.random()*1000) + 1;
				Project gd = new Project(random);
				
				if(gd.getProjectId() != i+1) {
					return false;
				}
				if(gd.getGoalAmount() != random) {
					return false;
				}
				if(gd.getDonations() == null) {
					return false;
				}
				if(gd.getNumDonations() != 0) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testProjectConstructor");
			return false;
		}
	}
	
	public static boolean testProjectDescription() {
		try {
			for(int i=0; i<10; i++) {
				int random = (int)(Math.random()*1000) + 1;
				Project gd = new Project(random);
				if(gd.getDescription() != null) {
					return false;
				}
				gd.setDescription(""+i);
				if(!gd.getDescription().equals(""+i)) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testProjectDescription");
			return false;
		}
	}
	
	public static boolean testProjectDonation() {
		try {
			for(int i=0; i<10; i++) {
				int random = (int)(Math.random()*1000) + 1;
				Project gd = new Project(random);
				if(gd.getNumDonations() != 0) {
					return false;
				}
				for(int j=0; j<10; j++) {
					Donation d = null;
					gd.receiveDonation(d);
					if(gd.getNumDonations() != (j+1)) {
						return false;
					}
					if(gd.getDonations()[j] != d) {
						return false;
					}
				}
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testProjectDonation");
			return false;
		}
	}
	
	public static boolean testProjectCalculateTotalDonationAmount() {
		try {
			double totalDonationAmount = 0.0;

			int random = (int)(Math.random()*1000) + 1;
			Project gd = new Project(random);
			User u = null;
			
			if(gd.calculateTotalDonationAmount() != totalDonationAmount) {
				return false;
			}
			
			for(int i=0; i<10; i++) {
				random = (int)(Math.random()*1000) + 1;
				Donation d = new Donation(u, gd, random);
				gd.receiveDonation(d);
				totalDonationAmount += random;
				if(gd.calculateTotalDonationAmount() != totalDonationAmount) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testProjectCalculateTotalDonationAmount");
			return false;
		}
	}
	
	public static boolean testProjectIsFunded() {
		try {
			for(int i=0; i<10; ++i) {
				int random = (int)(Math.random()*1000) + 10;
				Project gd = new Project(random);
				User u = null;
				
				if(gd.isFunded()) {
					return false;
				}
				Donation d = new Donation(u, gd, random-1);
				gd.receiveDonation(d);
				if(gd.isFunded()) {
					return false;
				}
				d = new Donation(u, gd, 1);
				gd.receiveDonation(d);
				if(!gd.isFunded()) {
					return false;
				}
				d = new Donation(u, gd, 1);
				gd.receiveDonation(d);
				if(!gd.isFunded()) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testProjectIsFunded");
			return false;
		}
	}
	
	public static boolean testProjectGetCrowdFunderFee() {
		try {
			for(int i=0; i<10; ++i) {
				int random = (int)(Math.random()*1000) + 10;
				Project gd = new Project(random);
				User u = null;
				
				if(gd.getCrowdFunderFee() != 0.0) {
					return false;
				}
				Donation d = new Donation(u, gd, random-1);
				gd.receiveDonation(d);
				if(gd.getCrowdFunderFee() != 0.0) {
					return false;
				}
				d = new Donation(u, gd, 1);
				gd.receiveDonation(d);
				if(gd.getCrowdFunderFee() != random * .05) {
					return false;
				}
				d = new Donation(u, gd, 10);
				gd.receiveDonation(d);
				if(gd.getCrowdFunderFee() != (random+10) * .05) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testProjectIsFunded");
			return false;
		}
	}
	
	public static boolean testProjectGetCollectionAmount() {
		try {
			for(int i=0; i<10; ++i) {
				int random = (int)(Math.random()*1000) + 10;
				Project gd = new Project(random);
				User u = null;
				
				if(gd.getCollectionAmount() != 0.0) {
					return false;
				}
				Donation d = new Donation(u, gd, random-1);
				gd.receiveDonation(d);
				if(gd.getCollectionAmount() != 0.0) {
					return false;
				}
				d = new Donation(u, gd, 1);
				gd.receiveDonation(d);
				if(!DecimalFormat.getCurrencyInstance().format(gd.getCollectionAmount()).equals(DecimalFormat.getCurrencyInstance().format(random * .95))) {
					return false;
				}
				d = new Donation(u, gd, 10);
				gd.receiveDonation(d);
				if(!DecimalFormat.getCurrencyInstance().format(gd.getCollectionAmount()).equals(DecimalFormat.getCurrencyInstance().format((random+10) * .95))) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testProjectIsFunded");
			return false;
		}
	}
	
	public static boolean testProjectEquals() {
		try {
			for(int i=0; i<10; i++) {
				int random = (int)(Math.random()*1000) + 10;
				Project gd = new Project(random);
				Project gd2 = new Project(random);
				
				if(gd.equals(gd2)) {
					return false;
				}
				if(gd2.equals(gd)) {
					return false;
				}
				if(!gd.equals(gd)) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testProjectEquals");
			return false;
		}
	}
	
	public static boolean testProjectToString() {
		try {
			User u = new User("Jack");
			int savedProjectId = 0;
			
			for(int i=0; i<10; i++) {
				int random = (int)(Math.random()*1000) + 10;
				Project gd = new Project(random);
				gd.setDescription(""+i);
				
				if(i == 0) {
					savedProjectId = gd.getProjectId();
				}
				String s = "" + (savedProjectId + i) +": " + i + " raised " + DecimalFormat.getCurrencyInstance().format(gd.calculateTotalDonationAmount())
						+ " of " + DecimalFormat.getCurrencyInstance().format(random) + " and has collected " + 
						DecimalFormat.getCurrencyInstance().format(0);
				if(!gd.toString().equals(s)) {
					return false;
				}
				int random2 = (int)(Math.random()*100)+1;
				Donation d = new Donation(u, gd, random2);
				gd.receiveDonation(d);
				s = "" + (savedProjectId + i) +": " + i + " raised " + DecimalFormat.getCurrencyInstance().format(gd.calculateTotalDonationAmount())
						+ " of " + DecimalFormat.getCurrencyInstance().format(random) + " and has collected " + 
						DecimalFormat.getCurrencyInstance().format(gd.getCollectionAmount());
				if(!gd.toString().equals(s)) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testProjectToString");
			return false;
		}
	}
	
	// USER TESTS //////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static boolean testUserConstructor() {
		try {
			int savedUserId = 0;
			for(int i=0; i<10; i++) {
				User gu = new User(""+i);
				
				if(i == 0) {
					savedUserId = gu.getUserId();
				}
				
				if(gu.getUserId() != savedUserId + i) {
					return false;
				}
				if(gu.getDonations() == null) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testUserConstructor");
			return false;
		}
	}
	
	public static boolean testUserDonate() {
		try {
			User gu = new User("Jack");
			int random = (int)(Math.random()*1000) + 100;
			Project p = new Project(random);
			ArrayList<Donation> donations = gu.getDonations();
			
			gu.donate(p, -100);
			gu.donate(p, 0);
			if(!gu.getDonations().isEmpty()) {
				return false;
			}
			
			for(int i=1; i<10; i++) {
				gu.donate(p, i);
				
				if(gu.getDonations().size() != i) {
					return false;
				}
				if(gu.getDonations() != donations) {
					return false;
				}
				Donation d = gu.getDonations().get(i-1);
				if(d.getAmount() != i) {
					return false;
				}
				if(p.getDonations() == null || d != p.getDonations()[i-1]) {
					return false;
				}
			}
			
			User gu2 = new User("Jill");
			if(gu2.getDonations() == donations || !gu2.getDonations().isEmpty()) {
				return false;
			}
			
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testUserDonate");
			return false;
		}
	}
	
	public static boolean testUserEquals() {
		try {
			for(int i=0; i<10; i++) {
				User gu = new User(""+i);
				User gu2 = new User(""+i);
				
				if(gu.equals(gu2)) {
					return false;
				}
				if(gu2.equals(gu)) {
					return false;
				}
				if(!gu.equals(gu)) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testUserEquals");
			return false;
		}
	}
	
	public static boolean testUserToString() {
		try {
			int savedUserId = 0;
			for(int i=0; i<10; i++) {
				User gu = new User(""+i);
				
				if(i==0) {
					savedUserId = gu.getUserId();
				}
				
				if(!gu.toString().equals(""+(savedUserId + i) + ": " + i)) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			System.out.println("An exception was thrown in testUserToString");
			return false;
		}
	}
}