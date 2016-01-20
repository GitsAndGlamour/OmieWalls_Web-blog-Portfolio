import java.lang.Exception;
import java.text.DecimalFormat;
public class MaxDonationsReceivedException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public MaxDonationsReceivedException(int maxNumDonations) {
		if(Project.getMaxNumDonations()< maxNumDonations){
			System.out.println("ERROR: A donation was made to a project that received its maximum number of donations: <maxNumDonations>");
		}
	}
}
