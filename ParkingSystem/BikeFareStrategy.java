package ParkingSystem;

import java.time.LocalDateTime;

public class BikeFareStrategy implements IFareStrategy {
    private static final double BASE_FARE = 10.0;
    private static final double HOURLY_RATE = 5.0;

    @Override
    public double calculateFare(Ticket ticket, LocalDateTime exitTime) {
        long hoursParked = ticket.getParkedHours(exitTime);
        return BASE_FARE + (HOURLY_RATE * hoursParked);
    }
}