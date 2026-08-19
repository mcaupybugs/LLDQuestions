package ParkingSystem;

import java.time.LocalDateTime;

public interface IFareStrategy {
    double calculateFare(Ticket ticket, LocalDateTime exitTime);
}