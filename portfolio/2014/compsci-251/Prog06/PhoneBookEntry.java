public class PhoneBookEntry {
	private String name; 
	private String number; 
	
	public PhoneBookEntry(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNumber() {
		return this.number;
	}
}
