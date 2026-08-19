package ParkingSystem;

public class ParkingSpot{
    private int spotNumber;
    private VehicleType supportedVehicleType;
    private Vehicle vehicle;
    private boolean isOccupied;

    public ParkingSpot(int spotNumber, VehicleType supportedVehicleType){
        this.spotNumber = spotNumber;
        this.supportedVehicleType = supportedVehicleType;
        this.isOccupied = false;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public VehicleType getSupportedVehicleType() {
        return supportedVehicleType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean canPark(Vehicle vehicle) {
        return !isOccupied && supportedVehicleType == vehicle.getVehicleType();
    }

    public void parkVehicle(Vehicle vehicle) {
        if (!canPark(vehicle)) {
            throw new IllegalStateException("Vehicle cannot be parked in this spot");
        }
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void unparkVehicle() {
        if (!isOccupied) {
            throw new IllegalStateException("Parking spot is already empty");
        }
        this.vehicle = null;
        this.isOccupied = false;
    }
}