package ParkingSystem;

import java.time.LocalDateTime;

public class CarFareStrategy implements IFareStrategy {
    private static final double BASE_FARE = 20.0;
    private static final double HOURLY_RATE = 10.0;

    @Override
    public double calculateFare(Ticket ticket, LocalDateTime exitTime) {
        long hoursParked = ticket.getParkedHours(exitTime);
        return BASE_FARE + (HOURLY_RATE * hoursParked);
    }
}