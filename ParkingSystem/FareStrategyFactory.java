package ParkingSystem;

public class FareStrategyFactory {
    public static IFareStrategy getStrategy(VehicleType vehicleType) {
        switch (vehicleType) {
            case BIKE: return new BikeFareStrategy();
            case CAR: return new CarFareStrategy();
            case TRUCK: return new TruckFareStrategy();
            default: throw new IllegalArgumentException("Unsupported vehicle type");
        }
    }
}