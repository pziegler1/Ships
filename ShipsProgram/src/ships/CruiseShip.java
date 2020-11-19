package ships;

/**
 * holds the information for a cruise ship
 */

import java.util.*;

public class CruiseShip extends Ship{
	private int maximum;
	private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	public CruiseShip() {
		;
	}
	public CruiseShip(String n, int b, int m) {
		super(n, b);
		maximum = m;
	}
	public CruiseShip(String n, int b, int m, ArrayList<Passenger> p) {
		super(n, b);
		maximum = m;
		passengers = p;
	}
	public CruiseShip(Ship s, int m, ArrayList<Passenger> p) {
		super(s.getName(), s.getBuilt());
		maximum = m;
		passengers = p;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	public int getMaximum() {
		return maximum;
	}
	public ArrayList<Passenger> getPassengers() {
		Passenger upto;
		ArrayList<Passenger> get = new ArrayList<Passenger>();
		for(int i = 0; i < passengers.size(); i++) {
			upto = new Passenger(passengers.get(i));
			get.add(upto);
		}
		return get;
	}
	public void addPassenger(Passenger pass) {
		if(passengers.size() < maximum) {//only adds if didn't reach maximum
			if(!exists(pass)) {//only adds if the passenger does not exist
				passengers.add(pass);
			}
			else {
				throw new PassengerExistsException();
			}
		}
		else{
			System.out.println("You have already reached the maximum number of passengers");
		}
	}
	public boolean exists(Passenger pass) {
		for(int i = 0; i < passengers.size(); i++) {
			if(pass.equals(passengers.get(i))) {
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("CruiseShip " + super.getName() + " built in " + super.getBuilt() + "\n");
		str.append("Maximum: " + maximum + "\n");
		str.append("Passengers:\n");
		for(int i = 0; i < passengers.size(); i++) {
			str.append(passengers.get(i).getFirstName() + " " + passengers.get(i).getLastName() + "\n");
		}
		return str.toString();
	}
}
