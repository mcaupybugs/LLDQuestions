# Traffic Control System Question

## Problem Statement

Design a low level design for a traffic control system.

A traffic control system manages traffic signals at road intersections and controls the flow of vehicles in different directions. The system should coordinate signal changes safely and ensure that conflicting directions are not allowed to move at the same time.

## Requirements

### Functional Requirements

- Support one or more traffic intersections
- Each intersection should manage multiple traffic signals
- Each signal should support states such as `RED`, `YELLOW`, and `GREEN`
- The system should switch signals in the correct sequence
- The system should ensure that conflicting lanes are not green at the same time
- The system should allow configuring signal timing durations
- The system should display the current signal state for an intersection
- The system should support manual override for an intersection
- The system should allow the controller to resume automatic operation after manual override

### Behavioral Constraints

- Only valid signal transitions should be allowed
- The system should prevent unsafe state combinations across an intersection
- Manual override should not leave the intersection in an invalid state
- Automatic control should continue cycling signals until stopped

### Non-Functional Requirements

- Keep the design object-oriented, modular, and easy to extend
- The design should be maintainable and testable
- The design should allow future support for emergency vehicle priority and sensor-based traffic control
- Focus on low level design and class responsibilities, not database or distributed system design
