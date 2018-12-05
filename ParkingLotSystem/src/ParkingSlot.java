
/**
 * @author zoro
 *
 */
public class ParkingSlot {
	int parkingLevel;
	int parkingSlot;
	boolean isFilled;
	Car car;
	public boolean isFilled() {
		return isFilled;
	}
	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}
	public int getParkingLevel() {
		return parkingLevel;
	}
	public void setParkingLevel(int parkingLevel) {
		this.parkingLevel = parkingLevel;
	}
	public int getParkingSlot() {
		return parkingSlot;
	}
	public void setParkingSlot(int parkingSlot) {
		this.parkingSlot = parkingSlot;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	@Override
	public String toString() {
		return "ParkingSlot [parkingLevel=" + parkingLevel + ", parkingSlot=" + parkingSlot + ", isFilled=" + isFilled
				+ ", car=" + car + "]";
	}
}
