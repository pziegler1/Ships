package ships;

/**
 * holds the information of a ship
 */

public class Ship {
	private String name;
	private int built;
	public Ship() {
		;
	}
	public Ship(String name) {
		this.name = name;
	}
	public Ship(int built) {
		this.built = built;
	}
	public Ship(String name, int built) {
		this.name = name;
		this.built = built;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBuilt(int built) {
		this.built = built;
	}
	public String getName() {
		return name;
	}
	public int getBuilt() {
		return built;
	}
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(name);
		str.append(" built in " + built);
		return str.toString();
	}
}
