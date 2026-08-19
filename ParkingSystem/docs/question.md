# Parking System Question

## Problem Statement

Design a low level design for a parking system for a commercial parking lot.

The system should be extensible enough to support interview follow-up cases such as multi-floor parking, different spot categories, and future billing or gate management without requiring major redesign.

## Requirements

### Core Functional Requirements

- Support a parking lot with multiple floors
- Each floor should have multiple parking spots
- Support different vehicle types such as `Bike`, `Car`, and `Truck`
- Support different parking spot types such as `BikeSpot`, `CarSpot`, and `TruckSpot`
- A vehicle should be parked only in a compatible spot
- Park a vehicle in an available spot
- Generate a parking ticket when a vehicle is parked successfully
- Remove a vehicle from its parked spot
- Close the ticket when the vehicle exits
- Track available and occupied spots at both floor level and parking lot level
- Prevent invalid parking, such as:
	- parking in an occupied spot
	- parking a vehicle in an incompatible spot
	- removing a vehicle that is not parked
	- closing or querying a ticket for a vehicle that is not currently parked

### Behavioral Expectations

- The system should assign a suitable available parking spot when a vehicle arrives
- The system should mark the spot as occupied after successful parking
- The system should create and return a ticket containing at least ticket id, vehicle details, spot details, entry time, and current status
- The system should free the spot when the vehicle exits
- The system should calculate parking charges during exit based on vehicle type and parking duration
- Pricing strategy should be different for different vehicle types
- The system should be able to display current availability by floor and by spot type

### Design Expectations

- Keep the design object-oriented and extensible
- Model the system in a way that single-floor parking can be treated as a special case of multi-floor parking
- Keep ticket generation and pricing logic separate from spot allocation logic
- The design should be ready for future extensions such as:
	- entry and exit gates
	- advanced ticket lifecycle management
	- pricing and payments
	- reserved spots
	- display boards

### Non-Functional / Interview Scope

- Prevent invalid state transitions
- Keep responsibilities clearly separated across classes
- Provide a runnable entry point to demonstrate the flow
- Focus on clean low-level design, not database or distributed system design

## Suggested Discussion Points

While implementing, be prepared to explain:

- How spot allocation works
- How vehicle-to-spot compatibility is enforced
- How floor-wise availability is tracked
- How ticket lifecycle is managed
- How pricing differs by vehicle type
- How the design can be extended for billing and payments
