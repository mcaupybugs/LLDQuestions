package ParkingSystem;

enum VehicleType {
    CAR,
    BIKE,
    TRUCK
}

public class Vehicle{
    private String number;
    private VehicleType vehicleType;

    public Vehicle(String number, VehicleType vehicleType) {
        this.number = number;
        this.vehicleType = vehicleType;
    }

    public String getNumber() {
        return number;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}