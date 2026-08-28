# Vending Machine Question

## Problem Statement

Design a low level design for a vending machine.

A vending machine is a self-service automated device that allows users to select an item, insert money, and receive the item without human assistance.

The machine should support a single active transaction at a time and should model the full flow from idle state to item selection, payment, dispensing, and collection.

## Requirements

### Functional Requirements

- Allow users to view available items along with item code, price, and quantity
- Allow users to select an item using an item code
- Accept coin-based payments using fixed denominations such as `$1`, `$5`, and `$10`
- Dispense the selected item only if sufficient money has been inserted
- Return change if the inserted amount is greater than the item price
- Allow users to cancel a transaction before item dispensing and receive a full refund
- Allow adding new items to the machine
- Allow restocking existing items with additional quantity
- Display intermediate transaction state such as selected item, inserted amount, refund, or change returned

### Behavioral Constraints

- Only one transaction should be active at a time
- A purchase must be atomic: either the item and correct change are dispensed, or the full amount is refunded
- The machine should reject invalid actions based on the current state
- The machine should not dispense an item if it is out of stock
- The machine should not complete a purchase if the inserted amount is insufficient

### Non-Functional Requirements

- Keep the design object-oriented, modular, and easy to extend
- The design should be maintainable and testable
- The design should allow future support for additional payment methods with minimal changes
- Focus on low level design and class responsibilities, not database or distributed system design
