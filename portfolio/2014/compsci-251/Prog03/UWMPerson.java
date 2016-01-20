public class UWMPerson {
	private int uwmId; 
	private String firstName;
	private String lastName;
	public UWMPerson (int uwmId, String firstName, String lastName) {
		this.uwmId = uwmId;
		this.firstName = firstName; 
		this.lastName = lastName;
	}
	public int getUwmId() {
		return this.uwmId;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setFirstName(String firstName) {
		 this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String toString() {
		String personString = "[UWMPerson = uwmId: " + uwmId + ", name: " + firstName + " " + lastName + "]";
		return personString;
	}
	public boolean equals(UWMPerson other) {
		return other.getUwmId()==this.getUwmId(); 
	}
}