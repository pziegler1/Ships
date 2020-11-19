package ships;

/**
 *holds the information of an address
 */

public class Address {
	private String street;
	private String city;
	private String state;
	private String zipcode;
	public Address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		zipcode = zip;
	}
	public String getStreet() {
		return street;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZip() {
		return zipcode;
	}
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("Address:\n");
		str.append(street + "\n");
		str.append(city + ", " + state + " " + zipcode);
		return str.toString();
	}
}