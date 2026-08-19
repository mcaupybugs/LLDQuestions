# Parking System Learnings

- Do not force design patterns. Add them only when a real varying behavior exists.
- `enum` is enough when types are only categories. Use interfaces/strategies when behavior differs.
- Fare calculation is a good use case for Strategy Pattern because pricing varies by vehicle type.
- Ticket generation and pricing should stay separate from parking spot allocation.
- In a multi-floor parking system, keep floors as part of the domain model instead of creating unnecessary managers per floor.
