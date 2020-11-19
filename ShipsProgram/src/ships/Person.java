package ships;

import java.time.*;

/**
 *holds the information for a person
 */

public class Person {
	private String firstName;
	private String lastName;
	private Gender gender;
	private LocalDate birthdate;
	private Address address;
	public Person(String f, String l, Gender g, Address add, String birthdate) {
		firstName = f;
		lastName = l;
		gender = g;
		address = add;
		this.birthdate = LocalDate.parse(birthdate);
	}
	public Person(String f, String l, Gender g, String s, String c, String state, String zip, String birthdate) {
		firstName = f;
		lastName = l;
		gender = g;
		address = new Address(s, c, state, zip);
		this.birthdate = LocalDate.parse(birthdate);
	}
	public Person(String f, String l, Gender g, Address add, LocalDate birthdate) {
		firstName = f;
		lastName = l;
		gender = g;
		address = add;
		this.birthdate = birthdate;
	}
	public Person(Person p) {
		firstName = p.firstName;
		lastName = p.lastName;
		gender = p.gender;
		address = p.address;
		birthdate = p.birthdate;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Gender getGender() {
		return gender;
	}
	public LocalDate getBirthDate() {
		return birthdate;
	}
	public Address getAddress() {
		return address;
	}
	public void setLastName(String last) {
		lastName = last;
	}
	public void setAddress(Address addr) {
		address = addr;
	}
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(lastName + "," + firstName + "\n");
		str.append("Gender: " + gender + "\n");
		str.append("Birth Date: " + birthdate + "\n");
		str.append(address);
		return str.toString();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (birthdate == null) {
			if (other.birthdate != null)
				return false;
		} else if (!birthdate.equals(other.birthdate))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
}
