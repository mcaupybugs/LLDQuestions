package ParkingSystem;

public class ParkingSystemApp {
    public static void main(String[] args) {
        // Example usage of the parking system
        ParkingLot parkingLot = new ParkingLot(10, 10); // Create a parking lot with 10 floors and 10 slots per floor
        Vehicle car = new Vehicle("ABC123", VehicleType.CAR);
        Ticket ticket = parkingLot.parkVehicle(car); // Park the car and get a ticket
        System.out.println("Ticket ID: " + ticket.getTicketNumber());

        // Simulate some time passing before unparking
        Ticket closedTicket = parkingLot.unparkVehicle(car); // Unpark the car and get
        // the closed ticket with fare details
        System.out.println("Fare for ticket ID " + closedTicket.getTicketNumber() + ": " + closedTicket.getTotalFare());
    }
}