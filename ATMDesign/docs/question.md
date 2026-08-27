# ATM - Question

## Problem Statement
Design an `ATM (Automated Teller Machine)` system that allows a bank customer to perform basic self-service banking operations without visiting a branch.

The ATM should interact with a simulated backend banking service to authenticate users, fetch account details, and update balances.

## Supported Features
The system must support the following transactions:
- Cash withdrawal
- Cash deposit
- Balance inquiry

## Authentication
- A user inserts a card to begin.
- The ATM reads the card details.
- The user enters a PIN.
- The ATM verifies the PIN using a simulated bank service.
- If authentication succeeds, the user can perform transactions.
- If authentication fails, show an appropriate message and eject the card.

## Cash Dispensing Rules
- The ATM supports these denominations only:
  - `$100`
  - `$50`
  - `$20`
  - `$10`
- For withdrawals, the ATM should dispense cash using the **largest denominations first**.
- Before debiting the account, the ATM must verify:
  - the user has sufficient balance
  - the ATM has sufficient cash inventory
  - the requested amount can be dispensed using the available denominations

## Deposit Rules
- A user should be able to deposit cash into their account.
- The backend bank service should be updated accordingly.
- You may assume the deposited amount is valid for the demo.

## Balance Inquiry
- A user should be able to check the current available account balance.

## State Management
The ATM should model state transitions similar to:
- `Idle`
- `ReadCard`
- `VerifyPin`
- `SelectTxn`
- `Process`
- `Dispense`
- `Eject`

## Error Handling
Handle these cases gracefully with proper messages:
- Invalid PIN
- Insufficient account balance
- ATM has insufficient cash
- Requested amount cannot be dispensed exactly
- Invalid transaction for current state

## Assumptions
- Hardcode the sequence of operations for demo purposes.
- No UI or real user input handling is required.
- No daily withdrawal or transaction limits.
- Bank operations can be simulated using in-memory classes.

## Functional Requirements
- Authenticate users using card number and PIN
- Support withdrawal, deposit, and balance inquiry
- Dispense cash using largest denominations first
- Validate account balance and ATM cash inventory before withdrawal
- Track ATM state transitions correctly
- Simulate bank operations in memory

## Non-Functional Requirements
- Follow object-oriented design principles
- Keep the system modular and extensible
- Make the code testable in isolation
- Ensure thread safety where shared mutable data exists
- Follow validation-before-commit for financial operations

## Expected Discussion Points
While solving, consider:
- Core classes and responsibilities
- How to model ATM states
- How to represent transactions
- How to separate ATM logic from bank service logic
- How to manage cash inventory safely
- How to make it easy to add new transaction types later
