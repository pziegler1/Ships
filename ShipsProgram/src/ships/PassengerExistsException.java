package ships;

public class PassengerExistsException extends RuntimeException {
	public PassengerExistsException() {
		super("duplicate");
	}
	public PassengerExistsException(String message) {
		super(message);
	}
}
