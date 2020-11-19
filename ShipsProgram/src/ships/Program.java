package ships;

/**
 * creates an ArrayList of Cargo Ships and Cruise Ships
 */

import java.util.*;

public class Program {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		ArrayList<CargoShip> cargos = new ArrayList<CargoShip>();
		ArrayList<CruiseShip> cruises = new ArrayList<CruiseShip>();
		String again;
		
		//add Cargo Ships
		do {
			newCargo(keyboard, cargos);			
			System.out.print("Do you want to add another cargo ship? (enter y for yes) ");
			again = keyboard.nextLine();
		}while(again.equalsIgnoreCase("y"));
		
		//display Cargo Ships
		System.out.println("\nCargo Ships:");
		for(int i = 0; i < cargos.size(); i++) {
			System.out.println(cargos.get(i).toString());
		}
		
		//add Cruise Ships
		again = "y";
		do {
			newCruise(keyboard, cruises);			
			System.out.print("Do you want to add another cruise ship? (enter y for yes) ");
			again = keyboard.nextLine();
		}while(again.equalsIgnoreCase("y"));
		
		//display Cruise Ships
		System.out.println("\nCruise Ships:");
		for(int i = 0; i < cruises.size(); i++) {
			System.out.println(cruises.get(i).toString());
		}
		
		keyboard.close();
	}
	public static void newCargo(Scanner keyboard, ArrayList<CargoShip> cargos){
		String name;
		int built, capacity;
		System.out.println("\nCargo Ship # " + (cargos.size()+1));
		System.out.print("What is the name of this ship? ");
		name = keyboard.nextLine().toUpperCase();
		System.out.print("What year was this ship built in? ");
		built = keyboard.nextInt();
		System.out.print("What is the capacity of this ship (in tonnage)? ");
		capacity = keyboard.nextInt();
		keyboard.nextLine();
		cargos.add(new CargoShip(name, built, capacity));
	}
	public static void newCruise(Scanner keyboard, ArrayList<CruiseShip> cruises){
		String name;
		int built, maximum;
		System.out.println("\nCruise Ship # " + (cruises.size()+1));
		System.out.print("What is the name of this ship? ");
		name = keyboard.nextLine();
		System.out.print("What year was this ship built in? ");
		built = keyboard.nextInt();
		System.out.print("What is the maximum number of passengers this ship can hold? ");
		maximum = keyboard.nextInt();
		keyboard.nextLine();
		CruiseShip adding = new CruiseShip(name, built, maximum, new ArrayList<Passenger>());
		String again;
		do {
			try{
				if(adding.getPassengers().size() < adding.getMaximum()) {
					newPassenger(keyboard, adding);	
				}
				else {
					System.out.println("You have already reached the maximum number of passengers");
					again = "n";
					break;
				}
			}
			catch(PassengerExistsException e) {
				System.out.println("That passenger already exists");
			}
			System.out.print("Do you want to add another passenger to this cruise ship? (enter y for yes) ");
			again = keyboard.nextLine();
		}while(again.equalsIgnoreCase("y"));
		cruises.add(adding);
	}
	public static void newPassenger(Scanner keyboard, CruiseShip ship) {
		Gender gender;
		Address address; 
		String firstName, lastName, gen, street, city, state, zip, month, day, year, birthdate, passportID; 
		int luggage;
		System.out.println("\nPassenger # " + (ship.getPassengers().size()+1));
		System.out.print("What is this passenger's first name? ");
		firstName = keyboard.nextLine();
		System.out.print("What is this passenger's last name? ");
		lastName = keyboard.nextLine();
		System.out.print("What is this passenger's gender? (enter F or M) ");
		gen = keyboard.nextLine();
		while(!gen.equalsIgnoreCase("F") && !gen.equalsIgnoreCase("M")) {
			System.out.print("Please enter F or M for the passenger's gender: ");
			gen = keyboard.nextLine().toUpperCase();
		}
		if(gen.equalsIgnoreCase("F")) {
			gender = Gender.F;
		}
		else {
			gender = Gender.M;
		}
		System.out.print("What is this passenger's street? ");
		street = keyboard.nextLine();
		System.out.print("What is this passenger's city? ");
		city = keyboard.nextLine();
		System.out.print("What is this passenger's state? ");
		state = keyboard.nextLine();
		System.out.print("What is this passenger's zip code? ");
		zip = keyboard.nextLine();
		address = new Address(street, city, state, zip);
		System.out.print("What month was this passenger born in? ");
		month = keyboard.nextLine();
		System.out.print("What day was this passenger born on? ");
		day = keyboard.nextLine();
		System.out.print("What year was this passenger born in? ");
		year = keyboard.nextLine();
		StringBuilder str = new StringBuilder(year + "-");
		str.append(month + "-" + day);
		birthdate = str.toString();
		System.out.print("What is this passenger's passport ID? ");
		passportID = keyboard.nextLine();
		System.out.print("How many pieces of luggage can this passenger take? ");
		luggage = keyboard.nextInt();
		keyboard.nextLine();
		Passenger adding = new Passenger(firstName, lastName, gender, address, birthdate, passportID, luggage);
		ship.addPassenger(adding);
	}
}
