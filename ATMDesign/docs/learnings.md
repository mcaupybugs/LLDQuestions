# ATM Design Learnings

## Architectural Learnings
- Model ATM workflow with the **State pattern** when valid actions depend on the current step.
- Model transaction execution with the **Strategy pattern** to keep withdrawal, deposit, and balance inquiry isolated.
- Keep **orchestration**, **business logic**, and **resource management** separate:
  - `ATMMachine` handles session flow
  - `BankService` handles account-side operations
  - `CashInventory` handles note-level ATM cash logic

## Good Design Decisions in This Version
- `TransactionType` is an enum, which is safer than strings.
- `CashInventory` uses a `LinkedHashMap` plus ordered denominations to preserve high-to-low dispensing order.
- The ATM session is explicitly reset after transaction completion or authentication failure.
- Balance inquiry does not require an amount.

## Important Rules Captured
- Authenticate before allowing transaction selection.
- Require amount only for amount-based transactions.
- Validate withdrawal against both:
  - account balance
  - ATM cash inventory
- Dispense higher denominations before lower denominations.
- Reject amounts that cannot be dispensed exactly.

## Code Smells That Were Fixed
- duplicate PIN validation responsibility
- raw string transaction comparisons
- broken defaulting of unknown transaction types
- incomplete transaction execution state
- missing balance inquiry support
- missing withdrawal implementation
- inconsistent state methods like `cancelTransaction()` outside the interface

## Remaining Improvement Areas
- Add explicit hardware abstractions such as card reader and cash dispenser device.
- Replace `System.out.println` with return models or a display interface.
- Add rollback-safe transaction handling.
- Add unit tests for:
  - invalid PIN
  - insufficient balance
  - insufficient ATM cash
  - exact denomination failure
  - successful deposit/withdrawal/balance inquiry
- Add audit logs and transaction records.
- Add an explicit `EjectCardState` if stricter lifecycle modeling is needed.

## Interview Talking Points
- Why State pattern over a single ATM class with flags
- Why Strategy pattern for transactions
- Why account validation and cash dispense validation must be separate
- Why enums are better than strings for transaction selection
- How to evolve this design for production systems
