package ParkingSystem;

public class ParkingFloor{
    private int floorNumber;
    private ParkingSpot[] parkingSpots;

    public ParkingFloor(int floorNumber, int numberOfSpots) {
        this.floorNumber = floorNumber;
        this.parkingSpots = new ParkingSpot[numberOfSpots];
        for (int i = 0; i < numberOfSpots; i++) {
            parkingSpots[i] = new ParkingSpot(i + 1, getSupportedTypeForSpot(i));
        }
    }

    private VehicleType getSupportedTypeForSpot(int index) {
        VehicleType[] supportedTypes = VehicleType.values();
        return supportedTypes[index % supportedTypes.length];
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public ParkingSpot[] getEmptyParkingSpots(VehicleType vehicleType) {
        int count = 0;
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getSupportedVehicleType() == vehicleType && !spot.isOccupied()) {
                count++;
            }
        }

        ParkingSpot[] matchingSpots = new ParkingSpot[count];
        int index = 0;
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getSupportedVehicleType() == vehicleType && !spot.isOccupied()) {
                matchingSpots[index++] = spot;
            }
        }
        return matchingSpots;
    }

    public ParkingSpot[] getParkingSpots() {
        return parkingSpots;
    }
}