package ships;

/**
 *holds the information of a cargo ship
 */

public class CargoShip extends Ship {
	private int capacity;//in tonnage
	public CargoShip() {
		;
	}
	public CargoShip(String n, int c) {
		super(n);
		capacity = c;
	}
	public CargoShip(String n, int b, int c) {
		super(n, b);
		capacity = c;
	}
	public CargoShip(Ship s, int c) {
		super(s.getName(), s.getBuilt());
		capacity = c;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getCapacity() {
		return capacity;
	}
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("CargoShip " + super.getName());
		str.append(" - capacity = " + capacity);
		return str.toString();
	}
}
