package ships;

/**
 *holds the information for a passenger on a cruise ship
 */

public class Passenger extends Person {
	private String passportID;
	private int luggagePieces;
	public Passenger(String f, String l, Gender g, Address addr, String birthdate, String passportID, int luggage) {
		super(f, l, g, addr, birthdate);
		this.passportID = passportID;
		luggagePieces = luggage;
	}
	public Passenger(Passenger p) {
		super(p.getFirstName(), p.getLastName(), p.getGender(), p.getAddress(), p.getBirthDate());
		this.passportID = p.passportID;
		luggagePieces = p.luggagePieces;
	}
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("Passenger: ");
		str.append("Passport ID = " + passportID);
		str.append(", Luggage Pieces = " + luggagePieces);
		return str.toString();
	}	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (getClass() != o.getClass())
			return false;
		Passenger other = (Passenger) o;
		if (passportID == null) {
			if (other.passportID != null)
				return false;
		} else if (!passportID.equals(other.passportID))
			return false;
		return true;
	}
}
