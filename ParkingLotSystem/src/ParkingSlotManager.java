

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ParkingSlotManager {

	ArrayList<ParkingSlot> parkingSlots;
	ArrayList<ParkingSlot> filledSlots;
	
	/**
	 * Here we try to allocate the parking space for the vehicles
	 */
	public ParkingSlotManager() {
		this.parkingSlots = new ArrayList<ParkingSlot>();
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j<= 20; j++) {
				ParkingSlot parkingSlot = new ParkingSlot();
				parkingSlot.setFilled(false);
				parkingSlot.setParkingLevel(i);
				parkingSlot.setParkingSlot(j);
				this.parkingSlots.add(parkingSlot);
			}
		}
	}
	
	/**
	 * @return the value if the parking lot is occupied
	 */

	public ParkingSlot getEmptyParkingSlot() {
		for(ParkingSlot parkingSlot: this.parkingSlots) {
			if(!parkingSlot.isFilled())
				return parkingSlot;
		}
		return null;
	}
	
	/**
	 * @return Returns the list of the occupied parking slots
	 */
	public ArrayList<ParkingSlot> getFilledParkingSlots() {
		filledSlots = (ArrayList<ParkingSlot>) this.parkingSlots.stream().filter(u -> u.isFilled() == true).collect(Collectors.toList());
		return filledSlots;
	}
	
	/**
	 * @param car Accepts the details of the car for the parking space
	 * @throws ParkingFullException If the parking is full the exception is thrown
	 */
	public void assignCarParkingSpot(Car car) throws ParkingFullException{
		ParkingSlot parkingSlot = this.getEmptyParkingSlot();
		if(parkingSlot == null) {
			throw new ParkingFullException("Parking is full");
		}
		parkingSlot.setCar(car);
		parkingSlot.setFilled(true);
	}
	
	/**
	 * @param car accepts the details of the car to empty the space where the car was parked
	 */
	public void emptyParkingSpace(Car car) {
		ArrayList<ParkingSlot> filledSlots = getFilledParkingSlots();
		for(ParkingSlot parkingSlot: filledSlots) {
			if(parkingSlot.getCar().equals(car)) {
				parkingSlot.setCar(null);
				parkingSlot.setFilled(false);
			}
		}
	}
	
	/**
	 * @param color Accepts the color of the car to find the registration number of the car
	 * @return the registration number of the car
	 * @throws RegistrationNotFoundException if the registration number is not found
	 */
	public List<String> registrationNumbersByColor(String color) throws RegistrationNotFoundException {
		ArrayList<ParkingSlot> filledSlots = getFilledParkingSlots();
		List<String> registrationNumbers = filledSlots.stream()
				.filter(slot -> color.equals(slot.getCar().getColor()))
                .map(p -> p.getCar().getRegistrationNumber())
                .collect(Collectors.toList());
		if(registrationNumbers.isEmpty())
			throw new RegistrationNotFoundException("Registration not found!");
		return registrationNumbers;
	}
	
	/**
	 * @param registration accepts the registration number to find the car by color
	 * @return floor and slot where the car is parked
	 * @throws RegistrationNotFoundException if the car is not registered
	 */
	public String getSlotOfCarByRegistration(String registration) throws RegistrationNotFoundException {
		ArrayList<ParkingSlot> filledSlots = getFilledParkingSlots();
		ParkingSlot result = filledSlots.stream()
                .filter(slot -> registration.equals(slot.getCar().getRegistrationNumber())).findAny()
                .orElse(null);
		if(result == null)
			throw new RegistrationNotFoundException("Registration not found!");
		return "Parking Level: "+result.getParkingLevel()+" "+"Parking Slot: "+result.getParkingSlot();
	}
	
	/**
	 * @param color accepts the color to find the slot of the car
	 * @return the floor and slot of the car where it is parked
	 * @throws ColorNotFoundException if the car is not found of the specific color
	 */
	public List<String> getSlotOfCarByColor(String color) throws ColorNotFoundException {
		ArrayList<ParkingSlot> filledSlots = getFilledParkingSlots();
		List<String> parkingSlots = filledSlots.stream()
				.filter(slot -> color.equals(slot.getCar().getColor()))
                .map(p -> "Parking Level: "+p.getParkingLevel()+" Parking Slot: "+p.getParkingSlot())
                .collect(Collectors.toList());
		if(parkingSlots.isEmpty())
			throw new ColorNotFoundException("Color not found!");
		return parkingSlots;
	}
}
