package ParkingSystem;

import java.time.LocalDateTime;

public class TruckFareStrategy implements IFareStrategy {
    private static final double BASE_FARE = 50.0;
    private static final double HOURLY_RATE = 20.0;

    @Override
    public double calculateFare(Ticket ticket, LocalDateTime exitTime) {
        long hoursParked = ticket.getParkedHours(exitTime);
        return BASE_FARE + (hoursParked * HOURLY_RATE);
    }
}