package ParkingSystem;

import java.time.LocalDateTime;

public class ParkingLot {
    private ParkingFloor[] parkingFloors;
    private ParkingManager parkingManager;
    private TicketManager ticketManager;

    public ParkingLot(int numberOfFloors, int spotsPerFloor) {
        this.parkingManager = new ParkingManager();
        this.parkingFloors = new ParkingFloor[numberOfFloors];
        for (int i = 0; i < numberOfFloors; i++) {
            parkingFloors[i] = new ParkingFloor(i + 1, spotsPerFloor);
        }
        this.ticketManager = new TicketManager();
    }

    public Ticket parkVehicle(Vehicle vehicle){
        for(ParkingFloor floor : parkingFloors){
            ParkingSpot[] emptySpots = parkingManager.findEmptyParkingSpots(floor, vehicle.getVehicleType());
            if(emptySpots.length > 0){
                ParkingSpot selectedSpot = emptySpots[0];
                selectedSpot.parkVehicle(vehicle);
                Ticket ticket = ticketManager.generateTicket(floor.getFloorNumber(), selectedSpot.getSpotNumber(), vehicle, LocalDateTime.now());
                System.out.println("Vehicle parked at Floor: " + floor.getFloorNumber() + ", Spot: " + selectedSpot.getSpotNumber());
                return ticket;
            }
        }
        throw new IllegalStateException("No available parking spot found for vehicle type " + vehicle.getVehicleType());
    }

    public Ticket unparkVehicle(Vehicle vehicle){
        Ticket activeTicket = ticketManager.getActiveTicket(vehicle.getNumber());
        for(ParkingFloor floor : parkingFloors){
            for(ParkingSpot spot : floor.getParkingSpots()){
                if(spot.isOccupied() && spot.getVehicle().getNumber().equals(vehicle.getNumber())){
                    spot.unparkVehicle();
                    Ticket closedTicket = parkingManager.generateFare(activeTicket, LocalDateTime.now());
                    System.out.println("Vehicle unparked from Floor: " + floor.getFloorNumber() + ", Spot: " + spot.getSpotNumber());
                    return closedTicket;
                }
            }
        }
        throw new IllegalArgumentException("Vehicle is not parked in the parking lot");
    }
}