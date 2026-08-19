package ParkingSystem;

import java.time.Duration;
import java.time.LocalDateTime;

enum TicketStatus {
    ACTIVE,
    CLOSED
}

public class Ticket{
    private String ticketNumber;
    private int floorNumber;
    private int spotNumber;
    private String vehicleNumber;
    private VehicleType vehicleType;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private TicketStatus status;
    private double totalFare;

    public Ticket(String ticketNumber, int floorNumber, int spotNumber, String vehicleNumber, VehicleType vehicleType, LocalDateTime entryTime) {
        this.ticketNumber = ticketNumber;
        this.floorNumber = floorNumber;
        this.spotNumber = spotNumber;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.entryTime = entryTime;
        this.status = TicketStatus.ACTIVE;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public long getParkedHours(LocalDateTime exitTime) {
        long parkedHours = Duration.between(entryTime, exitTime).toHours();
        return Math.max(1, parkedHours == 0 ? 1 : parkedHours);
    }

    public void closeTicket(LocalDateTime exitTime, double totalFare) {
        if (status == TicketStatus.CLOSED) {
            throw new IllegalStateException("Ticket is already closed");
        }
        this.exitTime = exitTime;
        this.totalFare = totalFare;
        this.status = TicketStatus.CLOSED;
    }
}