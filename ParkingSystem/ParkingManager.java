package ParkingSystem;

import java.time.LocalDateTime;

public class ParkingManager{
    public ParkingManager(){
    }

    public ParkingSpot[] findEmptyParkingSpots(ParkingFloor parkingFloor, VehicleType vehicleType) {
        return parkingFloor.getEmptyParkingSpots(vehicleType);
    }

    public Ticket generateFare(Ticket ticket, LocalDateTime exitTime){
        IFareStrategy fareStrategy = FareStrategyFactory.getStrategy(ticket.getVehicleType());
        double fare = fareStrategy.calculateFare(ticket, exitTime);
        ticket.closeTicket(exitTime, fare);
        return ticket;
    }
}