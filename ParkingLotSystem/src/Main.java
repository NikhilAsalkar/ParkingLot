import java.util.Scanner;
import java.lang.*;

public class Main {
	public static void main(String[] args) {
		// Constructor initializes parking slots to empty spaces
		ParkingSlotManager parkingSlotManager = new ParkingSlotManager();
		String color,reg_number;
		int accept_choice;
		Scanner sc = new Scanner(System.in);
		Car car = null;
		while(true)
		{
			System.out.println("1.Add Car");
			System.out.println("2.Search Registration Number of Cars by color");
			System.out.println("3.Search for Car slots with same color");
			System.out.println("4.Search for slot number of Car by Regisatration Number");
			System.out.println("5.Remove a car");
			System.out.println("6.Exit");
			accept_choice = sc.nextInt();
			switch(accept_choice)
			{
			case 1:
				car = new Car();
				System.out.println("Enter the Color of car");
				color = sc.next();
				System.out.println("Enter the registration number");
				reg_number = sc.next();
				car.setColor(color);
				car.setRegistrationNumber(reg_number);
				try {
					parkingSlotManager.assignCarParkingSpot(car);
				} catch (ParkingFullException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
			
				System.out.println("Searching registration numbers of cars by color..");
				color=sc.next();
				try {
					System.out.println(parkingSlotManager.registrationNumbersByColor(color));
				} catch (RegistrationNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("Enter the Color of Car to search");
				color = sc.next();
				try {
					System.out.println(parkingSlotManager.getSlotOfCarByColor(color));
				} catch (ColorNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("Enter Registration number of Car to find slot number");
				reg_number = sc.next();
				try {
					System.out.println(parkingSlotManager.getSlotOfCarByRegistration(reg_number));
				} catch (RegistrationNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				System.out.println("Enter color of car");
				color = sc.next();
				System.out.println("Enter Registration Number");
				reg_number = sc.next();
				car.setColor(color);
				car.setRegistrationNumber(reg_number);
				parkingSlotManager.emptyParkingSpace(car);
				break;
			case 6:
				System.exit(0);
			}
		}
		
	}
}
