public class UWMStudent extends UWMPerson{
	private double gpa;
	public UWMStudent(int uwmId, String firstName, String lastName, double gpa) {
		super(uwmId, firstName, lastName);
		this.gpa = gpa;
	}
	public double getGpa() {
		return this.gpa;
	}
	public String toString() {
		String studentString = "[UWMStudent = uwmId: " + super.getUwmId() + ", name: " + super.getFirstName() + " " + super.getLastName() + ", gpa: " + gpa + "]"; 
		return studentString;
	}
	public boolean equals(UWMStudent other) {
		return other.getUwmId()==this.getUwmId();
	}
}
