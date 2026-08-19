package ParkingSystem;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class TicketManager{
    private Map<String, Ticket> tickets = new HashMap<>();
    private int ticketCounter = 1;

    public Ticket generateTicket(int floorNumber, int spotNumber, Vehicle vehicle, LocalDateTime entryTime) {
        if (tickets.containsKey(vehicle.getNumber()) && tickets.get(vehicle.getNumber()).getStatus() == TicketStatus.ACTIVE) {
            throw new IllegalStateException("Vehicle is already parked");
        }

        String ticketNumber = "TICKET-" + ticketCounter++;
        Ticket ticket = new Ticket(ticketNumber, floorNumber, spotNumber, vehicle.getNumber(), vehicle.getVehicleType(), entryTime);
        tickets.put(vehicle.getNumber(), ticket);
        return ticket;
    }

    public Ticket getActiveTicket(String vehicleNumber) {
        Ticket ticket = tickets.get(vehicleNumber);
        if (ticket == null || ticket.getStatus() != TicketStatus.ACTIVE) {
            throw new IllegalArgumentException("No active ticket found for vehicle " + vehicleNumber);
        }
        return ticket;
    }
}