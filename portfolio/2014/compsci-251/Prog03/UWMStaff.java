public class UWMStaff extends UWMPerson {
	private String title;
	private double hourlyPay;
	private double hoursPerWeek;
	public UWMStaff(int uwmId, String firstName, String lastName) {
		super(uwmId, firstName, lastName);
	}
	public String getTitle(String title) {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getHourlyPay() {
		return this.hourlyPay;
	}
	public void setHourlyPay(double hourlyPay) {
		this.hourlyPay = hourlyPay;
	}
	public double getHoursPerWeek() {
		return this.hoursPerWeek;
	}
	public void setHoursPerWeek(double hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}
	public String toString() {
		String staffString = "[UWMStaff = uwmId: " + this.getUwmId() + ", name: " + this.getFirstName() + " " + this.getLastName() + ", title: " + this.getTitle(title) + ", hourly pay: " + this.hourlyPay + ", hours/week: " + this.hoursPerWeek + "]";
		return staffString;
	}
	public boolean equals(UWMStaff other) {
		return other.getUwmId() == this.getUwmId();
	}

}
