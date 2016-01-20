import java.lang.Exception;
import java.text.DecimalFormat;

public class InsufficientDonationException extends Exception{
	private static final long serialVersionUID = 1L;
	public InsufficientDonationException(double minDonation, double donationAmount) {
		
			if(donationAmount < minDonation) {
			
				System.out.println("ERROR: A donation of " + DecimalFormat.getCurrencyInstance().format(donationAmount) + " was received by a project with a minimum donation of " + DecimalFormat.getCurrencyInstance().format(minDonation));
			
	
		}
			
	}

}
