# Parking System Design

```mermaid
classDiagram
    class ParkingLot {
        -ParkingFloor[] parkingFloors
        -ParkingManager parkingManager
        -TicketManager ticketManager
        +parkVehicle(vehicle)
        +unparkVehicle(vehicle)
    }

    class ParkingFloor {
        -int floorNumber
        -ParkingSpot[] parkingSpots
        +getFloorNumber()
        +getEmptyParkingSpots(vehicleType)
        +getParkingSpots()
    }

    class ParkingSpot {
        -int spotNumber
        -VehicleType supportedVehicleType
        -Vehicle vehicle
        -boolean isOccupied
        +getSpotNumber()
        +getVehicle()
        +getSupportedVehicleType()
        +isOccupied()
        +canPark(vehicle)
        +parkVehicle(vehicle)
        +unparkVehicle()
    }

    class ParkingManager {
        +findEmptyParkingSpots(parkingFloor, vehicleType)
        +generateFare(ticket, exitTime)
    }

    class TicketManager {
        -Map~String, Ticket~ tickets
        -int ticketCounter
        +generateTicket(floorNumber, spotNumber, vehicle, entryTime)
        +getActiveTicket(vehicleNumber)
    }

    class Ticket {
        -String ticketNumber
        -int floorNumber
        -int spotNumber
        -String vehicleNumber
        -VehicleType vehicleType
        -LocalDateTime entryTime
        -LocalDateTime exitTime
        -TicketStatus status
        -double totalFare
        +getParkedHours(exitTime)
        +closeTicket(exitTime, totalFare)
    }

    class IFareStrategy {
        <<interface>>
        +calculateFare(ticket, exitTime)
    }

    class BikeFareStrategy {
        +calculateFare(ticket, exitTime)
    }

    class CarFareStrategy {
        +calculateFare(ticket, exitTime)
    }

    class TruckFareStrategy {
        +calculateFare(ticket, exitTime)
    }

    class FareStrategyFactory {
        +getStrategy(vehicleType)
    }

    class Vehicle {
        -String number
        -VehicleType vehicleType
        +getNumber()
        +getVehicleType()
    }

    class VehicleType {
        <<enumeration>>
        CAR
        BIKE
        TRUCK
    }

    class TicketStatus {
        <<enumeration>>
        ACTIVE
        CLOSED
    }

    ParkingLot --> ParkingFloor
    ParkingLot --> ParkingManager
    ParkingLot --> TicketManager
    ParkingFloor --> ParkingSpot
    ParkingSpot --> Vehicle
    ParkingSpot --> VehicleType
    ParkingManager --> ParkingFloor
    ParkingManager --> Ticket
    ParkingManager --> FareStrategyFactory
    TicketManager --> Ticket
    Ticket --> VehicleType
    Ticket --> TicketStatus
    FareStrategyFactory --> IFareStrategy
    IFareStrategy <|.. BikeFareStrategy
    IFareStrategy <|.. CarFareStrategy
    IFareStrategy <|.. TruckFareStrategy
    Vehicle --> VehicleType
```

```mermaid
flowchart TD
    A[Vehicle arrives] --> B[ParkingLot.parkVehicle(vehicle)]
    B --> C[ParkingManager finds empty compatible spot floor by floor]
    C --> D[ParkingSpot parks vehicle]
    D --> E[TicketManager generates active ticket]
    E --> F[Vehicle exits]
    F --> G[ParkingLot.unparkVehicle(vehicle)]
    G --> H[TicketManager fetches active ticket]
    H --> I[ParkingSpot is freed]
    I --> J[ParkingManager selects fare strategy]
    J --> K[FareStrategy calculates fare]
    K --> L[Ticket closes with exit time and total fare]
```
